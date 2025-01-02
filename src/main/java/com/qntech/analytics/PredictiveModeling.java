package com.qntech.analytics;

import java.util.List;

public class PredictiveModeling {

    // Predicts the next value based on historical data using linear regression
    public double predictNextValue(List<Double> historicalData) {
        if (historicalData.size() < 2) {
            throw new IllegalArgumentException("Insufficient data for prediction.");
        }

        double sumX = 0, sumY = 0, sumXY = 0, sumX2 = 0;
        int n = historicalData.size();

        for (int i = 0; i < n; i++) {
            double x = i + 1; // Time variable
            double y = historicalData.get(i);
            sumX += x;
            sumY += y;
            sumXY += x * y;
            sumX2 += x * x;
        }

        double slope = (n * sumXY - sumX * sumY) / (n * sumX2 - sumX * sumX);
        double intercept = (sumY - slope * sumX) / n;

        return slope * (n + 1) + intercept; // Predicting the next value
    }

    // Evaluates the model's performance using Mean Squared Error (MSE)
    public double evaluateModel(List<Double> actual, List<Double> predicted) {
        if (actual.size() != predicted.size()) {
            throw new IllegalArgumentException("Actual and predicted lists must be of the same size.");
        }

        double mse = 0.0;
        for (int i = 0; i < actual.size(); i++) {
            mse += Math.pow(actual.get(i) - predicted.get(i), 2);
        }
        return mse / actual.size();
    }
}
