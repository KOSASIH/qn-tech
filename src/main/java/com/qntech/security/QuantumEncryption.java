package com.qntech.security;

import java.security.SecureRandom;
import java.util.Base64;

public class QuantumEncryption {
    private static final SecureRandom secureRandom = new SecureRandom();

    // Encrypts the plaintext using a quantum key
    public String encrypt(String plaintext, String quantumKey) {
        byte[] keyBytes = Base64.getDecoder().decode(quantumKey);
        byte[] plaintextBytes = plaintext.getBytes();
        byte[] encryptedBytes = new byte[plaintextBytes.length];

        for (int i = 0; i < plaintextBytes.length; i++) {
            encryptedBytes[i] = (byte) (plaintextBytes[i] ^ keyBytes[i % keyBytes.length]);
        }

        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Generates a quantum key using a secure random generator
    public String generateQuantumKey(int length) {
        byte[] key = new byte[length];
        secureRandom.nextBytes(key);
        return Base64.getEncoder().encodeToString(key);
    }
}
