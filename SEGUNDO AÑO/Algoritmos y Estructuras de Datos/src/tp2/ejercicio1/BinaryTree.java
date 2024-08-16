package tp2.ejercicio1;
import java.util.*;


public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	@Override
	public String toString() {
		return this.getData().toString();
	}

	public  int contarHojas() {
		int hojasIzq=0;
		int hojasDer=0;
		if (this.isEmpty()) return 0;
		else if (this.isLeaf()) return 1;
		else 
			if (this.hasLeftChild()) {
				hojasIzq= this.getLeftChild().contarHojas();}
			if (this.hasRightChild()) {
				hojasDer= this.getRightChild().contarHojas();}
		return hojasIzq+hojasDer;
	}
		
		
    	 
    public BinaryTree<T> espejo(){
    	BinaryTree<T> aux = new BinaryTree<T>(this.getData());
    	if (this.hasLeftChild()) aux.addRightChild(this.getLeftChild().espejo());
    	if (this.hasRightChild()) aux.addLeftChild(this.getRightChild().espejo());
		       		  
 	   return aux;
    }

	// 0<=n<=m
	public void entreNiveles(int n, int m){
		if (this.isEmpty() || n<0 || m<n ) return;
		Queue<BinaryTree<T>> cola = new LinkedList<BinaryTree<T>>();
		cola.add(this);
		int nivelActual=0;
		while (!cola.isEmpty()) {
			int nodosdelnivel=cola.size();
			for (int i= 0; i<nodosdelnivel; i++) {
				BinaryTree<T> nodo= cola.remove();
				if (nivelActual>=n & nivelActual<=m)
					{System.out.println(nodo.getData());}
				if (nodo.hasLeftChild()) cola.add(nodo.getLeftChild());
				if (nodo.hasRightChild()) cola.add(nodo.getRightChild());
				}
			nivelActual++;
			System.out.println("");
		}
		}
		
		public void imprimirArbol() {
	        if(this.hasLeftChild()) this.getLeftChild().imprimirArbol();
	        System.out.print(this.getData() + " ");
	        if(this.hasRightChild()) this.getRightChild().imprimirArbol();
	    }
	
	public static void main (String[] args) {
        System.out.println("Test metodos Arboles");
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        
        System.out.println(ab.contarHojas());
        System.out.println("Arbol original: ");
        ab.imprimirArbol();
        System.out.println("");
        System.out.println("Arbol espejo: ");
        BinaryTree<Integer> abEspejo = ab.espejo();
        abEspejo.imprimirArbol();
        System.out.println("");
        System.out.println("Impresion Arbol por niveles 1 y 2");
        ab.entreNiveles(0, 2);
    }
    
}

