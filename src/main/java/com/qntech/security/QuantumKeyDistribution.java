package com.qntech.security;

import java.util.Random;

public class QuantumKeyDistribution {
    private static final Random random = new Random();

    // Simulates the generation of a quantum key using BB84 protocol
    public String generateQuantumKey(int length) {
        StringBuilder key = new StringBuilder();
        for (int i = 0; i < length; i++) {
            key.append(random.nextBoolean() ? '0' : '1');
        }
        return key.toString();
    }

    // Simulates the measurement of the quantum key
    public String measureKey(String quantumKey) {
        StringBuilder measuredKey = new StringBuilder();
        for (char bit : quantumKey.toCharArray()) {
            measuredKey.append(random.nextBoolean() ? bit : (bit == '0' ? '1' : '0'));
        }
        return measuredKey.toString();
    }
}
