package oo1;

import java.time.LocalDate;

public class Guarderia extends Servicio{
    private int cantDias;

    public Guarderia (Mascota mascota, LocalDate fecha, int cantDias){
        super (fecha,mascota);
        this.cantDias=cantDias;
    }

    @Override
    public double calcularCosto(){
        double costoBase= 500*this.cantDias;
        return super.getMascota().tiene5oMasServicios() ? costoBase * 0.9 : costoBase;
    }

}
