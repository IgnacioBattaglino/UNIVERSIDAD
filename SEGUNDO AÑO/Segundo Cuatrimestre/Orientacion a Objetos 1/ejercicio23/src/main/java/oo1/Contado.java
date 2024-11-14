package oo1;

public class Contado implements FormaPago{

    @Override
    public double getPorcentajeExtra() {
        return 1;
    }

}
