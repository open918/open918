package org.open918.lib.services;

import org.junit.Test;
import org.open918.lib.domain.Carrier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by joelhaasnoot on 18/11/2016.
 */
public class CarrierServiceTest {

    @Test
    public void testReadCompanyCodes() {
        CarrierService service = new CarrierService();
        Carrier ns = service.getCarrier(1184);
        assertEquals("NL", ns.getCountry());
        assertEquals("http://www.ns.nl/", ns.getWebsite());

        assertNull(service.getCarrier(101)); // Dummy
    }

}
