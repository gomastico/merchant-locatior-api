package com.qless.challenge.merchantlocatorapi.services;

import com.qless.challenge.merchantlocatorapi.model.Location;
import com.qless.challenge.merchantlocatorapi.model.QueryParametersEntity;
import com.qless.challenge.merchantlocatorapi.respositories.MerchantRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Service
public class MerchantLocatorServiceImpl implements MerchantLocatorService {

    private final MerchantRepository repository;
    private static final int MAX_RESULTS = 10;

    public MerchantLocatorServiceImpl(MerchantRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Location> searchAllMerchantLocations(String searchText,
                                                     Double longitude,
                                                     Double latitude,
                                                     Integer searchRadius,
                                                     String[] gid,
                                                     Integer maximumResults,
                                                     boolean mobileClientAccess,
                                                     boolean omitMerchantInfo,
                                                     boolean omitContactInfo,
                                                     boolean omitConsumerFeature,
                                                     String xFields) {
        List<Location> resultList = new ArrayList<>();
        try (Stream<Location> result = (Stream<Location>) repository.findAllByCustomQuery()) {
            resultList = result
                    .parallel()
                    .filter(l -> searchText.contains(l.getName()) ||
                            latitude == l.getContactInfo().getGps().getLatitude() ||
                            longitude == l.getContactInfo().getGps().getLongitude())
                    .limit(maximumResults)
                    .map(l -> applyFilters(omitMerchantInfo, omitContactInfo, omitConsumerFeature, l))
                    .collect(toList());
        }
        return resultList;
    }

    @Override
    public Location searchByGID(boolean mobileClientAccess,
                                boolean omitMerchantInfo,
                                boolean omitContactInfo,
                                boolean omitConsumerFeatures,
                                String xFields,
                                String location_gid) {

        Location location = repository.findByGlobalId(location_gid, mobileClientAccess);
        location = applyFilters(omitMerchantInfo, omitContactInfo, omitConsumerFeatures, location);

        return location;
    }

    private Location applyFilters(boolean omitMerchantInfo, boolean omitContactInfo, boolean omitConsumerFeatures, Location location) {
        Location l = location;
        if (location != null) {
            if (omitMerchantInfo) {
                location.setMerchantInfo(null);
            }
            if (omitContactInfo) {
                location.setContactInfo(null);
            }
            if (omitConsumerFeatures) {
                location.setConsumerFeatures(null);
            }
        }
        return l;
    }
}
