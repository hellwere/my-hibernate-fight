package by.edu.lesson.entity.sport_center;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "hibernate_fight", name = "employee")
public class Employee extends User {
    private LocalDate employmentDate;
    private LocalDate firedDate;
    private String position;
    private double salary;

    public Employee(Long id, String address, String name, String surname, int yearOfBirth, LocalDate employmentDate, LocalDate firedDate, String position, double salary) {
        super(id, address, name, surname, yearOfBirth);
        this.employmentDate = employmentDate;
        this.firedDate = firedDate;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Employee{" +
                "employmentDate=" + employmentDate +
                ", firedDate=" + firedDate +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }
}
