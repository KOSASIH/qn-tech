package com.qntech.governance;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class GovernanceControllerTest {

    @InjectMocks
    private GovernanceController governanceController;

    @Mock
    private GovernanceService governanceService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(governanceController).build();
    }

    @Test
    public void testProposeChange() throws Exception {
        Proposal proposal = new Proposal("Increase block size");
        String proposalId = "PROP-12345";
        when(governanceService.createProposal(any(Proposal.class))).thenReturn(proposalId);

        mockMvc.perform(post("/governance/propose")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"description\":\"Increase block size\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Proposal created with ID: " + proposalId));
    }

    @Test
    public void testVote() throws Exception {
        Vote vote = new Vote("user1", true);
        doNothing().when(governanceService).castVote(anyString(), any(Vote.class));

        mockMvc.perform(post("/governance/vote/PROP-12345")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"voterId\":\"user1\", \"inFavor\":true}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Vote cast successfully."));
    }

    @Test
    public void testGetResults() throws Exception {
        ProposalResults results = new ProposalResults();
        when(governanceService.getProposalResults(anyString())).thenReturn(results);

        mockMvc.perform(get("/governance/results/PROP-12345"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
