package oo1;

public class Usuario {
    private String nombre;
    private String domicilio;
    private double consumoActiva;
    private double consumoReactiva;

    public Usuario(String nombre, String domicilio) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.consumoActiva=0;
        this.consumoReactiva=0;
    }

    public double getFPE() {
        return this.consumoActiva / (Math.sqrt(Math.pow(consumoActiva,2) + Math.pow(consumoReactiva, 2)));
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public double getConsumoActiva() {
        return consumoActiva;
    }
    public void setConsumoActiva(double consumoActiva) {
        this.consumoActiva = consumoActiva;
    }
    public double getConsumoReactiva() {
        return consumoReactiva;
    }
    public void setConsumoReactiva(double consumoReactiva) {
        this.consumoReactiva = consumoReactiva;
    }
    
    
}
