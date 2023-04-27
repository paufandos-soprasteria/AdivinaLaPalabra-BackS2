package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.WordRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.GameRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class GameServiceImplTest {

    @Mock
    GameServiceImpl gameService;

    @Mock
    GameRepository gameRepository;

    @Mock
    WordRepository dictionaryRepository;

    // @Test
    // void testNewGameMustReturnAnInt() {
    //     final int GAME_ID = 1;
    //     final Word CORRECT_WORD = new Word(1, "abaca");
    //     final Game NEW_GAME = new Game(CORRECT_WORD, DateUtils.generateLocalDateNow());
    //     final GameDTO ASSERT_GAME_ID = new GameDTO(GAME_ID);

    //     when(gameRepository.save(NEW_GAME)).thenReturn(new Game());
    //     when(dictionaryRepository.count()).thenReturn(1L);
    //     when(gameService.newGame()).thenReturn(ASSERT_GAME_ID);

    //     assertInstanceOf(Game.class, NEW_GAME);
    // }
}
