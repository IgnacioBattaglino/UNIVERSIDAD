package parcial.Arboles;
import tp3.ejercicio1_3_y_5.*;

public class parcial5 {
	
	public static boolean esDeSeleccion (GeneralTree<Integer> arbol) {
		boolean ret=true;
		if (arbol.hasChildren()) {
			int min=9999;
			for (GeneralTree<Integer> child : arbol.getChildren()) { 
				if (min>child.getData()) min=child.getData();
			}
			if (arbol.getData().equals(min)) {
				for (GeneralTree<Integer> child : arbol.getChildren()) 
					if (ret)
						ret= esDeSeleccion (child);
					else 
						break;
			}
			else 
				ret=false;
		}
		return ret;
	}
	
	
	public static void main (String [] Args) {
		GeneralTree<Integer> ab = new GeneralTree<Integer> (10);
		
		ab.addChild(new GeneralTree<Integer> (10));
		ab.addChild(new GeneralTree<Integer> (25));
		
		ab.getChildren().get(0).addChild(new GeneralTree<Integer> (35));
		ab.getChildren().get(0).addChild(new GeneralTree<Integer> (10));
		ab.getChildren().get(1).addChild(new GeneralTree<Integer> (25));

		
		ab.getChildren().get(0).getChildren().get(0).addChild(new GeneralTree<Integer> (35));
		ab.getChildren().get(0).getChildren().get(1).addChild(new GeneralTree<Integer> (14));
		ab.getChildren().get(0).getChildren().get(1).addChild(new GeneralTree<Integer> (12));
		ab.getChildren().get(0).getChildren().get(1).addChild(new GeneralTree<Integer> (10));
		
		ab.getChildren().get(0).getChildren().get(0).getChildren().get(0).addChild(new GeneralTree<Integer> (35));
		ab.getChildren().get(0).getChildren().get(1).getChildren().get(2).addChild(new GeneralTree<Integer> (35));
		ab.getChildren().get(0).getChildren().get(1).getChildren().get(2).addChild(new GeneralTree<Integer> (83));
		ab.getChildren().get(0).getChildren().get(1).getChildren().get(2).addChild(new GeneralTree<Integer> (10));
		ab.getChildren().get(0).getChildren().get(1).getChildren().get(2).addChild(new GeneralTree<Integer> (33));

		System.out.println(parcial5.esDeSeleccion(ab));
		
		
	}
}
