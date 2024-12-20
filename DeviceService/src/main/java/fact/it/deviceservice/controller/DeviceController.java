package fact.it.deviceservice.controller;

import fact.it.deviceservice.dto.DeviceResponse;
import fact.it.deviceservice.model.Device;
import fact.it.deviceservice.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("api/device")
@RequiredArgsConstructor
public class DeviceController {
    private final DeviceService deviceService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<DeviceResponse> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @PostMapping
    public ResponseEntity<DeviceResponse> addDevice(@RequestBody Device device) {
        DeviceResponse createdDevice = deviceService.addDevice(device);
        return ResponseEntity.status(201).body(createdDevice);    }

    @PutMapping("/{id}")
    public ResponseEntity<DeviceResponse> updateDevice(@PathVariable Long id, @RequestBody Device updatedDevice) {
        DeviceResponse device = deviceService.updateDevice(id, updatedDevice);
        return ResponseEntity.ok(device);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
        return ResponseEntity.noContent().build();

    }
}
