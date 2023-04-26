package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Letter;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Word;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.WordRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.GameRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.IWordService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements IWordService {

    @Autowired
    WordRepository wordRepository;

    @Autowired
    GameRepository gameRepository;

    public Boolean checkIfWordExists(String requestWord) throws RuntimeException {
        Word word = wordRepository.findByValue(requestWord);
        return word != null;
    }

    @Override
    public List<Letter> validatePositions(String requestWord, Integer gameId) {
        List<Letter> letters = new ArrayList<Letter>();

        Word word = wordRepository.findByValue(requestWord);
        Game game = gameRepository.getReferenceById(gameId);

        String correctWord = game.getCorrectWord().getValue();
        char[] correctWordSplited = correctWord.toCharArray();

        String tryWord = word.getValue();
        char[] tryWordSplited = tryWord.toCharArray();

        IntStream.range(0, correctWordSplited.length).forEach(i -> {
            Letter letter = new Letter(tryWordSplited[i], 0, i);

            long charOcurrencesCorrectWord = correctWord.chars().filter(ch -> ch == tryWordSplited[i]).count();
            String stringCuted = tryWord.substring(0, i+1);
            long charOcurrencesTryWord = stringCuted.chars().filter(ch -> ch == tryWordSplited[i]).count();

            if (correctWordSplited[i] == tryWordSplited[i]) {
                letter.status = 1;
            } else if (correctWord.contains(String.valueOf(tryWordSplited[i])) && charOcurrencesCorrectWord >= charOcurrencesTryWord) {
                letter.status = 2;
            }

            letters.add(letter);
        });

        return letters;
    }
}
