package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class GameHistoryDTO {

    @JsonProperty("date")
    private LocalDateTime date;

    @JsonProperty("winned")
    private boolean winned;

    @JsonProperty("attempts")
    private int attempts;

    public GameHistoryDTO(LocalDateTime date, boolean winned, int attempts) {
        this.date = date;
        this.winned = winned;
        this.attempts = attempts;
    }
}


