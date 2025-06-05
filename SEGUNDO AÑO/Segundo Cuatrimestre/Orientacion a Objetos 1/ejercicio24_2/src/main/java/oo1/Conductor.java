package oo1;

public class Conductor extends Usuario {
    private Vehiculo vehiculo;
    public Conductor (String nombre, Vehiculo vehiculo) {
        super (nombre, 0);
        this.vehiculo = vehiculo;
    } 

    @Override
    public double calcularComision() {
        if (vehiculo.getAntiguedad()<5) return 0.99;
        else return 0.9;
    }

    @Override 
    public double calcularBonificacion() {
        return vehiculo.bonificacion();
    }

}
