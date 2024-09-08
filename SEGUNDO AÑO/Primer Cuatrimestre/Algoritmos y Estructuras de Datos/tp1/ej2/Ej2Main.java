package tp1.ej2;
import java.util.Scanner;

public class Ej2Main {
	public static void main (String[]args) {
	
	System.out.println ("Ingrese numeros, termine con -1");
	@SuppressWarnings("resource")
	Scanner s= new Scanner (System.in);
	while (true) { 
		int input= s.nextInt();
		if (input==-1) { break; }
		Clase.metodo (input);
		Clase.imprimir();
	}
	
}
}

