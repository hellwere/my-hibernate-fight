package by.edu.lesson.entity;

import by.edu.lesson.entity.room.Room;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(schema = "hibernate_fight", name = "company_service")
public class CompanyService {
    @Id
    @SequenceGenerator(name = "servicesSq", sequenceName = "services_sq", schema = "hibernate_fight", allocationSize = 1)
    @GeneratedValue(generator = "servicesSq", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String service;
    private String amount;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Room> rooms;
}
