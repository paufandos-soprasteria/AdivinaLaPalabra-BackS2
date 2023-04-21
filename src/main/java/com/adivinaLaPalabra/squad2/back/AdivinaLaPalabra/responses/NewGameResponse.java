package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.responses;

public class NewGameResponse {

    private int game_id;

    public NewGameResponse(int game_id) {
        this.game_id = game_id;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }
}
