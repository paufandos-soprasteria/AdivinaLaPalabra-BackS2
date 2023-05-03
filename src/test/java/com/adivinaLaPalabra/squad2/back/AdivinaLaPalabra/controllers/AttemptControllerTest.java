package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.CheckFiveAttemptsDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl.AttemptServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
public class AttemptControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    AttemptServiceImpl attemptService;

    @Test
    void testEndpointNewGameMustReturnOK() throws Exception {
        final String NEW_GAME_URL = "/checkFiveAttempts/40981bf7-c7ba-4b17-9226-95e99a48bc1b";
        this.mockMvc.perform(MockMvcRequestBuilders.get(NEW_GAME_URL))
                .andExpect(status().isOk());
    }
}
