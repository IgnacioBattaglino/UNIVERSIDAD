package oo1;

import java.util.List;

public class ReporteDeConstruccion {
    private List<Pieza> piezas;
    

    public double volumenDeMaterial (String material ){
        double volumen=0;
        for (Pieza pieza : piezas) {
            if (pieza.getMaterial().equals(material)) volumen += pieza.getVolumen();
        }
        return volumen;
    }

    public double superficieDeColor (String color) {
        double superficie=0;
        for (Pieza pieza : piezas) {
            if (pieza.getColor().equals(color)) superficie += pieza.getSuperficie();
        }
        return superficie;
    }
}
