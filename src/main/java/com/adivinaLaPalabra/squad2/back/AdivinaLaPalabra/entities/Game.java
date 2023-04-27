package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities;

import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "game")
@Getter
@Setter
@NoArgsConstructor
public class Game {

    @Id
    @Unsigned
    @Nonnull
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

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

    public Game(UUID gameId) {
        this.id = gameId;
    }

    public Game(UUID gameId, Word word, LocalDate localDate) {
        this.id = gameId;
        this.correctWord = word;
        this.date = localDate;
    }
}