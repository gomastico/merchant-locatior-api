package com.qless.challenge.merchantlocatorapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private List<String> addressLines;
    private String city;
    private String state;
    private String postalCode;
    private String isoCountryCode;
}
