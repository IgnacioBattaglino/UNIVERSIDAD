package oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {
    Cliente cliente;

    @BeforeEach
    void setUp(){
        cliente = new Cliente ("Ignacio Battaglino", 
        "Plaza Paso 167");
        
    }

    @Test
    void testCrearPedido (){
        assertNotNull(cliente.crearPedido(new Contado(), new RetirarComercio(), 
        new Producto("Producto 1", "Categoria 1", 100, 100), 
        1)); // Test caso de borde limite minimo
        assertNotNull(cliente.crearPedido(new Contado(), new RetirarComercio(), 
        new Producto("Producto 1", "Categoria 1", 100, 100), 
        10)); // Test particion 1 (Dentro de los limites)
        assertNotNull(cliente.crearPedido(new Contado(), new RetirarComercio(), 
        new Producto("Producto 1", "Categoria 1", 100, 100), 
        100)); // Test caso de borde limite maximo
        assertNull(cliente.crearPedido(new Contado(), new RetirarComercio(), 
        new Producto("Producto 1", "Categoria 1", 100, 100), 
        101)); // Test particion 2 (Fuera de los limites)
    }

    @Test
    void testCantProductosCategoria(){
        cliente.crearPedido(new Contado(), new RetirarComercio(), 
        new Producto("Producto 1", "Categoria 1", 100, 100), 
        10);

        cliente.crearPedido(new Contado(), new RetirarComercio(), 
        new Producto("Producto 1", "Categoria 1", 100, 100), 
        10);

        cliente.crearPedido(new Contado(), new RetirarComercio(), 
        new Producto("Producto 1", "Categoria 2", 100, 100), 
        100);

        cliente.crearPedido(new Contado(), new RetirarComercio(), 
        new Producto("Producto 1", "Categoria 3", 100, 100), 
        100);

        HashMap<String,Integer> mapaEsperado = new HashMap<>();
        mapaEsperado.put("Categoria 1", 20);
        mapaEsperado.put("Categoria 2", 100);
        mapaEsperado.put("Categoria 3", 100);
        assertEquals(cliente.cantProductosCategoria(), mapaEsperado);
    }
}
