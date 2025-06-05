package ar.edu.unlp.info.oo2.biblioteca;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class BibliotecaTest {
    private Biblioteca biblioteca;
    private Socio socio1;
    private Socio socio2;

    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca();
        socio1 = new Socio("Mateo", "mail", "1");
        socio2 = new Socio("Nacho", "mail2", "2");
    }

    @Test
    void testExportarSinSocios () {
        assertEquals("[]", biblioteca.exportarSocios());
    }

    @Test
    void testExportarUnSocio() {
        biblioteca.agregarSocio(socio1);
        String resultado = biblioteca.exportarSocios();
        assertTrue(resultado.contains("\"nombre\": \"Mateo\""));
        assertTrue(resultado.contains("\"email\": \"mail\""));
        assertTrue(resultado.contains("\"legajo\": \"1\""));
    }

    @Test
    void testExportarSocios() {
        biblioteca.agregarSocio(socio1);
        biblioteca.agregarSocio(socio2);
        String resultado = biblioteca.exportarSocios();
        assertTrue(resultado.contains("\"nombre\": \"Mateo\""));
        assertTrue(resultado.contains("\"email\": \"mail\""));
        assertTrue(resultado.contains("\"legajo\": \"1\""));
        assertTrue(resultado.contains("\"nombre\": \"Nacho\""));
        assertTrue(resultado.contains("\"email\": \"mail2\""));
        assertTrue(resultado.contains("\"legajo\": \"2\""));
    }


}
