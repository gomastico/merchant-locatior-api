package com.qless.challenge.merchantlocatorapi.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NetworkSource {

    private SourceDataType type;
    private String globalId;
    private String hostName;
    private String hostId;
    private String indirectId;

}
