package by.edu.lesson.repository.hibernate;

import by.edu.lesson.configuration.HibernateConnection;
import by.edu.lesson.entity.CompanyService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import org.hibernate.Session;

import java.util.List;

public class CompanyServiceRepository {

    private final HibernateConnection hibernateConnection;

    public CompanyServiceRepository() {
        this.hibernateConnection = new HibernateConnection();
    }

    public CompanyService addCompanyService(CompanyService companyService) {
        Session unwrap = hibernateConnection.getEntityManager().unwrap(Session.class);
        try(Session session = unwrap.getSessionFactory().openSession()) {
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
}
