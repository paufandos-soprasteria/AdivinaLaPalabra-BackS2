package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Word;

import java.util.UUID;

public class TestHelper {

    public static final String CHECK_ATTEMPTS_IN_RANGE_URL = "/checkAttemptsInRange/";

    public static final String VALIDATE_POSITIONS_URL = "/validatePositions/{game_id}";

    public static final String CHECK_IF_WORD_EXISTS_URL = "/checkIfWordExists/word";

    public static final String GET_CORRECT_WORD_URL = "/getCorrectWord/";

    public static final String NEW_GAME_URL = "/newGame";

    public static UUID GAME_ID = UUID.randomUUID();

    public static Game GAME = new Game(GAME_ID);

    public static final Word EXISTING_WORD_IN_THE_DICTIONARY = new Word(1, "abaca");

    public static final Word REQUEST_WORD = new Word(1, "halla");

    public static final String NONEXISTENT_WORD_IN_THE_DICTIONARY = "aaaaa";

    public static final String NEW_GAME_EXPECTED_DATA = "{\n" +
            "    \"game_id\": \""+GAME_ID +"\"\n" +
            "}";

    public static final String EXPECTED_LIST_DATA = "[\n" +
            "    {\n" +
            "        \"letter\": \"h\",\n" +
            "        \"status\": \"NOT_MATCHED\",\n" +
            "        \"position\": 0\n" +
            "    },\n" +
            "    {\n" +
            "        \"letter\": \"a\",\n" +
            "        \"status\": \"MATCHED\",\n" +
            "        \"position\": 1\n" +
            "    },\n" +
            "    {\n" +
            "        \"letter\": \"l\",\n" +
            "        \"status\": \"NOT_MATCHED\",\n" +
            "        \"position\": 2\n" +
            "    },\n" +
            "    {\n" +
            "        \"letter\": \"l\",\n" +
            "        \"status\": \"NOT_MATCHED\",\n" +
            "        \"position\": 3\n" +
            "    },\n" +
            "    {\n" +
            "        \"letter\": \"a\",\n" +
            "        \"status\": \"MATCHED\",\n" +
            "        \"position\": 4\n" +
            "    }\n" +
            "]";

}
