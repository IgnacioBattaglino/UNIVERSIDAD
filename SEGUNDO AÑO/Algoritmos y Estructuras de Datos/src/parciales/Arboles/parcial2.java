package parcial.Arboles;
import tp2.ejercicio1.*;

public class parcial2 {
	private BinaryTree<Integer> ab;
	
	public BinaryTree<Integer> getAb() {
		return ab;
	}

	public parcial2(BinaryTree<Integer> ab) {
		super();
		this.ab = ab;
	}

	public void setAb(BinaryTree<Integer> ab) {
		this.ab = ab;
	}

	public boolean resolver (int k) {
		boolean aux=monodistante(0,k,ab);
		return aux;
	}
	
	private boolean monodistante (int suma, int k, BinaryTree<Integer> a) {
		suma+= a.getData();
		if (a.isLeaf() & (suma != k)) 
				return false;
		else {
			if (a.hasLeftChild() & a.hasRightChild()) 
				return monodistante(suma,k,a.getLeftChild()) && monodistante(suma,k,a.getRightChild());
			else if (a.hasRightChild()) 
				return monodistante (suma,k,a.getRightChild());
			else if (a.hasLeftChild())
				return monodistante (suma,k,a.getLeftChild());
			}
		return true;
	}

	public static void main(String[] args) {
        System.out.println("Test Ejercicio 7");

        BinaryTree<Integer> ab = new BinaryTree<>(2);
        ab.addLeftChild(new BinaryTree<>(1));
        ab.addRightChild(new BinaryTree<>(2));

        ab.getLeftChild().addLeftChild(new BinaryTree<>(5));
        ab.getLeftChild().addRightChild(new BinaryTree<>(4));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<>(1));
        ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<>(1));

        ab.getRightChild().addLeftChild(new BinaryTree<>(1));
        ab.getRightChild().addRightChild(new BinaryTree<>(2));
        ab.getRightChild().getRightChild().addRightChild(new BinaryTree<>(2));
        ab.getRightChild().getLeftChild().addLeftChild(new BinaryTree<>(3));
        
        parcial2 aux = new parcial2(ab);
        System.out.print(aux.resolver(8));
	}
	
}
