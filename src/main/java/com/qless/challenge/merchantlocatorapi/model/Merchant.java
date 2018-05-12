package com.qless.challenge.merchantlocatorapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Merchant {

    private NetworkSource source;
    private String name;
}
