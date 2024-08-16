package tp3.ejercicio7;
import tp3.ejercicio1_3_y_5.GeneralTree;
import java.util.*;

public class Caminos {
	GeneralTree<Integer> arbol;
	
	public Caminos(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}


	public GeneralTree<Integer> getArbol() {
		return arbol;
	}

	public void setArbol(GeneralTree<Integer> arbol) {
		this.arbol = arbol;
	}



	public List<Integer> caminoAHojasMasLejana(){
		List<Integer> listaAux= new LinkedList<Integer> ();
		List<Integer> ret= new LinkedList<Integer> ();
		this.caminoHelper(ret, listaAux, arbol);
		return ret;
	}
	
	
	private void caminoHelper (List<Integer> listaMax, List<Integer> listaAct, GeneralTree<Integer> tree) {
		if (tree.hasChildren()){
			for (GeneralTree<Integer> child: tree.getChildren()) {
				listaAct.add(tree.getData());
				caminoHelper (listaMax,new LinkedList<>(listaAct),child);
				if (listaAct.size()>listaMax.size()) {
					listaMax.clear();
					listaMax.addAll(listaAct);}
				listaAct.remove(listaAct.size()-1);
			}
		}
		else {  
			listaAct.add(tree.getData());
			if (listaAct.size() > listaMax.size()) {
	            listaMax.clear();
	            listaMax.addAll(listaAct);
			}
		}
	}
	

	public static void main (String[] args) {
		Caminos camino= new Caminos (new GeneralTree<Integer> (12));
		
		camino.getArbol().addChild(new GeneralTree<Integer> (17));
		camino.getArbol().addChild(new GeneralTree<Integer> (9));
		camino.getArbol().addChild(new GeneralTree<Integer> (15));
		
		camino.getArbol().getChildren().get(0).addChild(new GeneralTree<Integer> (10));
		camino.getArbol().getChildren().get(0).addChild(new GeneralTree<Integer> (6));
		camino.getArbol().getChildren().get(1).addChild(new GeneralTree<Integer> (8));
		camino.getArbol().getChildren().get(2).addChild(new GeneralTree<Integer> (14));
		camino.getArbol().getChildren().get(2).addChild(new GeneralTree<Integer> (18));
		
		
		
		camino.getArbol().getChildren().get(0).getChildren().get(1).addChild(new GeneralTree<Integer> (1));
		camino.getArbol().getChildren().get(2).getChildren().get(0).addChild(new GeneralTree<Integer> (16));
		camino.getArbol().getChildren().get(2).getChildren().get(0).addChild(new GeneralTree<Integer> (7));
		
		System.out.println(camino.caminoAHojasMasLejana());
		
		
		
	}
	
	
	
	
}
