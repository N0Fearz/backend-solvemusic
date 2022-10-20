package com.example.location.controller;

import com.example.location.entity.Location;
import com.example.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locations")
@CrossOrigin(origins = "*")
public class LocationController {
    @Autowired
    private LocationService locationService;

    @GetMapping("/{id}")
    public Location FindLocationById(@PathVariable("id") Long locationId){
        return locationService.findLocationById(locationId);
    }

    @GetMapping("/")
    public List<Location> GetAllLocations() {
        return locationService.getAllLocations();
    }

    @PostMapping("/add")
    public Location saveLocation(@RequestBody Location newLocation) {
        return locationService.saveLocation(newLocation);
    }

    @PutMapping("/edit/{id}")
    public Location updateLocation(@RequestBody Location updateLocation, @PathVariable Long id) {
        return locationService.updateLocation(updateLocation, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteById(id);
    }
}
