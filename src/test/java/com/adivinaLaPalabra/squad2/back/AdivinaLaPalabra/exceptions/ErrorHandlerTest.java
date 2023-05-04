package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.GameRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.request.ValidatePositionsRequest;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl.GameServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.TestHelper.GAME_ID;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;;

@SpringBootTest
@AutoConfigureMockMvc
public class ErrorHandlerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    GameServiceImpl gameService;

    @MockBean
    GameRepository gameRepository;

    @Test
    void testBadURLRequestMustReturn404Status() throws Exception {
        final String BAD_URL = "/NotNonexistentURL";
        this.mockMvc.perform(MockMvcRequestBuilders.get(BAD_URL))
                .andExpect(status().isNotFound());
    }

    @Test
    void testIncompleteURLRequestMustReturn404Status() throws Exception {
        final String BAD_URL = "/validatePositions/";
        this.mockMvc.perform(MockMvcRequestBuilders.get(BAD_URL))
                .andExpect(status().isNotFound());
    }

    @Test
    void testBadRequestException() throws Exception {
        final String BAD_URL = "/validatePositions/saf";
        ValidatePositionsRequest requestBody = new ValidatePositionsRequest(' ', 'b', 'a', 'c', 'a');
        this.mockMvc.perform(MockMvcRequestBuilders.post(BAD_URL).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(requestBody)))
                .andExpect(status().is5xxServerError());
    }

    @Test
    void testHttpMessageNotReadableException() throws Exception {
        final String BAD_URL = "/validatePositions/dae36a93-0243-4006-ba2c-49d07b28627a";
        this.mockMvc.perform(MockMvcRequestBuilders.post(BAD_URL).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testHandleDatabaseException() throws Exception {
        final String BAD_URL = "/validatePositions/dae36a93-0243-4006-ba2c-49d07b28627a";
        this.mockMvc.perform(MockMvcRequestBuilders.post(BAD_URL).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void testhandleRangeException() throws Exception {
        final String BAD_URL = "/validatePositions/";
        Game game = new Game(GAME_ID);
        game.setAttempts(6);
        when(gameRepository.getReferenceById(GAME_ID)).thenReturn(game);
        ValidatePositionsRequest requestBody = new ValidatePositionsRequest('a', 'b', 'a', 'c', 'a');
        this.mockMvc.perform(MockMvcRequestBuilders.post(BAD_URL+GAME_ID).contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(requestBody)))
                .andExpect(status().isRequestedRangeNotSatisfiable());
    }

    }
