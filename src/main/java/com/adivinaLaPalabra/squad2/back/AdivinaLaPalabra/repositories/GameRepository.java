package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Dictionary;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}

