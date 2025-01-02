package com.qntech.data;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DataExchangeProtocolTest {

    @Test
    void testInitiateExchange() {
        DataExchangeProtocol protocol = new DataExchangeProtocol();
        boolean result = protocol.initiateExchange("source", "destination");
        assertTrue(result);
    }

    @Test
    void testValidateData() {
        DataExchangeProtocol protocol = new DataExchangeProtocol();
        boolean isValid = protocol.validateData("sampleData");
        assertTrue(isValid);
    }
}
