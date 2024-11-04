package oo1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PrismaTest {
    private PrismaRectangular prisma;

    @BeforeEach
    public void setUp() {
        prisma = new PrismaRectangular("Madera", "Verde", 5, 3, 4);
    }

    @Test
    public void testVolumen() {
        double expectedVolumen = 5 * 3 * 4;
        assertEquals(expectedVolumen, prisma.getVolumen(), 0.001);
    }

    @Test
    public void testSuperficie() {
        double expectedSuperficie = 2 * (5 * 3 + 5 * 4 + 3 * 4);
        assertEquals(expectedSuperficie, prisma.getSuperficie(), 0.001);
    }

}
