package com.qntech.interoperability;

public class TransferRequest {
    private String toChain;
    private double amount;

    // Getters and Setters
    public String getToChain() {
        return toChain;
    }

    public void setToChain(String toChain) {
        this.toChain = toChain;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
