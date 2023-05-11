package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.DateUtils;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "word_id")
    private Word correctWord;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @Column(name = "date")
    private LocalDateTime date;

    @JsonIgnore
    @Column(name = "attempts")
    private int attempts;

    @JsonIgnore
    @Column(name = "winned")
    private Boolean winned;


    public Game(Word word, User userId) {
        this.correctWord = Objects.requireNonNull(word);
        this.date = DateUtils.generateLocalDateTimeNow();
        this.attempts = 0;
        this.winned = false;
        this.user = userId;
    }

    public Game(UUID id) {
        this.id = id;
    }

    public Game(UUID gameId, Word correctWord) {
        this.id = gameId;
        this.correctWord = correctWord;
    }
}