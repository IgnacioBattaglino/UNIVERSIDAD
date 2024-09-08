package tp3.ejercicio2;
import java.util.*;
import tp1.ejercicio8.Queue;
import tp3.ejercicio1_3_y_5.GeneralTree;

public class RecorridosAG {
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree<Integer>a, Integer n) {
		List<Integer> lista= new LinkedList<Integer> ();
		if (!a.isEmpty()) { this.numImparesPreOrden(lista, a, n);}
		return lista;
	}
	
	private void numImparesPreOrden (List<Integer> lista,GeneralTree<Integer>a, Integer n) {
		if ((!(a.getData()%2==0)) && (a.getData()>n)) lista.add(a.getData()); 
		if (a.hasChildren()) {
			for (GeneralTree<Integer> child:a.getChildren()) {
				this.numImparesPreOrden(lista, child, n);
			}
		}
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n) {
		List<Integer> lista= new LinkedList<Integer> ();
		if (!a.isEmpty()) { this.numImparesInOrden(lista, a, n);}
		return lista;
	}
	
	private void numImparesInOrden (List<Integer> lista,GeneralTree<Integer>a, Integer n) {
		if (a.hasChildren()) this.numImparesInOrden(lista, a.getChildren().get(0), n);
		if ((!(a.getData()%2==0)) && (a.getData()>n)) lista.add(a.getData()); 
		if (a.hasChildren()) {
			List<GeneralTree<Integer>> children= a.getChildren();
			for (int i=1; i<children.size(); i++) {
				this.numImparesInOrden(lista, children.get(i), n);
			}
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n) {
		List<Integer> lista= new LinkedList<Integer> ();
		if (!a.isEmpty()) { this.numImparesPostOrden(lista, a, n);}
		return lista;
	}
	
	private void numImparesPostOrden (List<Integer> lista,GeneralTree<Integer>a, Integer n) {
		if (a.hasChildren()) {
			for (GeneralTree<Integer> child:a.getChildren()) this.numImparesPostOrden(lista, child, n);
			}
		if ((!(a.getData()%2==0)) && (a.getData()>n)) lista.add(a.getData()); 
		}

	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n) {
		List<Integer> lista= new LinkedList<Integer> ();
		if (!a.isEmpty()) { this.numImparesPorNiveles(lista, a, n);}
		return lista;
	}
	
	private void numImparesPorNiveles (List<Integer> lista,GeneralTree<Integer>a, Integer n) {
		Queue<GeneralTree<Integer>> cola = new Queue <GeneralTree<Integer>> ();
		cola.enqueue(a);
		GeneralTree<Integer> aux = new GeneralTree<Integer>();
		while (!cola.isEmpty()) {
			aux= cola.dequeue();
			if ((!(aux.getData()%2==0)) && (aux.getData()>n)) lista.add(aux.getData()); 
			for (GeneralTree<Integer> child: aux.getChildren()) {
				cola.enqueue(child);
			}
		}
	}

	public static void main(String[] args) {
	    List<GeneralTree<Integer>> children = new LinkedList<GeneralTree<Integer>>();
	    
	    children.add(new GeneralTree<Integer>(21));
	    children.add(new GeneralTree<Integer>(22));
	    children.add(new GeneralTree<Integer>(23));
	    children.add(new GeneralTree<Integer>(24));
	    
	    children.get(0).addChild(new GeneralTree<Integer>(25));
	    children.get(0).addChild(new GeneralTree<Integer>(26));
	    
	    children.get(1).addChild(new GeneralTree<Integer>(27));
	    
	    children.get(2).addChild(new GeneralTree<Integer>(28));
	    children.get(2).addChild(new GeneralTree<Integer>(29));
	    
	    children.get(3).addChild(new GeneralTree<Integer>(30));
	    children.get(3).addChild(new GeneralTree<Integer>(31));
	    
	    GeneralTree<Integer> a = new GeneralTree<Integer>(1, children);
	    
	    RecorridosAG rec = new RecorridosAG();
	    
	    System.out.println("PREORDEN:" + rec.numerosImparesMayoresQuePreOrden(a, 0));
	    
	    System.out.println("INORDEN:" + rec.numerosImparesMayoresQueInOrden(a, 0));
	    
	    System.out.println("POSTORDEN:" + rec.numerosImparesMayoresQuePostOrden(a, 0));
	    
	    System.out.println("POR NIVELES:" + rec.numerosImparesMayoresQuePorNiveles(a, 0));        
		
}

}