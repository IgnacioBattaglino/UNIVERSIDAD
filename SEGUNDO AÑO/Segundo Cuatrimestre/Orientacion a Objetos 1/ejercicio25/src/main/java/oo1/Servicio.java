package oo1;

import java.time.LocalDate;

public abstract class Servicio {
    private LocalDate fecha;
    private Mascota mascota;

    public abstract double calcularCosto();

    public Servicio(LocalDate fecha, Mascota mascota) {
        mascota.getServiciosUsados().add(this);
        this.fecha = fecha;
        this.mascota = mascota;
    }

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public Mascota getMascota() {
        return mascota;
    }
    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    } 
}
