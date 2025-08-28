package oo1;

import java.time.LocalDate;

public class PersonaFisica extends Cliente{
    private String DNI;

    public PersonaFisica(String nombre, String direccion, String dNI) {
        super(nombre, direccion);
        DNI = dNI;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    @Override
    public double precioEnviosPeriodo(LocalDate from, LocalDate to) {
        return super.precioEnviosPeriodo(from, to) * 0.9;
    }
        
}
