package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.CheckAttemptsInRangeDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.CorrectWordDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Word;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.WordRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.GameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.mock.mockito.MockBean;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class GameServiceImplTest {

    @InjectMocks
    GameServiceImpl gameService;

    @Mock
    GameRepository gameRepository;

    @MockBean
    WordServiceImpl wordService;

    @Mock
    WordRepository wordRepository;

    @Captor
    ArgumentCaptor<Game> captor;

    @Test
    void testNewGameMustReturnAnInt() {
        final UUID GAME_ID = UUID.randomUUID();
        final Word CORRECT_WORD = new Word(1, "abaca");
        final Game NEW_GAME = new Game(CORRECT_WORD);
        final Game SAVE_GAME = new Game(CORRECT_WORD);
        SAVE_GAME.setId(GAME_ID);
        NEW_GAME.setId(GAME_ID);

        when(wordRepository.getReferenceById(anyInt())).thenReturn(CORRECT_WORD);
        when(wordRepository.count()).thenReturn(1L);
        when(gameRepository.save(captor.capture())).thenReturn(null);

        gameService.newGame();
        Game saveGame = captor.getValue();
        assertEquals(CORRECT_WORD,saveGame.getCorrectWord());
    }

    @Test
    void testGetCorrectWordMustReturnCorrectWord() {
        final UUID GAME_ID = UUID.randomUUID();
        final String WORD = "abaca";
        final Word CORRECT_WORD = new Word(1, WORD);
        Game game = new Game(GAME_ID,CORRECT_WORD);
        when(gameRepository.getReferenceById(GAME_ID)).thenReturn(game);
        final CorrectWordDTO EXPEXTED_WORD = new CorrectWordDTO(WORD);
        CorrectWordDTO correctWordDTO = gameService.getCorrectWord(GAME_ID);
        assertEquals(EXPEXTED_WORD.getCorrectWord(),correctWordDTO.getCorrectWord());
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true","4,true","5,false","10,false"})
    void testCheckFiveAttemptsMustReturnInRange(int attemptNumber,boolean expectedResult) {
        final UUID GAME_ID = UUID.randomUUID();
        final CheckAttemptsInRangeDTO EXPECTED_DTO = new CheckAttemptsInRangeDTO(expectedResult);
        Game game = new Game(GAME_ID);
        game.setAttempts(attemptNumber);
        when(gameRepository.getReferenceById(GAME_ID)).thenReturn(game);
        CheckAttemptsInRangeDTO checkAttemptsInRangeDTO = gameService.checkFiveAttempts(GAME_ID);
        assertThat(checkAttemptsInRangeDTO).usingRecursiveComparison().isEqualTo(EXPECTED_DTO);
    }
}
