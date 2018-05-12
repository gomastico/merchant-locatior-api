package com.qless.challenge.merchantlocatorapi.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QueryParametersEntity {

    private String searchText;
    private Double longitude;
    private Double latitude;
    private Integer searchRadius;
    private String[] gid;
    private Integer maximumResults;
    private boolean mobileClientAccess;
    private boolean omitMerchantInfo;
    private boolean omitContactInfo;
    private boolean omitConsumerFeatures;
    private String xfields;
}
