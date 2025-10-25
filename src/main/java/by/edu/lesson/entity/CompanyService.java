package by.edu.lesson.entity;

import by.edu.lesson.entity.room.Room;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(schema = "hibernate_fight", name = "company_service")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CompanyService {
    @Id
    @SequenceGenerator(name = "servicesSq", sequenceName = "services_sq", schema = "hibernate_fight", allocationSize = 1)
    @GeneratedValue(generator = "servicesSq", strategy = GenerationType.SEQUENCE)
    private Long id;
    private String service;
    private Double amount;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Room> rooms;
}
