package oo1;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
    private Pedido pedidoContadoExpress;
    private Pedido pedidoSeisCuotasComercio;
    private Pedido pedidoContadoCorreo;
    private Producto producto;

    @BeforeEach
    void setUp() {
        this.producto = new Producto(null, null, 0, 0);
        this.pedidoContadoExpress = new Pedido(producto, new Contado(), new ExpressDomicilio("Direccion1", "Diraccion2"), 100);
        this.pedidoSeisCuotasComercio = new Pedido (producto, new SeisCuotas(), new RetirarComercio(), 100);
        this.pedidoContadoCorreo = new Pedido (producto, new Contado(), new RetirarCorreo(), 100);
    }

    @Test
    void testGetCategoria(){
        assertEquals(producto.getCategoria(), pedidoContadoCorreo.getCategoria());
    }

    @Test
    void testCalcularCostoTotal (){
        double costoEsperado = pedidoContadoCorreo.getCostoProducto() + 3000;
        assertEquals(pedidoContadoCorreo.calcularCostoTotal(), costoEsperado);

        costoEsperado = pedidoContadoExpress.getCostoProducto() + 100 * 0.5;
        assertEquals(pedidoContadoExpress.calcularCostoTotal(), costoEsperado);

        costoEsperado = pedidoSeisCuotasComercio.getCostoProducto() * 1.2;
        assertEquals(pedidoSeisCuotasComercio.calcularCostoTotal(), costoEsperado);

    }
}
