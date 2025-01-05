package com.qntech.interoperability;

public class TransferStatus {
    private String transactionId;
    private String status;
    private double amount;
    private String toChain;

    public TransferStatus(String transactionId, String status, double amount, String toChain) {
        this.transactionId = transactionId;
        this.status = status;
        this.amount = amount;
        this.toChain = toChain;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getStatus() {
        return status;
    }

    public double getAmount() {
        return amount;
    }

    public String getToChain() {
        return toChain;
    }
}
