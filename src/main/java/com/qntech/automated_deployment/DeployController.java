package com.qntech.automated_deployment;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/deploy")
public class DeployController {

    @Autowired
    private DeployService deployService;

    @PostMapping("/contract")
    public ResponseEntity<String> deployContract(@RequestBody ContractDeploymentRequest request) {
        String contractAddress = deployService.deployContract(request);
        return ResponseEntity.ok("Contract deployed at address: " + contractAddress);
    }

    @PostMapping("/rollback/{contractAddress}")
    public ResponseEntity<String> rollbackContract(@PathVariable String contractAddress) {
        deployService.rollbackContract(contractAddress);
        return ResponseEntity.ok("Contract rolled back successfully.");
    }

    @GetMapping("/status/{contractAddress}")
    public ResponseEntity<DeploymentStatus> getContractStatus(@PathVariable String contractAddress) {
        DeploymentStatus status = deployService.getContractStatus(contractAddress);
        return ResponseEntity.ok(status);
    }
}
