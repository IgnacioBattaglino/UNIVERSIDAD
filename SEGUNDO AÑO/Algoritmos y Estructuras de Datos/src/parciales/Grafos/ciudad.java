package parcial.Grafos;

public class ciudad {
	public String nombre;
	public int dias;
	public ciudad(String nombre, int dias) {
		super();
		this.nombre = nombre;
		this.dias = dias;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDias() {
		return dias;
	}
	public void setDias(int dias) {
		this.dias = dias;
	}
	@Override
	public String toString() {
		return "ciudad [nombre=" + nombre + ", dias=" + dias + "]";
	}
	
	
}
