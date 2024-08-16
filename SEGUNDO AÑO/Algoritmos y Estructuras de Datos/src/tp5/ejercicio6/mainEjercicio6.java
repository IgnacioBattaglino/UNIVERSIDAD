package tp5.ejercicio6;
import java.util.*;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;
import tp5.ejercicio5.Persona;
import tp5.ejercicio5.main;

public class mainEjercicio6 {
	public Graph<String> bosque= new AdjListGraph<>();
	
	public mainEjercicio6(Graph<String> bosque) {
		super();
		this.bosque = bosque;
	}

	public List <List<String>> recorridosMasSeguro(){
		List<List<String>> caminos = new ArrayList<>();
		if (bosque.isEmpty()) return caminos;
		
		Vertex<String> caperucita = bosque.search("Casa Caperucita");
		
		if (caperucita==null) return caminos;
		
		recorridosMasSeguro(caminos, new ArrayList<String>() ,new boolean [bosque.getSize()], caperucita);
		
		return caminos;
	}

	public void recorridosMasSeguro(List<List<String>> caminos, List<String> caminoAct, boolean [] visitados, Vertex<String> actual){
		if (actual.getData().equals("Casa Abuelita")) {
			caminoAct.add(actual.getData());
			caminos.add(new ArrayList <> (caminoAct));
			caminoAct.remove(caminoAct.size()-1);
			return;
		}
		 
		caminoAct.add(actual.getData());
		visitados[actual.getPosition()]=true;
		
		for (Edge<String> edge: bosque.getEdges(actual)) {
			if (!visitados[edge.getTarget().getPosition()] && edge.getWeight()<=5) {
				recorridosMasSeguro(caminos, caminoAct, visitados, edge.getTarget());
			}
		}
		caminoAct.remove(caminoAct.size()-1);
		visitados[actual.getPosition()]=false;
	}
	
	public static void main(String[] args) {
		
	 	Graph<String> grafo = new AdjListGraph<>();

		 // Create vertices
		Vertex<String> casaCaperucita = grafo.createVertex("Casa Caperucita");
		Vertex<String> claro1 = grafo.createVertex("Claro 1");
		Vertex<String> claro2 = grafo.createVertex("Claro 2");
		Vertex<String> claro3 = grafo.createVertex("Claro 3");
		Vertex<String> claro4 = grafo.createVertex("Claro 4");
		Vertex<String> claro5 = grafo.createVertex("Claro 5");
		Vertex<String> casaAbuelita = grafo.createVertex("Casa Abuelita");
	
		 // Connect vertices with edges and weights
		grafo.connect(casaCaperucita, claro3, 4);
		grafo.connect(claro3, casaCaperucita, 4);
	
		grafo.connect(casaCaperucita, claro1, 3);
		grafo.connect(claro1, casaCaperucita, 3);
	
		grafo.connect(casaCaperucita, claro2, 4);
		grafo.connect(claro2, casaCaperucita, 4);
	
		grafo.connect(claro1, claro2, 4);
		grafo.connect(claro2, claro1, 4);
	
		grafo.connect(claro1, claro5, 3);
		grafo.connect(claro5, claro1, 3);
	
		grafo.connect(claro3, claro5, 15);
		grafo.connect(claro5, claro3, 15);
	
		grafo.connect(claro2, claro4, 10);
		grafo.connect(claro4, claro2, 10);
	
		grafo.connect(claro5, claro2, 11);
		grafo.connect(claro2, claro5, 11);
	
		grafo.connect(claro5, casaAbuelita, 4);
		grafo.connect(casaAbuelita, claro5, 4);
	
		grafo.connect(claro4, casaAbuelita, 9);
		grafo.connect(casaAbuelita, claro4, 9);
		
		mainEjercicio6 m= new mainEjercicio6 (grafo);

        System.out.println(m.recorridosMasSeguro());
 } 
}
