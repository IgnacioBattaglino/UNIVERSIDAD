package oo1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Cliente extends Persona{
    private List<Pedido> pedidos;

    public Cliente(String nombre, String direccion) {
        super(nombre, direccion);
        this.pedidos = new LinkedList<>();
    }

    public Pedido crearPedido (FormaPago formaPago, FormaEnvio formaEnvio, Producto producto, int cant) {
        if ((producto.tieneUnidades(cant)) && (cant >0)) {
            producto.reducirStock(cant);
            Pedido pedido = new Pedido(producto, formaPago, formaEnvio, cant);
            pedidos.add(pedido);
            return pedido;
        }
        return null;
    }

    public Map<String,Integer> cantProductosCategoria (){
        HashMap<String,Integer> mapa = new HashMap<>();
        for (Pedido pedido : this.pedidos) {
            if (mapa.containsKey(pedido.getCategoria())) 
                mapa.put(pedido.getCategoria(),mapa.get(pedido.getCategoria())+pedido.getCant());
            else 
                mapa.put (pedido.getCategoria(),pedido.getCant());
        }
        return mapa;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
    
}
