package fact.it.houseservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "house")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String city;
    private String postalCode;
    private String numberOfRooms;
    private String ownerName;
    private int constructionYear;
}
