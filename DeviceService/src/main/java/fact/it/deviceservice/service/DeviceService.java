package fact.it.deviceservice.service;

import fact.it.deviceservice.dto.DeviceResponse;
import fact.it.deviceservice.model.Device;
import fact.it.deviceservice.repository.DeviceRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceService {
private final DeviceRepository deviceRepository;

    @Transactional(readOnly = true)
    public List<DeviceResponse> getAllDevices() {
        return deviceRepository.findAll().stream()
                .map(device ->
                        DeviceResponse.builder()
                                .id(device.getId())
                                .houseId(device.getHouseId())
                                .name(device.getName())
                                .brand(device.getBrand())
                                .model(device.getModel())
                                .active(device.isActive())
                                .status(device.getStatus())
                                .build()
                ).toList();
    }

    @Transactional
    public DeviceResponse addDevice(Device device) {
        Device savedDevice = deviceRepository.save(device);
        return DeviceResponse.builder()
                .id(savedDevice.getId())
                .houseId(savedDevice.getHouseId())
                .name(savedDevice.getName())
                .brand(savedDevice.getBrand())
                .model(savedDevice.getModel())
                .status(savedDevice.getStatus())
                .active(savedDevice.isActive())
                .build();
    }

    @Transactional
    public DeviceResponse updateDevice(Long id, Device updatedDevice) {
        Device existingDevice = deviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));

        existingDevice.setHouseId(updatedDevice.getHouseId());
        existingDevice.setName(updatedDevice.getName());
        existingDevice.setBrand(updatedDevice.getBrand());
        existingDevice.setModel(updatedDevice.getModel());
        existingDevice.setActive(updatedDevice.isActive());
        existingDevice.setStatus(updatedDevice.getStatus());


        Device savedDevice = deviceRepository.save(existingDevice);
        return DeviceResponse.builder()
                .id(savedDevice.getId())
                .houseId(savedDevice.getHouseId())
                .name(savedDevice.getName())
                .brand(savedDevice.getBrand())
                .model(savedDevice.getModel())
                .status(savedDevice.getStatus())
                .active(savedDevice.isActive())
                .build();
    }

        @Transactional
        public void deleteDevice(Long id) {
            Device currentDevice = deviceRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Device not found"));

            deviceRepository.delete(currentDevice);
        }

}
