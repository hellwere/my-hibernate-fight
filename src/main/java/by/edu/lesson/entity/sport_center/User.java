package by.edu.lesson.entity.sport_center;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(schema = "hibernate_fight", name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @SequenceGenerator(name = "userSq", schema = "hibernate_fight", sequenceName = "user_sq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userSq")
    private Long id;
    private String address;
    private String name;
    private String surname;
    private int yearOfBirth;
}
