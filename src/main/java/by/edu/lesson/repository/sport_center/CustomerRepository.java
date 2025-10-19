package by.edu.lesson.repository.sport_center;

import by.edu.lesson.entity.sport_center.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer addCustomer(Customer customer);
    Customer findById(Long id);
    List<Customer> findAll();
    List<Customer> findCustomerByName(String name);
}
