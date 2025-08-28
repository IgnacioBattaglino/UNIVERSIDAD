package oo1;
public class Cilindro extends Pieza {
    private int radio;
    private int altura;
    
    public Cilindro(String material, String color, int radio, int altura) {
        super(material, color);
        this.radio = radio;
        this.altura = altura;
    }

    public int getRadio() {
        return radio;
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    @Override
    public double getSuperficie() {
        return 2*Math.PI*this.radio*this.altura+2*Math.PI* Math.pow(this.radio,2);
    }   

    @Override
    public double getVolumen() {
        return Math.PI* Math.pow(this.radio,2)*this.altura;
    }
    
}
