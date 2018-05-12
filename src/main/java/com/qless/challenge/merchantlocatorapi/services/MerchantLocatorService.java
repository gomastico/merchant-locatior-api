package com.qless.challenge.merchantlocatorapi.services;


import com.qless.challenge.merchantlocatorapi.model.Location;
import com.qless.challenge.merchantlocatorapi.model.QueryParametersEntity;

import java.util.List;

public interface MerchantLocatorService {

    //List<Location> searchAllMerchantLocations(QueryParametersEntity parameters);
    List<Location> searchAllMerchantLocations(String searchText,
                                              Double longitude,
                                              Double latitude,
                                              Integer searchRadius,
                                              String[] gid,
                                              Integer maximumResults,
                                              boolean mobileClientAccess,
                                              boolean omitMerchantInfo,
                                              boolean omitContactInfo,
                                              boolean omitConsumerFeature,
                                              String xFields);

    Location searchByGID(boolean mobileClientAccess,
                         boolean omitMerchantInfo,
                         boolean omitContactInfo,
                         boolean omitConsumerFeatures,
                         String xFields,
                         String location_gid);

}
