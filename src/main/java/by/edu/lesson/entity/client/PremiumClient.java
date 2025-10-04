package by.edu.lesson.entity.client;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Where;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(schema = "hibernate_fight", name = "client")
@Immutable
@Where(clause = "status = 'PREMIUM'")
public class PremiumClient {
    @Id
    private long id;
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    private Status status;
}
