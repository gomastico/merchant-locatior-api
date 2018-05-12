package com.qless.challenge.merchantlocatorapi.respositories;

import com.qless.challenge.merchantlocatorapi.model.Location;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.stream.Stream;

@Repository
public interface MerchantRepository extends MongoRepository<Location, String> {

    @Query("{}")
    Stream<Location> findAllByCustomQuery();

    @Query("{'source.globalId' :?0}, {'consumerFeatures.hasMobileAccess' : ?1}")
    Location findByGlobalId(String globalId, boolean hastMobileAccess);

}
