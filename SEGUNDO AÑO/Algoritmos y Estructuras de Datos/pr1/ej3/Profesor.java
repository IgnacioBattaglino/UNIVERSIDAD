package tp1.ej3;

public class Profesor {
	public String nombre;
	public String apellido;
	public String catedra;
	public String email;
	public String facultad;
	
	
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
	public String getCatedra() {
		return catedra;
	}
	public void setCatedra(String catedra) {
		this.catedra = catedra;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFacultad() {
		return facultad;
	}
	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}
	
	public String tusDatos() {
		String datos= "nombre: " + this.getApellido() + " " + this.getNombre() + "\n facultad:" + this.getFacultad() + "\n catedra: " + this.getCatedra()
		+ "\n email: " + this.getEmail();
		
		return datos;
	}
	
	
	
}
