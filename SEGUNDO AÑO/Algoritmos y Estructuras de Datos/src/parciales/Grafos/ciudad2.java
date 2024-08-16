package parcial.Grafos;

public class ciudad2 {
	public String nombre;
	public int fase;
	public ciudad2(String nombre, int fase) {
		super();
		this.nombre = nombre;
		this.fase = fase;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getFase() {
		return fase;
	}
	public void setFase(int dias) {
		this.fase = dias;
	}
	@Override
	public String toString() {
		return nombre;
	}
	
	
}
