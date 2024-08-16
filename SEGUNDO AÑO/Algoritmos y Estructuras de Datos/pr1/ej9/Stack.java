package tp1.ej9;

import java.util.LinkedList;

public class Stack<T> {
	LinkedList <T> fila = new LinkedList <T> ();
	
	public void Stack() {
	}
	
	public void push (T dato) {
		fila.addLast(dato);
	}
	
	public T pull (T dato) {
		T aux=fila.pollLast();
		return aux;
	}
	public boolean isEmpty () {
		boolean aux= fila.isEmpty();
		return aux;
	}
}