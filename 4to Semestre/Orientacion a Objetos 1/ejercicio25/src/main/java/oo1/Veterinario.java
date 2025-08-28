package oo1;

import java.time.LocalDate;

public class Veterinario {
    private String nombre;
    private LocalDate fechaIngreso;
    private double honorarios;
    
    public Veterinario(String nombre, LocalDate fechaIngreso, double honorarios) {
        this.nombre = nombre;
         this.fechaIngreso = fechaIngreso;
        this.honorarios = honorarios;
    }
    public int getAntiguedad() {
        return LocalDate.now().getYear() - this.fechaIngreso.getYear();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public double getHonorarios() {
        return honorarios;
    }
    public void setHonorarios(double honorarios) {
        this.honorarios = honorarios;
    }

}
