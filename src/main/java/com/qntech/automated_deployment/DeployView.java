package com.qntech.automated_deployment;

import org.springframework.stereotype.Component;

@Component
public class DeployView {

    public void displayDeploymentForm() {
        // Logic to render a form for deploying a smart contract
        System.out.println("Displaying deployment form...");
    }

    public void displayDeploymentStatus(DeploymentStatus status) {
        // Logic to render the status of a deployed contract
        System.out.println("Contract Address: " + status.getContractAddress());
        System.out.println("Status: " + status.getStatus());
    }
}
