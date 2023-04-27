package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Word;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.DateUtils;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.GameRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.request.ValidatePositionsRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class WordControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Mock
    GameRepository gameRepository;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testCheckIfwordExtistMustReturnOKStatus() throws Exception {
        final String OK_URL = "/checkIfWordExists/word";

        this.mockMvc.perform(MockMvcRequestBuilders.get(OK_URL))
                .andExpect(status().isOk());
    }

    @Test
    public void testEndPointValidatePositionsReturnOkStatus() throws Exception {
        final UUID GAME_ID = UUID.randomUUID();
        final String VALIDATE_POSITIONS_URL = "/validatePositions/{game_id}";
        ValidatePositionsRequest requestBody = new ValidatePositionsRequest('a', 'b', 'a', 'c', 'a');

        Game game = new Game(GAME_ID);
        when(gameRepository.save(game)).thenReturn(game);
        
        this.mockMvc.perform(MockMvcRequestBuilders.post(VALIDATE_POSITIONS_URL, GAME_ID)
                .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(requestBody)))
                .andExpect(status().isOk());
    }

}
