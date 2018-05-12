package com.qless.challenge.merchantlocatorapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GPSCoordinates {

    private double longitude;
    private double latitude;
}
