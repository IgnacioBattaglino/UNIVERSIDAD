package oo1;

public abstract class Usuario {
    private String nombre;
    private double saldo;
    
    public abstract double calcularBonificacion ();
    public abstract double calcularComision ();
    public void procesar (double costo){
        this.descontarSaldo(costo);
    }
    public void descontarSaldo ( double cant ) {
        this.saldo = this.saldo - cant + this.calcularBonificacion();
    }
    
    public void cargarSaldo ( double cant) {
        this.saldo = this.saldo + cant * this.calcularComision();
    }

    public Usuario(String nombre, double saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
}
