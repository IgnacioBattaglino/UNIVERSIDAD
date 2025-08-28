package oo1;

import java.time.LocalDate;

public class Vacunacion extends ServicioMedico {
    private String nombreVacuna;
    private double costo;

    public Vacunacion (Mascota mascota, Medico medico, LocalDate fecha, String vacuna, double costo){
        super (fecha,mascota,medico);
        this.nombreVacuna=vacuna;
        this.costo=costo;
    }

    @Override
    protected double adicional(){
        return 500 + this.costo;
    }
}

