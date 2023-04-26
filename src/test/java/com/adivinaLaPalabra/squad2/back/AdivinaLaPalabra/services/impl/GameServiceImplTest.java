package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Word;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.WordRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.GameRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.DateUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class GameServiceImplTest {

    @Mock
    GameServiceImpl gameService;

    @Mock
    WordServiceImpl dictionaryService;

    @Mock
    GameRepository gameRepository;

    @Mock
    WordRepository dictionaryRepository;

    @Test
    void testNewGameMustReturnAnInt() {
        final Word CORRECT_WORD = new Word(1, "abaca");
        final Game NEW_GAME = new Game(CORRECT_WORD, DateUtils.generateLocalDateNow());

        when(gameRepository.save(NEW_GAME)).thenReturn(new Game());
        when(dictionaryRepository.count()).thenReturn(1L);
        when(gameService.newGame()).thenReturn(NEW_GAME);

        assertInstanceOf(Game.class, NEW_GAME);
    }
}
