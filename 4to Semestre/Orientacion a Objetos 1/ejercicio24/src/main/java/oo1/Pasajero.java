package oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pasajero extends Usuario{
    private List<Viaje> viajesPrevios;

    public Pasajero(String nombre, double saldo) {
        super(nombre, saldo);
        this.viajesPrevios = new ArrayList<>(); 
    }

    public boolean registrarseAViaje (Viaje viaje){
        if ((viaje.tieneCapacidad()) && (viaje.getFecha().minusDays(1).isAfter(LocalDate.now())) 
        && (!this.saldoEnRojo()) && (!viaje.getPasajeros().contains(this))) {
            viaje.agregarPasajero(this);
            viajesPrevios.add(viaje);
            return true;
        }
        return false;
    }

    private boolean tieneViaje () {
        if (viajesPrevios.size()<=1) return false;
        return true;
    }

    private boolean tieneViajeUltimos30Dias (){
        return viajesPrevios.stream()
        .map(viaje -> viaje.getFecha())
        .anyMatch(fecha -> fecha.isAfter(LocalDate.now().minusMonths(1)));
    }

    private boolean saldoEnRojo(){
        if (this.getSaldo()<0) return true;
        return false;
    }

    @Override
    public double calcularBonificacion() {
        if (this.tieneViaje()) return 500;
        return 0;
    }

    @Override
    public double calcularComision() {
        if (this.tieneViajeUltimos30Dias())
            return 1;
        return 0.9;
    }

    public List<Viaje> getViajesPrevios() {
        return viajesPrevios;
    }
    
}
