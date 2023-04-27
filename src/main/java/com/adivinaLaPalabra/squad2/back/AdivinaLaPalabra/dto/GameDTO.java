package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class GameDTO {

    @JsonProperty("game_id")
    private UUID gameId;

    public GameDTO(UUID gameId) {
        this.gameId = gameId;
    }
}
