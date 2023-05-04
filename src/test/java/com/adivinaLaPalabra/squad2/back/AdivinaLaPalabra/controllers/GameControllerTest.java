package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.controllers;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.CheckAttemptsInRangeDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.CorrectWordDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.GameRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.WordRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl.GameServiceImpl;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl.WordServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.TestHelper.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class GameControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    GameServiceImpl gameService;

    @Mock
    GameRepository gameRepository;

    @InjectMocks
    WordServiceImpl wordService;

    @Mock
    WordRepository wordRepository;

    @Test
    void testEndpointNewGameMustReturnOK() throws Exception {
        when(gameService.newGame()).thenReturn(GAME);
        this.mockMvc.perform(MockMvcRequestBuilders.get(NEW_GAME_URL))
                .andExpect(status().isOk())
                .andExpect(content().json(NEW_GAME_EXPECTED_DATA));
    }

    @Test
    void testEndpointCheckAttemptsInRangeMustReturnOK() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get(CHECK_ATTEMPTS_IN_RANGE_URL+GAME_ID))
                .andExpect(status().isOk());
    }

    @Test
    void testGetCorrectWordMustReturnCorrectWord() {
        when(gameService.getCorrectWord(GAME_ID)).thenReturn(new CorrectWordDTO(EXISTENT_WORD));
        final CorrectWordDTO EXPEXTED_WORD = new CorrectWordDTO(EXISTENT_WORD);
        CorrectWordDTO correctWordDTO = gameService.getCorrectWord(GAME_ID);
        assertEquals(EXPEXTED_WORD.getCorrectWord(),correctWordDTO.getCorrectWord());
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true","4,true","5,false","10,false"})
    void testCheckAttemptsInRangeMustReturnInRange(int attemptNumber,boolean expectedResult) {
        final CheckAttemptsInRangeDTO EXPECTED_DTO = new CheckAttemptsInRangeDTO(expectedResult);
        Game game = new Game(GAME_ID);
        game.setAttempts(attemptNumber);
        when(gameService.checkFiveAttempts(GAME_ID)).thenReturn(EXPECTED_DTO);
        CheckAttemptsInRangeDTO checkAttemptsInRangeDTO = gameService.checkFiveAttempts(GAME_ID);
        assertThat(checkAttemptsInRangeDTO).usingRecursiveComparison().isEqualTo(EXPECTED_DTO);
    }
}
