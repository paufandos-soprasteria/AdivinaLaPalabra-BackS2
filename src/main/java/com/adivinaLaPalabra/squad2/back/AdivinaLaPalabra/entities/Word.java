package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

@Entity
@Table(name = "word")
public class Word {

    @Id
    @Nonnull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "value")
    private String value;

    public Word() {
    }

    public Word(int id, String word) {
        this.id = id;
        this.value = word;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String word) {
        this.value = word;
    }
}