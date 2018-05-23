package com.qless.challenge.merchantlocatorapi;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.qless.challenge.merchantlocatorapi.model.Location;
import com.qless.challenge.merchantlocatorapi.respositories.MerchantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.stream.Stream;

@Component
public class MerchantLocatorInit implements CommandLineRunner {


    private final MerchantRepository repository;

    public MerchantLocatorInit(MerchantRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        populateDatabase();
    }

    protected void populateDatabase() {
        //clean all
        repository.deleteAll();

        //populate database
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
