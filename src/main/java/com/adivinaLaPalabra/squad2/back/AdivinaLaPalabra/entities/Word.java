package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "word")
@Getter
@Setter
@NoArgsConstructor
public class Word {

    @Id
    @Nonnull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "value")
    private String value;

    public Word(int id, String word) {
        this.id = id;
        this.value = word;
    }
}