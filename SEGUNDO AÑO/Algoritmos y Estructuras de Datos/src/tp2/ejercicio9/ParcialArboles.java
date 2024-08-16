package tp2.ejercicio9;
import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {
	
	public BinaryTree<SumAndDif> sumAndDif (BinaryTree<Integer> arbol){
		BinaryTree<SumAndDif> ab = new BinaryTree <SumAndDif> ();
		this.sumAndDifRecursive(ab, arbol, 0,0);
		return ab;
	}
	
	private void sumAndDifRecursive (BinaryTree<SumAndDif> ab1, BinaryTree<Integer> ab2, int padre, int total) {
		total+=ab2.getData();
		SumAndDif sad= new SumAndDif (total,ab2.getData()-padre);
		ab1.setData(sad);
		if (ab2.hasLeftChild()) {
			ab1.addLeftChild(new BinaryTree<SumAndDif>());
			this.sumAndDifRecursive(ab1.getLeftChild(), ab2.getLeftChild(), ab2.getData(), total);
		}
		if (ab2.hasRightChild()) {
			ab1.addRightChild(new BinaryTree<SumAndDif>());
			this.sumAndDifRecursive(ab1.getRightChild(), ab2.getRightChild(), ab2.getData(), total);
		}
	}
	
	public static void main(String[] args) {
        System.out.println("Test Ejercicio9");
        ParcialArboles parcialArb = new ParcialArboles();
        
        BinaryTree<Integer> ab = new BinaryTree<Integer>(20);
        ab.addLeftChild(new BinaryTree<Integer>(5));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(-5));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(10));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.addRightChild(new BinaryTree<Integer>(30));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(50));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(-9));
        ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
        ab.getRightChild().getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(6));
        
        ab.entreNiveles(0, 6);
        System.out.println();
        System.out.println("Nuevo arbol:");
        parcialArb.sumAndDif(ab).entreNiveles(0, 6);
    }
}