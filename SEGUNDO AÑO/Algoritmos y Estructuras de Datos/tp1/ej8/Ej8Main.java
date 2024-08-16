package tp1.ej8;

public class Ej8Main {
	public static void main(String[] args) {
		Queue cola =new Queue ();
		cola.enqueue(1);
		cola.enqueue(2);
		cola.enqueue(3);
		cola.enqueue(4);
		
		System.out.println (cola.toString());
		
		System.out.println (cola.size());
		
		System.out.println(cola.isEmpty());
		
		System.out.println(cola.dequeue());
		System.out.println(cola.dequeue());
		
		System.out.println (cola.head());
		
		System.out.println(cola.dequeue());
		System.out.println(cola.dequeue());
		
		System.out.println(cola.isEmpty());
		
		
		
	}
}