package fact.it.houseservice;

import fact.it.houseservice.dto.HouseResponse;
import fact.it.houseservice.model.House;
import fact.it.houseservice.repository.HouseRepository;
import fact.it.houseservice.service.HouseService;
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
public class HouseServiceApplicationTests {

    @InjectMocks
    private HouseService houseService;

    @Mock
    private HouseRepository houseRepository;

    @Test
    public void testGetAllHouses() {
        // Arrange
        House house1 = new House();
        house1.setId(1L);
        house1.setAddress("123 Test Street");
        house1.setCity("Test City");
        house1.setPostalCode("12345");
        house1.setNumberOfRooms("4");
        house1.setOwnerName("Test Owner");
        house1.setConstructionYear(2000);
        when(houseRepository.findAll()).thenReturn(List.of(house1));

        // Act
        List<HouseResponse> houses = houseService.getAllHouses();

        // Assert
        assertEquals(1, houses.size());
        assertEquals(1L, houses.get(0).getId());
        assertEquals("123 Test Street", houses.get(0).getAddress());
        assertEquals("Test City", houses.get(0).getCity());
        assertEquals("12345", houses.get(0).getPostalCode());
        assertEquals("4", houses.get(0).getNumberOfRooms());
        assertEquals("Test Owner", houses.get(0).getOwnerName());
        assertEquals(2000, houses.get(0).getConstructionYear());

        verify(houseRepository, times(1)).findAll();
    }

    @Test
    public void testAddHouse() {
        // Arrange
        House house2 = new House();
        house2.setId(2L);
        house2.setAddress("456 Another Street");
        house2.setCity("Another City");
        house2.setPostalCode("67890");
        house2.setNumberOfRooms("3");
        house2.setOwnerName("Another Owner");
        house2.setConstructionYear(2010);

        when(houseRepository.save(any(House.class))).thenReturn(house2);

        // Act
        HouseResponse newHouse = houseService.addHouse(house2);

        // Assert
        assertEquals(2L, newHouse.getId());
        assertEquals("456 Another Street", newHouse.getAddress());
        assertEquals("Another City", newHouse.getCity());
        assertEquals("67890", newHouse.getPostalCode());
        assertEquals("3", newHouse.getNumberOfRooms());
        assertEquals("Another Owner", newHouse.getOwnerName());
        assertEquals(2010, newHouse.getConstructionYear());
        verify(houseRepository, times(1)).save(house2);
    }

    @Test
    public void testUpdateHouse() {
        // Arrange
        House existingHouse = new House();
        existingHouse.setId(1L);
        existingHouse.setAddress("Old Address");
        existingHouse.setCity("Old City");
        existingHouse.setPostalCode("00000");
        existingHouse.setNumberOfRooms("2");
        existingHouse.setOwnerName("Old Owner");
        existingHouse.setConstructionYear(1990);

        House updatedHouse = new House();
        updatedHouse.setAddress("Updated Address");
        updatedHouse.setCity("Updated City");
        updatedHouse.setPostalCode("54321");
        updatedHouse.setNumberOfRooms("5");
        updatedHouse.setOwnerName("Updated Owner");
        updatedHouse.setConstructionYear(2020);

        when(houseRepository.findById(1L)).thenReturn(Optional.of(existingHouse));
        when(houseRepository.save(any(House.class))).thenReturn(updatedHouse);

        // Act
        HouseResponse response = houseService.updateHouse(1L, updatedHouse);

        // Assert
        assertEquals("Updated Address", response.getAddress());
        assertEquals("Updated City", response.getCity());
        assertEquals("54321", response.getPostalCode());
        assertEquals("5", response.getNumberOfRooms());
        assertEquals("Updated Owner", response.getOwnerName());
        assertEquals(2020, response.getConstructionYear());
        verify(houseRepository, times(1)).findById(1L);
        verify(houseRepository, times(1)).save(existingHouse);
    }

    @Test
    public void testDeleteHouse() {
        // Arrange
        House house = new House();
        house.setId(1L);
        when(houseRepository.findById(1L)).thenReturn(Optional.of(house));

        // Act
        houseService.deleteHouse(1L);

        // Assert
        verify(houseRepository, times(1)).findById(1L);
        verify(houseRepository, times(1)).delete(house);
    }
}
