package com.qntech.data;

import java.util.HashMap;
import java.util.Map;

public class DataPrivacyManager {
    private Map<String, String> userAccessControl;

    public DataPrivacyManager() {
        userAccessControl = new HashMap<>();
    }

    // Adds a user with specific access rights
    public void addUser (String username, String accessLevel) {
        userAccessControl.put(username, accessLevel);
    }

    // Checks if a user has access to specific data
    public boolean hasAccess(String username, String requiredAccessLevel) {
        String userAccessLevel = userAccessControl.get(username);
        return userAccessLevel != null && userAccessLevel.equals(requiredAccessLevel);
    }

    // Anonymizes sensitive data
    public String anonymizeData(String data) {
        return data.replaceAll("[0-9]", "*"); // Simple anonymization example
    }
}
