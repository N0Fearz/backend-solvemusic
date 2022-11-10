package src.main.java.com.example.fileservice.repository;

import src.main.java.com.example.fileservice.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import src.main.java.com.example.fileservice.entity.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findByLocationId(Long locationId);
}
