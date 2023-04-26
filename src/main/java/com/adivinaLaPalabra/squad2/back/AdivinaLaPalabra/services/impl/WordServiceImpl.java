package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Letter;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Letter.Status;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions.BadRequestException;
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

    final static int START_WORD_LENGHT = 0;

    final static int MAX_WORD_LENGHT = 5;

    final static int NOT_MATCHED_LETTER_STATUS = 0;

    final static int MATCHED_LETTER_STATUS = 1;

    final static int CONTAINED_LETTER_STATUS = 2;

    @Autowired
    WordRepository wordRepository;

    @Autowired
    GameRepository gameRepository;

    public Boolean checkIfWordExists(String requestWord) throws RuntimeException {
        return wordRepository.findByValue(requestWord) != null;
    }

    @Override
    public List<Letter> validatePositions(String requestWord, int gameId) throws BadRequestException {
        List<Letter> letters = new ArrayList<>();

        checkIfIsBadWord(requestWord);

        Game game = gameRepository.getReferenceById(gameId);
        String correctWord = game.getCorrectWord().getValue();

        IntStream.range(START_WORD_LENGHT, MAX_WORD_LENGHT).forEach(position -> {
            String tryWordLetter = String.valueOf(requestWord.charAt(position));
            String correctWordLetter = String.valueOf(correctWord.charAt(position));

            Letter letter = new Letter(tryWordLetter, Status.NOT_MATCHED_LETTER_STATUS.ordinal(), position);
            letter.status = validateLetter(correctWord, tryWordLetter, correctWordLetter);
            letters.add(letter);
        });
        return letters;
    }

    public int validateLetter(String correctWord, String tryWordLetter, String correctWordLetter) {
        if (tryWordLetter.equalsIgnoreCase(correctWordLetter))
            return Status.MATCHED_LETTER_STATUS.ordinal();
        return correctWord.contains(tryWordLetter) ? Status.CONTAINED_LETTER_STATUS.ordinal() : Status.NOT_MATCHED_LETTER_STATUS.ordinal();
    }

    public void checkIfIsBadWord(String requestWord) throws BadRequestException {
        if (wordRepository.findByValue(requestWord) == null) {
            throw new BadRequestException(requestWord + " no existe.");
        }
    }
}
