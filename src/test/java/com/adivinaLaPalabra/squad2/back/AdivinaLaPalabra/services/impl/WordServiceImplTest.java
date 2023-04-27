package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Letter;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions.BadRequestException;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.GameRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.DateUtils;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Word;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.WordRepository;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class WordServiceImplTest {

    @InjectMocks
    WordServiceImpl wordServiceImpl;

    @InjectMocks
    GameServiceImpl gameService;

    @Mock
    WordRepository wordRepository;

    @Mock
    GameRepository gameRepository;

    @Test
    void testCheckIfWordExistsMustReturnTrueIfWordExist() {
        final Word EXISTING_WORD_IN_THE_DICTIONARY = new Word(1, "abaca");
        when(wordRepository.findByValue(EXISTING_WORD_IN_THE_DICTIONARY.getValue()))
                .thenReturn(EXISTING_WORD_IN_THE_DICTIONARY);

        Boolean assertDictionaryWord = wordServiceImpl
                .checkIfWordExists(EXISTING_WORD_IN_THE_DICTIONARY.getValue());

        assertTrue(assertDictionaryWord);
    }

    @Test
    void testCheckIfWordExistsMustReturnFalseIfWordNotExist() {
        final String NONEXISTENT_WORD_IN_THE_DICTIONARY = "aaaaa";
        when(wordRepository.findByValue(NONEXISTENT_WORD_IN_THE_DICTIONARY)).thenReturn(null);

        Boolean assertDictionaryWord = wordServiceImpl.checkIfWordExists(NONEXISTENT_WORD_IN_THE_DICTIONARY);

        assertFalse(assertDictionaryWord);
    }

    @Test
    public void testValidatePositionsMustReturnWordList() throws BadRequestException {
        final int GAME_ID = 1;
        final String REQUEST = "amigo";

        final Word CORRECT_WORD = new Word(1, "abaca");
        final Word REQUEST_WORD = new Word(2, "amigo");
        final Game NEW_GAME = new Game(CORRECT_WORD, DateUtils.generateLocalDateNow());

        when(wordRepository.findByValue(REQUEST)).thenReturn(REQUEST_WORD);
        when(gameRepository.save(NEW_GAME)).thenReturn(NEW_GAME);
        when(gameRepository.getReferenceById(GAME_ID)).thenReturn(NEW_GAME);

        assertInstanceOf(List.class,wordServiceImpl.validatePositions(REQUEST,GAME_ID));
    }

    @Test
    public void testCheckIfIsBadWord() {
        assertThatThrownBy(() -> wordServiceImpl.checkIfIsBadWord(null))
                .isInstanceOf(BadRequestException.class);
    }

    @Test
    public void testValidatePositionsNotMatchedLetterStatus() {
        final String CORRECT_WORD = "perro";
        final String CORRECT_WORD_LETTER = "p";
        final String REQUEST_WORD_LETTER = "h";
        final int NOT_MATCHED_LETTER_STATUS = 0;
        assertEquals(NOT_MATCHED_LETTER_STATUS,wordServiceImpl.validateLetter(CORRECT_WORD,REQUEST_WORD_LETTER,CORRECT_WORD_LETTER));
    }

    @Test
    public void testValidatePositionsMatchedLetterStatus() {
        final String CORRECT_WORD = "perro";
        final String CORRECT_WORD_LETTER = "p";
        final String REQUEST_WORD_LETTER = "p";
        final int MATCHED_LETTER_STATUS = 1;
        assertEquals(MATCHED_LETTER_STATUS,wordServiceImpl.validateLetter(CORRECT_WORD,REQUEST_WORD_LETTER,CORRECT_WORD_LETTER));
    }

    @Test
    public void testValidatePositionsContainedLetterStatus() {
        final String CORRECT_WORD = "campo";
        final String CORRECT_WORD_LETTER = "c";
        final String REQUEST_WORD_LETTER = "p";
        final int CONTAINED_LETTER_STATUS = 2;
        assertEquals(CONTAINED_LETTER_STATUS,wordServiceImpl.validateLetter(CORRECT_WORD,REQUEST_WORD_LETTER,CORRECT_WORD_LETTER));
    }
}
