package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities;

import java.time.LocalDate;

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
    public LocalDate startDate;

    public Game(Integer id) {
        this.id = id;
    }

    public Game() {
    }

    public Game(String correctWord, LocalDate startDate) {
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}