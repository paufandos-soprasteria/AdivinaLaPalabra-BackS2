package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GameDTO {

    @JsonProperty("game_id")
    private int gameId;


    public GameDTO(int gameId) {
        this.gameId = gameId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }


}
