package oo1;

import java.time.LocalDate;

public class Conductor extends Usuario {

    private Vehiculo vehiculo;

    public Conductor(String nombre, double saldo, Vehiculo vehiculo) {
        super(nombre, saldo);
        this.vehiculo = vehiculo;
    }

    public Viaje registrarViaje (String origen, String destino, double costoTotal, LocalDate fecha) {
        Viaje viaje = new Viaje(origen, destino, costoTotal, fecha, this.vehiculo);
        viaje.agregarPasajero(this);
        return viaje;
    }

    @Override
    public double calcularBonificacion() {
        return this.vehiculo.getValor()*0.01;
    }

    @Override
    public double calcularComision() {
        if (vehiculo.getAntiguedad()<5) return 0.99;
        return 0.9;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }
    
}
