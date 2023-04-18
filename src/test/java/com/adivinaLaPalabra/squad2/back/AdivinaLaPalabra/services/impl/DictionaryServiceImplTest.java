package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

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
        Dictionary dictionaryWord = new Dictionary();
        when(dictionaryRepository.findByWord("coche")).thenReturn(dictionaryWord);

        Boolean assertDictionaryWord = dictionaryServiceImpl.checkIfWordExists("coche");
        assertTrue(assertDictionaryWord);
    }
}
