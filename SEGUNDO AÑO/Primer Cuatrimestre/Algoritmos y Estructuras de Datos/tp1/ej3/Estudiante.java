package tp1.ej3;

public class Estudiante {
	public String nombre;
	public String apellido;
	public int comision;
	public String email;
	public String direccion;
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getComision() {
		return comision;
	}
	public void setComision(int comision) {
		this.comision = comision;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	public String tusDatos() {
		String datos= "nombre: " + this.getApellido() + " " + this.getNombre() + "\n comision:" + this.getComision() + "\n direccion: " + this.getDireccion()
		+ "\n email: " + this.getEmail();
		
		return datos;
	}
	
	
}
