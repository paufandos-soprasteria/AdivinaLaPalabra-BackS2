package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.config;

import java.util.Date;
import java.util.TimeZone;
import org.springframework.context.annotation.Configuration;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class TimeZoneConfig {
    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/Madrid"));
        System.out.println("Date in UTC: " + new Date().toString());
    }
}
