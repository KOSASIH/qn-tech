package com.qntech.contracts;

import java.util.ArrayList;
import java.util.List;

public class AutomatedAuditTrail {
    private List<AuditEntry> auditEntries;

    public AutomatedAuditTrail() {
        auditEntries = new ArrayList<>();
    }

    // Records an audit entry
    public void recordEntry(String action, String details) {
        AuditEntry entry = new AuditEntry(action, details);
        auditEntries.add(entry);
    }

    // Retrieves the audit trail
    public List<AuditEntry> getAuditTrail() {
        return auditEntries;
    }

    // Inner class representing an audit entry
    private class AuditEntry {
        private String action;
        private String details;
        private long timestamp;

        public AuditEntry(String action, String details) {
            this.action = action;
            this.details = details;
            this.timestamp = System.currentTimeMillis();
        }

        @Override
        public String toString() {
            return "Action: " + action + ", Details: " + details + ", Timestamp: " + timestamp;
        }
    }
}
