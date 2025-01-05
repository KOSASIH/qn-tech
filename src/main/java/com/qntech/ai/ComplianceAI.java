package com.qntech.ai;

import java.util.List;

public class ComplianceAI {

    public ComplianceResult checkCompliance(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            if (!isCompliant(transaction)) {
                return new ComplianceResult(transaction.getId(), false, "Non-compliant transaction detected.");
            }
        }
        return new ComplianceResult(null, true, "All transactions are compliant.");
    }

    private boolean isCompliant(Transaction transaction) {
        // Example compliance checks
        return transaction.getAmount() <= 10000 && !transaction.isSuspicious();
    }
}
