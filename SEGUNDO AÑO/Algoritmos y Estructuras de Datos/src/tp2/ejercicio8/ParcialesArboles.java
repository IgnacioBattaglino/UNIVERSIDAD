package tp2.ejercicio8;
import tp2.ejercicio1.BinaryTree;
public class ParcialesArboles {

	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		if (arbol1.isEmpty() || arbol2.isEmpty())
			return (arbol1.isEmpty() && arbol2.isEmpty());
		else 
			return esPrefijoRecursive (arbol1,arbol2);
	}
	
	private boolean esPrefijoRecursive (BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
		if (!arbol1.getData().equals(arbol2.getData())) return false;
		else { 
			boolean aux=true;
			if (arbol1.hasLeftChild()) {
				if (arbol2.hasLeftChild()) aux= this.esPrefijoRecursive(arbol1.getLeftChild(), arbol2.getLeftChild());
				else aux=false;
			}
			if (aux && arbol1.hasRightChild()) 
				if (arbol2.hasRightChild()) aux= this.esPrefijoRecursive(arbol1.getRightChild(), arbol2.getRightChild());
				else aux=false;
			return aux;
		}
	}
	
	
	public static void main (String [] args) {
		System.out.println ("Test");
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

		
		BinaryTree<Integer> ab2= new BinaryTree<Integer>(2);
		ab2.addLeftChild(new BinaryTree<Integer>(7));
		ab2.addRightChild(new BinaryTree<Integer>(-5));
		ab2.getLeftChild().addLeftChild(new BinaryTree<Integer>(23));
		ab2.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
		ab2.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(-3));
		ab2.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(55));

	
		ParcialesArboles parcial = new ParcialesArboles();
		System.out.println(parcial.esPrefijo(ab2, ab));
		
}
}
