package by.edu.lesson.controller;

import by.edu.lesson.entity.sport_center.Customer;
import by.edu.lesson.entity.sport_center.CustomerStatus;
import by.edu.lesson.entity.sport_center.Employee;
import by.edu.lesson.service.sport_center.CustomerService;
import by.edu.lesson.service.sport_center.EmployeeService;

import java.time.LocalDate;
import java.util.ArrayList;

public class SportCentreController {

    private final CustomerService customerService;
    private final EmployeeService employeeService;

    public SportCentreController() {
        this.customerService = new CustomerService();
        this.employeeService = new EmployeeService();
    }

    public void callExerciseEight() {
        ArrayList<Customer> customers = new ArrayList<>() {{
            add(new Customer(null, "г. Минск, ул. Центральная, д. 1, кв. 12", "Илья", "Ильич", 1993,
                    CustomerStatus.ACTIVE, LocalDate.now(), 1800.63, LocalDate.parse("2023-11-06")));
            add(new Customer(null, "г. Минск, ул. Центральная, д. 2, кв. 13", "Вадим", "Вадмич", 2001,
                    CustomerStatus.INACTIVE, LocalDate.now(), 1800.63, LocalDate.parse("2023-11-06")));
            add(new Customer(null, "г. Минск, ул. Центральная, д. 3, кв. 14", "Дима", "Димич", 2010,
                    CustomerStatus.ACTIVE, LocalDate.now(), 1800.63, LocalDate.parse("2023-11-06")));
            add(new Customer(null, "г. Минск, ул. Центральная, д. 4, кв. 15", "Олег", "Олегич", 1978,
                    CustomerStatus.INACTIVE, LocalDate.now(), 1800.63, LocalDate.parse("2023-11-06")));
            add(new Customer(null, "г. Минск, ул. Центральная, д. 5, кв. 16", "Алексей", "Лексеич", 1991,
                    CustomerStatus.ACTIVE, LocalDate.now(), 1800.63, LocalDate.parse("2023-11-06")));
        }};

        for (Customer customer : customerService.addCustomers(customers)) {
            System.out.println(customer);
        }

        System.out.println(customerService.findById(1L));
        customerService.findAll().forEach(System.out::println);

        ArrayList<Employee> employees = new ArrayList<>() {{
            add(new Employee(null, "г. Минск, ул. Центральная, д. 2, кв. 12", "Ильич", "Илья", 1991,
                    LocalDate.parse("2023-11-06"), LocalDate.parse("2024-11-06"), "Начальник начальников", 2290.22));
            add(new Employee(null, "г. Минск, ул. Центральная, д. 2, кв. 12", "Олег", "Олегов", 1994,
                    LocalDate.parse("2019-11-06"), LocalDate.parse("2024-11-06"), "ПодНачальник начальников", 1901.22));
            add(new Employee(null, "г. Минск, ул. Центральная, д. 2, кв. 11", "Иван", "Иванов", 1997,
                    LocalDate.parse("2013-11-06"), LocalDate.parse("2024-11-06"), "Начальник начальниковых начальников", 12190.22));
            add(new Employee(null, "г. Минск, ул. Центральная, д. 2, кв. 17", "Дима", "Димоооооооонов", 1992,
                    LocalDate.parse("2003-11-06"), LocalDate.parse("2024-11-06"), "Единственный рабочий", 1290.22));
            add(new Employee(null, "г. Минск, ул. Центральная, д. 2, кв. 19", "Пустое", "Место", 1993,
                    LocalDate.parse("2003-11-06"), LocalDate.parse("2024-11-06"), "Униженный обиженный", 1.23));

        }};

        for (Employee employee : employeeService.addEmployees(employees)) {
            System.out.println(employee);
        }

        System.out.println(employeeService.findById(6L));
        employeeService.findAll().forEach(System.out::println);

    }
}
