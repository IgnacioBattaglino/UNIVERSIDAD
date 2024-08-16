package parcial.Grafos;
import tp1.ejercicio8.Queue;
import tp5.ejercicio1.adjList.*;
import tp5.ejercicio1.*;
import parcial.Tuple; 


public class Parcial {
	public Tuple nivelPopularidad (Graph<String> red, String usuario, int distancia, int umbral) {
		Tuple tupla= new Tuple (0,false);
		
		if (red.isEmpty()) return tupla; 
		
		Vertex<String> Inicio = red.search(usuario);
		
		if (Inicio==null) return null;
		
		int cant= nivelPopularidad (red,Inicio,distancia);
		
		tupla.setCant(cant);
		if (cant>= umbral) tupla.setPopular(true);
		
		return tupla;
	}
	
	
	private int nivelPopularidad (Graph<String> red, Vertex<String> Inicio, int dist) {
	    boolean[] visitados = new boolean[red.getSize()];
	    Queue<Vertex<String>> cola = new Queue<>();
	    cola.enqueue(Inicio);
	    cola.enqueue(null); // null indica cambio de nivel
	    visitados[Inicio.getPosition()] = true;
	    int nivelActual = 0;
	    
	    while (!cola.isEmpty()) {
	        Vertex<String> actual = cola.dequeue();
	        if (actual == null) {
	            nivelActual++;
	            if (nivelActual > dist) {
	                break;
	            }
	            if (!cola.isEmpty()) {
	                if (nivelActual == dist) {
	                    return cola.size();
	                }
	                cola.enqueue(null);
	            }
	        } else {
	            if (nivelActual < dist) {
	                for (Edge<String> edge : red.getEdges(actual)) {
	                    if (!visitados[edge.getTarget().getPosition()]) {
	                        cola.enqueue(edge.getTarget());
	                        visitados[edge.getTarget().getPosition()] = true;
	                    }
	                }
	            }
	        }
	    }
	    return 0;
	}


	    public static void main(String[] args) {

	        Graph<String> grafo = new AdjListGraph<>();

	 
	        Vertex<String> lionel = grafo.createVertex("Lionel");
	        Vertex<String> angel = grafo.createVertex("Ángel");
	        Vertex<String> rodrigo = grafo.createVertex("Rodrigo");
	        Vertex<String> julian = grafo.createVertex("Julián");
	        Vertex<String> diego = grafo.createVertex("Diego");
	        Vertex<String> emiliano = grafo.createVertex("Emiliano");
	        Vertex<String> enzo = grafo.createVertex("Enzo");
	        Vertex<String> lautaro = grafo.createVertex("Lautaro");

	  
	        grafo.connect(lionel, angel);
	        grafo.connect(angel, lionel);
	        
	        grafo.connect(lionel, rodrigo);
	        grafo.connect(rodrigo, lionel);
	        
	        grafo.connect(angel, diego);
	        grafo.connect(diego, angel);
	        
	        grafo.connect(angel, julian);
	        grafo.connect(julian, angel);
	        
	        grafo.connect(rodrigo, julian);
	        grafo.connect(julian, rodrigo);
	        
	        grafo.connect(rodrigo, emiliano);
	        grafo.connect(emiliano, rodrigo);
	        
	        grafo.connect(diego, lautaro);
	        grafo.connect(lautaro, diego);
	        
	        grafo.connect(diego, enzo);
	        grafo.connect(enzo, diego);
	       
	        grafo.connect(julian, lautaro);
	        grafo.connect(lautaro, julian);
	        
	        grafo.connect(emiliano, enzo);
	        grafo.connect(enzo, emiliano);
	        
	        grafo.connect(emiliano, lautaro);
	        grafo.connect(lautaro, emiliano);


	        Parcial parcial = new Parcial();
	        Tuple resultado = parcial.nivelPopularidad(grafo, "Lionel", 2, 3);
	        System.out.println(resultado);
	    }

}
