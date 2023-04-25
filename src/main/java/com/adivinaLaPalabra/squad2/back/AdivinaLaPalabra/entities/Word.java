package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jdk.jfr.Unsigned;

@Entity
@Table(name = "word")
public class Word {

    @Id
    @Unsigned
    @Nonnull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @ManyToOne
    @JoinColumn(name = "dictionary_id")
    public Dictionary dictionary;

    @ManyToOne
    @JoinColumn(name = "game_id")
    public Game game;

    @OneToMany(mappedBy = "word")
    private List<Letter> letters;

    public Word() {
    }

    public Word(int id, Dictionary dictionary, Game game) {
        this.id = id;
        this.dictionary = dictionary;
        this.game = game;
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

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<Letter> getLetters() {
        return letters;
    }

    public void setLetters(List<Letter> letters) {
        this.letters = letters;
    }

}
