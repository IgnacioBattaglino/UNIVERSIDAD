package oo1;

import java.time.LocalDate;

public abstract class ServicioMedico extends Servicio {
    private Veterinario medico;

    public ServicioMedico(LocalDate fecha, Mascota mascota, Veterinario medico) {
        super(fecha, mascota);
        this.medico = medico;
    }

    public abstract double getCostoMaterial();

    public double costoSiEsDomingo () {
        if (this.getFecha().getDayOfWeek().getValue()==7) return 200;
        return 0;
    }

    public Veterinario getMedico() {
        return medico; 
    }

    public void setMedico(Veterinario medico) {
        this.medico = medico;
    }
    
}
