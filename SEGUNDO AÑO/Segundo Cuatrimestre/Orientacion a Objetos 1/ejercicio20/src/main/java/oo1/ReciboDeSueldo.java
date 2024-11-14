package oo1;

import java.time.LocalDate;

public class ReciboDeSueldo {
    private String nombre;
    private String apellido;
    private String CUIL;
    private int antiguedad;
    private LocalDate fecha;
    private double monto;
    
    public ReciboDeSueldo(String nombre, String apellido, String cUIL, int antiguedad, LocalDate fecha, double monto) {
        this.nombre = nombre;
        this.apellido = apellido;
        CUIL = cUIL;
        this.antiguedad = antiguedad;
        this.fecha = fecha;
        this.monto = monto;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCUIL() {
        return CUIL;
    }
    public void setCUIL(String cUIL) {
        CUIL = cUIL;
    }
    public int getAntiguedad() {
        return antiguedad;
    }
    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }    
}
