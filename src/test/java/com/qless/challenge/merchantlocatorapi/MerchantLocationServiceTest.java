package com.qless.challenge.merchantlocatorapi;

import com.qless.challenge.merchantlocatorapi.model.Location;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class MerchantLocationServiceTest extends AbstractBaseIntegrationTest {

    @Test
    public void searchAllAndFilterByParameters() {
        List<Location> result = service.searchAllMerchantLocations("Mission",
                0d,
                0d,
                null,
                null,
                2,
                false,
                false,
                false,
                false,
                null);

        assertThat(result, is(not(Collections.EMPTY_LIST)));
        assertThat(result.get(0).getName(), is("Mission"));
        assertThat(result.get(0).getSource().getGlobalId(), is("EF7BE5A5EE23A51D339A43CDC1D62982EB61CC3F"));
        assertThat(result.get(0).getConsumerFeatures(), not(nullValue()));
    }

    @Test
    public void searchByGID() {
        Location resultLocation = service.searchByGID(false,
                false,
                false,
                false,
                null,
                "606A3D78F0341ADB789E60664A3EC5245525B073");

        assertThat(resultLocation.getName(), is("Olathe"));
        assertThat(resultLocation.getConsumerFeatures(), not(nullValue()));
    }
}
