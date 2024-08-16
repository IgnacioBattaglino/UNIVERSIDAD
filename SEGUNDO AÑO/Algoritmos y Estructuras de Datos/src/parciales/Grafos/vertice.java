package parcial.Grafos;

public class vertice {
    private String nombre;
    private boolean controlado;

    public vertice(String nombre, boolean controlado) {
        this.nombre = nombre;
        this.controlado = controlado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isControlado() {
        return controlado;
    }

    public void setControlado(boolean controlado) {
        this.controlado = controlado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        vertice vertice = (vertice) o;

        return nombre.equals(vertice.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}
