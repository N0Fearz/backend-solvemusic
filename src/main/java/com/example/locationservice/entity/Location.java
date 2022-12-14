package com.example.locationservice.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long locationId;
    private String locationName;
    private String locationSource;
    private String locationDestination;

    public Long getLocationId(){ return locationId; }

    public String getLocationName(){ return locationName; }

    public String getLocationSource(){ return locationSource; }

    public String getLocationDestination(){ return locationDestination; }

    public void setLocationId(Long id){ locationId = id; }

    public void setLocationName(String name){ locationName = name; }

    public void setLocationSource(String source){ locationSource = source; }

    public void setLocationDestination(String destination){ locationDestination = destination; }
}
