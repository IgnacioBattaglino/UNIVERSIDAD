package oo1;
import java.time.*;;

public class PlazoFijo implements Inversion {
    private LocalDate fecha;
    private double montoDepositado;
    private double porcentajeDeInteresDiario;

    public PlazoFijo(double montoDepositado, double porcentajeDeInteresDiario) {
        this.montoDepositado = montoDepositado;
        this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
        this.setFecha(LocalDate.now());
    }
    
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public double getMontoDepositado() {
        return montoDepositado;
    }
    public void setMontoDepositado(double montoDepositado) {
        this.montoDepositado = montoDepositado;
    }
    public double getPorcentajeDeInteresDiario() {
        return porcentajeDeInteresDiario;
    }
    public void setPorcentajeDeInteresDiario(double porcentajeDeInteresDiario) {
        this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
    }

    public double valorActual() {
        LocalDate fechaActual = LocalDate.now();
        
        int diasTranscurridos = (int) (fechaActual.toEpochDay() - fecha.toEpochDay());
        
        double interesGanado = montoDepositado * (porcentajeDeInteresDiario / 100) * diasTranscurridos;
        
        return montoDepositado + interesGanado;
    }

}
