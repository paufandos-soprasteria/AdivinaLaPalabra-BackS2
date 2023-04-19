package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {
    static final DateTimeFormatter ESP_DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public String generateDateNowEspFormat(){
        LocalDate now = LocalDate.now();
        String datenow = ESP_DATE_FORMAT.format(now);
        return datenow;
    }
    public int generateRandomNumberInRange(int range){
       return (int) (Math.random() * range) +1;
    }
}
