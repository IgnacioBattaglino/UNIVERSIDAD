package tp2.ejercicio3;
import tp2.ejercicio1.BinaryTree;
import java.util.*;

public class ContadorArbol {
	private BinaryTree<Integer> arbol;
	
	public ContadorArbol(BinaryTree<Integer> arbol) {
		this.arbol = arbol;
	}

	public List<Integer> numerosParesInOrden (){
		List <Integer> aux = new LinkedList<Integer>(); 
		if (!arbol.isEmpty()) this.numParesInOrden(aux,this.arbol);
		return aux;
	}
	
	private void numParesInOrden (List <Integer> lista, BinaryTree<Integer> a) {
		if (a.hasLeftChild()) this.numParesInOrden(lista,a.getLeftChild());
		if (a.getData()%2==0) {lista.add(a.getData());} 
		if (a.hasRightChild()) this.numParesInOrden(lista,a.getRightChild());
	}
	
	public List<Integer> numerosParesPosOrden (){
		List <Integer> aux = new LinkedList<Integer>(); 
		if (!arbol.isEmpty()) this.numParesPosOrden(aux,this.arbol);
		return aux;
	}
	
	private void numParesPosOrden (List <Integer> lista, BinaryTree<Integer> a) {
		if (a.hasLeftChild()) this.numParesPosOrden(lista,a.getLeftChild());
		if (a.hasRightChild()) this.numParesPosOrden(lista,a.getRightChild());
		if (a.getData()%2==0) {lista.add(a.getData());} 
	}
	
	public static void main (String[] args) {
        System.out.println("Test numeros Pares");
        BinaryTree<Integer> ab = new BinaryTree<Integer>(4);
        ab.addLeftChild(new BinaryTree<Integer>(2));
        ab.addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(3));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));

        
        ContadorArbol arbol = new ContadorArbol (ab);
        
        List<Integer> lisIN = arbol.numerosParesInOrden();
        System.out.println("Los nodos pares del arbol en INORDER son: ");
        System.out.println(lisIN);
        
        
        List<Integer> lisPOST = arbol.numerosParesPosOrden();
        System.out.println("Los nodos pares del arbol en POSTORDER son: ");
        System.out.println(lisPOST);
    }
}
	

