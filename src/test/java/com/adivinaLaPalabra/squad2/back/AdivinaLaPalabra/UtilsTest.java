package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.DateUtils;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.NumberUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UtilsTest {

    @Test
    void generateLocalDateNowTest() {
        LocalDate now = LocalDate.now();
        assertEquals(now, DateUtils.generateLocalDateNow());
    }

    @Test
    void generateRandomNumberTest() {
        final int NUMBER_IN_RANGE_1 = 1;
        final int NUMBER_EXPECTED = 1;
        assertEquals(NUMBER_EXPECTED, NumberUtils.generateRandomNumberInRange(NUMBER_IN_RANGE_1));
    }
}
