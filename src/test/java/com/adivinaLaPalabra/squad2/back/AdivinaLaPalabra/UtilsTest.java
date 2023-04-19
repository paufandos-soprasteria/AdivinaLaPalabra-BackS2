package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.Utils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UtilsTest {
    static final Utils UTILS = new Utils();
    @Test
    void generateDateNowEspFormat(){
        final DateTimeFormatter ESP_DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate now = LocalDate.now();
        String datenowExpected = ESP_DATE_FORMAT.format(now);
        assertEquals(datenowExpected,UTILS.generateDateNowEspFormat());
    }
    @Test
    void generateRandomNumber(){
        final int NUMBER_IN_RANGE_1 = 1;
        final int NUMBER_EXPECTED = 1;
        assertEquals(NUMBER_EXPECTED,UTILS.generateRandomNumberInRange(NUMBER_IN_RANGE_1));
    }
}
