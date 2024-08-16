package tp3.ejercicio11;
import tp3.ejercicio1_3_y_5.*;
import tp1.ejercicio8.*;

public class ParcialArboles {
	public static boolean resolver(GeneralTree<Integer> arbol) {
		Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>> (); 
		cola.enqueue(arbol);
		int nivel=1;
		while (!cola.isEmpty()) {
			int cantNodos= cola.size();
			for (int i=0; i<cantNodos; i++) {
				GeneralTree<Integer> current= cola.dequeue();
				for (GeneralTree<Integer> child: current.getChildren()) {
					cola.enqueue(child);
				}
			if (nivel!=cantNodos) return false;
			}
			nivel++;
		}
		return true;
	}
	
	public static void main (String[] args) {
		GeneralTree<Integer> arbol= new GeneralTree<Integer> (2);
		
		arbol.addChild(new GeneralTree<Integer> (1));
		arbol.addChild(new GeneralTree<Integer> (25));
		
		
		arbol.getChildren().get(0).addChild(new GeneralTree<Integer> (5));
		arbol.getChildren().get(0).addChild(new GeneralTree<Integer> (4));
		arbol.getChildren().get(1).addChild(new GeneralTree<Integer> (13));
		
		
		arbol.getChildren().get(0).getChildren().get(0).addChild(new GeneralTree<Integer> (18));
		arbol.getChildren().get(0).getChildren().get(1).addChild(new GeneralTree<Integer> (7));
		arbol.getChildren().get(0).getChildren().get(1).addChild(new GeneralTree<Integer> (3));
	
		
		arbol.getChildren().get(0).getChildren().get(0).getChildren().get(0).addChild(new GeneralTree<Integer> (83));
		arbol.getChildren().get(0).getChildren().get(1).getChildren().get(1).addChild(new GeneralTree<Integer> (33));
		arbol.getChildren().get(0).getChildren().get(1).getChildren().get(1).addChild(new GeneralTree<Integer> (12));
		arbol.getChildren().get(0).getChildren().get(1).getChildren().get(1).addChild(new GeneralTree<Integer> (17));
		arbol.getChildren().get(0).getChildren().get(1).getChildren().get(1).addChild(new GeneralTree<Integer> (9));
		
		System.out.println(ParcialArboles.resolver(arbol));
	}
}
