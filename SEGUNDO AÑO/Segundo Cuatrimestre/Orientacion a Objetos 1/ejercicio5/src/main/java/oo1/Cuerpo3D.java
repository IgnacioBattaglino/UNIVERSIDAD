package oo1;
public class Cuerpo3D {
    private double altura;
    private Figura2D caraBasal;

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setCaraBasal(Figura2D caraBasal) {
        this.caraBasal = caraBasal;
    }

    public double getVolumen (){
        return caraBasal.getArea() * this.getAltura();
    }
    
    public double getSuperficieExterior (){
        return 2* caraBasal.getArea() + caraBasal.getPerimetro() *altura;
    }
    
}
