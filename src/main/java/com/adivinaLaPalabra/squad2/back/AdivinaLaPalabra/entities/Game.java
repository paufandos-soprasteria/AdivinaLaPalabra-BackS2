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
    public int id;

    @ManyToOne
    @JoinColumn(name="dictionary_id")
    public Dictionary dictionary;

    @Column(name = "start_date")
    public LocalDate startDate;

    public Game(int id) {
        this.id = id;
    }

    public Game() {
    }

    public Game(Dictionary dictionary, LocalDate startDate) {
        this.dictionary = dictionary;
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
}