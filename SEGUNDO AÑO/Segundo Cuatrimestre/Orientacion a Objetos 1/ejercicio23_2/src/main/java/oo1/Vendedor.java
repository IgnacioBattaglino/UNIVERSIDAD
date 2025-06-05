package oo1;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Persona {
    @SuppressWarnings("unused")
    private List<Producto> productos;

    public Vendedor (String nombre, String direccion){
        super(nombre,direccion);
        this.productos= new ArrayList<>();
    }
}
