package tp1.ej5;

public class Ej5Main {
	public static void main(String[] args) {
	int [] arreglo = new int[10];
	arreglo [0]= 10;
	arreglo [1]= 10;
	arreglo [2]= 10;
	arreglo [3]= 10;
	arreglo [4]= 10;
	arreglo [5]= 10;
	arreglo [6]= 10;
	arreglo [7]= 10;
	arreglo [8]= 0;
	arreglo [9]= 0;
	
	Dato dato= new Dato();
	
	Clase.calcularValores2(arreglo, dato);
	System.out.println (dato.toString());
	
}
}
