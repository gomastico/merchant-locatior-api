package com.qless.challenge.merchantlocatorapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneNumber {

    private String countryCode;
    private String digits;
}
