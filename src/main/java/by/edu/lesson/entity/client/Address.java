package by.edu.lesson.entity.client;

import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Embeddable
public class Address {
    private String city;
    private String street;
    private int houseNumber;
    private String postIndex;
}
