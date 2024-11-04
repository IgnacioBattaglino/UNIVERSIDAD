package oo1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EsferaTest {
    private Esfera esfera;

    @BeforeEach
    public void setUp() {
        esfera = new Esfera("Vidrio", "Azul", 3);
    }

    @Test
    public void testVolumen() {
        double expectedVolumen = (4.0 / 3.0) * Math.PI * Math.pow(3, 3);
        assertEquals(expectedVolumen, esfera.getVolumen(), 0.001);
    }

    @Test
    public void testSuperficie() {
        double expectedSuperficie = 4 * Math.PI * Math.pow(3, 2);
        assertEquals(expectedSuperficie, esfera.getSuperficie(), 0.001);
    }

}
