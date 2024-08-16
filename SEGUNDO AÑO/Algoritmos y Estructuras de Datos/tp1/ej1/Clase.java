package tp1.ej1;

public class Clase {
	public static void metodoa (int a, int b){
		System.out.println ("Metodo A");
		if (a<b) {
			for (int i=a; i<=b; i++) {
				System.out.println (i);
			}
		}
		else {
			for (int i=b; i<=a; i++) {
				System.out.println (i);
			}
		}	
	}
	
	
	public static void metodob (int a, int b){
		System.out.println ("Metodo B");
		if (a<b) {
			while (a<=b) {
				System.out.println(a);
				a++;
			}
		}
		else {
			while (b<=a) {
				System.out.println(b);
				b++;
			}
		}
			
	
	}

	
	public static void metodoc (int a, int b) {
		System.out.println ("Metodo C");
		if (a<b) {
			recursivo (a,b);
		}
		else { recursivo (b,a); }
		
	}

	private static void recursivo (int a, int b) {
		if (a<=b) {
			System.out.println (a);
			a++;
			recursivo (a,b);
		}	
	}
	
	
	
}