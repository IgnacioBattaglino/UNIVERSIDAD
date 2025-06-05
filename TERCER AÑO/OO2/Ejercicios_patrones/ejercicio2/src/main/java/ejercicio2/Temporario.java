package ejercicio2;

public class Temporario extends Empleado{
    private int horasTrabajadas;
    private boolean estaCasado;
    private int canthijos;

    public Temporario(int horasTrabajadas, boolean estaCasado, int canthijos) {
        this.horasTrabajadas = horasTrabajadas;
        this.estaCasado = estaCasado;
        this.canthijos = canthijos;
    }

    @Override
    protected double basico() {
        return 20000 + this.horasTrabajadas*300;
    }

    @Override
    protected double adicionales() {
        double aux = 0;
        if (this.estaCasado) aux+=5000;
        aux+= this.canthijos*2000;
        return aux;
    }

}
