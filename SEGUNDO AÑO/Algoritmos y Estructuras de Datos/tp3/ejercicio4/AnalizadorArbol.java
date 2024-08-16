package tp3.ejercicio4;
import tp1.ejercicio8.Queue;
import tp3.ejercicio1_3_y_5.GeneralTree;

public class AnalizadorArbol {

	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol) {
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue <GeneralTree<AreaEmpresa>> ();
		cola.enqueue(arbol);
		double max= -1;
		while (!cola.isEmpty()) {
			int sum=0;
			int act=cola.size();
			for (int i=0; i<act; i++) {
				GeneralTree<AreaEmpresa> current= cola.dequeue();
				sum+= current.getData().getTardanza();
				for (GeneralTree<AreaEmpresa> child: current.getChildren()) {
					cola.enqueue(child);
				}
			double prom= sum / act;
			if (prom>max) max=prom;
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
 
	    GeneralTree<AreaEmpresa> a = new GeneralTree<AreaEmpresa>(new AreaEmpresa ("M",14));
	    a.addChild(new GeneralTree<AreaEmpresa> (new AreaEmpresa ("J",13)));
	    a.addChild(new GeneralTree<AreaEmpresa> (new AreaEmpresa ("K",30)));
	    a.addChild(new GeneralTree<AreaEmpresa> (new AreaEmpresa ("L",10)));
	    a.getChildren().get(0).addChild(new GeneralTree<AreaEmpresa> (new AreaEmpresa ("A",4)));
	    a.getChildren().get(0).addChild(new GeneralTree<AreaEmpresa> (new AreaEmpresa ("B",7)));
	    a.getChildren().get(0).addChild(new GeneralTree<AreaEmpresa> (new AreaEmpresa ("C",5)));
	    a.getChildren().get(1).addChild(new GeneralTree<AreaEmpresa> (new AreaEmpresa ("D",6)));
	    a.getChildren().get(1).addChild(new GeneralTree<AreaEmpresa> (new AreaEmpresa ("E",10)));
	    a.getChildren().get(1).addChild(new GeneralTree<AreaEmpresa> (new AreaEmpresa ("F",18)));	
	    a.getChildren().get(2).addChild(new GeneralTree<AreaEmpresa> (new AreaEmpresa ("G",9)));
	    a.getChildren().get(2).addChild(new GeneralTree<AreaEmpresa> (new AreaEmpresa ("H",12)));
	    a.getChildren().get(2).addChild(new GeneralTree<AreaEmpresa> (new AreaEmpresa ("I",19)));
	    
	    
	    AnalizadorArbol anal= new AnalizadorArbol ();
	    
	    
	    System.out.println(anal.devolverMaximoPromedio(a));
}
}
