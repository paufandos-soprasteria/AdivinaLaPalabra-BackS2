package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jdk.jfr.Unsigned;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @Unsigned
    @Nonnull
    @JsonProperty("game_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="word_id")
    public Word correctWord;

    @JsonIgnore
    @Column(name = "date")
    public LocalDate date;

    public Game(int id) {
        this.id = id;
    }

    public Game() {
    }

    public Game(Word word, LocalDate date) {
        this.correctWord = word;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Word getCorrectWord() {
        return correctWord;
    }

    public void setCorrectWord(Word word) {
        this.correctWord = word;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}