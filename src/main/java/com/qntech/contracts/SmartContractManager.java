package com.qntech.contracts;

import java.util.HashMap;
import java.util.Map;

public class SmartContractManager {
    private Map<String, SmartContract> contracts;

    public SmartContractManager() {
        contracts = new HashMap<>();
    }

    // Creates a new smart contract
    public String createContract(String contractId, String terms) {
        SmartContract contract = new SmartContract(contractId, terms);
        contracts.put(contractId, contract);
        return contractId;
    }

    // Executes a smart contract
    public String executeContract(String contractId) {
        SmartContract contract = contracts.get(contractId);
        if (contract != null) {
            return contract.execute();
        } else {
            return "Contract not found.";
        }
    }

    // Retrieves the terms of a smart contract
    public String getContractTerms(String contractId) {
        SmartContract contract = contracts.get(contractId);
        return contract != null ? contract.getTerms() : "Contract not found.";
    }

    // Inner class representing a smart contract
    private class SmartContract {
        private String contractId;
        private String terms;
        private boolean executed;

        public SmartContract(String contractId, String terms) {
            this.contractId = contractId;
            this.terms = terms;
            this.executed = false;
        }

        public String execute() {
            if (!executed) {
                executed = true;
                return "Contract executed: " + terms;
            } else {
                return "Contract has already been executed.";
            }
        }

        public String getTerms() {
            return terms;
        }
    }
}
