package com.qntech.automated_deployment;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DeployService {

    private Map<String, DeploymentStatus> deployedContracts = new HashMap<>();

    public String deployContract(ContractDeploymentRequest request) {
        // Logic to deploy the smart contract using Web3j or similar library
        String contractAddress = "0x" + generateRandomAddress();
        deployedContracts.put(contractAddress, new DeploymentStatus(contractAddress, "Deployed"));
        return contractAddress;
    }

    public void rollbackContract(String contractAddress) {
        // Logic to rollback the contract deployment
        deployedContracts.remove(contractAddress);
    }

    public DeploymentStatus getContractStatus(String contractAddress) {
        return deployedContracts.getOrDefault(contractAddress, new DeploymentStatus(contractAddress, "Not Found"));
    }

    private String generateRandomAddress() {
        // Generate a random Ethereum address for demonstration
        return Long.toHexString(Double.doubleToLongBits(Math.random()));
    }
}
