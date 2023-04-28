package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import java.util.UUID;

@Getter
public class GameDTO {

    @JsonProperty("game_id")
    private final UUID gameId;

    public GameDTO(UUID gameId) {
        this.gameId = gameId;
    }
}
