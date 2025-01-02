package com.qntech.security;

import java.util.Base64;

public class SecureDataTransmission {
    private QuantumEncryption quantumEncryption;
    private QuantumKeyDistribution quantumKeyDistribution;

    public SecureDataTransmission() {
        this.quantumEncryption = new QuantumEncryption();
        this.quantumKeyDistribution = new QuantumKeyDistribution();
    }

    // Transmits data securely
    public String transmitData(String data) {
        String quantumKey = quantumKeyDistribution.generateQuantumKey(128);
        String encryptedData = quantumEncryption.encrypt(data, quantumKey);
        // In a real implementation, the quantum key would be shared securely
        return "Encrypted Data: " + encryptedData + "\nQuantum Key: " + quantumKey;
    }

    // Receives and decrypts data
    public String receiveData(String encryptedData, String quantumKey) {
        return quantumEncryption.decrypt(encryptedData, quantumKey);
    }
}
