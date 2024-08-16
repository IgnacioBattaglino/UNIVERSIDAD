package tp1.ej8;

public class CircularQueue<T> extends Queue<T> {
	public T shift () {
		T aux= super.dequeue();
		super.enqueue(aux);
		return aux;
	}
}