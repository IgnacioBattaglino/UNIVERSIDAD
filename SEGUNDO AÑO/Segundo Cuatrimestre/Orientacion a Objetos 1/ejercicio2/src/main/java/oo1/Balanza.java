package oo1;
import java.time.LocalDate;

public class Balanza {
    private int cantidadDeProductos;
    private double precioTotal;
    private double pesoTotal;

    public Balanza() {
    }

    public Balanza(int cantidadDeProductos, double precioTotal, double pesoTotal) {
        this.cantidadDeProductos = cantidadDeProductos;
        this.precioTotal = precioTotal;
        this.pesoTotal = pesoTotal;
    }

    public void ponerEnCero () {
        pesoTotal = 0;
        precioTotal=0;
        this.cantidadDeProductos=0;
    }

    public void agregarProducto (Producto Producto){
        pesoTotal+= Producto.getPeso();
        precioTotal+= Producto.getPeso() * Producto.getPrecioPorKilo();
        cantidadDeProductos++;
    }

    public Ticket emitirTicket(){
        return new Ticket (LocalDate.now(), this.cantidadDeProductos, this. pesoTotal, this.precioTotal);
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
