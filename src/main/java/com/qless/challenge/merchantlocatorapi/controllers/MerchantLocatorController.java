package com.qless.challenge.merchantlocatorapi.controllers;

import com.qless.challenge.merchantlocatorapi.model.Location;
import com.qless.challenge.merchantlocatorapi.services.MerchantLocatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(MerchantLocatorController.BASE_URL)
public class MerchantLocatorController {

    public static final String BASE_URL = "/merchant/location";

    private final MerchantLocatorService locatorService;

    public MerchantLocatorController(MerchantLocatorService locatorService) {
        this.locatorService = locatorService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Location>> searchForMerchantLocations(@RequestParam(required = false, defaultValue = "") String searchText,
                                   @RequestParam(required = false, defaultValue = "0") Double longitude,
                                   @RequestParam(required = false, defaultValue = "0") Double latitude,
                                   @RequestParam(required = false, defaultValue = "0") Integer searchRadius,
                                   @RequestParam(required = false) String[] gid,
                                   @RequestParam(required = false, defaultValue = "10") Integer maximumResults,
                                   @RequestParam(required = false, defaultValue = "false") boolean mobileClientAccess,
                                   @RequestParam(required = false, defaultValue = "false") boolean omitMerchantInfo,
                                   @RequestParam(required = false, defaultValue = "false") boolean omitContactInfo,
                                   @RequestParam(required = false, defaultValue = "false") boolean omitConsumerFeature,
                                   @RequestParam(required = false, defaultValue = "") String xFields) {

        List<Location> results = locatorService.searchAllMerchantLocations(searchText,
                                                                        longitude,
                                                                        latitude,
                                                                        searchRadius,
                                                                        gid,
                                                                        maximumResults,
                                                                        mobileClientAccess,
                                                                        omitMerchantInfo,
                                                                        omitContactInfo,
                                                                        omitConsumerFeature,
                                                                        xFields);
        return ResponseEntity.ok(results);
    }

    @GetMapping(path = "/{location_gid}")
    public ResponseEntity<Location> searchByLocation(@RequestParam (required = false, defaultValue = "false") boolean mobileClientAccess,
                                                     @RequestParam (required = false, defaultValue = "false") boolean omitMerchantInfo,
                                                     @RequestParam (required = false, defaultValue = "false") boolean omitContactInfo,
                                                     @RequestParam (required = false, defaultValue = "false") boolean omitConsumerFeatures,
                                                     @RequestParam (required = false, defaultValue = "") String xFields,
                                                     @PathVariable String location_gid) {


        Location location = locatorService.searchByGID(mobileClientAccess, omitMerchantInfo, omitContactInfo, omitConsumerFeatures, xFields, location_gid);

        if (location == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(location);
    }
}