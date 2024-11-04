package oo1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CilindroTest {
    private Cilindro cilindro;

    @BeforeEach
    public void setUp() {
        cilindro = new Cilindro("Metal", "Rojo", 2, 5);
    }

    @Test
    public void testVolumen() {
        double expectedVolumen = Math.PI * Math.pow(2, 2) * 5;
        assertEquals(expectedVolumen, cilindro.getVolumen(), 0.001);
    }

    @Test
    public void testSuperficie() {
        double expectedSuperficie = 2 * Math.PI * 2 * 5 + 2 * Math.PI * Math.pow(2, 2);
        assertEquals(expectedSuperficie, cilindro.getSuperficie(), 0.001);
    }
}
