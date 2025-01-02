package com.qntech.collaboration;

import java.util.ArrayList;
import java.util.List;

public class CollaborationTool {
    private List<String> documents;
    private List<String> tasks;

    public CollaborationTool() {
        documents = new ArrayList<>();
        tasks = new ArrayList<>();
    }

    // Adds a document to the collaboration tool
    public void addDocument(String document) {
        documents.add(document);
        System.out.println("Document added: " + document);
    }

    // Retrieves all documents
    public List<String> getDocuments() {
        return documents;
    }

    // Adds a task to the collaboration tool
    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    // Retrieves all tasks
    public List<String> getTasks() {
        return tasks;
    }

    // Shares a document with a user
    public void shareDocument(String document, String user) {
        if (documents.contains(document)) {
            System.out.println("Document '" + document + "' shared with " + user);
        } else {
            System.out.println("Document not found.");
        }
    }
}
