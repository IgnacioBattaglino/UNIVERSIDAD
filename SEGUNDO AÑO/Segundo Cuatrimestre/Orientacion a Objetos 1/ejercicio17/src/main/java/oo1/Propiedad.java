package oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Propiedad {
    private String direccion;
    private String nombre;
    private double precioPorNoche;
    private List<Reserva> reservas;

    public Propiedad(String direccion, String nombre, double precioPorNoche) {
        this.direccion = direccion;
        this.nombre = nombre;
        this.precioPorNoche = precioPorNoche;
        this.reservas = new ArrayList<>();
    }

    public void reservar (DateLapse periodo) {
        this.reservas.add(new Reserva(this,precioPorNoche,periodo));
    }

    public boolean isAvailable (LocalDate from, LocalDate to) {
        DateLapse periodo = new DateLapse (from, to);
        return ! this.reservas.stream()
        .map (reserva -> reserva.getPeriodo())
        .anyMatch(p -> p.includesLapse(periodo));
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecioPorNoche() {
        return precioPorNoche;
    }
    public void setPrecioPorNoche(double precioPorNoche) {
        this.precioPorNoche = precioPorNoche;
    }

    
}
