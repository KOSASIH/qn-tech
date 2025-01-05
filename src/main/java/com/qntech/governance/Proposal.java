package com.qntech.governance;

public class Proposal {
    private String id;
    private String description;

    public Proposal(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() ```java
    {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
