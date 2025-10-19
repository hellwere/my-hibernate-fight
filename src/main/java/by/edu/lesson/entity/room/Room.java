package by.edu.lesson.entity.room;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(schema = "hibernate_fight", name = "room")
public class Room {
    @Id
    @GeneratedValue(generator = "roomSq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "roomSq", sequenceName = "room_sq", schema = "hibernate_fight", allocationSize = 1)
    private Long id;
    private String roomName;
    private String identificationNumber;
    private Long peopleLimit;
    @Enumerated(EnumType.STRING)
    private RoomStatus status;
    private Double amountPerHour;

    @OneToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Visitor> visits = new HashSet<>();
}
