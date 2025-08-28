package oo1;

public class Circulo implements Figura2D {
    private double radio;
    

    public Circulo() {
        this.radio=0;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
        
    }

    public double getDiametro() {
        return radio * 2;
    }

    public void setDiametro(double diametro) {
        this.radio = diametro / 2;
    }
    
    @Override
    public double getArea (){
        return Math.PI * Math.pow(radio, 2);
    }
    
    @Override
    public double getPerimetro () {
        return Math.PI * this.getDiametro();
    }
}
