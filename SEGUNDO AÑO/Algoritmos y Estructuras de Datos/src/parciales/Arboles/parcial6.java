package parcial.Arboles;
import java.util.*;
import tp3.ejercicio1_3_y_5.*;
import tp1.ejercicio8.Queue;

public class parcial6 {
	
	
	public static List<Integer> resolver (GeneralTree<Integer> arbol){
		MaxSum maxsum= new MaxSum (-1);
		ArrayList<Integer> retorno = new ArrayList<Integer> ();
		resolverHelper (arbol, retorno, new ArrayList<Integer>(), 0,0, maxsum);
		return retorno;
	}
	
	private static void resolverHelper (GeneralTree<Integer> a, List<Integer> camino, List<Integer> caminoAct, int nivel, int suma, MaxSum maxsum) {
		if (a.getData().equals(1)) {
			caminoAct.add(1);
			suma+= nivel;
		}
		if (a.hasChildren()) {
			for (GeneralTree<Integer> child : a.getChildren() ) {
				resolverHelper (child, camino, caminoAct, nivel+1, suma, maxsum);
			}
		}
		else {
			if (maxsum.getSumamaxima()<suma) {
				maxsum.setSumamaxima(suma);
				camino.clear();
				camino.addAll(caminoAct);
			}
		}
		if (a.getData().equals(1))
			caminoAct.remove(caminoAct.size()-1);
	}
	
	public static void entreNiveles (GeneralTree<Integer> arbol) {
		Queue<GeneralTree<Integer>> cola= new Queue<GeneralTree<Integer>>();
		cola.enqueue(arbol);
		while (!cola.isEmpty()) {
			int size=cola.size();
			for ( int i=0; i<size; i++) {
				GeneralTree<Integer> a= cola.dequeue();
				System.out.print (a.getData()+" ");
			for (GeneralTree<Integer> child: a.getChildren()) 
				cola.enqueue(child);
			}
			System.out.println();
		}
		System.out.println ("fin");
	}
	
	
	public static void main (String[] args) {
		GeneralTree<Integer> arbol= new GeneralTree<Integer> (1);
		
		arbol.addChild(new GeneralTree<Integer> (0));
		arbol.addChild(new GeneralTree<Integer> (1));
		arbol.addChild(new GeneralTree<Integer> (1));
		
		
		arbol.getChildren().get(0).addChild(new GeneralTree<Integer> (1));
		arbol.getChildren().get(0).addChild(new GeneralTree<Integer> (1));
		
		arbol.getChildren().get(1).addChild(new GeneralTree<Integer> (1));
		arbol.getChildren().get(1).addChild(new GeneralTree<Integer> (0));
		
		arbol.getChildren().get(2).addChild(new GeneralTree<Integer> (0));
		
		
		arbol.getChildren().get(0).getChildren().get(0).addChild(new GeneralTree<Integer> (1));
		arbol.getChildren().get(0).getChildren().get(0).addChild(new GeneralTree<Integer> (1));
		arbol.getChildren().get(0).getChildren().get(0).addChild(new GeneralTree<Integer> (1));
		
		arbol.getChildren().get(1).getChildren().get(1).addChild(new GeneralTree<Integer> (0));
		arbol.getChildren().get(2).getChildren().get(0).addChild(new GeneralTree<Integer> (1));
		
		arbol.getChildren().get(1).getChildren().get(1).getChildren().get(0).addChild(new GeneralTree<Integer> (1));
		
		arbol.getChildren().get(2).getChildren().get(0).getChildren().get(0).addChild(new GeneralTree<Integer> (0));
		arbol.getChildren().get(2).getChildren().get(0).getChildren().get(0).addChild(new GeneralTree<Integer> (1));
		
		
		System.out.println (parcial6.resolver(arbol));
		parcial6.entreNiveles(arbol);
	}
}
