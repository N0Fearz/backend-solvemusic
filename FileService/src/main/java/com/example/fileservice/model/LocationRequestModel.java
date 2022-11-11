package com.example.fileservice.model;

import lombok.Data;

@Data
public class LocationRequestModel {
    private Long locationId;
    private String locationName;
    private String locationSource;
    private String locationDestination;
}
