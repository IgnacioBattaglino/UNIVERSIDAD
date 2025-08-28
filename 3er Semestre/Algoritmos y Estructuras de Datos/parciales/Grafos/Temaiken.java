package parcial.Grafos;

import java.util.Objects;

public class Temaiken {
    public String name;
    public int tiempo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public Temaiken(String name, int tiempo) {
        super();
        this.name = name;
        this.tiempo = tiempo;
    }

    public Temaiken(String name) {
        super();
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Temaiken temaiken = (Temaiken) o;
        return tiempo == temaiken.tiempo && Objects.equals(name, temaiken.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, tiempo);
    }
}
