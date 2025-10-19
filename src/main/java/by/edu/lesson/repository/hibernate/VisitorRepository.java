package by.edu.lesson.repository.hibernate;

import by.edu.lesson.configuration.HibernateConnection;
import by.edu.lesson.entity.room.Visitor;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;

public class VisitorRepository {

    private final EntityManager entityManager;

    public VisitorRepository() {
        this.entityManager = new HibernateConnection().getEntityManager();
    }

    public Visitor addVisit(Visitor visitor) {
        Session unwrap = entityManager.unwrap(Session.class);
        try(Session session = unwrap.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.merge(visitor);
            session.getTransaction().commit();
        }
        return visitor;
    }
}
