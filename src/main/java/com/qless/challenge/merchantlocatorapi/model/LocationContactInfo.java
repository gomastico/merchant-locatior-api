package com.qless.challenge.merchantlocatorapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationContactInfo {

    private String timeZone;
    private Address address;
    private PhoneNumber phone;
    private PhoneNumber fax;
    private GPSCoordinates gps;
}
