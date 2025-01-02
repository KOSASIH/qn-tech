package com.qntech.collaboration;

import java.util.HashMap;
import java.util.Map;

public class VirtualRealityIntegration {
    private Map<String, String> virtualRooms;

    public VirtualRealityIntegration() {
        virtualRooms = new HashMap<>();
    }

    // Creates a virtual room for collaboration
    public String createVirtualRoom(String roomName) {
        virtualRooms.put(roomName, "Room created: " + roomName);
        return "Virtual room '" + roomName + "' created.";
    }

    // Joins a virtual room
    public String joinVirtualRoom(String roomName) {
        if (virtualRooms.containsKey(roomName)) {
            return "Joined virtual room: " + roomName;
        } else {
            return "Virtual room not found.";
        }
    }

    // Displays the list of virtual rooms
    public void listVirtualRooms() {
        System.out.println("Available Virtual Rooms:");
        for (String room : virtualRooms.keySet()) {
            System.out.println("- " + room);
        }
    }
}
