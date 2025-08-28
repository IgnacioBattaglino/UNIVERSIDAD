package oo1;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Balanza {
    private int cantidadDeProductos;
    private double precioTotal;
    private double pesoTotal;
    private List<Producto> productos;

    public Balanza() {
        this.cantidadDeProductos = 0;
        this.precioTotal = 0;
        this.pesoTotal = 0;
        this.productos = new LinkedList<>();
    }

    public List<Producto> getProductos(){
        return productos;
    }

    public Balanza(int cantidadDeProductos, double precioTotal, double pesoTotal) {
        this.cantidadDeProductos = cantidadDeProductos;
        this.precioTotal = precioTotal;
        this.pesoTotal = pesoTotal;
        this.productos = new LinkedList<>();
    }

    public void ponerEnCero () {
        pesoTotal = 0;
        precioTotal=0;
        this.cantidadDeProductos=0;
        this.productos.clear();
    }

    public void agregarProducto (Producto Producto){
        pesoTotal+= Producto.getPeso();
        precioTotal+= Producto.getPeso() * Producto.getPrecioPorKilo();
        cantidadDeProductos++;
        this.productos.add(Producto);
    }

    public Ticket emitirTicket(){
        return new Ticket (LocalDate.now(), this.cantidadDeProductos, this. pesoTotal, this.precioTotal, this.productos);
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }
}
