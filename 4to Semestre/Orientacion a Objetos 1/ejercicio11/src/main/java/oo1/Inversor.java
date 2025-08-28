package oo1;
import java.util.*;


public class Inversor {
    private String nombre;
    private List<Inversion> inversiones;

    public Inversor(String unNombre){
        this.nombre=unNombre;
        this.inversiones= new ArrayList<>();
    }

    public double valorActual (){
        double valor=0;
        for (Inversion inv : inversiones) {
            valor+= inv.valorActual();
        }
        return valor;
    }

    public void agregarInversion (Inversion unaInversion){
        inversiones.add(unaInversion);
    }

    public void eliminarInversion (Inversion unaInversion){
        if (inversiones != null) inversiones.remove(unaInversion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Inversion> getInversiones() {
        return inversiones;
    }
}
