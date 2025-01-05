package com.qntech.automated_deployment;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class DeployControllerTest {

    @InjectMocks
    private DeployController deployController;

    @Mock
    private DeployService deployService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(deployController).build();
    }

    @Test
    public void testDeployContract() throws Exception {
        // Arrange
        ContractDeploymentRequest request = new ContractDeploymentRequest();
        request.setContractName("TestContract");
        request.setContractCode("contract code here");
        String contractAddress = "0x1234567890abcdef";
        when(deployService.deployContract(any(ContractDeploymentRequest.class))).thenReturn(contractAddress);

        // Act & Assert
        mockMvc.perform(post("/deploy/contract")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"contractName\":\"TestContract\", \"contractCode\":\"contract code here\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string("Contract deployed at address: " + contractAddress));
    }

    @Test
    public void testRollbackContract() throws Exception {
        // Arrange
        doNothing().when(deployService).rollbackContract(anyString());

        // Act & Assert
        mockMvc.perform(post("/deploy/rollback/0x1234567890abcdef"))
                .andExpect(status().isOk())
                .andExpect(content().string("Contract rolled back successfully."));
    }

    @Test
    public void testGetDeploymentStatus() throws Exception {
        // Arrange
        DeploymentStatus status = new DeploymentStatus("0x1234567890abcdef", "SUCCESS");
        when(deployService.getContractStatus(anyString())).thenReturn(status);

        // Act & Assert
        mockMvc.perform(get("/deploy/status/0x1234567890abcdef"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
