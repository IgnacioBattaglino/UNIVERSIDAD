package tp1.ej8;

import java.util.LinkedList;

public class Queue<T> {
	LinkedList <T> data= new LinkedList();
	
	public void Queue() {
	}

	public void enqueue (T dat) {
		data.add(dat);
	}
	
	public T dequeue () {
		T aux=data.poll();
		return aux;
	}
	public T head() {
		T aux=data.getFirst();
		return aux;
	}
	public boolean isEmpty () {
		boolean aux= data.isEmpty();
		return aux;
	}
	
	public int size() {
		int aux= data.size();
		return aux;
	}
	
	public String toString (){
		String aux= data.toString();
		return aux;
	}
}