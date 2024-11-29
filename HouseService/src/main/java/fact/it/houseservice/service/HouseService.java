package fact.it.houseservice.service;


import fact.it.houseservice.dto.HouseResponse;
import fact.it.houseservice.model.House;
import fact.it.houseservice.repository.HouseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HouseService {
private final HouseRepository houseRepository;

    @Transactional(readOnly = true)
public List<HouseResponse> getAllHouses() {
        return houseRepository.findAll().stream().map(house ->
                HouseResponse.builder()
                        .id(house.getId())
                        .address(house.getAddress())
                        .city(house.getCity())
                        .postalCode(house.getPostalCode())
                        .numberOfRooms(house.getNumberOfRooms())
                        .ownerName(house.getOwnerName())
                        .constructionYear(house.getConstructionYear())
                        .build()
        ).toList();
    }

    @Transactional
    public HouseResponse addHouse(House house) {
        House savedHouse = houseRepository.save(house);
        return HouseResponse.builder()
                .id(savedHouse.getId())
                .address(savedHouse.getAddress())
                .city(savedHouse.getCity())
                .postalCode(savedHouse.getPostalCode())
                .numberOfRooms(savedHouse.getNumberOfRooms())
                .ownerName(savedHouse.getOwnerName())
                .constructionYear(savedHouse.getConstructionYear())
                .build();
    }

    @Transactional
    public HouseResponse updateHouse(Long id, House updatedHouseDetails) {
        House currentHouse = houseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("House not found"));

        currentHouse.setAddress(updatedHouseDetails.getAddress());
        currentHouse.setCity(updatedHouseDetails.getCity());
        currentHouse.setPostalCode(updatedHouseDetails.getPostalCode());
        currentHouse.setNumberOfRooms(updatedHouseDetails.getNumberOfRooms());
        currentHouse.setOwnerName(updatedHouseDetails.getOwnerName());
        currentHouse.setConstructionYear(updatedHouseDetails.getConstructionYear());

        House savedHouse = houseRepository.save(currentHouse);

        return HouseResponse.builder()
                .id(savedHouse.getId())
                .address(savedHouse.getAddress())
                .city(savedHouse.getCity())
                .postalCode(savedHouse.getPostalCode())
                .numberOfRooms(savedHouse.getNumberOfRooms())
                .ownerName(savedHouse.getOwnerName())
                .constructionYear(savedHouse.getConstructionYear())
                .build();
    }

    @Transactional
    public void deleteHouse(Long id) {
        House house = houseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("House not found"));

        houseRepository.delete(house);
    }
}

