package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra;

import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.DateUtils;
import com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.utilities.NumberUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UtilsTest {

    @Test
    void generateLocalDateNowTest() {
        LocalDate now = LocalDate.now();
        assertEquals(now, DateUtils.generateLocalDateNow());
    }

    @Test
    void generateRandomNumberMustReturnNumberInRangeTenTest() {
        final int RANGE_10 = 10;
        final double NUMBER_IN_RANGE_10 = NumberUtils.generateRandomNumberInRange(RANGE_10);
        assertTrue(validateNumber(RANGE_10,NUMBER_IN_RANGE_10));

    }

    @Test
    void generateRandomNumberMustReturnNumberNotInRangeTenTest() {
        final int RANGE_10 = 10;
        final double NUMBER_NOT_IN_RANGE_10 = NumberUtils.generateRandomNumberInRange(RANGE_10);
        final double NUMBER_EXPECTED = Math.random();
        assertFalse(validateNumber(NUMBER_EXPECTED,NUMBER_NOT_IN_RANGE_10));

    }

    boolean validateNumber(double maxNumber,double number){
        return number <= maxNumber;
    }
}
