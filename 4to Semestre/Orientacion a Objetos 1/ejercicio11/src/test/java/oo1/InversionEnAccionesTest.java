package oo1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InversionEnAccionesTest {

    private InversionEnAcciones inversion;

    @BeforeEach
    void setUp() {
        inversion = new InversionEnAcciones("Acción XYZ", 10, 100.0);
    }

    @Test
    void testValorActual() {
        assertEquals(1000.0, inversion.valorActual());
    }

    @Test
    void testSetCantidad() {
        inversion.setCantidad(5);
        assertEquals(5, inversion.getCantidad());
        assertEquals(500.0, inversion.valorActual());
    }

    @Test
    void testSetValorUnitario() {
        inversion.setValorUnitario(150.0);
        assertEquals(150.0, inversion.getValorUnitario());
        assertEquals(1500.0, inversion.valorActual());
    }
}

