package oo1;

import java.time.LocalDate;

public class Vehiculo {
    private String descripcion;
    private int capacidadMaxima;
    private int anio;
    private double valor;

    public int getAntiguedad() {
        int anioactual = LocalDate.now().getYear();
        return anioactual - this.getAnio();
        
    }

    public Vehiculo(String descripcion, int capacidadMaxima, int anio, double valor) {
        this.descripcion = descripcion;
        this.capacidadMaxima = capacidadMaxima;
        this.anio = anio;
        this.valor = valor;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getcapacidadMaxima() {
        return capacidadMaxima;
    }
    public void setcapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }


    
}
