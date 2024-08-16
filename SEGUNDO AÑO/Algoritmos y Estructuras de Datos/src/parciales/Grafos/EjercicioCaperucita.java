package parcial.Grafos;

import java.util.ArrayList;
import java.util.List;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;

public class EjercicioCaperucita {
	public List<List<String>> BuscadorDeCaminos (Graph<String> bosque, int frutas){
		
		if (bosque.isEmpty()) return null;
		
		Vertex <String> inicio = bosque.search("Casa Caperucita");
		Vertex <String> fin = bosque.search("Casa Abuelita");
		
		
		if (inicio==null || fin == null) return null;
		
		ArrayList<List<String>> caminos = new ArrayList<> ();
		
		BuscadorDeCaminos (bosque, inicio, frutas, caminos, new ArrayList<> (), new boolean [bosque.getSize()]);
		
		return caminos;
		
	}
	
	private void BuscadorDeCaminos (Graph<String> bosque, Vertex<String> actual, int frutas, List<List<String>> caminos, List<String> caminoAct, boolean[]visitados) {
		caminoAct.add(actual.getData());
		
		if (actual.getData().equals("Casa Abuelita")) {
			caminos.add(new ArrayList<String> (caminoAct));
			caminoAct.remove(caminoAct.size()-1);
			return;
		}
		
		visitados[actual.getPosition()]=true;
		
		for (Edge<String> edge: bosque.getEdges(actual)) {
			if (!visitados[edge.getTarget().getPosition()] && edge.getWeight()<=frutas)
				BuscadorDeCaminos (bosque, edge.getTarget(), frutas, caminos, caminoAct, visitados);
		}
		
		caminoAct.remove(caminoAct.size()-1);
		visitados[actual.getPosition()]=false;
		
	}
	public static void main(String[] args) {
        Graph<String> grafo = new AdjListGraph<>();

        // Crear vértices
        Vertex<String> casaCaperucita = grafo.createVertex("Casa Caperucita");
        Vertex<String> claro1 = grafo.createVertex("Claro 1");
        Vertex<String> claro2 = grafo.createVertex("Claro 2");
        Vertex<String> claro3 = grafo.createVertex("Claro 3");
        Vertex<String> claro4 = grafo.createVertex("Claro 4");
        Vertex<String> claro5 = grafo.createVertex("Claro 5");
        Vertex<String> casaAbuelita = grafo.createVertex("Casa Abuelita");

        // Conectar vértices con aristas y pesos (grafo no direccional)
        grafo.connect(casaCaperucita, claro1, 3);
        grafo.connect(claro1, casaCaperucita, 3);

        grafo.connect(casaCaperucita, claro2, 4);
        grafo.connect(claro2, casaCaperucita, 4);

        grafo.connect(casaCaperucita, claro3, 4);
        grafo.connect(claro3, casaCaperucita, 4);

        grafo.connect(claro1, claro5, 3);
        grafo.connect(claro5, claro1, 3);

        grafo.connect(claro1, claro2, 4);
        grafo.connect(claro2, claro1, 4);

        grafo.connect(claro2, claro4, 10);
        grafo.connect(claro4, claro2, 10);

        grafo.connect(claro2, claro5, 11);
        grafo.connect(claro5, claro2, 11);

        grafo.connect(claro3, claro5, 15);
        grafo.connect(claro5, claro3, 15);

        grafo.connect(claro4, casaAbuelita, 9);
        grafo.connect(casaAbuelita, claro4, 9);

        grafo.connect(claro5, casaAbuelita, 4);
        grafo.connect(casaAbuelita, claro5, 4);

        EjercicioCaperucita b = new EjercicioCaperucita();

        System.out.println(b.BuscadorDeCaminos(grafo, 5));

    }
}
