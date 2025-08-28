package oo1;

import java.time.LocalDate;

public class Vehiculo {
    private String descripcion;
    private Conductor dueño;
    private int capacidad;
    private int año;
    private double valor;

    public Vehiculo (String descripcion, Conductor duenio, int capacidad, int anio, double valor) {
        this.descripcion = descripcion;
        this.dueño = duenio;
        this.capacidad = capacidad;
        this.año = anio;
        this.valor = valor;
    }

    public int getAntiguedad() {
        return LocalDate.now().getYear() - this.año;
    }

    public double bonificacion () {
        return this.valor * 0.01;
    }

    public int getCapacidad () {
        return this.capacidad;
    }

    public Conductor getConductor () {
        return this.dueño;
    }
}
