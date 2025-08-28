package oo1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ClienteDeCorreoTest {

    private ClienteDeCorreo clienteDeCorreo;
    private Carpeta carpeta1;
    private Carpeta carpeta2;
    private Email email1;
    private Email email2;

    @BeforeEach
    void setUp() {
        clienteDeCorreo = new ClienteDeCorreo();
        carpeta1 = new Carpeta("Carpeta 1");
        carpeta2 = new Carpeta("Carpeta 2");

        List<Archivo> adjuntos = new ArrayList<>();
        adjuntos.add(new Archivo("Adjunto 1"));
        
        email1 = new Email("Título 1", "Cuerpo del email 1", adjuntos);
        email2 = new Email("Título 2", "Cuerpo del email 2", adjuntos);
        
        clienteDeCorreo.recibir(email1);
        clienteDeCorreo.getCarpetas().add(carpeta1);
        clienteDeCorreo.getCarpetas().add(carpeta2);
        carpeta1.agregarCorreo(email2);
    }

    @Test
    void testBuscar() {
        assertEquals(email1, clienteDeCorreo.buscar("Título 1"));
        assertEquals(email2, clienteDeCorreo.buscar("email 2"));
        assertNull(clienteDeCorreo.buscar("No existe"));
    }

    @Test
    void testMover() {
        assertTrue(clienteDeCorreo.getInbox().getMails().contains(email1));
        assertFalse(carpeta1.getMails().contains(email1));
        
        clienteDeCorreo.mover(email1, clienteDeCorreo.getInbox(), carpeta1);
        
        assertFalse(clienteDeCorreo.getInbox().getMails().contains(email1));
        assertTrue(carpeta1.getMails().contains(email1));
    }

    @Test
    void testEspacioOcupado() {
        int espacioTotal = email1.getTamaño() + email2.getTamaño();
        assertEquals(espacioTotal, clienteDeCorreo.espacioOcupado());
    }
}
