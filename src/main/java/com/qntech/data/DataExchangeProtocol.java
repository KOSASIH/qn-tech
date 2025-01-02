package com.qntech.data;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class DataExchangeProtocol {
    private SecretKey secretKey;

    public DataExchangeProtocol() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // Using AES-256
        this.secretKey = keyGen.generateKey();
    }

    // Encrypts the data for secure transmission
    public String encryptData(String data) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedData = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedData);
    }

    // Decrypts the received data
    public String decryptData(String encryptedData) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedData = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
        return new String(decryptedData);
    }

    // Returns the base64 encoded secret key for sharing
    public String getSecretKey() {
        return Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }
}
