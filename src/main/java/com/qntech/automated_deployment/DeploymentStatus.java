package com.qntech.automated_deployment;

public class DeploymentStatus {
    private String contractAddress;
    private String status;

    public DeploymentStatus(String contractAddress, String status) {
        this.contractAddress = contractAddress;
        this.status = status;
    }

    public String getContractAddress() {
        return contractAddress;
    }

    public String getStatus() {
        return status;
    }
}
