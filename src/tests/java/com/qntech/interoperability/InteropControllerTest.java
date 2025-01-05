package com.qntech.interoperability;

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

public class InteropControllerTest {

    @InjectMocks
    private InteropController interopController;

    @Mock
    private InteropService interopService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(interopController).build();
    }

    @Test
    public void testExecuteInteropFunction() throws Exception {
        InteropRequest request = new InteropRequest("functionName", "param1");
        String result = "Function executed successfully";
        when(interopService.executeFunction(any(InteropRequest.class))).thenReturn(result);

        mockMvc.perform(post("/interop/execute")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"functionName\":\"functionName\", \"param\":\"param1\"}"))
                .andExpect(status().isOk())
                .andExpect(content().string(result));
    }

    @Test
    public void testGetInteropStatus() throws Exception {
        InteropStatus status = new InteropStatus("functionName", "COMPLETED");
        when(interopService.getStatus(anyString())).thenReturn(status);

        mockMvc.perform(get("/interop/status/functionName"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
          }
