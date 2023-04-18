package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.repositories;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities.Dictionary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryRepository extends JpaRepository<Dictionary,Integer> {
}
