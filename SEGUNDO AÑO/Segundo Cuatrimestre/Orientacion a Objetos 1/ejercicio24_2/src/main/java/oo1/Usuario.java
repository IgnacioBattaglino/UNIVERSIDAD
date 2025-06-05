package oo1;

public abstract class Usuario {
    @SuppressWarnings("unused")
    private String nombre;
    private double saldo;

    public Usuario (String nombre, double saldo){
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public void cargarSaldo (double monto ) {
        this.saldo+= monto * this.calcularComision();
    }

    public void descontarSaldo (double monto) {
        this.saldo-= monto + this.calcularBonificacion();
    }

    public abstract double calcularComision();

    public abstract double calcularBonificacion();

    protected double getSaldo() {
        return this.saldo;
    }
}
