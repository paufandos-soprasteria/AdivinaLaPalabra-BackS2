package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.AuthDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.GameHistoryDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.LoginDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Word;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.DateUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.List;
import java.util.UUID;

public class TestHelper {

    public static final String AUTH_TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiY0dGMVptRnVaRzl6IiwiaWF0IjoxNjgzNTM3NDU5LCJleHAiOjI2ODM1Mzc0NTh9.1wcPPYvUA5e6FCsPvfjp073ioL_kY4plPNykmFmGvCs";

    public static final String CHECK_ATTEMPTS_IN_RANGE_URL = "/checkAttemptsInRange/";

    public static final String VALIDATE_POSITIONS_URL = "/validatePositions/{game_id}";

    public static final String CHECK_IF_WORD_EXISTS_URL = "/checkIfWordExists/word";

    public static final String GET_CORRECT_WORD_URL = "/getCorrectWord/";

    public static final String GET_LAST_TEN_GAMES = "/getLastTenGames";

    public static final String NEW_GAME_URL = "/newGame";

    public static final String LOGIN_URL = "/auth/login";

    public static UUID GAME_ID = UUID.randomUUID();

    public static final Word EXISTING_WORD_IN_THE_DICTIONARY = new Word(1, "abaca");

    public static Game GAME = new Game(GAME_ID, EXISTING_WORD_IN_THE_DICTIONARY);

    public static final Word REQUEST_WORD = new Word(1, "halla");

    public static final String NONEXISTENT_WORD = "aaaaa";

    public static final String EXISTENT_WORD = "abaca";

    public static final LoginDTO USER_REQUEST_DTO = new LoginDTO("cGF1ZmFuZG9z", "MTIzNDU2");

    public static final AuthDTO TOKEN_EXPECTED_RESPONSE = new AuthDTO(
            "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyIjoiY0dGMVptRnVaRzl6IiwiaWF0IjoxNjgzNTI3MTYzLCJleHAiOjE3NzM1MjcxNjN9.cWcr1qwsbyG1BI__okiNEoYET-5tZXGcYhcUq47Ecrg");

    public static final String DECODED_STRING = "paufandos";

    public static final String ENCODED_STRING = "cGF1ZmFuZG9z";

    public static final List<Game> EXPECTED_GAME_LIST = List.of(
            new Game(),
            new Game(),
            new Game(),
            new Game(),
            new Game());

    public static final List<GameHistoryDTO> EXPECTED_GAME_HISTORY_LIST = List.of(
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(), true, 5),
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(), true, 5),
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(), true, 5),
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(), true, 5),
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(), true, 5));

    public static final List<GameHistoryDTO> REQUESTED_GAME_HISTORY_LIST = List.of(
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(), true, 5),
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(), true, 5),
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(), true, 5),
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(), true, 5),
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(), true, 5),
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(), true, 5));

    public static final String NEW_GAME_EXPECTED_DATA = """
            {
            game_id:""" + GAME_ID + """
                }
            """;

    public static final String EXPECTED_LIST_DATA = """
                [
                {
                   letter: h,
                   status: NOT_MATCHED,
                   position: 0
                },
               {
                    letter: a,
                    status: MATCHED,
                    position: 1
                },
                {
                    letter: l,
                    status: NOT_MATCHED,
                    position: 2
                },
                {
                    letter: l,
                    status: NOT_MATCHED,
                    position: 3
                },
                {
                    letter:a,
                    status: MATCHED,
                    position: 4
                }
            ]
            """;

    public static String asJsonString(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
