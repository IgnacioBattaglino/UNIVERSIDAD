package oo1;
import java.time.LocalDate;
import java.util.List;

public class Ticket {
    private LocalDate fecha;
    private final List<Producto> productos;
    private int cantidadDeProductos;
    private double pesoTotal;
    private double precioTotal;


    public Ticket(LocalDate fecha, int cantidadDeProductos, double pesoTotal, double precioTotal, List<Producto> productos) {
        this.fecha = fecha;
        this.cantidadDeProductos = cantidadDeProductos;
        this.pesoTotal = pesoTotal;
        this.precioTotal = precioTotal;
        this.productos = productos;
    }

    public List<Producto> getProductos(){
        return this.productos;
    }

    public double impuesto(){
        return this.precioTotal*0.21; 
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCantidadDeProductos() {
        return cantidadDeProductos;
    }

    public void setCantidadDeProductos(int cantidadDeProductos) {
        this.cantidadDeProductos = cantidadDeProductos;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

}
