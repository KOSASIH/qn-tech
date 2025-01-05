package com.qntech.governance;

public class Vote {
    private String voterId;
    private boolean inFavor;

    public Vote(String voterId, boolean inFavor) {
        this.voterId = voterId;
        this.inFavor = inFavor;
    }

    public String getVoterId() {
        return voterId;
    }

    public boolean isInFavor() {
        return inFavor;
    }
}
