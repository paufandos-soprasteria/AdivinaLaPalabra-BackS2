package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Dictionary;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.DictionaryRepository;

@ExtendWith(MockitoExtension.class)
public class DictionaryServiceImplTest {

    @InjectMocks
    DictionaryServiceImpl dictionaryServiceImpl;

    @Mock
    DictionaryRepository dictionaryRepository;

    @Test
    void testCheckIfWordExistsMustReturnTrueIfWordExist() {
        final Dictionary EXISTING_WORD_IN_THE_DICTIONARY = new Dictionary(1, "abaca");
        when(dictionaryRepository.findByWord(EXISTING_WORD_IN_THE_DICTIONARY.getWord()))
                .thenReturn(EXISTING_WORD_IN_THE_DICTIONARY);

        Boolean assertDictionaryWord = dictionaryServiceImpl
                .checkIfWordExists(EXISTING_WORD_IN_THE_DICTIONARY.getWord());

        assertTrue(assertDictionaryWord);
    }

    @Test
    void testCheckIfWordExistsMustReturnFalseIfWordNotExist() {
        final String NONEXISTENT_WORD_IN_THE_DICTIONARY = "aaaaa";
        when(dictionaryRepository.findByWord(NONEXISTENT_WORD_IN_THE_DICTIONARY)).thenReturn(null);

        Boolean assertDictionaryWord = dictionaryServiceImpl.checkIfWordExists(NONEXISTENT_WORD_IN_THE_DICTIONARY);

        assertFalse(assertDictionaryWord);
    }
}
