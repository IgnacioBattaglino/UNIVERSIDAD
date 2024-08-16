package parcial;

public class Tuple {
	int cant;
	boolean popular;
	
	public Tuple(int cant, boolean popular) {
		super();
		this.cant = cant;
		this.popular = popular;
	}
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}
	public boolean isPopular() {
		return popular;
	}
	public void setPopular(boolean popular) {
		this.popular = popular;
	}
	@Override
	public String toString() {
		return "Tuple [cant=" + cant + ", popular=" + popular + "]";
	}
	
	
	
}
