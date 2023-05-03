package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.entities;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.DateUtils;
import jakarta.persistence.*;
import jdk.jfr.Unsigned;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "attempt")
@Getter
@Setter
@NoArgsConstructor
public class Attempt {

    @Id
    @Unsigned
    @UuidGenerator
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

    private LocalDateTime date;

    public Attempt(Game game) {
        this.date = DateUtils.generateLocalDateTimeNow();
        this.game = game;
    }
}
