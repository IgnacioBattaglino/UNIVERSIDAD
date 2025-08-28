package oo1;

import java.time.LocalDate;

public class Guarderia extends Servicio {
    private int cantDias;
    
    public Guarderia(Mascota mascota, int cantDias) {
        super(LocalDate.now(), mascota);
        this.cantDias = cantDias;
    }
    @Override
    public double calcularCosto() {
        double costo = this.cantDias * 500;
        if (this.getMascota().tiene5OMasServicios()) costo = costo * 0.9;
        return costo;
    }

    public int getCantDias() {
        return cantDias;
    }

    public void setCantDias(int cantDias) {
        this.cantDias = cantDias;
    }

    
}
