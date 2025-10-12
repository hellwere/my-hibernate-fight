package by.edu.lesson.entity.room;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(schema = "hibernate_fight", name = "room")
@Immutable
@Subselect("SELECT * from hibernate_fight.room WHERE peopleLimit <= 15")
public class SubselectRoom {
    @Id
    private Long id;
    private String roomName;
    private Double amountPerHour;
}
