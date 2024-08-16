package tp3.ejercicio9;
import tp3.ejercicio1_3_y_5.*;

public class ParcialArboles {
	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		if (arbol.isLeaf()) return true;
	
		int min=Integer.MAX_VALUE;
		for (GeneralTree<Integer> child: arbol.getChildren()) {
			if (!esDeSeleccion (child)) return false;
			min = Math.min(child.getData(), min);
			}	
		return (arbol.getData()==min);
	}
	
	public static void main (String [] args) {
		GeneralTree<Integer> ar= new GeneralTree<Integer> (18);
		ar.addChild(new GeneralTree<Integer> (18));
		ar.addChild(new GeneralTree<Integer> (25));
		
		ar.getChildren().get(0).addChild(new GeneralTree<Integer> (35));
		ar.getChildren().get(0).addChild(new GeneralTree<Integer> (18));
		ar.getChildren().get(0).getChildren().get(0).addChild(new GeneralTree<Integer> (35));
		ar.getChildren().get(0).getChildren().get(0).getChildren().get(0).addChild(new GeneralTree<Integer> (35));
		
		ar.getChildren().get(0).addChild(new GeneralTree<Integer> (18));
		ar.getChildren().get(0).getChildren().get(1).addChild(new GeneralTree<Integer> (14));
		ar.getChildren().get(0).getChildren().get(1).addChild(new GeneralTree<Integer> (18));
		ar.getChildren().get(0).getChildren().get(1).addChild(new GeneralTree<Integer> (33));
		ar.getChildren().get(0).getChildren().get(1).getChildren().get(2).addChild(new GeneralTree<Integer> (35));
		ar.getChildren().get(0).getChildren().get(1).getChildren().get(2).addChild(new GeneralTree<Integer> (83));
		ar.getChildren().get(0).getChildren().get(1).getChildren().get(2).addChild(new GeneralTree<Integer> (90));
		ar.getChildren().get(0).getChildren().get(1).getChildren().get(2).addChild(new GeneralTree<Integer> (33));
		
		ar.getChildren().get(1).addChild(new GeneralTree<Integer> (25));
		
		
		System.out.println(ParcialArboles.esDeSeleccion(ar));
		
		
		
		
	}
}
