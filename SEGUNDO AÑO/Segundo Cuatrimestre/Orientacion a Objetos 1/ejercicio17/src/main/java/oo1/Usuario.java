package oo1;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Usuario {
    private String nombre;
    private String direccion;
    private String DNI;
    private Set<Propiedad> propiedades;

    public Usuario(String nombre, String direccion, String dNI) {
        this.nombre = nombre;
        this.direccion = direccion;
        DNI = dNI;
        propiedades = new HashSet<>();
    }

    public boolean reservar (Propiedad propiedad, LocalDate from, LocalDate to){
        if (propiedad.isAvailable(from, to)) {
            propiedad.reservar(new DateLapse(from, to));
            return true;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getDNI() {
        return DNI;
    }
    public void setDNI(String dNI) {
        DNI = dNI;
    }
    public Set<Propiedad> getPropiedades() {
        return propiedades;
    }
    public void setPropiedades(Set<Propiedad> propiedades) {
        this.propiedades = propiedades;
    }


    
}
