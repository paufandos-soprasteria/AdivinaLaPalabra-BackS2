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

    final String BASE_URL = "http://localhost:8080/";

    @Autowired
    MockMvc mockMvc;

    @Test
    void testEndpointNewGameMustReturnOK() throws Exception {
        final String NEW_GAME_URL = BASE_URL + "/newGame";
        this.mockMvc.perform(MockMvcRequestBuilders.get(NEW_GAME_URL))
                .andExpect(status().isOk());
    }
}
