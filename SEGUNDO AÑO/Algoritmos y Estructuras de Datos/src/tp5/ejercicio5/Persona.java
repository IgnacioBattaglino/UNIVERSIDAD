package tp5.ejercicio5;

public class Persona {
	public String type= "empleado";
	public String name;
	public String domicilio;
	
	public Persona(String name, String domicilio) {
		super();
		this.name = name;
		this.domicilio = domicilio;
	}
	
	public Persona(String type, String name, String domicilio) {
		super();
		this.type = type;
		this.name = name;
		this.domicilio = domicilio;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	@Override
	public String toString() {
		return "Persona [type=" + type + ", name=" + name + "]";
	}
	
	
	
	
}
