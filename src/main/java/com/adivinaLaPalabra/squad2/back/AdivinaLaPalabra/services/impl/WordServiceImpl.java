package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.impl;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.LetterDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.LetterDTO.Status;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.exceptions.BadRequestException;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.WordRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories.GameRepository;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.services.IWordService;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WordServiceImpl implements IWordService {

    private final static int START_WORD_LENGHT = 0;
    private final static int MAX_WORD_LENGHT = 5;

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private GameRepository gameRepository;

    public Boolean checkIfWordExists(String requestWord) throws RuntimeException {
        return wordRepository.findByValue(requestWord) != null;
    }

    @Override
    public List<LetterDTO> validatePositions(String requestWord, UUID gameId) throws BadRequestException {
        List<LetterDTO> letters = new ArrayList<>();

        checkIfIsBadWord(requestWord);

        Game game = gameRepository.getReferenceById(gameId);
        String correctWord = game.getCorrectWord().getValue();

        IntStream.range(START_WORD_LENGHT, MAX_WORD_LENGHT).forEach(position -> {
            char tryWordLetter = requestWord.charAt(position);
            char correctWordLetter = correctWord.charAt(position);

            Status status = validateLetter(correctWord, tryWordLetter, correctWordLetter);
            LetterDTO letter = new LetterDTO(tryWordLetter, status, position);
            letters.add(letter);
        });
        return letters;
    }

    public Status validateLetter(String correctWord, char tryWordLetter, char correctWordLetter) {
        if (tryWordLetter == correctWordLetter) return Status.MATCHED;
        return correctWord.indexOf(tryWordLetter) >= START_WORD_LENGHT ? Status.CONTAINED : Status.NOT_MATCHED;
    }

    public void checkIfIsBadWord(String requestWord) throws BadRequestException {
        if (!checkIfWordExists(requestWord)) {
            throw new BadRequestException(requestWord + " no existe.");
        }
    }
}
