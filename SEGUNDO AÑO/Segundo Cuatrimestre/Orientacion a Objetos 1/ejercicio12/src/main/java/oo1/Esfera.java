package oo1;

public class Esfera extends Pieza {
    private int radio;

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public Esfera(String material, String color, int radio) {
        super(material, color);
        this.radio = radio;
    }

    @Override
    public double getSuperficie() {
        return 4*Math.PI*Math.pow(this.radio,2);
    }

    @Override
    public double getVolumen() {
        return (4.0/3.0)*Math.PI*Math.pow(this.radio, 3);
    }
    
}
