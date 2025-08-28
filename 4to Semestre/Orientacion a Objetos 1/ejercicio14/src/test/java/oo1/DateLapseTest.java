package oo1;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DateLapseTest {

    private DateLapseb dateLapse;
    private LocalDate startDate;
    private LocalDate endDate;

    @BeforeEach
    void setUp() {
        startDate = LocalDate.of(2023, 1, 1);
        endDate = LocalDate.of(2023, 12, 31);
        dateLapse = new DateLapseb(startDate, endDate);
    }

    @Test
    void testSizeInDays() {
        assertEquals(364, dateLapse.sizeInDays());
    }

    @Test
    void testIncludesDate() {
        // Caso en el límite inferior (inicio)
        assertTrue(dateLapse.includesDate(startDate));

        // Caso en el límite superior (fin)
        assertTrue(dateLapse.includesDate(endDate));

        // Caso dentro del rango
        LocalDate dateWithinRange = LocalDate.of(2023, 6, 15);
        assertTrue(dateLapse.includesDate(dateWithinRange));

        // Caso fuera del rango (antes del inicio)
        LocalDate dateBeforeRange = startDate.minusDays(1);
        assertFalse(dateLapse.includesDate(dateBeforeRange));

        // Caso fuera del rango (después del fin)
        LocalDate dateAfterRange = endDate.plusDays(1);
        assertFalse(dateLapse.includesDate(dateAfterRange));
    }
}
