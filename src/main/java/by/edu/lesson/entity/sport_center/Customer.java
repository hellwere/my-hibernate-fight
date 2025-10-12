package by.edu.lesson.entity.sport_center;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(schema = "hibernate_fight", name = "customer")
public class Customer extends User {

    @Embedded
    private CustomerStatus status;
    private LocalDate lastVisitDateTime;
    private double sumSpentAmount;
    private LocalDate firstDateVisit;

    public Customer(Long id, String address, String name, String surname, int yearOfBirth, CustomerStatus status, LocalDate lastVisitDateTime, double sumSpentAmount, LocalDate firstDateVisit) {
        super(id, address, name, surname, yearOfBirth);
        this.status = status;
        this.lastVisitDateTime = lastVisitDateTime;
        this.sumSpentAmount = sumSpentAmount;
        this.firstDateVisit = firstDateVisit;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Customer{" +
                "status=" + status +
                ", lastVisitDateTime=" + lastVisitDateTime +
                ", sumSpentAmount=" + sumSpentAmount +
                ", firstDateVisit=" + firstDateVisit +
                '}';
    }
}
