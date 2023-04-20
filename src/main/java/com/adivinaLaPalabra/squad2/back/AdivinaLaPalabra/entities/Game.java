package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jdk.jfr.Unsigned;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @Unsigned
    @Nonnull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(name = "correct_word")

    public String correctWord;

    @Column(name = "start_date")
    public String startDate;

    public Game() {
    }

    public Game(String correctWord, String startDate) {
        this.correctWord = correctWord;
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorrectWord() {
        return correctWord;
    }

    public void setCorrectWord(String correctWord) {
        this.correctWord = correctWord;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}