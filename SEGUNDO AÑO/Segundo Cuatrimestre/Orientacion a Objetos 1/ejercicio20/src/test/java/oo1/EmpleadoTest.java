package oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {
    private Empleado empleado;
    private ContratoDePlanta contratoPlanta;

    @BeforeEach
    void setUp() {
        empleado = new Empleado("Nombre", "Apellido", "20-12345678-9", LocalDate.of(2000, 1, 1), false, false);
    }

    @Test
    void testGenerarReciboSinContrato() {
        // Sin contrato activo
        assertNull(empleado.generarReciboDeSueldo());
    }

    @Test
    void testGenerarReciboConContratoActivoAntiguedadExacta5() {
        // Caso de borde: antigüedad exacta de 5 años, adicional = 1.3
        contratoPlanta = new ContratoDePlanta(LocalDate.now().minusDays(365 * 5), 100000, 5000, 10000); // 5 años
        empleado.agregarContrato(contratoPlanta);
        double montoEsperado = 100000 * 1.3; // Sin hijos ni cónyuge
        assertEquals(montoEsperado, empleado.generarReciboDeSueldo().getMonto());
    }
    
    @Test
    void testGenerarReciboConContratoActivoAntiguedadDentroDe5a9() {
        // Caso normal: antigüedad entre 5 y 9 años, adicional = 1.3
        contratoPlanta = new ContratoDePlanta(LocalDate.now().minusDays(365 * 6), 100000, 5000, 10000); // 6 años
        empleado.agregarContrato(contratoPlanta);
        double montoEsperado = 100000 * 1.3; // Sin hijos ni cónyuge
        assertEquals(montoEsperado, empleado.generarReciboDeSueldo().getMonto());
    }
    
    @Test
    void testGenerarReciboConContratoActivoAntiguedadExacta10() {
        // Caso de borde: antigüedad exacta de 10 años, adicional = 1.5
        contratoPlanta = new ContratoDePlanta(LocalDate.now().minusDays(365 * 10), 100000, 5000, 10000); // 10 años
        empleado.agregarContrato(contratoPlanta);
        double montoEsperado = 100000 * 1.5; // Sin hijos ni cónyuge
        assertEquals(montoEsperado, empleado.generarReciboDeSueldo().getMonto());
    }
    
    @Test
    void testGenerarReciboConContratoActivoAntiguedadDentroDe10a14() {
        // Caso normal: antigüedad entre 10 y 14 años, adicional = 1.5
        contratoPlanta = new ContratoDePlanta(LocalDate.now().minusDays(365 * 12), 100000, 5000, 10000); // 12 años
        empleado.agregarContrato(contratoPlanta);
        double montoEsperado = 100000 * 1.5; // Sin hijos ni cónyuge
        assertEquals(montoEsperado, empleado.generarReciboDeSueldo().getMonto());
    }
    
    @Test
    void testGenerarReciboConContratoActivoAntiguedadExacta15() {
        // Caso de borde: antigüedad exacta de 15 años, adicional = 1.7
        contratoPlanta = new ContratoDePlanta(LocalDate.now().minusDays(365 * 15), 100000, 5000, 10000); // 15 años
        empleado.agregarContrato(contratoPlanta);
        double montoEsperado = 100000 * 1.7; // Sin hijos ni cónyuge
        assertEquals(montoEsperado, empleado.generarReciboDeSueldo().getMonto());
    }
    
    @Test
    void testGenerarReciboConContratoActivoAntiguedadDentroDe15a19() {
        // Caso normal: antigüedad entre 15 y 19 años, adicional = 1.7
        contratoPlanta = new ContratoDePlanta(LocalDate.now().minusDays(365 * 16), 100000, 5000, 10000); // 16 años
        empleado.agregarContrato(contratoPlanta);
        double montoEsperado = 100000 * 1.7; // Sin hijos ni cónyuge
        assertEquals(montoEsperado, empleado.generarReciboDeSueldo().getMonto());
    }
    
    @Test
    void testGenerarReciboConContratoActivoAntiguedadExacta20() {
        // Caso de borde: antigüedad exacta de 20 años, adicional = 2.0
        contratoPlanta = new ContratoDePlanta(LocalDate.now().minusDays(365 * 20), 100000, 5000, 10000); // 20 años
        empleado.agregarContrato(contratoPlanta);
        double montoEsperado = 100000 * 2.0; // Sin hijos ni cónyuge
        assertEquals(montoEsperado, empleado.generarReciboDeSueldo().getMonto());
    }
    
    @Test
    void testGenerarReciboConContratoActivoAntiguedadMasDe20() {
        // Caso normal: antigüedad mayor de 20 años, adicional = 2.0
        contratoPlanta = new ContratoDePlanta(LocalDate.now().minusDays(365 * 21), 100000, 5000, 10000); // 21 años
        empleado.agregarContrato(contratoPlanta);
        double montoEsperado = 100000 * 2.0; // Sin hijos ni cónyuge
        assertEquals(montoEsperado, empleado.generarReciboDeSueldo().getMonto());
    }
}    