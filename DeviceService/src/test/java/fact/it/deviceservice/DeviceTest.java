package fact.it.deviceservice;

import fact.it.deviceservice.model.Device;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeviceTest {
    private Device device;

    @BeforeEach
    void setUp() {
        device = new Device();
    }

    @Test
    void testDefaultConstructor(){
        assertNotNull(device);
        assertNull(device.getId());
        assertNull(device.getHouseId());
        assertNull(device.getName());
        assertNull(device.getModel());
        assertNull(device.getStatus());
        assertNull(device.getBrand());
    }

    @Test
    void testAllArgsConstructor() {
    device = new Device(1L, "1", "Camera", "Philips", "l320", "Idle", true);

    assertEquals(1L, device.getId());
    assertEquals("1", device.getHouseId());
    assertEquals("Camera", device.getName());
    assertEquals("Philips", device.getBrand());
    assertEquals("l320", device.getModel());
    assertEquals("Idle", device.getStatus());
    assertTrue(device.isActive());
    }

    @Test
    void testingSettersnGetters(){
        device.setId(2L);
        assertEquals(2L, device.getId());
        device.setHouseId("2");
        assertEquals("2", device.getHouseId());
        device.setName("New Name");
        assertEquals("New Name", device.getName());
        device.setModel("New Model");
        assertEquals("New Model", device.getModel());
        device.setStatus("New Status");
        assertEquals("New Status", device.getStatus());
        device.setBrand("New Brand");
        assertEquals("New Brand", device.getBrand());
        device.setActive(true);
        assertTrue(device.isActive());
    }
}
