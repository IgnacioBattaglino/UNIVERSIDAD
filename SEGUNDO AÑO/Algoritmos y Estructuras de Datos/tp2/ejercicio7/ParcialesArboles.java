package tp2.ejercicio7;
import tp2.ejercicio1.BinaryTree;
import java.util.concurrent.atomic.*;
public class ParcialesArboles {
	private BinaryTree<Integer> arbol;
	
	
	public boolean isLeftTree (int num) {
		AtomicInteger sumI = new AtomicInteger(-1);
        AtomicInteger sumD = new AtomicInteger(-1);
		BinaryTree<Integer> ab= encontrarNodo(this.arbol,num);
		if (ab != null) {
			if (ab.hasLeftChild()) {
				sumI.set(0);
				recursiveMethod (ab.getLeftChild(),sumI);
			}
			System.out.println(sumI);
			if (ab.hasRightChild()) {
				sumD.set(0);
				recursiveMethod (ab.getRightChild(),sumD);
			}
			System.out.println(sumD);
			return (sumI.get()>sumD.get());
		}
		else return false;
	}
	
	public ParcialesArboles (BinaryTree<Integer> unArbol){
		this.arbol= unArbol;
	}
	
	private BinaryTree<Integer> encontrarNodo (BinaryTree<Integer> ab, int num) {
		if (ab.getData().equals(num)) { 
			System.out.println("encontrado");
			return ab;
		}
		else 
		{	BinaryTree<Integer> aux=null;
			if (aux==null && ab.hasLeftChild()) aux= encontrarNodo(ab.getLeftChild(),num);
			if (aux==null && ab.hasRightChild()) aux= encontrarNodo(ab.getRightChild(),num);
			return aux;
		}
	}
	
	private void recursiveMethod (BinaryTree<Integer> ab,AtomicInteger suma) {
		if (ab.hasLeftChild() && !ab.hasRightChild() || ab.hasRightChild()& !ab.hasLeftChild()) suma.incrementAndGet();	
		if (ab.hasLeftChild()) recursiveMethod (ab.getLeftChild(),suma);
		if (ab.hasRightChild()) recursiveMethod (ab.getRightChild(),suma);
		}

	
	public static void main (String [] args) {
		System.out.println ("Test clase transformacion");
		BinaryTree<Integer> ab= new BinaryTree<Integer>(2);
		ab.addLeftChild(new BinaryTree<Integer>(7));
		ab.addRightChild(new BinaryTree<Integer>(-5));
		ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(23));
		ab.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
		ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(-3));
		ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(55));
		ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(11));
		ab.getRightChild().addLeftChild(new BinaryTree<Integer>(19));
		ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
		ab.getRightChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(18));
		ab.entreNiveles(0,4);
		ParcialesArboles parcial= new ParcialesArboles(ab);
		System.out.println(parcial.isLeftTree(-5));
}
}
