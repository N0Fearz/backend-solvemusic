package com.example.fileservice.controller;

import javax.validation.Valid;

import com.example.fileservice.entity.Location;
import com.example.fileservice.errors.LocationNotFoundException;
import com.example.fileservice.model.LocationRequestModel;
import com.example.fileservice.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
@CrossOrigin(origins = "http://localhost:3000")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/{id}")
    public Location findLocationById(@PathVariable("id") Long locationId){
        if (locationService.findLocationById(locationId) == null){
            throw new LocationNotFoundException("Location not found");
        }
        return locationService.findLocationById(locationId);
    }

    @GetMapping("/")
    public List<Location> getAllLocations() {
        return locationService.getAllLocations();
    }

    @PostMapping("/add")
    public Location saveLocation(@Valid @RequestBody LocationRequestModel newLocation) {
        Location location = new Location(newLocation);
        return locationService.saveLocation(location);
    }

    @PutMapping("/edit/{id}")
    public Location updateLocation(@Valid @RequestBody LocationRequestModel updateLocation, @PathVariable Long id) {
        Location location = new Location(updateLocation);
        return locationService.updateLocation(location, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLocation(@PathVariable Long id) {
        if (locationService.findLocationById(id) == null){
            throw new LocationNotFoundException("Location not found");
        }

        locationService.deleteById(id);
    }
}
