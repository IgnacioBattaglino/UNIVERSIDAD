package oo1;

import java.time.LocalDate;

public class Consulta extends ServicioMedico {
    
    public Consulta (Mascota mascota, Medico medico, LocalDate fecha){
        super (fecha,mascota,medico);
    }

    @Override
    protected double adicional(){
        return 300 + super.getMedico().getAntiguedad() * 100;
    }
}
