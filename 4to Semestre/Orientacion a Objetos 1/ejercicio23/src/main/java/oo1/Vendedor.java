package oo1;

import java.util.LinkedList;
import java.util.List;

public class Vendedor extends Persona {
    private List<Producto> productos;

    public Vendedor(String nombre, String direccion) {
        super(nombre, direccion);
        this.productos = new LinkedList<>();
    }
    
    public void publicarProducto (Producto producto) {
        this.productos.add(producto);
    }

    public List<Producto> getProductos() {
        return productos;
    }
    

}
