package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;

    public String correct_word;

    public Date start_date;
}
