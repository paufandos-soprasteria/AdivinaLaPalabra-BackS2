package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.helpers;

import java.util.List;
import java.util.UUID;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto.GameHistoryDTO;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.DateUtils;

public class GameHelper {

    public static final String CHECK_ATTEMPTS_IN_RANGE_URL = "/checkAttemptsInRange/";

    public static final String GET_CORRECT_WORD_URL = "/getCorrectWord/";

    public static final String GET_LAST_TEN_GAMES_URL = "/getLastTenGames";

    public static final String GET_TOP3_GAMES_URL = "/getTopThreeGames";

    public static final String NEW_GAME_URL = "/newGame";

    public static UUID GAME_ID = UUID.randomUUID();

    public static Game GAME = new Game(GAME_ID, WordHelper.EXISTING_WORD_IN_THE_DICTIONARY);

    public static final List<Game> EXPECTED_GAME_LIST = List.of(
            new Game(),
            new Game(),
            new Game(),
            new Game(),
            new Game());

    public static final List<Game> EXPECTED_TOP3_GAME_LIST = List.of(
            new Game(),
            new Game(),
            new Game());


    public static final List<GameHistoryDTO> EXPECTED_TOP3_GAME_HISTORY_LIST = List.of(
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(), true, 5),
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(), true,2 ),
            new GameHistoryDTO(DateUtils.generateLocalDateTimeNow(), true, 1));

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

}
