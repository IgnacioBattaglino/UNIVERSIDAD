package oo1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cliente extends Persona {
    private ArrayList<Pedido> pedidos;

    public Cliente(String nombre, String direccion) {
        super (nombre,direccion);
        this.pedidos = new ArrayList<> ();
    }

    public void crearPedido ( FormaDePago formaPago, FormaDeEnvio formaEnvio, Producto producto, int cant){
        if (producto.tieneUnidades(cant)) {
            pedidos.add(new Pedido(cant,producto,formaPago,formaEnvio));
            producto.disminuirCant(cant);
        }
    } 

    public Map<String,Integer> productosPorCategoria(){
        Map<String,Integer> mapa = new HashMap<>();
        for (Pedido p: this.pedidos ) {
            mapa.merge(p.getCategoriaProducto(),p.getCant(), (x, y) -> x + y);
        }
        return mapa;
    }

}
