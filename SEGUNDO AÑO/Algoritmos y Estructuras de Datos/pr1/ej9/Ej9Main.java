package tp1.ej9;

import java.util.*;

public class Ej9Main {
	
	private static boolean estaBalanceado (String cad) {
		List<Character> cierre = new LinkedList<Character>();
        cierre.add(')');
        cierre.add(']');
        cierre.add('}');
		boolean aux=true;
		if ((cad.length()%2 != 0) || (cad.length()>0 & cierre.contains(cad.charAt(0))))
			aux=false;
		else{
			List<Character> apertura = new LinkedList <Character> ();
			apertura.add('(');
			apertura.add('[');
			apertura.add('{');
			Character actual;
			
			Stack<Character> pila= new Stack<Character>();
			
			for (int i=0; i<cad.length(); i++) {
				actual= cad.charAt(i);
				pila.push(actual);
				
			}
			
			
		}
		return aux;
	}
	
	public static void main(String[] args) {
		System.out.println ("Ingrese una cadena con '(,),[,],{,}");
		Scanner lectura = new Scanner(System.in);
		String S = lectura.nextLine();
		lectura.close();
		
		if (estaBalanceado(S)) 
			System.out.println ("La cadena esta balanceada.");
		else 
			System.out.println ("La cadena no esta balanceada.");
	}
}