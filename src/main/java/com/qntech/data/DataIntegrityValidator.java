package com.qntech.data;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DataIntegrityValidator {
    
    // Generates a SHA-256 hash of the input data
    public String generateHash(String data) throws NoSuchAlgorithmException {
        MessageDigest .getInstance("SHA-256");
        byte[] hashBytes = digest.digest(data.getBytes());
        StringBuilder hashString = new StringBuilder();
        for (byte b : hashBytes) {
            hashString.append(String.format("%02x", b));
        }
        return hashString.toString();
    }

    // Validates the integrity of the data by comparing hashes
    public boolean validateDataIntegrity(String originalData, String hashToCompare) throws NoSuchAlgorithmException {
        String generatedHash = generateHash(originalData);
        return generatedHash.equals(hashToCompare);
    }
}
