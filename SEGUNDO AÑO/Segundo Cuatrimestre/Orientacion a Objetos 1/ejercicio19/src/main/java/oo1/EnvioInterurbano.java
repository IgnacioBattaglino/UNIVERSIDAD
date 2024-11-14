package oo1;

import java.time.LocalDate;

public class EnvioInterurbano extends Envio{
    private double distancia;
    
    public EnvioInterurbano (LocalDate fecha, String direccionOrigen, String direccionDestino, int peso, double distancia){
        super(fecha, direccionOrigen, direccionDestino, peso);
        this.distancia=distancia;
    }
    
    @Override
    public double getPrecio() {
        if (distancia<100) 
            return 20 * this.getPeso();
        if (distancia<=500)
            return 25 * this.getPeso();
        return 30 * this.getPeso(); 
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
}
