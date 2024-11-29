package fact.it.deviceservice.repository;

import fact.it.deviceservice.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DeviceRepository extends JpaRepository<Device, Long> {
List<Device> findAll();
}
