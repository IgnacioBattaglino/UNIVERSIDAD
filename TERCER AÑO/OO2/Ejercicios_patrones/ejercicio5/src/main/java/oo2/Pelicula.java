package oo2;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
    private int añoEstreno;
    private String titulo;
    private double puntaje;
    private List<Pelicula> similares;
    
    public Pelicula(int añoEstreno, String titulo, double puntaje) {
        this.añoEstreno = añoEstreno;
        this.titulo = titulo;
        this.puntaje = puntaje;
        this.similares = new ArrayList<>();
    }
    
    public void agregarSimilar(Pelicula pelicula) {
        if (!this.similares.contains(pelicula)) {
            this.similares.add(pelicula);
            pelicula.similares.add(this);
        }
    }
    
    public boolean eliminarSimilar(Pelicula pelicula) {
        boolean eliminado = this.similares.remove(pelicula);
        if (eliminado) {
            pelicula.similares.remove(this);
        }
        return eliminado;
    }

    public int getAñoEstreno() {
        return añoEstreno;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPuntaje() {
        return puntaje;
    }

    public List<Pelicula> getSimilares() {
        return similares;
    }

    
}
