import pandas as pd
import spacy
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.metrics.pairwise import cosine_similarity

class ComplianceChecker:
    def __init__(self, compliance_documents):
        self.nlp = spacy.load("en_core_web_sm")
        self.compliance_documents = compliance_documents
        self.vectorizer = CountVectorizer().fit_transform(compliance_documents)
        self.vectors = self.vectorizer.toarray()

    def check_compliance(self, new_document):
        """Check compliance of a new document against existing documents."""
        new_vector = self.vectorizer.transform([new_document]).toarray()
        cosine_similarities = cosine_similarity(new_vector, self.vectors)
        return cosine_similarities.flatten()

    def analyze_document(self, document):
        """Analyze the document for compliance issues."""
        doc = self.nlp(document)
        issues = []
        for sent in doc.sents:
            if "non-compliant" in sent.text.lower():
                issues.append(sent.text)
        return issues

# Example usage
if __name__ == "__main__":
    compliance_docs = [
        "Document 1: This document is compliant with regulations.",
        "Document 2: This document is non-compliant due to missing signatures."
    ]
    checker = ComplianceChecker(compliance_docs)
    new_doc = "This is a new document that is compliant."
    compliance_scores = checker.check_compliance(new_doc)
    print("Compliance Scores:", compliance_scores)
    issues = checker.analyze_document("This document is non-compliant due to missing information.")
    print("Compliance Issues:", issues)
