package tp3.ejercicio6;
import tp3.ejercicio1_3_y_5.GeneralTree;

public class RedDeAguaPotable {
	GeneralTree<Character> estructura;
	
	public GeneralTree<Character> getRed() {
		return estructura;
	}

	public void setRed(GeneralTree<Character> red) {
		this.estructura = red;
	}

	


	public RedDeAguaPotable(GeneralTree<Character> estructura) {
		this.estructura = estructura;
	}
	
	public double minimoCaudal(double caudal) {
		return this.minCaudalHelper(caudal, this.estructura);
		}
		
	private double minCaudalHelper (double caudal, GeneralTree<Character> est) {
		double min= caudal;
		double aux = caudal / est.getChildren().size();
		double caudalhijo;
		for (GeneralTree<Character> child: est.getChildren()) {
			caudalhijo= this.minCaudalHelper(aux,child);
			if (caudalhijo<min) min=caudalhijo;
		}	
		return min;
	}	
	
	
	public static void main (String[] args) {
		RedDeAguaPotable red= new RedDeAguaPotable (new GeneralTree<Character> ('A'));
		
		red.getRed().addChild(new GeneralTree<Character> ('B'));
		red.getRed().addChild(new GeneralTree<Character> ('C'));
		red.getRed().addChild(new GeneralTree<Character> ('D'));
		red.getRed().addChild(new GeneralTree<Character> ('E'));
		
		red.getRed().getChildren().get(1).addChild(new GeneralTree<Character> ('F'));
		red.getRed().getChildren().get(1).addChild(new GeneralTree<Character> ('G'));
		
		red.getRed().getChildren().get(2).addChild(new GeneralTree<Character> ('H'));
		red.getRed().getChildren().get(2).addChild(new GeneralTree<Character> ('I'));
		red.getRed().getChildren().get(2).addChild(new GeneralTree<Character> ('J'));
		red.getRed().getChildren().get(2).addChild(new GeneralTree<Character> ('K'));
		red.getRed().getChildren().get(2).addChild(new GeneralTree<Character> ('P'));
		
		red.getRed().getChildren().get(1).getChildren().get(1).addChild(new GeneralTree<Character> ('L'));
		
		red.getRed().getChildren().get(2).getChildren().get(2).addChild(new GeneralTree<Character> ('M'));
		red.getRed().getChildren().get(2).getChildren().get(2).addChild(new GeneralTree<Character> ('N'));
		
		
		System.out.println(red.minimoCaudal(1500));
	}
	
}

