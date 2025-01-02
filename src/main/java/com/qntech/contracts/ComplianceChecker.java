package com.qntech.contracts;

import java.util.ArrayList;
import java.util.List;

public class ComplianceChecker {
    private List<String> complianceRules;

    public ComplianceChecker() {
        complianceRules = new ArrayList<>();
        loadComplianceRules();
    }

    // Loads predefined compliance rules
    private void loadComplianceRules() {
        complianceRules.add("Rule 1: All contracts must be signed digitally.");
        complianceRules.add("Rule 2: Contracts must include a termination clause.");
        complianceRules.add("Rule 3: All parties must be identified.");
    }

    // Checks if a contract complies with the rules
    public boolean checkCompliance(String contractTerms) {
        // Simple compliance check logic (can be expanded)
        for (String rule : complianceRules) {
            if (!contractTerms.contains(rule)) {
                return false;
            }
        }
        return true;
    }

    // Returns the list of compliance rules
    public List<String> getComplianceRules() {
        return complianceRules;
    }
}
