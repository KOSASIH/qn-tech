package com.qntech.collaboration;

import java.util.ArrayList;
import java.util.List;

public class RealTimeCommunication {
    private List<String> messages;

    public RealTimeCommunication() {
        messages = new ArrayList<>();
    }

    // Sends a message to a user
    public void sendMessage(String message, String user) {
        messages.add("Message to " + user + ": " + message);
        System.out.println("Sent: " + message + " to " + user);
    }

    // Retrieves all messages
    public List<String> getMessages() {
        return messages;
    }

    // Initiates a video call with a user
    public String initiateVideoCall(String user) {
        return "Video call initiated with " + user;
    }
}
