package tp5.ejercicio5;
import tp5.ejercicio1.*;
import java.util.*;
import tp1.ejercicio8.Queue;
import tp5.ejercicio1.adjList.*;


public class main {
	public List<Persona> generarCartera(Graph<Persona> grafo, Persona empleado, int separacion) {
        List<Persona> lista = new ArrayList<>(); 
        
        if (grafo.isEmpty()) return lista;
        
        Queue<Vertex<Persona>> cola = new Queue<>();
        Vertex<Persona> vertex = grafo.search(empleado);
        
        if (vertex == null) return lista;
        
        boolean[] visitados = new boolean[grafo.getSize()];
        int[] niveles = new int[grafo.getSize()];
        
        visitados[vertex.getPosition()] = true;
        niveles[vertex.getPosition()] = 0;
        
        cola.enqueue(vertex);
        
        while (!cola.isEmpty()) {
            Vertex<Persona> actual = cola.dequeue();
            int nivelActual = niveles[actual.getPosition()];
            
            if (nivelActual < separacion) {
                for (Edge<Persona> edge : grafo.getEdges(actual)) {
                    if (!visitados[edge.getTarget().getPosition()]) {
                        visitados[edge.getTarget().getPosition()] = true;
                        niveles[edge.getTarget().getPosition()] = nivelActual + 1;
                        
                        if (edge.getTarget().getData().type.equals("Jubilado")) {
                            lista.add(edge.getTarget().getData());
                        }
                        
                        cola.enqueue(edge.getTarget());
                    }
                }
            }
        }
        
        return lista;
    }
	
	 public static void main(String[] args) {
		 	main m= new main ();
	        Graph<Persona> grafo = new AdjListGraph<>();
	        Persona empleado= new Persona("Emp", "AAA");
	        Vertex<Persona> v1 = grafo.createVertex(empleado);
	        Vertex<Persona> v2 = grafo.createVertex(new Persona("Jubilado", "1", "BBB"));
	        Vertex<Persona> v3 = grafo.createVertex(new Persona("Jubilado", "2", "CCC"));
	        Vertex<Persona> v4 = grafo.createVertex(new Persona("Empleado", "3", "DDD"));
	        Vertex<Persona> v5 = grafo.createVertex(new Persona("Jubilado", "4", "EEE"));
	        Vertex<Persona> v6 = grafo.createVertex(new Persona("Empleado", "5", "FFF"));
	        Vertex<Persona> v7 = grafo.createVertex(new Persona("Jubilado", "6", "GGG"));
	        Vertex<Persona> v8 = grafo.createVertex(new Persona("Jubilado", "7", "HHH"));
	        Vertex<Persona> v9 = grafo.createVertex(new Persona("Jubilado", "8", "III"));
	        Vertex<Persona> v10 = grafo.createVertex(new Persona("Jubilado", "9", "JJJ"));
	        Vertex<Persona> v11 = grafo.createVertex(new Persona("Jubilado", "10", "JJJ"));
	        Vertex<Persona> nivel1_1 = grafo.createVertex(new Persona("Jubilado", "nivel 1", "JJJ"));
	        Vertex<Persona> nivel1_2 = grafo.createVertex(new Persona("Jubilado", "nivel 1.2", "JJJ"));
	        
	        grafo.connect(v1, nivel1_1);
	        grafo.connect(nivel1_1, v1);
	        
	        grafo.connect(v1, nivel1_2);
	        grafo.connect(nivel1_2, v1);
	        
	        grafo.connect(v1, v2);
	        grafo.connect(v2, v1);
	        
	        grafo.connect(v2, v3);
	        grafo.connect(v3, v2);
	        
	        grafo.connect(v1, v9);
	        grafo.connect(v9, v1);
	        
	        grafo.connect(v9, v8);
	        grafo.connect(v8, v9);
	        
	        grafo.connect(v1, v4);
	        grafo.connect(v4, v1);
	        
	        grafo.connect(v1, v6);
	        grafo.connect(v6, v1);
	        
	        grafo.connect(v4, v5);
	        grafo.connect(v5, v4);
	        
	        grafo.connect(v5, v7);
	        grafo.connect(v7, v5);
	        
	        grafo.connect(v9, v10);
	        grafo.connect(v10, v9);
	        
	        grafo.connect(v10, v11);
	        grafo.connect(v11, v10);

	        System.out.println(m.generarCartera (grafo, empleado, 2));
	 }            
}
