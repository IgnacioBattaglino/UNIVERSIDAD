package oo1;

import java.time.LocalDate;

public abstract class Contrato {
    private LocalDate fechaInicio;
    
    public abstract double calcularMontoACobrar ( Empleado e);
    public abstract boolean esActivo ();
    
    public Contrato(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public abstract int getDuracion();
    
    
}
