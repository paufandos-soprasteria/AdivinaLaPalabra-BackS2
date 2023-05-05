package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.LetterDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.LetterDTO.Status;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions.BadRequestException;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions.GameIsWinnedException;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.GameRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Word;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.WordRepository;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class WordServiceImplTest {

    @InjectMocks
    WordServiceImpl wordServiceImpl;

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
    public void testValidatePositionsMustReturnWordList() throws BadRequestException, GameIsWinnedException {
        final UUID GAME_ID = UUID.randomUUID();
        final String REQUEST = "halla";
        final String CORRECT = "abaca";
        final List<LetterDTO> EXPECTED_LIST = List.of(
                new LetterDTO('h',Status.NOT_MATCHED,0),
                new LetterDTO('a',Status.CONTAINED,1),
                new LetterDTO('l',Status.NOT_MATCHED,2),
                new LetterDTO('l',Status.NOT_MATCHED,3),
                new LetterDTO('a',Status.MATCHED,4)
        );

        final Word CORRECT_WORD = new Word(1, CORRECT);
        final Word REQUEST_WORD = new Word(2, REQUEST);
        final Game NEW_GAME = new Game(CORRECT_WORD);

        when(wordRepository.findByValue(REQUEST)).thenReturn(REQUEST_WORD);
        when(gameRepository.save(NEW_GAME)).thenReturn(NEW_GAME);
        when(gameRepository.getReferenceById(GAME_ID)).thenReturn(NEW_GAME);

        assertLettersAreExpected(EXPECTED_LIST,wordServiceImpl.validatePositions(REQUEST,GAME_ID));
    }

    void assertLettersAreExpected(List<LetterDTO> expectedLetters, List<LetterDTO> requestLetters) {
        IntStream.range(0, 5).forEach(position -> {
            LetterDTO expectedLetter = expectedLetters.get(position);
            LetterDTO requestLetter = requestLetters.get(position);
            assertEquals(expectedLetter.getLetter(),requestLetter.getLetter());
            assertEquals(expectedLetter.getStatus(),requestLetter.getStatus());
            assertEquals(expectedLetter.getPosition(),requestLetter.getPosition());
        });
    }

    @Test
    public void testCheckIfIsBadWord() {
        assertThatThrownBy(() -> wordServiceImpl.checkIfIsBadWord(null))
                .isInstanceOf(BadRequestException.class);
    }

    @ParameterizedTest
    @CsvSource({"perro,p,h,NOT_MATCHED","perro,p,p,MATCHED","campo,c,p,CONTAINED"})
    public void testValidatePositionsLetterStatus(String correctWord, char correctWordLetter,char requestWordLetter,Status status) {
        assertEquals(status,wordServiceImpl.validateLetter(correctWord,requestWordLetter,correctWordLetter));
    }
}
