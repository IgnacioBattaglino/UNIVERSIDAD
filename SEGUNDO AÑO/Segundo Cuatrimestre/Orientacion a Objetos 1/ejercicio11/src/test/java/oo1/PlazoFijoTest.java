package oo1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class PlazoFijoTest {
    private PlazoFijo plazoFijo;

    @BeforeEach
    void setUp() {
        // Usamos una fecha fija para la prueba
        plazoFijo = new PlazoFijo(1000.0, 5.0); // Monto de 1000 y 5% de interés diario
        plazoFijo.setFecha(LocalDate.of(2023, 1, 1)); // Establecemos una fecha de constitución
    }

    @Test
    void testValorActual() {
        LocalDate fechaActual = LocalDate.now();
        long diasTranscurridos = LocalDate.of(2023, 1, 1).until(fechaActual).getDays();
        double interesGanado = 1000.0 * (5.0 / 100) * diasTranscurridos;
        double valorEsperado = 1000.0 + interesGanado;

        assertEquals(valorEsperado, plazoFijo.valorActual(), 0.01);
    }

    @Test
    void testSetMontoDepositado() {
        plazoFijo.setMontoDepositado(2000.0);
        assertEquals(2000.0, plazoFijo.getMontoDepositado());
    }

    @Test
    void testSetPorcentajeDeInteresDiario() {
        plazoFijo.setPorcentajeDeInteresDiario(10.0);
        assertEquals(10.0, plazoFijo.getPorcentajeDeInteresDiario());
    }
}
