package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Word;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.WordRepository;

@ExtendWith(MockitoExtension.class)
public class WordServiceImplTest {

    @InjectMocks
    WordServiceImpl wordServiceImpl;

    @Mock
    WordRepository wordRepository;

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
    public void testValidatePositionsMustReturnWordValidated() {
        //TO DO
    }

    @Test
    public void testCheckIfIsBadWord() {
        //TO DO
    }

    @Test
    public void testValidatePositions() {
        //TO DO
    }
}
