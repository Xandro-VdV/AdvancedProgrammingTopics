package fact.it.deviceservice;

import fact.it.deviceservice.dto.DeviceResponse;
import fact.it.deviceservice.model.Device;
import fact.it.deviceservice.repository.DeviceRepository;
import fact.it.deviceservice.service.DeviceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeviceServiceApplicationTests {

	@InjectMocks
	private DeviceService deviceService;

	@Mock
	private DeviceRepository deviceRepository;

	@Test
	public void testGetAllDevices() {
		// Arrange
		Device device1 = new Device();
		device1.setId(1L);
		device1.setHouseId("1");
		device1.setName("Test Device");
		device1.setBrand("Test Brand");
		device1.setModel("Test Model");
		device1.setStatus("Test Status");
		device1.setActive(true);
		when(deviceRepository.findAll()).thenReturn(List.of(device1));

		// Act
		List<DeviceResponse> devices = deviceService.getAllDevices();

		// Assert
		assertEquals(1, devices.size());
		assertEquals(1L, devices.get(0).getId());
		assertEquals("1", devices.get(0).getHouseId());
		assertEquals("Test Device", devices.get(0).getName());
		assertEquals("Test Brand", devices.get(0).getBrand());
		assertEquals("Test Model", devices.get(0).getModel());
		assertEquals("Test Status", devices.get(0).getStatus());
		assertTrue(devices.get(0).isActive());

		verify(deviceRepository, times(1)).findAll();
	}

	@Test
	public void testAddDevice() {
		// Arrange
		Device device2 = new Device();
		device2.setId(2L);
		device2.setHouseId("2");
		device2.setName("Test Device 2");
		device2.setBrand("Test Brand 2");
		device2.setModel("Test Model 2");
		device2.setStatus("Test Status 2");
		device2.setActive(true);

		when(deviceRepository.save(any(Device.class))).thenReturn(device2);

		// Act
		DeviceResponse newDevice = deviceService.addDevice(device2);

		// Assert
		assertEquals(2L, newDevice.getId());
		assertEquals("2", newDevice.getHouseId());
		assertEquals("Test Device 2", newDevice.getName());
		assertEquals("Test Brand 2", newDevice.getBrand());
		assertEquals("Test Model 2", newDevice.getModel());
		assertEquals("Test Status 2", newDevice.getStatus());
		assertTrue(newDevice.isActive());
		verify(deviceRepository, times(1)).save(device2);
	}

	@Test
	public void testUpdateDevice() {
		// Arrange
		Device existingDevice = new Device();
		existingDevice.setId(1L);
		existingDevice.setHouseId("1");
		existingDevice.setName("Old Device");
		existingDevice.setBrand("Old Brand");
		existingDevice.setModel("Old Model");
		existingDevice.setStatus("Old Status");
		existingDevice.setActive(false);

		Device updatedDevice = new Device();
		updatedDevice.setHouseId("1");
		updatedDevice.setName("Updated Device");
		updatedDevice.setBrand("Updated Brand");
		updatedDevice.setModel("Updated Model");
		updatedDevice.setStatus("Updated Status");
		updatedDevice.setActive(true);

		when(deviceRepository.findById(1L)).thenReturn(Optional.of(existingDevice));
		when(deviceRepository.save(any(Device.class))).thenReturn(updatedDevice);

		// Act
		DeviceResponse response = deviceService.updateDevice(1L, updatedDevice);

		// Assert
		assertEquals("Updated Device", response.getName());
		assertEquals("Updated Brand", response.getBrand());
		assertEquals("Updated Model", response.getModel());
		assertEquals("Updated Status", response.getStatus());
		assertTrue(response.isActive());
		verify(deviceRepository, times(1)).findById(1L);
		verify(deviceRepository, times(1)).save(existingDevice);
	}

	@Test
	public void testDeleteDevice() {
		// Arrange
		Device device = new Device();
		device.setId(1L);
		when(deviceRepository.findById(1L)).thenReturn(Optional.of(device));

		// Act
		deviceService.deleteDevice(1L);

		// Assert
		verify(deviceRepository, times(1)).findById(1L);
		verify(deviceRepository, times(1)).delete(device);
	}
}
