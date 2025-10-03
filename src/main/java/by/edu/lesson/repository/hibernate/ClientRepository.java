package by.edu.lesson.repository.hibernate;

import by.edu.lesson.configuration.HibernateConnection;
import by.edu.lesson.entity.Client;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;

public class ClientRepository {

    private final EntityManager entityManager;

    public ClientRepository() {
        this.entityManager = new HibernateConnection().getEntityManager();
    }

    public Client findById(Long id) {
        Session unwrap = entityManager.unwrap(Session.class);
        try(Session session = unwrap.getSessionFactory().openSession()) {
            return session.get(Client.class, id);
        }
    }
}
