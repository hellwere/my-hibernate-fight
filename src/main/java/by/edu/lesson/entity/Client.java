package by.edu.lesson.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(schema = "hibernate_fight", name = "client")
public class Client {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    long id;
    String name;
    String surname;
    int age;
    @Column(name = "phone_number")
    String phoneNumber;
    @Column(name = "last_date_visited")
    LocalDateTime lastDateVisited;
    @Enumerated(EnumType.STRING)
    Status status;
    double amount;

    public Client(String name, String surname, int age, String phoneNumber, LocalDateTime lastDateVisited, Status status, double amount) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.lastDateVisited = lastDateVisited;
        this.status = status;
        this.amount = amount;
    }
}
