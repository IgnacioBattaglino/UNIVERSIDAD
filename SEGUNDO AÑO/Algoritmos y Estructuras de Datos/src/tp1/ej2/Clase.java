package tp1.ej2;

public class Clase {
	private static int[] arreglo;
	private static int num;
	
	public static void metodo (int n) {
		num=n;
		arreglo = new int[n];
		for (int i=0; i<n; i++) {
			arreglo [i]= n*(i+1);
		}
	}

	public static void imprimir () {
		for (int i=0; i<num;i++) {
			System.out.print (arreglo[i]);
			System.out.print (" , ");
		}
	}
	
}
