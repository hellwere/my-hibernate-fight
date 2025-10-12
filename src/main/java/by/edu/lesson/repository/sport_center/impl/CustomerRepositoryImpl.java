package by.edu.lesson.repository.sport_center.impl;

import by.edu.lesson.configuration.HibernateConnection;
import by.edu.lesson.entity.sport_center.Customer;
import by.edu.lesson.repository.sport_center.CustomerRepository;
import jakarta.persistence.EntityManager;

import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    private final HibernateConnection connection;

    public CustomerRepositoryImpl() {
        this.connection = new HibernateConnection();
    }

    @Override
    public Customer addCustomer(Customer customer) {
        try (EntityManager entityManager = connection.getEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(customer);
            entityManager.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public Customer findById(Long id) {
        try (EntityManager entityManager = connection.getEntityManager()) {
            return entityManager.find(Customer.class, id);
        }
    }

    @Override
    public List<Customer> findAll() {
        try (EntityManager entityManager = connection.getEntityManager()) {
            return entityManager.createQuery("Select c from Customer c", Customer.class).getResultList();
        }
    }
}
