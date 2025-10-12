package by.edu.lesson.repository.sport_center.impl;

import by.edu.lesson.configuration.HibernateConnection;
import by.edu.lesson.entity.sport_center.User;
import by.edu.lesson.repository.sport_center.UserRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private final HibernateConnection connection;

    public UserRepositoryImpl() {
        this.connection = new HibernateConnection();
    }

    @Override
    public User addUser(User User) {
        try (EntityManager entityManager = connection.getEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(User);
            entityManager.getTransaction().commit();
            return User;
        }
    }

    @Override
    public User findById(Long id) {
        try (EntityManager entityManager = connection.getEntityManager()) {
            return entityManager.find(User.class, id);
        }
    }

    @Override
    public List<User> findAll() {
        try (EntityManager entityManager = connection.getEntityManager()) {
            return entityManager.createQuery("Select u from User u", User.class).getResultList();
        }
    }
}
