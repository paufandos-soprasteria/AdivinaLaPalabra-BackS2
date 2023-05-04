package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.DateUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UtilsTest {

    @Test
    void generateLocalDateNowTest() {
        LocalDate now = LocalDate.now();
        assertEquals(now, DateUtils.generateLocalDateNow());
    }

    @Test
    void generateLocalDateTimeNowTest() {
        assertInstanceOf(LocalDateTime.class, DateUtils.generateLocalDateTimeNow());
    }
}
