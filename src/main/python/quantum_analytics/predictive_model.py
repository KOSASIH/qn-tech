import numpy as np

class PredictiveModeling:
    def __init__(self):
        pass

    def predict_next_value(self, historical_data):
        """Predicts the next value based on historical data using linear regression."""
        if len(historical_data) < 2:
            raise ValueError("Insufficient data for prediction.")

        n = len(historical_data)
        x = np.arange(1, n + 1)  # Time variable
        y = np.array(historical_data)

        # Calculate slope (m) and intercept (b) for y = mx + b
        m, b = np.polyfit(x, y, 1)
        next_value = m * (n + 1) + b  # Predicting the next value
        return next_value

    def evaluate_model(self, actual, predicted):
        """Evaluates the model's performance using Mean Squared Error (MSE)."""
        if len(actual) != len(predicted):
            raise ValueError("Actual and predicted lists must be of the same size.")

        mse = np.mean((np.array(actual) - np.array(predicted)) ** 2)
        return mse
