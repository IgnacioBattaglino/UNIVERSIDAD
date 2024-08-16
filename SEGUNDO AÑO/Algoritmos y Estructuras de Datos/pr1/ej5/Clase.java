package tp1.ej5;

public class Clase {
	public static Dato calcularValores1 (int[] arreglo) {
		int max=-1;
		int min= 1000000000;
		int sum= 0;
		int cant=0;
		for (int i:arreglo) {
			if (i>max) { max=i;}
			if (i<min) { min=i;}
			sum+= i;
			cant++;
		}
		
		double prom= sum/cant; 
		Dato dato= new Dato(min,max,prom);	
		return dato;	
	}
	
	public static void calcularValores2 (int[] arreglo, Dato dato) {
		int max=-1;
		int min= 1000000000;
		int sum= 0;
		int cant=0;
		for (int i: arreglo) {
			if (i>max) { max=i;}
			if (i<min) { min=i;}
			sum+= i;
			cant++;
		}
		double prom= sum/cant; 
		dato.setMax(max);
		dato.setMin(min);
		dato.setProm(prom);
	}

}