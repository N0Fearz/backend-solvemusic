package com.example.locationservice.service;

import com.example.locationservice.entity.Location;
import com.example.locationservice.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public Location findLocationById(Long locationId) {
        return locationRepository.findByLocationId(locationId);
    }

    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    public Location saveLocation(Location newLocation) {
        return locationRepository.save(newLocation);
    }

    public Location updateLocation(Location updateLocation, Long id) {
        return locationRepository.findById(id)
                .map(location -> {
                    location.setLocationName(updateLocation.getLocationName());
                    location.setLocationSource(updateLocation.getLocationSource());
                    location.setLocationDestination(updateLocation.getLocationDestination());
                    return locationRepository.save(location);
                })
                .orElseGet(() -> {
                    updateLocation.setLocationId(id);
                    return locationRepository.save(updateLocation);
                });
    }

    public void deleteById(Long id) {
        locationRepository.deleteById(id);
    }
}
