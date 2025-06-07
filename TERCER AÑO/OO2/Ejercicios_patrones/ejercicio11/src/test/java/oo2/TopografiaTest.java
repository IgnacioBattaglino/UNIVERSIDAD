package oo2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TopografiaTest {
    
    private Agua agua;
    private Tierra tierra;
    private TopografiaMixta topografiaEjemplo;
    private TopografiaMixta topografiaTodoAgua;
    private TopografiaMixta topografiaTodoTierra;
    
    @BeforeEach
    void setUp() {
        // Elementos básicos
        agua = new Agua();
        tierra = new Tierra();
        
        // Topografía del ejemplo del enunciado: (1+0+0+1) / 4 = 0.5
        topografiaEjemplo = new TopografiaMixta();
        topografiaEjemplo.addHijo(new Agua());    // 1
        topografiaEjemplo.addHijo(new Tierra());  // 0
        topografiaEjemplo.addHijo(new Tierra());  // 0
        topografiaEjemplo.addHijo(new Agua());    // 1
        
        // Topografía mixta todo agua
        topografiaTodoAgua = new TopografiaMixta();
        topografiaTodoAgua.addHijo(new Agua());
        topografiaTodoAgua.addHijo(new Agua());
        topografiaTodoAgua.addHijo(new Agua());
        topografiaTodoAgua.addHijo(new Agua());
        
        // Topografía mixta todo tierra
        topografiaTodoTierra = new TopografiaMixta();
        topografiaTodoTierra.addHijo(new Tierra());
        topografiaTodoTierra.addHijo(new Tierra());
        topografiaTodoTierra.addHijo(new Tierra());
        topografiaTodoTierra.addHijo(new Tierra());
    }
    
    @Test
    void testProporcionAguaElementosBasicos() {
        assertEquals(1.0, agua.calcularProporcionAgua(), 0.001);
        assertEquals(0.0, tierra.calcularProporcionAgua(), 0.001);
    }
    
    @Test
    void testProporcionAguaTopografiaEjemplo() {
        // Verificar que la topografía del ejemplo da 0.5
        assertEquals(0.5, topografiaEjemplo.calcularProporcionAgua(), 0.001);
    }
    
    @Test
    void testProporcionAguaTopografiasTodoAgua() {
        assertEquals(1.0, topografiaTodoAgua.calcularProporcionAgua(), 0.001);
    }
    
    @Test
    void testProporcionAguaTopografiasTodoTierra() {
        assertEquals(0.0, topografiaTodoTierra.calcularProporcionAgua(), 0.001);
    }
    
    @Test
    void testTopografiaRecursiva() {
        // Crear una topografía mixta que contenga otras topografías mixtas
        TopografiaMixta topografiaRecursiva = new TopografiaMixta();
        topografiaRecursiva.addHijo(topografiaEjemplo);    // 0.5
        topografiaRecursiva.addHijo(topografiaTodoAgua);   // 1.0
        topografiaRecursiva.addHijo(topografiaTodoTierra); // 0.0
        topografiaRecursiva.addHijo(new Agua());           // 1.0
        
        // (0.5 + 1.0 + 0.0 + 1.0) / 4 = 0.625
        assertEquals(0.625, topografiaRecursiva.calcularProporcionAgua(), 0.001);
    }
    
    @Test
    void testEqualsElementosBasicos() {
        Agua otraAgua = new Agua();
        Tierra otraTierra = new Tierra();
        
        assertTrue(agua.equals(otraAgua));
        assertTrue(tierra.equals(otraTierra));
        assertFalse(agua.equals(tierra));
        assertFalse(tierra.equals(agua));
    }
    
    @Test
    void testEqualsTopografiasMixtas() {
        // Crear una topografía idéntica al ejemplo
        TopografiaMixta topografiaIgual = new TopografiaMixta();
        topografiaIgual.addHijo(new Agua());
        topografiaIgual.addHijo(new Tierra());
        topografiaIgual.addHijo(new Tierra());
        topografiaIgual.addHijo(new Agua());
        
        assertTrue(topografiaEjemplo.equals(topografiaIgual));
        
        // Crear una topografía con misma proporción pero diferente disposición
        TopografiaMixta topografiaDiferente = new TopografiaMixta();
        topografiaDiferente.addHijo(new Agua());
        topografiaDiferente.addHijo(new Agua());
        topografiaDiferente.addHijo(new Tierra());
        topografiaDiferente.addHijo(new Tierra());
        
        assertFalse(topografiaEjemplo.equals(topografiaDiferente));
    }
    
    @Test
    void testEqualsEntreTiposDistintos() {
        // Un Agua no puede ser igual a una TopografiaMixta (incluso si tienen misma proporción)
        assertFalse(agua.equals(topografiaTodoAgua));
        assertFalse(topografiaTodoAgua.equals(agua));
        
        // Una Tierra no puede ser igual a una TopografiaMixta
        assertFalse(tierra.equals(topografiaTodoTierra));
        assertFalse(topografiaTodoTierra.equals(tierra));
    }
    
    @Test
    void testValidacionCantidadHijos() {
        TopografiaMixta topografiaSinHijos = new TopografiaMixta();
        
        // Debe lanzar excepción si no tiene exactamente 4 hijos
        assertThrows(IllegalStateException.class, 
                    () -> topografiaSinHijos.calcularProporcionAgua());
        
        // Agregar solo 2 hijos
        topografiaSinHijos.addHijo(new Agua());
        topografiaSinHijos.addHijo(new Tierra());
        
        assertThrows(IllegalStateException.class, 
                    () -> topografiaSinHijos.calcularProporcionAgua());
    }
    
    @Test
    void testGestionHijos() {
        TopografiaMixta topografia = new TopografiaMixta();
        
        // Agregar hijos
        topografia.addHijo(new Agua());
        topografia.addHijo(new Tierra());
        
        assertEquals(2, topografia.getHijos().size());
        
        // Remover hijo
        Agua aguaParaRemover = new Agua();
        topografia.addHijo(aguaParaRemover);
        topografia.removeHijo(aguaParaRemover);
        
        assertEquals(2, topografia.getHijos().size());
    }
    
    @Test
    void testEqualsReflexivo() {
        // Un objeto debe ser igual a sí mismo
        assertTrue(topografiaEjemplo.equals(topografiaEjemplo));
        assertTrue(agua.equals(agua));
        assertTrue(tierra.equals(tierra));
    }
}