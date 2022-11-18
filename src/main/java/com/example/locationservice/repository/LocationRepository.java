package com.example.locationservice.repository;

import com.example.locationservice.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findByLocationId(Long locationId);
}
