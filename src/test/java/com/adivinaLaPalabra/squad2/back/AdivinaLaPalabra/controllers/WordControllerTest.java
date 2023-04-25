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
public class WordControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testEndPointValidatePositionsReturnOkStatus() throws Exception {
        final String VALIDATE_POSITIONS_URL = "/validatePositions";

        this.mockMvc.perform(MockMvcRequestBuilders.post(VALIDATE_POSITIONS_URL).param("word", "abaco"))
                .andExpect(status().isOk());
    }

}
