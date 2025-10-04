package by.edu.lesson.repository.hibernate;

import by.edu.lesson.configuration.HibernateConnection;
import by.edu.lesson.entity.client.Client;
import by.edu.lesson.entity.client.PremiumClient;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;

import java.util.List;

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

    public List<PremiumClient> getPremiumClients() {
        Session unwrap = entityManager.unwrap(Session.class);
        try (Session session = unwrap.getSessionFactory().openSession()) {
            return session.createQuery("Select p from PremiumClient p", PremiumClient.class).getResultList();
        }
    }
}
