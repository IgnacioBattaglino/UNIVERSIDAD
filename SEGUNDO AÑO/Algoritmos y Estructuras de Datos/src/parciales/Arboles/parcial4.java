package parcial.Arboles;
import tp2.ejercicio1.*;

public class parcial4 {
	
	public parcial4 () {
		
	}

	public boolean esPrefijo (BinaryTree<Integer>arbol1, BinaryTree<Integer> arbol2) {
		if (arbol1 == null) return true;
		if (arbol2 == null) return false;
		
		if (arbol1.getData().equals(arbol2.getData())) {
			if (arbol1.isLeaf()) return true;
			else if (arbol1.hasLeftChild() && arbol2.hasLeftChild() && arbol1.hasRightChild() && arbol2.hasRightChild()) 
				return (esPrefijo(arbol1.getLeftChild(),arbol2.getLeftChild()) && esPrefijo(arbol1.getRightChild(),arbol2.getRightChild()));
			else if (arbol1.hasLeftChild() && arbol2.hasLeftChild())
				return esPrefijo(arbol1.getLeftChild(),arbol2.getLeftChild());
			else if (arbol1.hasRightChild() && arbol2.hasRightChild()) 
				return esPrefijo(arbol1.getRightChild(),arbol2.getRightChild());
		}
		return false;
	}
	
	public static void main (String [] args) {
		System.out.println ("Test");
		BinaryTree<Integer> ab= new BinaryTree<Integer>(65);
		ab.addLeftChild(new BinaryTree<Integer>(37));
		ab.addRightChild(new BinaryTree<Integer>(81));
		ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(22));
		ab.getLeftChild().addRightChild(new BinaryTree<Integer>(47));
		ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(11));
		ab.getLeftChild().getLeftChild().addRightChild(new BinaryTree<Integer>(29));
		ab.getRightChild().addLeftChild(new BinaryTree<Integer>(76));
		ab.getRightChild().addRightChild(new BinaryTree<Integer>(93));
		ab.getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(85));
		ab.getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(94));

		
		BinaryTree<Integer> ab2= new BinaryTree<Integer>(65);
		ab2.addLeftChild(new BinaryTree<Integer>(37));
		ab2.addRightChild(new BinaryTree<Integer>(81));
		ab2.getLeftChild().addRightChild(new BinaryTree<Integer>(47));
		ab2.getRightChild().addRightChild(new BinaryTree<Integer>(93));
		
	
		parcial4 parcial = new parcial4();
		System.out.println(parcial.esPrefijo(ab2, ab));
		
}
}
