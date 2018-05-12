package com.qless.challenge.merchantlocatorapi;


import com.qless.challenge.merchantlocatorapi.model.Location;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class MerchantLocatiorControllerIntegrationTest extends AbstractBaseIntegrationTest {

    @Test
    public void getAllMerchantLocatorWithNameMissionAndOmmitConsumerFeatures() {
        ResponseEntity<Location[]> response = restTemplate.getForEntity(BASE_URL + "?searchText=Mission&omitConsumerFeature=true", Location[].class);
        assertThat(HttpStatus.OK, is(response.getStatusCode()));
        assertThat("Mission", is(response.getBody()[0].getName()));
        assertThat(response.getBody()[0].getConsumerFeatures(), is(nullValue()));
    }

    @Test
    public void getMerchantLocatorByGID() {
        ResponseEntity<Location> response = restTemplate.getForEntity(BASE_URL + "/B714F41486AF376AA9E9AC912CD00AD77144776C", Location.class);
        assertThat(HttpStatus.OK, is(response.getStatusCode()));
    }

    @Test
    public void getMerchantLocatorByFakeGID() {
        ResponseEntity<Location> response = restTemplate.getForEntity(BASE_URL + "/123", Location.class);
        assertThat(HttpStatus.NOT_FOUND, is(response.getStatusCode()));
    }
}