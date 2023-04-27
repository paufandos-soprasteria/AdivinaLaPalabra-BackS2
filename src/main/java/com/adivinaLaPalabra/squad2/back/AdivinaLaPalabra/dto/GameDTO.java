package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameDTO {

    @JsonProperty("game_id")
    private int gameId;

    public GameDTO(int gameId) {
        this.gameId = gameId;
    }
}
