package com.qntech.data;

import java.util.List;
import java.util.stream.Collectors;

public class DataAnalytics {
    
    // Calculates the average of a list of numbers
    public double calculateAverage(List<Double> data) {
        return data.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    // Predicts future values based on a simple linear regression model
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

    // Filters data based on a threshold
    public List<Double> filterDataAboveThreshold(List<Double> data, double threshold) {
        return data.stream().filter(value -> value > threshold).collect(Collectors.toList());
    }
}
