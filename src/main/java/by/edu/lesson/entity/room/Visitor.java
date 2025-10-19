package by.edu.lesson.entity.room;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(schema = "hibernate_fight", name = "visitor")
public class Visitor {

    @Id
    @SequenceGenerator(name = "visitSq", sequenceName = "visit_sq", schema = "hibernate_fight", allocationSize = 1)
    @GeneratedValue(generator = "visitSq", strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDate visitDate;
    private BigDecimal spentAmount;
    private int age;

    @OneToMany(mappedBy = "visits", cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Record> records = new HashSet<>();

    @OneToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Room> rooms = new HashSet<>();
}
