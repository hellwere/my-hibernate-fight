package by.edu.lesson.service.sport_center;

import by.edu.lesson.entity.sport_center.Employee;
import by.edu.lesson.repository.sport_center.EmployeeRepository;
import by.edu.lesson.repository.sport_center.impl.EmployeeRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService() {
        this.repository = new EmployeeRepositoryImpl();
    }

    public Employee addEmployee(Employee Employee) {
        return repository.addEmployee(Employee);
    }

    public List<Employee> addEmployees(List<Employee> Employees) {
        ArrayList<Employee> list = new ArrayList<>();
        for (Employee Employee : Employees) {
            list.add(addEmployee(Employee));
        }
        return list;
    }

    public Employee findById(Long id) {
        return repository.findById(id);
    }

    public List<Employee> findAll() {
        return repository.findAll();
    }

    public List<Employee> findEmployeeWithMaxSalary() {
        return repository.findEmployeeWithMaxSalary();
    }

    public List<Employee> findEmployeeWithMinSalary() {
        return repository.findEmployeeWithMinSalary();
    }

    public Double countMonthSalaryExpencies() {
        return repository.countMonthSalaryExpencies();
    }
}
