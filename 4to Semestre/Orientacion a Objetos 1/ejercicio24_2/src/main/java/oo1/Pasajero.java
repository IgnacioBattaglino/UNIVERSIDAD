package oo1;

import java.util.ArrayList;

public class Pasajero extends Usuario {
    private ArrayList<Viaje> viajes;

    public Pasajero (String nombre){
        super(nombre,0);
        this.viajes= new ArrayList<>();
    }

    public boolean registrarseAViaje (Viaje viaje) {
        if (viaje.tieneCapacidad() && viaje.diasHasta()>=2 && !this.saldoEnRojo()) {
            viajes.add(viaje);
            viaje.agregarPasajero (this);
            return true;
        }
        return false;
    }

    private boolean tieneViajes30Dias() {
        return viajes.stream()
        .anyMatch(v -> v.menosDe30Dias());
    }

    @Override 
    public double calcularComision() {
        if (tieneViajes30Dias()) return 1;
        else return 0.9;
    }

    @Override 
    public double calcularBonificacion() {
        if (viajes.stream().anyMatch(v -> v.yaPaso())) return 500;
        return 0;
    }

    private boolean saldoEnRojo() {
        return this.getSaldo() <= 0;
    }
}
