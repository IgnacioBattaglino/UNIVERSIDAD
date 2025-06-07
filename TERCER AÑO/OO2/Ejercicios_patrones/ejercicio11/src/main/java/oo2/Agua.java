package oo2;

public class Agua implements Topografia {

    @Override
    public double calcularProporcionAgua() {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Agua) return true;
        return false;
    }


}
