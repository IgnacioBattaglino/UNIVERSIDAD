package oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductoTest {
    private Producto producto;

    @BeforeEach
    void setUp(){
        producto= new Producto("Producto", "Categoria1", 100, 1000);
    }

    @Test
    void testTieneUnidades (){
        assertTrue (producto.tieneUnidades(100));
        assertFalse(producto.tieneUnidades(1500));
        assertTrue(producto.tieneUnidades(1000));
    }

    @Test
    void testReducirStock (){
        producto.reducirStock(100);
        int stockEsperado = 900;
        assertEquals(producto.getCantDisponible(), stockEsperado);

        producto.reducirStock(900);
        stockEsperado = 0;
        assertEquals(producto.getCantDisponible(), stockEsperado);
    }

}
