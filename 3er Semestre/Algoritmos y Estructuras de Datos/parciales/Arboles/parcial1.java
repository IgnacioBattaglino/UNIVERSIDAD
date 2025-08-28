package parcial.Arboles;
import tp2.ejercicio1.*;
import java.util.*;

public class parcial1 {
	
	
	public List<Integer> resolver (BinaryTree<Integer>ab,int min){
		List<Integer> lista = new ArrayList<Integer> ();
		List<Integer> resultado= new ArrayList<Integer>();
		resolverAux (ab,lista,resultado, min, 0);
		return resultado;
	}
	
	public void resolverAux (BinaryTree<Integer>ab,List<Integer> lista,List<Integer>resultado, int min, int act) {
		lista.add(ab.getData());
		
		if (ab.getData()%2== 0) act++;
		
		if (ab.isLeaf() && (act>=min) && resultado.isEmpty()) {	 
			resultado.addAll(lista); 
		}
		else {
			if (ab.hasLeftChild())
				resolverAux (ab.getLeftChild(),lista,resultado,min,act);
			if (ab.hasRightChild())
				resolverAux (ab.getRightChild(),lista,resultado,min,act);
			}
		lista.remove(lista.size()-1);
	}
	
	
	public static void main(String[] args) {
        BinaryTree<Integer> root = new BinaryTree<>(7);

        // Nivel 1
        BinaryTree<Integer> node56 = new BinaryTree<>(56);
        BinaryTree<Integer> node25 = new BinaryTree<>(25);
        root.addLeftChild(node56);
        root.addRightChild(node25);

        // Nivel 2
        BinaryTree<Integer> node38 = new BinaryTree<>(38);
        BinaryTree<Integer> node31 = new BinaryTree<>(31);
        BinaryTree<Integer> node5 = new BinaryTree<>(5);
        BinaryTree<Integer> node6 = new BinaryTree<>(6);
        node56.addLeftChild(node38);
        node56.addRightChild(node31);
        node25.addLeftChild(node5);
        node25.addRightChild(node6);

        // Nivel 3
        BinaryTree<Integer> node87 = new BinaryTree<>(87);
        BinaryTree<Integer> node77 = new BinaryTree<>(77);
        BinaryTree<Integer> node94 = new BinaryTree<>(94);
        node38.addLeftChild(node87);
        node38.addRightChild(node77);
        node31.addRightChild(node94);

        // Nivel 4
        BinaryTree<Integer> node16 = new BinaryTree<>(16);
        BinaryTree<Integer> node2 = new BinaryTree<>(2);
        node77.addLeftChild(node16);
        node94.addLeftChild(node2);

        // Nivel 5
        BinaryTree<Integer> node43 = new BinaryTree<>(43);
        BinaryTree<Integer> node1 = new BinaryTree<>(1);
        node16.addLeftChild(node43);
        node2.addLeftChild(node1);

        // Nivel 6
        BinaryTree<Integer> node9 = new BinaryTree<>(9);
        BinaryTree<Integer> node10 = new BinaryTree<>(10);
        node43.addLeftChild(node9);
        node43.addRightChild(node10);


        parcial1 p= new parcial1();
        List<Integer> camino = p.resolver(root, 3);
        for (Integer elem: camino) {
            System.out.println(elem);
        }
    }	
}

