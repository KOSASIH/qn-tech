package com.qntech.governance;

import java.util.ArrayList;
import java.util.List;

public class ProposalResults {
    private int votesFor;
    private int votesAgainst;
    private List<Vote> voteList;

    public ProposalResults() {
        this.votesFor = 0;
        this.votesAgainst = 0;
        this.voteList = new ArrayList<>();
    }

    public void addVote(Vote vote) {
        voteList.add(vote);
        if (vote.isInFavor()) {
            votesFor++;
        } else {
            votesAgainst++;
        }
    }

    public int getVotesFor() {
        return votesFor;
    }

    public int getVotesAgainst() {
        return votesAgainst;
    }
}
