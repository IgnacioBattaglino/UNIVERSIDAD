 package oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Viaje {
    private String origen;
    private String destino;
    private double costo;
    private LocalDate fecha;
    private Vehiculo vehiculo;
    private List<Usuario> pasajeros;
    
    public Viaje(String origen, String destino, double costo, LocalDate fecha, Vehiculo vehiculo) {
        this.origen = origen;
        this.destino = destino;
        this.costo = costo;
        this.fecha = fecha;
        this.vehiculo = vehiculo;
        this.pasajeros = new ArrayList<>();
    }

    public void agregarPasajero (Usuario pasajero){
        pasajeros.add(pasajero);
    } 

    public boolean tieneCapacidad () {
        return pasajeros.size()<this.vehiculo.getcapacidadMaxima();
    }

    public void procesarViaje () {
        for (Usuario pasajero : pasajeros) {
            pasajero.procesar(this.costo/this.pasajeros.size());
        }
    }

    public String getOrigen() {
        return origen;
    }
    public void setOrigen(String origen) {
        this.origen = origen;
    }
    public String getDestino() {
        return destino;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public List<Usuario> getPasajeros() {
        return pasajeros;
    }
    
}
