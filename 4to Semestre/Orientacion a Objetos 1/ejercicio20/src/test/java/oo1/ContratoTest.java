package oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContratoTest {
    private ContratoDePlanta contratoPlanta;
    private ContratoPorHoras contratoHoras;


    @BeforeEach
    void setUp () {
        this.contratoPlanta = new ContratoDePlanta(LocalDate.now().minusDays(100), 100000, 5000, 10000);
        this.contratoHoras = new ContratoPorHoras(LocalDate.now().minusDays(500), LocalDate.now(), 1000, 55);
    }

    @Test
    void testGetDuracion (){
        int duracionEsperada = 100;
        assertEquals(duracionEsperada, contratoPlanta.getDuracion());
        duracionEsperada = 500;
        assertEquals(duracionEsperada, contratoHoras.getDuracion());

    }

    @Test 
    void testCalcularMonto () {
        Empleado e = new Empleado("Nombre", "Apellido", "1", LocalDate.of(2000, 1, 1), false, false);
        double montoEsperado = 100000;
        assertEquals(montoEsperado, contratoPlanta.calcularMontoACobrar(e));
        e.setTieneConyuge(true);
        montoEsperado += contratoPlanta.getMontoPorConyuge();
        assertEquals(montoEsperado, contratoPlanta.calcularMontoACobrar(e));
        e.setTieneHijos(true);
        montoEsperado += contratoPlanta.getMontoPorHijos();
        assertEquals(montoEsperado, contratoPlanta.calcularMontoACobrar(e));

        montoEsperado = 55000;
        assertEquals(montoEsperado, contratoHoras.calcularMontoACobrar(e));

    }

    @Test
    void testEsActivo () {
        assertTrue (contratoPlanta.esActivo());

        assertFalse (contratoHoras.esActivo());
        contratoHoras.setFechaFin(LocalDate.now().plusDays(10));
        assertTrue (contratoHoras.esActivo());
        contratoHoras.setFechaFin(LocalDate.now().minusDays(10));
        assertFalse(contratoHoras.esActivo());
    }

}
