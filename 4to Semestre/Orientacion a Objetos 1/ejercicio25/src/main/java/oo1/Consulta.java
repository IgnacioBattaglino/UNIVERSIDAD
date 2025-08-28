package oo1;

import java.time.LocalDate;

public class Consulta extends ServicioMedico {

    public Consulta(Mascota mascota, Veterinario medico) {
        super(LocalDate.now(), mascota, medico);
    }

    @Override
    public double getCostoMaterial() {
        return 300;
    }

    @Override
    public double calcularCosto() {
        return this.getMedico().getHonorarios() + this.getCostoMaterial() + this.costoSiEsDomingo() + this.getMedico().getAntiguedad() * 100;
    }

}
