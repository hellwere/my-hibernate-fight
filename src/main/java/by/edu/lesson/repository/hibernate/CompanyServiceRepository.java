package by.edu.lesson.repository.hibernate;

import by.edu.lesson.configuration.HibernateConnection;
import by.edu.lesson.entity.CompanyService;
import by.edu.lesson.entity.sport_center.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import org.hibernate.Session;
import org.hibernate.dialect.function.array.ArrayAggFunction;
import org.hibernate.stat.SessionStatistics;

import java.util.ArrayList;
import java.util.List;

public class CompanyServiceRepository {

    private final HibernateConnection hibernateConnection;

    public CompanyServiceRepository() {
        this.hibernateConnection = new HibernateConnection();
    }

    public CompanyService addCompanyService(CompanyService companyService) {
        try(Session session = hibernateConnection.getEntityManager().unwrap(Session.class)) {
            session.beginTransaction();
            session.merge(companyService);
            session.getTransaction().commit();
        }
        return companyService;
    }

    public List<CompanyService> findMinAmountActivityWithCriteria(String activity) {
        try (EntityManager entityManager = hibernateConnection.getEntityManager()) {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<CompanyService> query = cb.createQuery(CompanyService.class);
            Root<CompanyService> root = query.from(CompanyService.class);

            // Подзапрос: SELECT MIN(amount)
            Subquery<Double> subquery = query.subquery(Double.class);
            Root<CompanyService> subRoot = subquery.from(CompanyService.class);
            subquery.select(cb.min(subRoot.get("amount"))).where(cb.equal(subRoot.get("service"), activity));

            query.select(root).where(cb.equal(root.get("amount"), subquery));

            return entityManager.createQuery(query).getResultList();
        }
    }

    public List<CompanyService> findActivityWithCacheTwoTimes(List<Long> ids) {
        ArrayList<CompanyService> lst = new ArrayList<>();
        try (EntityManager entityManager = hibernateConnection.getEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.createQuery("Select c from CompanyService c", CompanyService.class).getResultList();
            entityManager.createQuery("Select e from Employee e", Employee.class).getResultList();
            entityManager.clear();
            for (Long id : ids) {
                lst.add(entityManager.find(CompanyService.class, id));
            }
            entityManager.getTransaction().commit();
            return lst;
        }
    }

    public List<CompanyService> findActivityWithCacheThreeTimes(List<Long> ids) {
        ArrayList<CompanyService> lst = new ArrayList<>();
        try (EntityManager entityManager = hibernateConnection.getEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.createQuery("Select c from CompanyService c", CompanyService.class).getResultList();
            entityManager.createQuery("Select e from Employee e", Employee.class).getResultList();
            entityManager.clear();
            for (Long id : ids) {
                lst.add(entityManager.find(CompanyService.class, id));
            }
            entityManager.getTransaction().commit();
            return lst;
        }
    }

    public List<CompanyService> findActivityWithCacheSecondLevel(List<Long> ids) {
        ArrayList<CompanyService> lst = new ArrayList<>();
        try (EntityManager entityManager = hibernateConnection.getEntityManager()) {
            entityManager.getTransaction().begin();
            for (Long id : ids) {
                lst.add(entityManager.find(CompanyService.class, id));
            }
            entityManager.getTransaction().commit();
            return lst;
        }
    }
}
