package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testEndpointNewGameMustReturnOK() throws Exception {
        final String NEW_GAME_URL = "/newGame";
        final String AUTH_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiY0dGMVptRnVaRzl6IiwiaWF0IjoxNjgzNTM3NDU5LCJleHAiOjI2ODM1Mzc0NTh9.1wcPPYvUA5e6FCsPvfjp073ioL_kY4plPNykmFmGvCs";

        this.mockMvc.perform(MockMvcRequestBuilders.get(NEW_GAME_URL)
                .header("Authorization","Bearer " + AUTH_TOKEN))
                .andExpect(status().isOk());
    }
}
