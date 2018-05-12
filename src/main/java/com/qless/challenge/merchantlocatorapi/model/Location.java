package com.qless.challenge.merchantlocatorapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "locations")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location {

    private NetworkSource source;
    @Indexed
    private String name;
    private String description;
    private Merchant merchantInfo;
    private LocationContactInfo contactInfo;
    private ConsumerFeatures consumerFeatures;
}
