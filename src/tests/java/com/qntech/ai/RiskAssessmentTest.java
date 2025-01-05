package com.qntech.ai;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RiskAssessmentTest {

    private RiskAssessment riskAssessment;

    @BeforeEach
    public void setUp() {
        riskAssessment = new RiskAssessment();
    }

    @Test
    public void testAssessRiskLowAmount() {
        // Arrange
        Transaction transaction = new Transaction();
        transaction.setAmount(5000); // Low amount
        transaction.setFrequency(2); // Low frequency
        UserHistory userHistory = new UserHistory();
        userHistory.setRiskLevel(0.1); // Low historical risk
        transaction.setUser History(userHistory);

        // Act
        RiskAssessmentResult result = riskAssessment.assessRisk(transaction);

        // Assert
        assertFalse(result.isHighRisk(), "Transaction should not be flagged as high risk.");
        assertTrue(result.getRiskScore() < 0.7, "Risk score should be below the threshold.");
    }

    @Test
    public void testAssessRiskHighAmount() {
        // Arrange
        Transaction transaction = new Transaction();
        transaction.setAmount(15000); // High amount
        transaction.setFrequency(2); // Low frequency
        UserHistory userHistory = new UserHistory();
        userHistory.setRiskLevel(0.1); // Low historical risk
        transaction.setUser History(userHistory);

        // Act
        RiskAssessmentResult result = riskAssessment.assessRisk(transaction);

        // Assert
        assertTrue(result.isHighRisk(), "Transaction should be flagged as high risk.");
        assertTrue(result.getRiskScore() > 0.7, "Risk score should be above the threshold.");
    }

    @Test
    public void testAssessRiskHighFrequency() {
        // Arrange
        Transaction transaction = new Transaction();
        transaction.setAmount(5000); // Low amount
        transaction.setFrequency(6); // High frequency
        UserHistory userHistory = new UserHistory();
        userHistory.setRiskLevel(0.1); // Low historical risk
        transaction.setUser History(userHistory);

        // Act
        RiskAssessmentResult result = riskAssessment.assessRisk(transaction);

        // Assert
        assertFalse(result.isHighRisk(), "Transaction should not be flagged as high risk.");
        assertTrue(result.getRiskScore() < 0.7, "Risk score should be below the threshold.");
    }

    @Test
    public void testAssessRiskHighRiskUser History() {
        // Arrange
        Transaction transaction = new Transaction();
        transaction.setAmount(5000); // Low amount
        transaction.setFrequency(2); // Low frequency
        UserHistory userHistory = new UserHistory();
        userHistory.setRiskLevel(0.9); // High historical risk
        transaction.setUser History(userHistory);

        // Act
        RiskAssessmentResult result = riskAssessment.assessRisk(transaction);

        // Assert
        assertTrue(result.isHighRisk(), "Transaction should be flagged as high risk due to user history.");
        assertTrue(result.getRiskScore() > 0.7, "Risk score should be above the threshold.");
    }
}
