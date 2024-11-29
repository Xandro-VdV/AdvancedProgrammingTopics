package fact.it.houseservice.repository;

import fact.it.houseservice.model.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface HouseRepository extends JpaRepository<House, Long> {
List<House> findAll();
}
