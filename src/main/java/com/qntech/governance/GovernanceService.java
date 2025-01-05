package com.qntech.governance;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GovernanceService {

    private Map<String, Proposal> proposals = new HashMap<>();
    private Map<String, ProposalResults> results = new HashMap<>();

    public String createProposal(Proposal proposal) {
        String proposalId = generateProposalId();
        proposals.put(proposalId, proposal);
        results.put(proposalId, new ProposalResults());
        return proposalId;
    }

    public void castVote(String proposalId, Vote vote) {
        ProposalResults proposalResults = results.get(proposalId);
        proposalResults.addVote(vote);
    }

    public ProposalResults getProposalResults(String proposalId) {
        return results.get(proposalId);
    }

    public List<Proposal> getAllProposals() {
        return new ArrayList<>(proposals.values());
    }

    private String generateProposalId() {
        return "PROP-" + System.currentTimeMillis();
    }
}
