package com.example.fileservice.service;

import com.example.fileservice.entity.Location;
import com.example.fileservice.repository.LocationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LocationServiceTest {

    @Mock
    private LocationRepository mockLocationRepository;

    @InjectMocks
    private LocationService locationServiceUnderTest;

    @Test
    void testFindLocationById() {
        // Setup
        final Location expectedResult = new Location(0L, "locationName", "locationSource", "locationDestination");

        // Configure LocationRepository.findByLocationId(...).
        final Location location = new Location(0L, "locationName", "locationSource", "locationDestination");
        when(mockLocationRepository.findByLocationId(0L)).thenReturn(location);

        // Run the test
        final Location result = locationServiceUnderTest.findLocationById(0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAllLocations() {
        // Setup
        final List<Location> expectedResult = List.of(
                new Location(0L, "locationName", "locationSource", "locationDestination"));

        // Configure LocationRepository.findAll(...).
        final List<Location> locations = List.of(
                new Location(0L, "locationName", "locationSource", "locationDestination"));
        when(mockLocationRepository.findAll()).thenReturn(locations);

        // Run the test
        final List<Location> result = locationServiceUnderTest.getAllLocations();

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testGetAllLocations_LocationRepositoryReturnsNoItems() {
        // Setup
        when(mockLocationRepository.findAll()).thenReturn(Collections.emptyList());

        // Run the test
        final List<Location> result = locationServiceUnderTest.getAllLocations();

        // Verify the results
        assertThat(result).isEqualTo(Collections.emptyList());
    }

    @Test
    void testSaveLocation() {
        // Setup
        final Location newLocation = new Location(0L, "locationName", "locationSource", "locationDestination");
        final Location expectedResult = new Location(0L, "locationName", "locationSource", "locationDestination");

        // Configure LocationRepository.save(...).
        final Location location = new Location(0L, "locationName", "locationSource", "locationDestination");
        when(mockLocationRepository.save(
                new Location(0L, "locationName", "locationSource", "locationDestination"))).thenReturn(location);

        // Run the test
        final Location result = locationServiceUnderTest.saveLocation(newLocation);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testUpdateLocation() {
        // Setup
        final Location updateLocation = new Location(0L, "locationName", "locationSource", "locationDestination");
        final Location expectedResult = new Location(0L, "locationName", "locationSource", "locationDestination");

        // Configure LocationRepository.findById(...).
        final Optional<Location> location = Optional.of(
                new Location(0L, "locationName", "locationSource", "locationDestination"));
        when(mockLocationRepository.findById(0L)).thenReturn(location);

        // Configure LocationRepository.save(...).
        final Location location1 = new Location(0L, "locationName", "locationSource", "locationDestination");
        when(mockLocationRepository.save(
                new Location(0L, "locationName", "locationSource", "locationDestination"))).thenReturn(location1);

        // Run the test
        final Location result = locationServiceUnderTest.updateLocation(updateLocation, 0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testUpdateLocation_LocationRepositoryFindByIdReturnsAbsent() {
        // Setup
        final Location updateLocation = new Location(0L, "locationName", "locationSource", "locationDestination");
        final Location expectedResult = new Location(0L, "locationName", "locationSource", "locationDestination");
        when(mockLocationRepository.findById(0L)).thenReturn(Optional.empty());

        // Configure LocationRepository.save(...).
        final Location location = new Location(0L, "locationName", "locationSource", "locationDestination");
        when(mockLocationRepository.save(
                new Location(0L, "locationName", "locationSource", "locationDestination"))).thenReturn(location);

        // Run the test
        final Location result = locationServiceUnderTest.updateLocation(updateLocation, 0L);

        // Verify the results
        assertThat(result).isEqualTo(expectedResult);
    }

    @Test
    void testDeleteById() {
        // Setup
        // Run the test
        locationServiceUnderTest.deleteById(0L);

        // Verify the results
        verify(mockLocationRepository).deleteById(0L);
    }
}
