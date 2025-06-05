package oo1;

import java.time.LocalDate;

public class Vacunacion extends ServicioMedico{
    private String nombreVacuna;
    private double costo;

    public Vacunacion(Mascota mascota, Veterinario medico, String nombreVacuna, double costo) {
        super(LocalDate.now(), mascota, medico);
        this.nombreVacuna = nombreVacuna;
        this.costo = costo;
    }

    @Override
    public double calcularCosto() {
        return this.getMedico().getHonorarios() + this.getCostoMaterial() + this.costoSiEsDomingo() + this.costo;
    }

    public double getCostoMaterial() {
        return 500;
    }

    public String getNombreVacuna() {
        return nombreVacuna;
    }
    public void setNombreVacuna(String nombreVacuna) {
        this.nombreVacuna = nombreVacuna;
    }
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
}
