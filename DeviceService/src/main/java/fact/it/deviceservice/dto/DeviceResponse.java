package fact.it.deviceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceResponse {
    private Long id;
    private String houseId;
    private String name;
    private String brand;
    private String model;
    private String status;
    private boolean active;
}
