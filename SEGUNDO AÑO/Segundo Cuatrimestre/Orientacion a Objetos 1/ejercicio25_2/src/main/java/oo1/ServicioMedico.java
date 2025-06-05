package oo1;

import java.time.DayOfWeek;
import java.time.LocalDate;

public abstract class ServicioMedico extends Servicio {
    private Medico medico;

    public ServicioMedico (LocalDate fecha, Mascota mascota, Medico med){
        super(fecha,mascota);
        this.medico=med;
    }
    
    @Override
    public double calcularCosto(){
        double costo=this.medico.getHonorarios() + this.adicional();
        costo += this.esDomingo() ? 200 : 0;
        return costo;
    }

    protected abstract double adicional();

    private boolean esDomingo(){
        return super.getFecha().getDayOfWeek().equals(DayOfWeek.SUNDAY);
    }

    protected Medico getMedico() {
        return this.medico;
    }
}
