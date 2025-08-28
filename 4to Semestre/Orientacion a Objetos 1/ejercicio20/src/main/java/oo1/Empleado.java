package oo1;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Empleado {
    private String nombre;
    private String apellido;
    private String CUIL;
    private LocalDate fechaNacimiento;
    private boolean tieneHijos;
    private boolean tieneConyuge;
    private List<Contrato> contratos;
    
    public Empleado(String nombre, String apellido, String cUIL, LocalDate fechaNacimiento, boolean tieneHijos,
            boolean tieneConyuge) {
        this.nombre = nombre;
        this.apellido = apellido;
        CUIL = cUIL;
        this.fechaNacimiento = fechaNacimiento;
        this.tieneHijos = tieneHijos;
        this.tieneConyuge = tieneConyuge;
        this.contratos = new LinkedList<>();
    }

    public Contrato getContratoActivo () {
        return this.contratos.stream()
        .filter(contrato -> contrato.esActivo())
        .findFirst().orElse(null);
    } 
    
    public ReciboDeSueldo generarReciboDeSueldo () {
        if (this.getContratoActivo()==null) return null;

        double monto = this.getContratoActivo().calcularMontoACobrar(this);
        monto = monto * this.calcularAdicionalAntiguedad();

        return new ReciboDeSueldo(this.nombre, this.apellido, this.CUIL, 
        this.calcularAntiguedad(), LocalDate.now(), monto);
    }

    private double calcularAdicionalAntiguedad () {
        if (this.calcularAntiguedad()<5) 
            return 1.0;
        if (this.calcularAntiguedad()<10)
            return 1.3;
        if (this.calcularAntiguedad()<15)
            return 1.5;
        if (this.calcularAntiguedad()<20)
            return 1.7;
        return 2.0;
    } 

    public int calcularAntiguedad(){
        return this.contratos.stream()
        .mapToInt(contrato -> contrato.getDuracion())
        .sum() / 365;
    }

    public void agregarContrato (Contrato contrato){
        this.contratos.add(contrato);
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
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public boolean isTieneHijos() {
        return tieneHijos;
    }
    public void setTieneHijos(boolean tieneHijos) {
        this.tieneHijos = tieneHijos;
    }
    public boolean isTieneConyuge() {
        return tieneConyuge;
    }
    public void setTieneConyuge(boolean tieneConyuge) {
        this.tieneConyuge = tieneConyuge;
    }
}
