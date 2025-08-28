package oo1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class InversorTest {
    private Inversor inversor;

    @BeforeEach
    void setUp() {
        inversor = new Inversor("Juan");
    }

    @Test
    void testAgregarInversion() {
        InversionEnAcciones acciones = new InversionEnAcciones("Acción XYZ", 10, 100.0);
        PlazoFijo plazoFijo = new PlazoFijo(1000.0, 5.0);
        plazoFijo.setFecha(LocalDate.of(2023, 1, 1));

        inversor.agregarInversion(acciones);
        inversor.agregarInversion(plazoFijo);

        double valorEsperado = acciones.valorActual() + plazoFijo.valorActual();
        assertEquals(valorEsperado, inversor.valorActual(), 0.01);
    }

    @Test
    void testEliminarInversion() {
        InversionEnAcciones acciones = new InversionEnAcciones("Acción XYZ", 10, 100.0);
        inversor.agregarInversion(acciones);
        
        assertEquals(acciones.valorActual(), inversor.valorActual(), 0.01);
        
        inversor.eliminarInversion(acciones);
        
        assertEquals(0.0, inversor.valorActual(), 0.01);
    }

    @Test
    void testValorActualSinInversiones() {
        assertEquals(0.0, inversor.valorActual(), 0.01);
    }
}
