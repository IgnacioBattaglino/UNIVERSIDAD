package oo1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

class DistribuidoraTests {
    private Usuario usuario;
    private CuadroTarifario cuadroTarifario;
    
    @BeforeEach
    void setUp() {
        usuario = new Usuario("Juan Pérez", "Av. Siempre Viva 123");
        cuadroTarifario = new CuadroTarifario();
    }

    @Test
    void testUsuarioYConsumos() {
        usuario.setConsumoActiva(100); // Consumo de energía activa
        usuario.setConsumoReactiva(50); // Consumo de energía reactiva
        
        assertEquals("Juan Pérez", usuario.getNombre());
        assertEquals("Av. Siempre Viva 123", usuario.getDomicilio());
        assertEquals(100, usuario.getConsumoActiva());
        assertEquals(50, usuario.getConsumoReactiva());
    }

    @Test
    void testCalculoFactorDePotenciaExactoEnBordeSinBonificacion() {
        // Borde donde FPE = 0.8, no debería aplicar bonificación
        usuario.setConsumoActiva(4);
        usuario.setConsumoReactiva(3);
        
        assertEquals(0.8, usuario.getFPE(), 0.001); // Comprobación en borde
        Factura factura = new Factura(usuario, cuadroTarifario);
        
        assertFalse(factura.isBonificacion()); // No debe aplicar bonificación
        double expectedMontoFinal = 4 * cuadroTarifario.getPrecio();
        assertEquals(expectedMontoFinal, factura.getMontoFinal(), 0.001);
    }
    
    @Test
    void testCalculoFactorDePotenciaExactoEnBordeConBonificacion() {
        // Borde justo sobre 0.8, debería aplicar bonificación
        usuario.setConsumoActiva(5);
        usuario.setConsumoReactiva(3);
        
        assertTrue(usuario.getFPE() > 0.8); // FPE debería ser ligeramente superior a 0.8
        Factura factura = new Factura(usuario, cuadroTarifario);
        
        assertTrue(factura.isBonificacion()); // Debe aplicar bonificación
        double expectedMontoFinal = 5 * cuadroTarifario.getPrecio() * 0.9;
        assertEquals(expectedMontoFinal, factura.getMontoFinal(), 0.001);
    }
    
    @Test
    void testParticionEquivalenteSinBonificacion() {
        // Partición sin bonificación, con valores representativos bajos de FPE
        usuario.setConsumoActiva(10);
        usuario.setConsumoReactiva(15); // FPE estará muy por debajo de 0.8
        
        Factura factura = new Factura(usuario, cuadroTarifario);
        
        assertFalse(factura.isBonificacion()); // No aplica bonificación
        double expectedMontoFinal = 10 * cuadroTarifario.getPrecio();
        assertEquals(expectedMontoFinal, factura.getMontoFinal(), 0.001);
    }
    
    @Test
    void testParticionEquivalenteConBonificacion() {
        // Partición con bonificación, con valores representativos altos de FPE
        usuario.setConsumoActiva(100);
        usuario.setConsumoReactiva(20); // FPE estará muy por encima de 0.8
        
        Factura factura = new Factura(usuario, cuadroTarifario);
        
        assertTrue(factura.isBonificacion()); // Aplica bonificación
        double expectedMontoFinal = 100 * cuadroTarifario.getPrecio() * 0.9;
        assertEquals(expectedMontoFinal, factura.getMontoFinal(), 0.001);
    }

    @Test
    void testPrecioCuadroTarifario() {
        assertEquals(10, cuadroTarifario.getPrecio()); // Precio inicial
        cuadroTarifario.setPrecio(15); // Ajuste del precio
        assertEquals(15, cuadroTarifario.getPrecio());
    }
    
    @Test
    void testFechaEmisionFactura() {
        usuario.setConsumoActiva(100);
        usuario.setConsumoReactiva(50);
        
        Factura factura = new Factura(usuario, cuadroTarifario);
        
        assertEquals(LocalDate.now(), factura.getFecha()); // La fecha debe ser la actual
    }
}


