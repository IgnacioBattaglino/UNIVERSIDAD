package oo1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ContratoDePlanta extends Contrato {
    private double sueldo;
    private double montoPorConyuge;
    private double montoPorHijos;
    
    public ContratoDePlanta(LocalDate fechaInicio, double sueldo, double montoPorConyuge, double montoPorHijos) {
        super(fechaInicio);
        this.sueldo = sueldo;
        this.montoPorConyuge = montoPorConyuge;
        this.montoPorHijos = montoPorHijos;
    }
    
    @Override
    public int getDuracion() {
        return (int) ChronoUnit.DAYS.between(this.getFechaInicio(), LocalDate.now());
    }

    @Override
    public double calcularMontoACobrar( Empleado e) {
        double monto = this.sueldo;
        if (e.isTieneConyuge()) monto += this.montoPorConyuge;
        if (e.isTieneHijos()) monto += this.montoPorHijos;
        return monto;
    }

    @Override
    public boolean esActivo() {
        return true;
    }

    public double getSueldo() {
        return sueldo;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    public double getMontoPorConyuge() {
        return montoPorConyuge;
    }
    public void setMontoPorConyuge(double montoPorConyuge) {
        this.montoPorConyuge = montoPorConyuge;
    }
    public double getMontoPorHijos() {
        return montoPorHijos;
    }
    public void setMontoPorHijos(double montoPorHijos) {
        this.montoPorHijos = montoPorHijos;
    }

    
}
