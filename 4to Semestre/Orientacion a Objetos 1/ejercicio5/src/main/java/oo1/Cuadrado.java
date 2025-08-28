package oo1;

public class Cuadrado implements Figura2D{
    private double lado;

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    } 

    @Override
    public double getPerimetro (){
        return lado * 4;
    }

    @Override
    public double getArea () {
        return Math.pow(lado, 2);
    }
}
