package fact.it.houseservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class HouseResponse {
    private Long id;
    private String address;
    private String city;
    private String postalCode;
    private String numberOfRooms;
    private String ownerName;
    private int constructionYear;
}
