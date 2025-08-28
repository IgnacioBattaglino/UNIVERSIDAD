package oo1;

import java.time.LocalDate;

public abstract class Servicio {
    private LocalDate fecha;
    private Mascota mascota;

    public Servicio (LocalDate fecha, Mascota mascota){
        this.mascota=mascota;
        this.fecha=fecha;
    }

    public abstract double calcularCosto();

    public LocalDate getFecha(){
        return this.fecha;
    }

    protected Mascota getMascota(){
        return this.mascota;
    }
}
