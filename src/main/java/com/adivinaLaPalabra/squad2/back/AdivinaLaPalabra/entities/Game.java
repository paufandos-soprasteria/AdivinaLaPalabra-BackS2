package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "game")
@Getter
@Setter
@NoArgsConstructor
public class Game {

    @Id
    @Unsigned
    @Nonnull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "word_id")
    private Word correctWord;

    @JsonIgnore
    @Column(name = "date")
    private LocalDate date;

    public Game(Word word, LocalDate date) {
        this.correctWord = word;
        this.date = date;
    }
}