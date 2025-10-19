package by.edu.lesson.entity.room;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(schema = "hibernate_fight", name = "record")
public class Record {
    @Id
    @SequenceGenerator(name = "recordSq", sequenceName = "record_sq", schema = "hibernate_fight", allocationSize = 1)
    @GeneratedValue(generator = "recordSq", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "client_id")
    private String clientId;
    private Long roomId;
    private LocalDate date;
    private LocalTime time;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room rooms;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "visit_id")
    private Visitor visits;
    
}
