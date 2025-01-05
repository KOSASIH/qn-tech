package com.qntech.automated_deployment;

public class ContractDeploymentRequest {
    private String contractName;
    private String contractCode;

    // Getters and Setters
    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public String getContractCode() {
        return contractCode;
    }

    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }
}
