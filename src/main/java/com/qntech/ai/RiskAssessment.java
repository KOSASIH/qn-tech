package com.qntech.ai;

import java.util.HashMap;
import java.util.Map;

public class RiskAssessment {

    private static final double THRESHOLD = 0.7; // Risk threshold for flagging

    public RiskAssessmentResult assessRisk(Transaction transaction) {
        double riskScore = calculateRiskScore(transaction);
        boolean isHighRisk = riskScore > THRESHOLD;

        return new RiskAssessmentResult(riskScore, isHighRisk);
    }

    private double calculateRiskScore(Transaction transaction) {
        // Example risk factors
        double amountRisk = transaction.getAmount() > 10000 ? 0.5 : 0.1; // High amount risk
        double frequencyRisk = transaction.getFrequency() > 5 ? 0.3 : 0.1; // High frequency risk
        double historyRisk = transaction.getUser History().getRiskLevel(); // User's historical risk

        // Simple risk score calculation
        return (amountRisk + frequencyRisk + historyRisk) / 3;
    }
}
