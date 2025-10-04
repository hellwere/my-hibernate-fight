package by.edu.lesson.repository.hibernate;

import by.edu.lesson.configuration.HibernateConnection;
import by.edu.lesson.entity.CompanyService;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;

public class CompanyServiceRepository {
    private final EntityManager entityManager;

    public CompanyServiceRepository() {
        this.entityManager = new HibernateConnection().getEntityManager();
    }

    public CompanyService addCompanyService(CompanyService companyService) {
        Session unwrap = entityManager.unwrap(Session.class);
        try(Session session = unwrap.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.persist(companyService);
            session.getTransaction().commit();
        }
        return companyService;
    }
}
