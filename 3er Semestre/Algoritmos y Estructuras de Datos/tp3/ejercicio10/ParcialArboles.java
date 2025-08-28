package tp3.ejercicio10;
import java.util.*;

import parcial.Arboles.MaxSum;
import tp3.ejercicio1_3_y_5.*;

public class ParcialArboles {
	public static List<Integer> resolver(GeneralTree<Integer> arbol){
		List <Integer> res= new LinkedList<Integer>();
		resolverHelper (arbol, res, new LinkedList<Integer>(), 0 , new MaxSum (0) , 0);
		return res;
	}
	
	private static void resolverHelper (GeneralTree<Integer> arbol, List<Integer> ListaMax, List<Integer>ListaAct, int nivel, MaxSum maxSuma, int sumaActual){
		int act= arbol.getData();
		
		if (act==1) { 
			sumaActual+= 1*nivel;
			ListaAct.add(act);
		}
		
		if (arbol.hasChildren()) {
			for (GeneralTree<Integer> child: arbol.getChildren()) {
				resolverHelper(child,ListaMax,ListaAct,nivel+1, maxSuma, sumaActual);
				
			}
		}
		else {
			if (sumaActual>maxSuma.getSumamaxima()) {
				maxSuma.setSumamaxima(sumaActual);
				ListaMax.clear();
				ListaMax.addAll(ListaAct);
			}
			ListaAct.remove(ListaAct.size()-1);
			}		
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
		
		System.out.println(ParcialArboles.resolver(arbol));
	}
}
