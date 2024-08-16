package tp2.ejercicio6;
import tp2.ejercicio1.BinaryTree;

public class Transformacion {
	private BinaryTree<Integer> arbol;
	
	public BinaryTree<Integer> suma () {
		arbolRecursivo (this.arbol);
		return this.arbol;
	}
	
	public Transformacion(BinaryTree<Integer> unArbol) {
        arbol = unArbol;
	}
	
	private int arbolRecursivo (BinaryTree<Integer> ab) {
		int suma;
		suma=0;
		if (ab.isLeaf()) {
			suma= ab.getData();
			ab.setData(0);
			return suma; 
		}
		else {
			if (ab.hasLeftChild()) {
				suma+= arbolRecursivo(ab.getLeftChild());
			}
			if (ab.hasRightChild()) {
				suma+= arbolRecursivo(ab.getRightChild());
			}
		}
		int aux=ab.getData();
		ab.setData(suma);
		return aux + suma;
	}
	
	public static void main (String [] args) {
		System.out.println ("Test clase transformacion");
		BinaryTree<Integer> ab= new BinaryTree<Integer>(1);
		ab.addLeftChild(new BinaryTree<Integer>(2));
		ab.addRightChild(new BinaryTree<Integer>(3));
		ab.getLeftChild().addRightChild(new BinaryTree<Integer>(4));
		ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
		ab.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
		ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(8));
		ab.getRightChild().addRightChild(new BinaryTree<Integer>(6));
		ab.entreNiveles(0,3);
		Transformacion trans= new Transformacion(ab);
		trans.arbolRecursivo(ab);
		ab.entreNiveles(0,3);
		
	}
	
}
