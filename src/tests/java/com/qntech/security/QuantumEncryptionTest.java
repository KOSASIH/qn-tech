package com.qntech.security;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantumEncryptionTest {

    @Test
    void testEncrypt() {
        QuantumEncryption quantumEncryption = new QuantumEncryption();
        String plaintext = "Hello, World!";
        String encrypted = quantumEncryption.encrypt(plaintext);
        assertNotNull(encrypted);
        assertNotEquals(plaintext, encrypted);
    }

    @Test
    void testDecrypt() {
        QuantumEncryption quantumEncryption = new QuantumEncryption();
        String plaintext = "Hello, World!";
        String encrypted = quantumEncryption.encrypt(plaintext);
        String decrypted = quantumEncryption.decrypt(encrypted);
        assertEquals(plaintext, decrypted);
    }
}
