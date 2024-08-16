package tp5.ejercicio2;
import java.util.*;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;
import tp1.ejercicio8.Queue;

public class Recorridos <T> {
	
	public Recorridos() {
		
	}
	
	public List<T> dfs (Graph<T> grafo) {
		List <T> lista = new ArrayList<T>();
		boolean[] visitados = new boolean [grafo.getSize()];
		
		for (Vertex<T> vertex: grafo.getVertices()) {
			if (!visitados[vertex.getPosition()])
				dfs (grafo,vertex,visitados,lista);
		}
		return lista;
	}
	
	public void dfs (Graph<T> grafo, Vertex<T> vertex, boolean[] visitados, List<T> lista) { 
        visitados[vertex.getPosition()] = true;
        lista.add(vertex.getData());

        for (Edge<T> edge: grafo.getEdges(vertex)) { 
        	
            if (!visitados[edge.getTarget().getPosition()])
                dfs (grafo, edge.getTarget(), visitados, lista);
        }
    }
	
	
	public List<T> bfs (Graph<T> grafo){
		boolean [] visitados= new boolean [grafo.getSize()];
		List <T> lista = new ArrayList<T>();
		for (Vertex<T> vertex: grafo.getVertices()){
			if (!visitados[vertex.getPosition()]) {
				visitados[vertex.getPosition()] = true;
				bfs (grafo, vertex, lista, visitados);
			}
		}
		return lista;
	}
	

	public void bfs (Graph <T> grafo, Vertex<T> vertex, List <T> lista, boolean [] visitados) {
		Queue<Vertex<T>> cola = new Queue<Vertex<T>> ();
		cola.enqueue(vertex);
		while (!cola.isEmpty()) {
			vertex= cola.dequeue();
			lista.add(vertex.getData());
			for (Edge<T> edge: grafo.getEdges(vertex)) {
				if (!visitados[edge.getTarget().getPosition()]) {
					cola.enqueue(edge.getTarget());
					visitados[edge.getTarget().getPosition()] = true;
				}
			}
		}
	}


	public static void main (String[] args) {
		Recorridos r= new Recorridos();
		Graph<Character> grafo= new AdjListGraph<Character>();
		grafo.createVertex('A');
		grafo.createVertex('B');
		grafo.createVertex('C');
		grafo.createVertex('D');
		grafo.createVertex('E');
		grafo.createVertex('F');
		grafo.createVertex('G');
		grafo.connect(grafo.getVertex(0), grafo.getVertex(1));
		grafo.connect(grafo.getVertex(1), grafo.getVertex(0));
		grafo.connect(grafo.getVertex(1), grafo.getVertex(2));
		grafo.connect(grafo.getVertex(1), grafo.getVertex(3));
		grafo.connect(grafo.getVertex(1), grafo.getVertex(4));
		grafo.connect(grafo.getVertex(2), grafo.getVertex(1));
		grafo.connect(grafo.getVertex(2), grafo.getVertex(3));
		grafo.connect(grafo.getVertex(2), grafo.getVertex(4));
		grafo.connect(grafo.getVertex(3), grafo.getVertex(1));
		grafo.connect(grafo.getVertex(4), grafo.getVertex(1));
		grafo.connect(grafo.getVertex(4), grafo.getVertex(2));
		
		grafo.connect(grafo.getVertex(5), grafo.getVertex(6));
		grafo.connect(grafo.getVertex(6), grafo.getVertex(5));
		
		System.out.println (r.dfs(grafo));
		
		System.out.println (r.bfs(grafo));
	}
	}