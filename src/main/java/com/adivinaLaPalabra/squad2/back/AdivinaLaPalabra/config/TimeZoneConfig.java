package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.config;

import java.util.Date;
import java.util.TimeZone;
import org.springframework.context.annotation.Configuration;
import jakarta.annotation.PostConstruct;

@Configuration
public class TimeZoneConfig {
    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("${dates.timezone}"));
        System.out.println("Date in UTC: " + new Date().toString());
    }
}