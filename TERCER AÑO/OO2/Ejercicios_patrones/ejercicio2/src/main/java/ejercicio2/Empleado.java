package ejercicio2;

public abstract class Empleado {
    public double getSueldo (){
        return (basico() + adicionales()) - descuento();
    }

    protected abstract double basico();
    protected abstract double adicionales();
    private double descuento() {
        return 0.13 * this.basico() + 0.05 * this.adicionales();
    }
}
