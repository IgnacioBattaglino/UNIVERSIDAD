package tp2.ejercicio5;
import tp2.ejercicio1.BinaryTree;

public class ProfundidadDeArbolBinario {
	private BinaryTree<Integer> arbol;
	
	public ProfundidadDeArbolBinario (BinaryTree<Integer> unArbolLleno) {
		this.arbol= unArbolLleno;
	}
	
	public int sumaElementosProfundidad (int p) {
		if (this.arbol.isEmpty()) return 0;
		else 
			return sumaElementosRecursivo(p,this.arbol,0);
	}
	
	public int sumaElementosRecursivo (int p, BinaryTree<Integer> ar, int nivelAct) {
		if (p==nivelAct) return ar.getData();
		else {
			int suma=0;
			if (ar.hasLeftChild()) suma+= this.sumaElementosRecursivo(p, ar.getLeftChild(), nivelAct+1);
			if (ar.hasRightChild()) suma+= this.sumaElementosRecursivo(p, ar.getRightChild(), nivelAct+1);
		return suma; 
		}
	}
	
	 public static void main (String[] args) {
	        System.out.println("Test Profundidad");
	        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
	        ab.addLeftChild(new BinaryTree<Integer>(2));
	        ab.addRightChild(new BinaryTree<Integer>(6));
	        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
	        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
	        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
	        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
	        
	        ProfundidadDeArbolBinario prof = new ProfundidadDeArbolBinario(ab);
	        System.out.println(prof.sumaElementosProfundidad(2));
	        
	    }
	
	
}
