package by.edu.lesson.service.sport_center;

import by.edu.lesson.entity.sport_center.Customer;
import by.edu.lesson.repository.sport_center.CustomerRepository;
import by.edu.lesson.repository.sport_center.impl.CustomerRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    
    private final CustomerRepository repository;

    public CustomerService() {
        this.repository = new CustomerRepositoryImpl();
    }

    public Customer addCustomer(Customer customer) {
        return repository.addCustomer(customer);
    }

    public List<Customer> addCustomers(List<Customer> customers) {
        ArrayList<Customer> list = new ArrayList<>();
        for (Customer customer : customers) {
            list.add(addCustomer(customer));
        }
        return list;
    }

    public Customer findById(Long id) {
        return repository.findById(id);
    }

    public List<Customer> findAll() {
        return repository.findAll();
    }
}
