package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Dictionary;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.DictionaryRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl implements IDictionaryService {
    @Autowired
    DictionaryRepository dictionaryRepository;
    static final String URL= "https://localhost:3306";
    public String hello(){
        return "HELLO WORLD!!";
    }
    public List<Dictionary> getDictionary(){
        List<Dictionary> dictionary = dictionaryRepository.findAll();
        return dictionary;
    }
}
