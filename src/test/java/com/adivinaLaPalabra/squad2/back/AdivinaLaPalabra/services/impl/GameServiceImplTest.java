package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.GameDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Word;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.WordRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.GameRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.DateUtils;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class GameServiceImplTest {

    @InjectMocks
    GameServiceImpl gameService;

    @Mock
    GameRepository gameRepository;

    @Mock
    WordRepository wordRepository;

    @Captor
    ArgumentCaptor<Game> captor;

    @Test
    void testNewGameMustReturnAnInt() {
        final int GAME_ID = 1;
        final Word CORRECT_WORD = new Word(1, "abaca");
        final Game NEW_GAME = new Game(CORRECT_WORD, DateUtils.generateLocalDateNow());
        final Game SAVE_GAME = new Game(CORRECT_WORD, DateUtils.generateLocalDateNow());
        SAVE_GAME.setId(GAME_ID);
        NEW_GAME.setId(GAME_ID);

        when(wordRepository.getReferenceById(anyInt())).thenReturn(CORRECT_WORD);
        when(wordRepository.count()).thenReturn(1L);
        when(gameRepository.save(captor.capture())).thenReturn(null);

        Game game = gameService.newGame();
        Game saveGame = captor.getValue();
        assertEquals(CORRECT_WORD,saveGame.getCorrectWord());
    }
}
