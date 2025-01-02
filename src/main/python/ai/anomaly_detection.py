import pandas as pd
from sklearn.ensemble import IsolationForest
import numpy as np

class AnomalyDetection:
    def __init__(self, data_path):
        self.data = pd.read_csv(data_path)
        self.model = IsolationForest(contamination=0.1, random_state=42)

    def preprocess_data(self):
        """Preprocess the data for anomaly detection."""
        self.data.fillna(0, inplace=True)
        self.features = self.data.select_dtypes(include=[np.number])  # Select only numeric features

    def fit_model(self):
        """Fit the anomaly detection model."""
        self.preprocess_data()
        self.model.fit(self.features)

    def detect_anomalies(self):
        """Detect anomalies in the dataset."""
        predictions = self.model.predict(self.features)
        # Anomalies are labeled as -1
        self.data['anomaly'] = predictions
        return self.data[self.data['anomaly'] == -1]

# Example usage
if __name__ == "__main__":
    anomaly_detector = AnomalyDetection('data.csv')
    anomaly_detector.fit_model()
    anomalies = anomaly_detector.detect_anomalies()
    print("Detected Anomalies:")
    print(anomalies)
