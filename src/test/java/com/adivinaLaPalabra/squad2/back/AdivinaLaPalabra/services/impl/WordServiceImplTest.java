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
    WordServiceImpl dictionaryServiceImpl;

    @Mock
    WordRepository dictionaryRepository;

    @Test
    void testCheckIfWordExistsMustReturnTrueIfWordExist() {
        final Word EXISTING_WORD_IN_THE_DICTIONARY = new Word(1, "abaca");
        when(dictionaryRepository.findByValue(EXISTING_WORD_IN_THE_DICTIONARY.getValue()))
                .thenReturn(EXISTING_WORD_IN_THE_DICTIONARY);

        Boolean assertDictionaryWord = dictionaryServiceImpl
                .checkIfWordExists(EXISTING_WORD_IN_THE_DICTIONARY.getValue());

        assertTrue(assertDictionaryWord);
    }

    @Test
    void testCheckIfWordExistsMustReturnFalseIfWordNotExist() {
        final String NONEXISTENT_WORD_IN_THE_DICTIONARY = "aaaaa";
        when(dictionaryRepository.findByValue(NONEXISTENT_WORD_IN_THE_DICTIONARY)).thenReturn(null);

        Boolean assertDictionaryWord = dictionaryServiceImpl.checkIfWordExists(NONEXISTENT_WORD_IN_THE_DICTIONARY);

        assertFalse(assertDictionaryWord);
    }

    @Test
    public void testValidatePositionsMustReturnWordValidated() {
        // TO DO
    }
}
