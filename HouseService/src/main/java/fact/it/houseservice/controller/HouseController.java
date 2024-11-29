package fact.it.houseservice.controller;

import fact.it.houseservice.dto.HouseResponse;
import fact.it.houseservice.model.House;
import fact.it.houseservice.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/house")
@RequiredArgsConstructor
public class HouseController {
    private final HouseService houseService;

    @GetMapping("/all")
    public List<HouseResponse> getAllHouses() {
        return houseService.getAllHouses();
    }

    @PostMapping
    public ResponseEntity<HouseResponse> addHouse(@RequestBody House house) {
        HouseResponse houseResponse = houseService.addHouse(house);
        return ResponseEntity.status(HttpStatus.CREATED).body(houseResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HouseResponse> updateHouse(@PathVariable Long id, @RequestBody House house) {
        HouseResponse houseResponse = houseService.updateHouse(id, house);
        return ResponseEntity.ok(houseResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHouse(@PathVariable Long id) {
        houseService.deleteHouse(id);
        return ResponseEntity.noContent().build();
    }
}
