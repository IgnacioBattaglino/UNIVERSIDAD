package oo2;

import java.util.ArrayList;
import java.util.List;

public class TopografiaMixta implements Topografia{
    private List<Topografia> hijos;

    // Constructor por defecto
    public TopografiaMixta() {
        this.hijos = new ArrayList<>();
    }

    // Constructor que recibe una lista de topografías
    public TopografiaMixta(List<Topografia> hijos) {
        this.hijos = new ArrayList<>(hijos);
    }

    // Método para agregar un hijo
    public void addHijo(Topografia hijo) {
        this.hijos.add(hijo);
    }

    // Método para remover un hijo
    public void removeHijo(Topografia hijo) {
        this.hijos.remove(hijo);
    }

    // Método para obtener los hijos (útil para testing)
    public List<Topografia> getHijos() {
        return new ArrayList<>(this.hijos);
    }

    @Override
    public double calcularProporcionAgua() {
        // Validación: una topografía mixta debe tener exactamente 4 hijos
        if (this.hijos.size() != 4) {
            throw new IllegalStateException("Una topografía mixta debe tener exactamente 4 hijos");
        }
        
        return this.hijos.stream()
            .mapToDouble(Topografia::calcularProporcionAgua)
            .sum() / 4.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TopografiaMixta)) return false;
        
        TopografiaMixta other = (TopografiaMixta) o;
        return this.hijos.equals(other.hijos);
    }
}
