import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.ensemble import RandomForestClassifier
from sklearn.metrics import classification_report, confusion_matrix
import joblib

class RiskAssessmentModel:
    def __init__(self, data_path):
        self.data = pd.read_csv(data_path)
        self.model = RandomForestClassifier(n_estimators=100, random_state=42)

    def preprocess_data(self):
        """Preprocess the data for training."""
        # Example preprocessing steps
        self.data.fillna(0, inplace=True)
        self.data['risk_level'] = self.data['risk_level'].map({'low': 0, 'medium': 1, 'high': 2})
        self.features = self.data.drop('risk_level', axis=1)
        self.labels = self.data['risk_level']

    def train_model(self):
        """Train the risk assessment model."""
        self.preprocess_data()
        X_train, X_test, y_train, y_test = train_test_split(self.features, self.labels, test_size=0.2, random_state=42)
        self.model.fit(X_train, y_train)
        predictions = self.model.predict(X_test)
        print(classification_report(y_test, predictions))
        print(confusion_matrix(y_test, predictions))

    def save_model(self, filename='risk_assessment_model.pkl'):
        """Save the trained model to a file."""
        joblib.dump(self.model, filename)

    def load_model(self, filename='risk_assessment_model.pkl'):
        """Load a trained model from a file."""
        self.model = joblib.load(filename)

    def predict(self, input_data):
        """Predict risk level for new data."""
        return self.model.predict([input_data])

# Example usage
if __name__ == "__main__":
    risk_model = RiskAssessmentModel('risk_data.csv')
    risk_model.train_model()
    risk_model.save_model()
