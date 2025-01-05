package com.qntech.interoperability;

import org.springframework.stereotype.Component;

@Component
public class InteropView {

    public void displayTransferForm() {
        // Logic to render a form for initiating a cross-chain transfer
        System.out.println("Displaying transfer form...");
    }

    public void displayTransferStatus(TransferStatus status) {
        // Logic to render the status of a cross-chain transfer
        System.out.println("Transaction ID: " + status.getTransactionId());
        System.out.println("Status: " + status.getStatus());
        System.out.println("Amount: " + status.getAmount());
        System.out.println("To Chain: " + status.getToChain());
    }
}
