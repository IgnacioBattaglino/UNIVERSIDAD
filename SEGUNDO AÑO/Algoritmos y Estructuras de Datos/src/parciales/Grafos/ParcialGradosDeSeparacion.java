package parcial.Grafos;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;
import tp1.ejercicio8.*;

public class ParcialGradosDeSeparacion {
	public int maximoGradoDeSeparacion (Graph <String> grafo) {
		
		if (grafo.isEmpty()) return 0;
		
		Queue<Vertex<String>> cola = new Queue<>();
		
		boolean [] visitados = new boolean [grafo.getSize()];
		visitados [grafo.getVertex(0).getPosition()]=true;
		cola.enqueue(grafo.getVertex(0));
		cola.enqueue(null);
		
		int nivel=0;
		
		while (!cola.isEmpty()) {
			Vertex<String> actual= cola.dequeue();
				
			if (actual==null) {
				if (!cola.isEmpty()) {
					cola.enqueue(null);
					nivel++;
				}
			}
			else {
				for (Edge<String> edge: grafo.getEdges(actual)) {
					if (!visitados[edge.getTarget().getPosition()]) {
						visitados [edge.getTarget().getPosition()]=true;
						cola.enqueue(edge.getTarget());
					}
				}
			}
		}
		for (boolean isvisitado: visitados) {
			if (!isvisitado) return 0;
		}
			
		return nivel;
		
	}
	
	public static void main(String[] args) {
	    // Crear un grafo de ejemplo
	    Graph<String> grafo = new AdjListGraph<>();
	    
	    Vertex<String> a = grafo.createVertex("A");
	    Vertex<String> b = grafo.createVertex("B");
	    Vertex<String> c = grafo.createVertex("C");
	    Vertex<String> d = grafo.createVertex("D");
	    Vertex<String> e = grafo.createVertex("E");
	    Vertex<String> f = grafo.createVertex("F");
	    
	    
	    grafo.connect(a, b);
	    grafo.connect(a, c);
	    grafo.connect(b, d);
	    grafo.connect(c, d);
	    grafo.connect(d, e);
	    
	    // Crear instancia de la clase y probar el método
	    ParcialGradosDeSeparacion parcial = new ParcialGradosDeSeparacion();
	    int maxGrado = parcial.maximoGradoDeSeparacion(grafo);
	    
	    System.out.println("Máximo grado de separación: " + maxGrado);
	}

}
