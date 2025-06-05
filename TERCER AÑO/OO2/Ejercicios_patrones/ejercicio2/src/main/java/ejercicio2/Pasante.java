package ejercicio2;

public class Pasante extends Empleado {
    private int examenesRendidos;

    public Pasante(int examenesRendidos) {
        this.examenesRendidos = examenesRendidos;
    }

    @Override
    protected double basico() {
        return 20000;
    }

    @Override
    protected double adicionales() {
        return this.examenesRendidos * 2000;
    }

}
