package oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mascota {
    private String nombre;
    private LocalDate fechaNacimiento;
    private String especie;
    private List<Servicio> serviciosUsados;

    public Mascota(String nombre, LocalDate fechaNacimiento, String especie) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.especie = especie;
        this.serviciosUsados = new ArrayList<>();
    }
    public double recaudacionEnFecha ( LocalDate fecha ){
        return serviciosUsados.stream()
        .filter(servicio -> servicio.getFecha().equals(fecha))
        .mapToDouble(servicio -> servicio.calcularCosto())
        .sum();
    }
    public boolean tiene5OMasServicios () {
        return serviciosUsados.size()>=5;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    protected List<Servicio> getServiciosUsados() {
        return serviciosUsados;
    }
    
}
