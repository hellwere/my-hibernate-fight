package by.edu.lesson.repository.sport_center;

import by.edu.lesson.entity.sport_center.Employee;

import java.util.List;

public interface EmployeeRepository {
    Employee addEmployee(Employee employee);
    Employee findById(Long id);
    List<Employee> findAll();
    List<Employee> findAllWithCriteria();
}
