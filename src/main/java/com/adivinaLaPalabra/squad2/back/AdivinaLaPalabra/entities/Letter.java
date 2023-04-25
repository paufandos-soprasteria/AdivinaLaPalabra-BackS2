package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jdk.jfr.Unsigned;

@Entity
@Table(name = "letter")
public class Letter {

    @Id
    @Unsigned
    @Nonnull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(name = "letter")
    public char letter;

    @Column(name = "status")
    public int status;

    @Column(name = "position")
    public int position;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "word_id", nullable=false)
    public Word word;

    public Letter() {
    }

    public Letter(int id, char letter, int status, int position, Word word) {
        this.id = id;
        this.letter = letter;
        this.status = status;
        this.position = position;
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }
    
}
