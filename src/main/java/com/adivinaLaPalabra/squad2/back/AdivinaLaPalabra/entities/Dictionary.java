package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "dictionary")
public class Dictionary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    public String word;

    public Dictionary() {
    }

    public Dictionary(int id, String word) {
        this.id = id;
        this.word = word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}