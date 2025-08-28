package oo1;

public class Producto {
    @SuppressWarnings("unused")
    private String nombre;
    private String categoria;
    private double precio;
    private int cantDisponible; 

    public boolean tieneUnidades (int cant){
        return cantDisponible>= cant;
    }

    public void disminuirCant(int cant) {
        this.cantDisponible = this.cantDisponible - cant;
    }

    public String getCategoria() {
        return this.categoria;
    }
 
    public double getPrecio () {
        return this.precio;
    }

}
