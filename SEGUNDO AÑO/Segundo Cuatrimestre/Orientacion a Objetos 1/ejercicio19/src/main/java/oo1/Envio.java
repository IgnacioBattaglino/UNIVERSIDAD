package oo1;

import java.time.LocalDate;

public abstract class Envio {

    private LocalDate fechaDespacho;
    private String direccionOrigen;
    private String direccionDestino;
    private int peso;

    public abstract double getPrecio();

    public Envio(LocalDate fechaDespacho, String direccionOrigen, String direccionDestino, int peso) {
        this.fechaDespacho = fechaDespacho;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.peso = peso;
    }

    public boolean envioEntreFechas (LocalDate from, LocalDate to) {
        return ((this.fechaDespacho.isAfter(from.minusDays(1))) && 
        (this.fechaDespacho.isBefore(to.plusDays(1))));
    }

    public LocalDate getFechaDespacho() {
        return fechaDespacho;
    }

    public void setFechaDespacho(LocalDate fechaDespacho) {
        this.fechaDespacho = fechaDespacho;
    }

    public String getDireccionOrigen() {
        return direccionOrigen;
    }

    public void setDireccionOrigen(String direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public String getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(String direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    
}
