package ejercicio2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestEmpleado {
    private Pasante pasante;
    private Planta planta;
    private Temporario temporario;
    
    @Test
    void testSueldoPasante() {
        pasante = new Pasante(10);
        double basico = 20000 + 10 * 100;
        double expected = basico - (basico * 0.13); // Solo se aplica el descuento del básico
        assertEquals(expected, pasante.getSueldo());
    }

    @Test
    void testSueldoPlantaCompleto() {
        planta = new Planta(true, 5, 5);
        // básico: 50000
        // adicionales: 5000 (casado) + 5*2000 (hijos) + 5*2000 (antigüedad)
        double adicionales = 5000 + 5*2000 + 5*2000;
        double expected = 50000 + adicionales - (50000 * 0.13) - (adicionales * 0.05);
        assertEquals(expected, planta.getSueldo());
    }

    @Test
    void testSueldoPlantaSinBeneficios() {
        planta = new Planta(false, 0, 0);
        double expected = 50000 - (50000 * 0.13);
        assertEquals(expected, planta.getSueldo());
    }

    @Test
    void testSueldoTemporarioCompleto() {
        temporario = new Temporario(80, true, 2);
        // básico: 20000 + 80*300
        // adicionales: 5000 (casado) + 2*2000 (hijos)
        double basico = 20000 + 80*300;
        double adicionales = 5000 + 2*2000;
        double expected = basico + adicionales - (basico * 0.13) - (adicionales * 0.05);
        assertEquals(expected, temporario.getSueldo());
    }

    @Test
    void testSueldoTemporarioSinBeneficios() {
        temporario = new Temporario(40, false, 0);
        double basico = 20000 + 40*300;
        double expected = basico - (basico * 0.13);
        assertEquals(expected, temporario.getSueldo());
    }
}
