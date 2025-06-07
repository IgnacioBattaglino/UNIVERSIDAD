package oo2;

import java.util.ArrayList;
import java.util.List;

public class Decodificador {
    private ArrayList<Pelicula> grillaPeliculas;
    private ArrayList<Pelicula> peliculasVistas;
    private Strategy strategy;

    public Decodificador() {
        this.grillaPeliculas = new ArrayList<>();
        this.peliculasVistas = new ArrayList<>();
    }
    
    public void agregarPeliculaGrilla(Pelicula pelicula) {
        this.grillaPeliculas.add(pelicula);
    }
    
    public void agregarPeliculaVista(Pelicula pelicula) {
        this.peliculasVistas.add(pelicula);
    }
    
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<Pelicula> recomendarPeliculas() {
        return this.strategy.recomendarPeliculas(this);
    }

    public ArrayList<Pelicula> getGrillaPeliculas() {
        return grillaPeliculas;
    }

    public ArrayList<Pelicula> getPeliculasVistas() {
        return peliculasVistas;
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public boolean yaLaVi (Pelicula peli) {
        if (this.peliculasVistas.contains(peli)) return true;
        return false;
    }
    
}
