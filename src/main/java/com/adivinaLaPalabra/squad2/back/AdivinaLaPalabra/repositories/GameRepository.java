package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface GameRepository extends JpaRepository<Game, UUID> {

    public List<Game> findTop10ByUser_IdOrderByDateDesc(UUID userId);

    @Query("SELECT g FROM Game g WHERE g.user.id = ?1 and g.winned = true ORDER BY g.attempts ASC LIMIT 3")
    public List<Game> getTop3UserGames(UUID userId);

    public List<Game> findAllByUser_Id(UUID userId);

    public long countByUser_Id(UUID userId);
}

