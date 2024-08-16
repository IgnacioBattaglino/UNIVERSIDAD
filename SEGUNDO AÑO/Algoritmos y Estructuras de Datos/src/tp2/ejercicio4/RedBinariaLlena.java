package tp2.ejercicio4;
import tp2.ejercicio1.BinaryTree;


public class RedBinariaLlena {
	private BinaryTree<Integer> red;
	
	public RedBinariaLlena (BinaryTree<Integer> unArbolLleno) {
		this.red= unArbolLleno;
	}
	
	public int retardoReenvio() {
		int aux= retardoRecursivo(this.red);
		return aux;
	}
	
	public int retardoRecursivo(BinaryTree<Integer> ab) {
		int retHi=0;
		int retHd=0;
		if (ab.hasLeftChild()) retHi=this.retardoRecursivo(ab.getLeftChild());
		if (ab.hasRightChild()) retHd=this.retardoRecursivo(ab.getRightChild());
		return Math.max(retHi, retHd) + ab.getData();
	}
		
	 public static void main (String[] args) {
	        System.out.println("Test mayor retardo");
	        BinaryTree<Integer> ab = new BinaryTree<Integer>(10);
	        ab.addLeftChild(new BinaryTree<Integer>(2));
	        ab.addRightChild(new BinaryTree<Integer>(3));
	        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(20));
	        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(4));
	        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(9));
	        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
	        ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(7));
	        ab.getLeftChild().getLeftChild().addRightChild(new BinaryTree<Integer>(8));
	        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(5));
	        ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(6));
	        ab.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(14));
	        ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(8));
	        ab.getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(2));
	        ab.getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(1));
	        
	        RedBinariaLlena red = new RedBinariaLlena(ab);
	        System.out.println("El mayor retardo posible es de: " + red.retardoReenvio() + " segundos");
}
}
