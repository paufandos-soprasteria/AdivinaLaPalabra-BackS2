package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.WordRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl.GameServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.UUID;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    GameServiceImpl gameService;

    @MockBean
    WordRepository wordRepository;

    @Test
    void testEndpointNewGameMustReturnOK() throws Exception {
        final String NEW_GAME_URL = "/newGame";
        when(wordRepository.getReferenceById(1)).thenReturn(new Game().getCorrectWord());
        when(gameService.newGame()).thenReturn(new Game());
        this.mockMvc.perform(MockMvcRequestBuilders.get(NEW_GAME_URL))
                .andExpect(status().isOk());
    }

    @Test
    void testEndpointCheckFiveAttemptsMustReturnOK() throws Exception {
        final String NEW_GAME_URL = "/checkFiveAttempts/40981bf7-c7ba-4b17-9226-95e99a48bc1b";
        this.mockMvc.perform(MockMvcRequestBuilders.get(NEW_GAME_URL))
                .andExpect(status().isOk());
    }

    @Test
    void testGetCorrectWordMustReturnOKStatus() throws Exception {
        UUID GAME_ID = UUID.randomUUID();
        final String OK_URL = "/getCorrectWord/";
        this.mockMvc.perform(MockMvcRequestBuilders.get(OK_URL+GAME_ID))
                .andExpect(status().isOk());
    }
}
