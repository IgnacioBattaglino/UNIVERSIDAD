package oo2;

public class Tierra implements Topografia{

    @Override
    public double calcularProporcionAgua() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Tierra) return true;
        return false;
    }

}
