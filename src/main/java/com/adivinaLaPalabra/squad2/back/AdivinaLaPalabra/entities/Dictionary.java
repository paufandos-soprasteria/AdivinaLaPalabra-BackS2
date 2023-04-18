package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "dictionary")
public class Dictionary {
    @Column(name = "id")
    public int id;
    @Column(name = "word")
    public String word;
}
