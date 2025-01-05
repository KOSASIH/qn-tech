package com.qntech.governance;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/governance")
public class GovernanceController {

    @Autowired
    private GovernanceService governanceService;

    @PostMapping("/propose")
    public ResponseEntity<String> proposeChange(@RequestBody Proposal proposal) {
        String proposalId = governanceService.createProposal(proposal);
        return ResponseEntity.ok("Proposal created with ID: " + proposalId);
    }

    @PostMapping("/vote/{proposalId}")
    public ResponseEntity<String> vote(@PathVariable String proposalId, @RequestBody Vote vote) {
        governanceService.castVote(proposalId, vote);
        return ResponseEntity.ok("Vote cast successfully.");
    }

    @GetMapping("/results/{proposalId}")
    public ResponseEntity<ProposalResults> getResults(@PathVariable String proposalId) {
        ProposalResults results = governanceService.getProposalResults(proposalId);
        return ResponseEntity.ok(results);
    }

    @GetMapping("/proposals")
    public ResponseEntity<List<Proposal>> getAllProposals() {
        List<Proposal> proposals = governanceService.getAllProposals();
        return ResponseEntity.ok(proposals);
    }
}
