package tp1.ej5;

public class Dato {
	public int min;
	public int max;
	public double prom;
	
	
	
	public Dato(int min, int max, double prom) {
		this.min = min;
		this.max = max;
		this.prom = prom;
	}
	
	public Dato() {
	}
	
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public double getProm() {
		return prom;
	}
	public void setProm(double prom) {
		this.prom = prom;
	}
	
	@Override
	public String toString() {
		String aux= "max: " + this.max + " min: " + this.min + " prom: " + this.prom;
		return aux;
	}
	
}
