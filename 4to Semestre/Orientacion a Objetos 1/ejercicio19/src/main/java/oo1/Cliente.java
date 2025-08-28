package oo1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
    private String nombre;
    private String direccion;
    private List<Envio> envios;

    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.envios = new ArrayList<>();
    }

    public double precioEnviosPeriodo (LocalDate from, LocalDate to){
        return envios.stream()
        .filter (envio -> envio.envioEntreFechas(from, to))
        .mapToDouble(envio -> envio.getPrecio())
        .sum();
    }

    public void agregarEnvio (Envio envio) {
        this.envios.add(envio);
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

    public List<Envio> getEnvios() {
        return envios;
    }

    public void setEnvios(List<Envio> envios) {
        this.envios = envios;
    }
}
