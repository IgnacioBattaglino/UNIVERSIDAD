package oo1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoPorHoras extends Contrato {
    private LocalDate fechaFin;
    private double valorHora;
    private int horasATrabajar;

    public ContratoPorHoras(LocalDate fechaInicio, LocalDate fechaFin, double valorHora, int horasATrabajar) {
        super(fechaInicio);
        this.fechaFin = fechaFin;
        this.valorHora = valorHora;
        this.horasATrabajar = horasATrabajar;
    }

    @Override
    public int getDuracion() {
        return (int) ChronoUnit.DAYS.between(this.getFechaInicio(), this.fechaFin);
    }

    @Override
    public double calcularMontoACobrar( Empleado e) {
        return this.valorHora * this.horasATrabajar;
    }

    @Override
    public boolean esActivo() {
        return (this.fechaFin.isAfter(LocalDate.now()));
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
    public double getValorHora() {
        return valorHora;
    }
    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
    public int getHorasATrabajar() {
        return horasATrabajar;
    }
    public void setHorasATrabajar(int horasATrabajar) {
        this.horasATrabajar = horasATrabajar;
    }

    
}
