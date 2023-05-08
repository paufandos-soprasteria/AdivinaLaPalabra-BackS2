package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.GameHistoryDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Word;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.DateUtils;
import java.util.List;
import java.util.UUID;

public class TestHelper {

    public static final String CHECK_ATTEMPTS_IN_RANGE_URL = "/checkAttemptsInRange/";

    public static final String VALIDATE_POSITIONS_URL = "/validatePositions/{game_id}";

    public static final String CHECK_IF_WORD_EXISTS_URL = "/checkIfWordExists/word";

    public static final String GET_CORRECT_WORD_URL = "/getCorrectWord/";
    public static final String GET_LAST_TEN_GAMES = "/getLastTenGames";

    public static final String NEW_GAME_URL = "/newGame";

    public static UUID GAME_ID = UUID.randomUUID();

    public static final Word EXISTING_WORD_IN_THE_DICTIONARY = new Word(1, "abaca");

    public static Game GAME = new Game(GAME_ID,EXISTING_WORD_IN_THE_DICTIONARY);

    public static final Word REQUEST_WORD = new Word(1, "halla");

    public static final String NONEXISTENT_WORD = "aaaaa";

    public static final String EXISTENT_WORD = "abaca";

    public static final List<Game> EXPECTED_GAME_LIST = List.of(
           new Game(),
           new Game(),
           new Game(),
           new Game(),
           new Game()
    );

    public static final List<GameHistoryDTO> EXPECTED_GAME_HISTORY_LIST = List.of(
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(),true,5),
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(),true,5),
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(),true,5),
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(),true,5),
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(),true,5)
    );

    public static final List<GameHistoryDTO> REQUESTED_GAME_HISTORY_LIST = List.of(
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(),true,5),
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(),true,5),
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(),true,5),
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(),true,5),
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(),true,5),
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(),true,5)
    );


    public static final String NEW_GAME_EXPECTED_DATA =
            """
                {
                game_id:"""+GAME_ID+"""
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

}
