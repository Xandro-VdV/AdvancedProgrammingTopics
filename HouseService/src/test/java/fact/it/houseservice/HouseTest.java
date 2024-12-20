package fact.it.houseservice;

import fact.it.houseservice.model.House;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HouseTest {
    private House house;

    @BeforeEach
    public void setUp() {
        house = new House();
    }

    @Test
    public void testDefaultConstructor() {
        assertNotNull(house);
        assertNull(house.getId());
        assertNull(house.getCity());
        assertNull(house.getOwnerName());
        assertNull(house.getAddress());
        assertNull(house.getPostalCode());
        assertNull(house.getNumberOfRooms());
    }

    @Test
    public void testAllArgsConstructor() {
        house = new House(1L, "AnAddress", "ACity", "2200", "4", "Kato Horemans", 2023);

        assertNotNull(house);
        assertEquals(1L, house.getId());
        assertEquals("AnAddress", house.getAddress());
        assertEquals("ACity", house.getCity());
        assertEquals("2200", house.getPostalCode());
        assertEquals("4", house.getNumberOfRooms());
        assertEquals("Kato Horemans", house.getOwnerName());
        assertEquals(2023, house.getConstructionYear());
    }

    @Test
    public void testingGettersnSetters() {
        house.setId(2L);
        assertEquals(2L, house.getId());
        house.setAddress("AnAddress");
        assertEquals("AnAddress", house.getAddress());
        house.setCity("ACity");
        assertEquals("ACity", house.getCity());
        house.setNumberOfRooms("2");
        assertEquals("2", house.getNumberOfRooms());
        house.setOwnerName("AnOwnerName");
        assertEquals("AnOwnerName", house.getOwnerName());
        house.setPostalCode("2240");
        assertEquals("2240", house.getPostalCode());
    }
}
