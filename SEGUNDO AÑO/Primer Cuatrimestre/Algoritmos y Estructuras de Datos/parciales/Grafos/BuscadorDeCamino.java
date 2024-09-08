package parcial.Grafos;
import java.util.*;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.AdjListGraph;

public class BuscadorDeCamino {
	
	public List<String> caminoDistanciaMaxima (Graph<String> ciudades, String origen, String destino, int distanciaMaxima){
		List<String> camino= new ArrayList<>(); 
		
		if (ciudades.isEmpty()) return camino;
		
		Vertex <String> inicio = ciudades.search(origen);
		Vertex <String> fin = ciudades.search(destino);
		 
		if (inicio==null || fin == null) return camino;
		
		caminoDistanciaMaxima (ciudades, camino, inicio, destino, distanciaMaxima, new boolean [ciudades.getSize()]);
		
		return camino;
		
	}
	
	private boolean caminoDistanciaMaxima (Graph<String> ciudades, List<String> camino, Vertex<String> actual, String destino, int maxdist,boolean [] visitados) {
		camino.add(actual.getData());
		if (actual.getData().equals(destino)) {
			return true;
		}
		
		
		visitados[actual.getPosition()]=true;
		boolean found=false;
		for (Edge<String> edge: ciudades.getEdges(actual)) {
			if (found) break;
			if (!visitados[edge.getTarget().getPosition()] && edge.getWeight()<maxdist) {
				found= caminoDistanciaMaxima (ciudades, camino, edge.getTarget(), destino, maxdist, visitados);
			}
		}
		
		if (!found) {
			visitados[actual.getPosition()] =false;
			camino.remove(camino.size()-1);
		}
				
		return found;
	}
	
	public static void main (String[] Args) {
		Graph<String> grafo = new AdjListGraph<>();

        // Create vertices
        Vertex<String> rioCuarto = grafo.createVertex("Rio Cuarto");
        Vertex<String> villaMaria = grafo.createVertex("Villa Maria");
        Vertex<String> villaGralBelgrano = grafo.createVertex("Villa Gral Belgrano");
        Vertex<String> villaDolores = grafo.createVertex("Villa Dolores");
        Vertex<String> cruzDelEje = grafo.createVertex("Cruz del Eje");
        Vertex<String> jesusMaria = grafo.createVertex("Jesus Maria");
        Vertex<String> tulumba = grafo.createVertex("Tulumba");
        Vertex<String> cordoba = grafo.createVertex("Cordoba");

        // Connect vertices with edges and weights
        grafo.connect(rioCuarto, villaMaria, 70);
        grafo.connect(villaMaria, rioCuarto, 70);

        grafo.connect(rioCuarto, villaGralBelgrano, 50);
        grafo.connect(villaGralBelgrano, rioCuarto, 50);

        grafo.connect(rioCuarto, villaDolores, 90);
        grafo.connect(villaDolores, rioCuarto, 90);

        grafo.connect(villaMaria, cruzDelEje, 80);
        grafo.connect(cruzDelEje, villaMaria, 80);

        grafo.connect(villaMaria, jesusMaria, 60);
        grafo.connect(jesusMaria, villaMaria, 60);

        grafo.connect(villaGralBelgrano, cruzDelEje, 85);
        grafo.connect(cruzDelEje, villaGralBelgrano, 85);

        grafo.connect(villaGralBelgrano, tulumba, 90);
        grafo.connect(tulumba, villaGralBelgrano, 90);

        grafo.connect(villaDolores, tulumba, 70);
        grafo.connect(tulumba, villaDolores, 70);

        grafo.connect(villaDolores, jesusMaria, 70);
        grafo.connect(jesusMaria, villaDolores, 70);

        grafo.connect(cruzDelEje, cordoba, 60);
        grafo.connect(cordoba, cruzDelEje, 60);

        grafo.connect(jesusMaria, cordoba, 90);
        grafo.connect(cordoba, jesusMaria, 90);

        grafo.connect(tulumba, cordoba, 75);
        grafo.connect(cordoba, tulumba, 75);

		BuscadorDeCamino b= new BuscadorDeCamino ();
		
		System.out.println(b.caminoDistanciaMaxima(grafo, "Rio Cuarto", "Cordoba", 80));
	}
	
}
