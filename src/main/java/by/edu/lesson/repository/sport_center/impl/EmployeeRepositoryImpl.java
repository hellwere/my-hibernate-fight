package by.edu.lesson.repository.sport_center.impl;

import by.edu.lesson.configuration.HibernateConnection;
import by.edu.lesson.entity.sport_center.Employee;
import by.edu.lesson.repository.sport_center.EmployeeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final HibernateConnection connection;

    public EmployeeRepositoryImpl() {
        this.connection = new HibernateConnection();
    }

    @Override
    public Employee addEmployee(Employee Employee) {
        try (EntityManager entityManager = connection.getEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(Employee);
            entityManager.getTransaction().commit();
            return Employee;
        }
    }

    @Override
    public Employee findById(Long id) {
        try (EntityManager entityManager = connection.getEntityManager()) {
            return entityManager.find(Employee.class, id);
        }
    }

    @Override
    public List<Employee> findAll() {
        try (EntityManager entityManager = connection.getEntityManager()) {
            return entityManager.createQuery("Select e from Employee e", Employee.class).getResultList();
        }
    }

    @Override
    public List<Employee> findEmployeeWithMaxSalary() {
        try (EntityManager entityManager = connection.getEntityManager()) {
            return entityManager.createQuery("Select e from Employee e where e.salary = (Select max(e.salary) from Employee e)", Employee.class).getResultList();
        }
    }

    @Override
    public List<Employee> findEmployeeWithMinSalary() {
        try (EntityManager entityManager = connection.getEntityManager()) {
            return entityManager.createQuery("Select e from Employee e where e.salary = (Select min(e.salary) from Employee e)", Employee.class).getResultList();
        }
    }

    @Override
    public Double countMonthSalaryExpencies() {
        try (EntityManager entityManager = connection.getEntityManager()) {
            return entityManager.createQuery("Select sum(e.salary) from Employee e", Double.class).getSingleResult();
        }
    }
}
