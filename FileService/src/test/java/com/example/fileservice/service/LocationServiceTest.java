package com.example.fileservice.service;

import com.example.fileservice.entity.Location;
import com.example.fileservice.repository.LocationRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.testng.AssertJUnit.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LocationServiceTest {
    @Mock
    LocationRepository locationRepository;

    @InjectMocks
    LocationService locationService;

    @Test
    public void shouldReturnAllLocations() {
        List<Location> locations = new ArrayList();
        locations.add(new Location());
        given(locationRepository.findAll()).willReturn(locations);
        List<Location> expected = locationService.getAllLocations();
        assertEquals(expected, locations);
        verify(locationRepository).findAll();
    }
}
