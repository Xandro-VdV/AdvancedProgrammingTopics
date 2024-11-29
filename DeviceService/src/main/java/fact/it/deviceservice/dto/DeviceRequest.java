package fact.it.deviceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceRequest {
    private Long name;
    private String houseId;
    private String brand;
    private String model;
    private String status;
    private boolean active;
}
