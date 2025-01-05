package com.qntech.governance;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GovernanceView {

    public void displayProposalForm() {
        // Logic to render a form for creating a proposal
        System.out.println("Displaying proposal creation form...");
    }

    public void displayVotingResults(ProposalResults results) {
        // Logic to render the results of a proposal vote
        System.out.println("Proposal Results:");
        System.out.println("Votes For: " + results.getVotesFor());
        System.out.println("Votes Against: " + results.getVotesAgainst());
    }

    public void displayAllProposals(List<Proposal> proposals) {
        // Logic to render all proposals
        System.out.println("Current Proposals:");
        for (Proposal proposal : proposals) {
            System.out.println("ID: " + proposal.getId() + ", Description: " + proposal.getDescription());
        }
    }
}
