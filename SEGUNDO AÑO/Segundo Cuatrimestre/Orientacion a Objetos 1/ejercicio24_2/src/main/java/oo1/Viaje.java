package oo1;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Viaje {
    private ArrayList<Usuario> pasajeros;
    private Vehiculo vehiculo;
    private String origen;
    private String destino;
    private double costoTotal;
    private LocalDate fecha;

    public Viaje (String origen, String destino, double costoTot, Vehiculo vehiculo, LocalDate fecha){
        this.pasajeros = new ArrayList<>();
        this.vehiculo = vehiculo;
        this.origen=origen;
        this.destino=destino;
        this.costoTotal=costoTot;
        this.fecha=fecha;
        this.pasajeros.add(vehiculo.getConductor());
    }

    public void procesarViaje () {
        double costoPorCabeza= this.costoTotal / pasajeros.size();
        pasajeros.stream()
        .forEach(p -> p.descontarSaldo(costoPorCabeza + p.calcularBonificacion()));
    }

    public boolean tieneCapacidad() {
        return this.pasajeros.size()<this.vehiculo.getCapacidad();
    }

    public int diasHasta() {
        if (!this.yaPaso()) 
            return (Period.between(LocalDate.now(), this.fecha).getDays());
        return 0;
    }

    public void agregarPasajero(Pasajero pasajero){
        this.pasajeros.add(pasajero);
    }

    public boolean menosDe30Dias() {
        if (!yaPaso()) return false; 
        return Period.between(LocalDate.now(), this.fecha).getDays() <= 30;
    }

    public boolean yaPaso() {
        return LocalDate.now().isAfter(this.fecha);
    }

}
