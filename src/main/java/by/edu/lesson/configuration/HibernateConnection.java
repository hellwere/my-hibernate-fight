package by.edu.lesson.configuration;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Properties;

public class HibernateConnection {

    private final static EntityManagerFactory factory;

    static {
        Properties properties = new Properties();
        properties.put("jakarta.persistence.jdbc.user", System.getenv("postgres_usr"));
        properties.put("jakarta.persistence.jdbc.password", System.getenv("postgres_password"));

        factory = Persistence.createEntityManagerFactory("ClientJpa", properties);
    }

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
