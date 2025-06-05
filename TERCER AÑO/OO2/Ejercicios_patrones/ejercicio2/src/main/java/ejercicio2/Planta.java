package ejercicio2;

public class Planta extends Empleado {
    private boolean estaCasado;
    private int canthijos;
    private int añosAntiguedad;


    public Planta(boolean estaCasado, int canthijos, int añosAntiguedad) {
        this.estaCasado = estaCasado;
        this.canthijos = canthijos;
        this.añosAntiguedad = añosAntiguedad;
    }

    @Override
    protected double basico() {
        return 50000;
    }

    @Override
    protected double adicionales() {
        return 2000 * this.canthijos + 2000 * this.añosAntiguedad + (this.estaCasado? 5000 : 0);
    }

}
