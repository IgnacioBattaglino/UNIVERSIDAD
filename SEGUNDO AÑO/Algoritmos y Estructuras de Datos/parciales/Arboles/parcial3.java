package parcial.Arboles;
import tp2.ejercicio1.*;

public class parcial3 {
	private BinaryTree<Integer> ab;


	public parcial3(BinaryTree<Integer> ab) {
		super();
		this.ab = ab;
	}

	public BinaryTree<Integer> getAb() {
		return ab;
	}

	public void setAb(BinaryTree<Integer> ab) {
		this.ab = ab;
	}

	public boolean isLeftTree (int num) {
		BinaryTree<Integer> a = findNodo(ab,num);
		if (a!=null) {
			System.out.print(a.getData());
			System.out.println (" Encontrado");
			boolean respuesta= isLeftTreeHelper(a);
			return respuesta;		
		}
		else {
			System.out.println ("No Encontrado");
			return false;
		}
	}
	
	private int contarArbol (BinaryTree<Integer>a) {
		if (a.hasLeftChild() && (!a.hasRightChild()))
			return contarArbol (a.getLeftChild())+1;
		if (a.hasRightChild() && (!a.hasLeftChild()))
			return contarArbol (a.getRightChild())+1;
		if (a.hasRightChild()&& (a.hasLeftChild()))
			return contarArbol (a.getLeftChild()) + contarArbol (a.getRightChild());
		return 0;
	}
	
	private boolean isLeftTreeHelper (BinaryTree<Integer> a) {
		int ramaIzq,ramaDer;
		if (!a.hasLeftChild())
			return false;

		if (!a.hasRightChild()) 
			return true;
		
		ramaDer= contarArbol (a.getRightChild());
		
		ramaIzq= contarArbol(a.getLeftChild());
	
		if (ramaIzq> ramaDer)
			return true;
		else 
			return false;
	}
	
	private BinaryTree<Integer> findNodo(BinaryTree<Integer> a, int num){
		if (a==null) return null;
		if (a.getData().equals(num)) return a;
		BinaryTree<Integer> aux=null;
		if (a.hasLeftChild()) aux= findNodo (a.getLeftChild(),num);
		if (aux==null && a.hasRightChild()) aux= findNodo (a.getRightChild(),num);
		return aux;
	}
	
	public static void main (String [] args) {
		System.out.println ("Test parcial");
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

		
		parcial3 parcial= new parcial3 (ab);
		System.out.println(parcial.isLeftTree(7));
	}
}
