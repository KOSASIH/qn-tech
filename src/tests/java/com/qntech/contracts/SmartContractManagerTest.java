package com.qntech.contracts;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SmartContractManagerTest {

    @Test
    void testDeployContract() {
        SmartContractManager manager = new SmartContractManager();
        String contractAddress = manager.deployContract("contractCode");
        assertNotNull(contractAddress);
    }

    @Test
    void testGetContractDetails() {
        SmartContractManager manager = new SmartContractManager();
        String contractAddress = manager.deployContract("contractCode");
        String details = manager.getContractDetails(contractAddress);
        assertNotNull(details);
    }
}
