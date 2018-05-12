package com.qless.challenge.merchantlocatorapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qless.challenge.merchantlocatorapi.model.Location;
import com.qless.challenge.merchantlocatorapi.respositories.MerchantRepository;
import com.qless.challenge.merchantlocatorapi.services.MerchantLocatorService;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractBaseIntegrationTest {

    @Autowired
    protected TestRestTemplate restTemplate;

    @Autowired
    protected MerchantRepository repository;

    @Autowired
    protected MerchantLocatorService service;

    @Before
    public void setUp() {
        repository.deleteAll();
        this.populateDatabase();
    }

    protected final String BASE_URL = "/merchant/location";

    protected void populateDatabase() {
        Location[] locations = new Location[]{};
        ObjectMapper mapper = new ObjectMapper();
        try {
            locations = mapper.readValue(new File("source.json"), Location[].class);
            Stream.of(locations).forEach(l -> repository.save(l));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
