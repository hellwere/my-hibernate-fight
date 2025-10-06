package by.edu.lesson.entity.client;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Table(schema = "hibernate_fight", name = "client")
public class Client {

    @Id
    @SequenceGenerator(name = "clientSq", sequenceName = "client_sq", schema = "hibernate_fight", allocationSize = 1)
    @GeneratedValue(generator = "client_sq", strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String surname;
    private int age;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "last_date_visited")
    private LocalDateTime lastDateVisited;
    @Enumerated(EnumType.STRING)
    private Status status;
    private double amount;
    @Embedded
    private Address address;

    public Client(String name, String surname, int age, String phoneNumber, LocalDateTime lastDateVisited, Status status, double amount, Address address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.lastDateVisited = lastDateVisited;
        this.status = status;
        this.amount = amount;
        this.address = address;
    }
}
