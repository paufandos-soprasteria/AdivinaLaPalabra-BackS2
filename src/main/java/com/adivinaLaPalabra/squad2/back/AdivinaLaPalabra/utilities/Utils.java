package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Utils {
    static final DateTimeFormatter ESP_DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String generateDateNowEspFormat(){
        LocalDate now = LocalDate.now();
        String datenow = ESP_DATE_FORMAT.format(now);
        return datenow;
    }
    public static int generateRandomNumberInRange(int range){
       return (int) (Math.random() * range) +1;
    }

    public static ResponseEntity<JSONObject> errorResponse(HttpStatus status) {
        JSONObject response = new JSONObject();
        response.put("status", status.value());
        response.put("message", status);

        return new ResponseEntity<JSONObject>(response, status);
    } 
}
