package parcial.Grafos;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;
import java.util.*;

public class parcial2 {
	public int resolver (Graph<ciudad> ciudades, String origen, String destino, int maxControles) {
		Vertex<ciudad> inicio=null;
		Vertex<ciudad> fin=null;
		
		if (ciudades.isEmpty()) return 0;
		
		for (Vertex<ciudad> vertex: ciudades.getVertices()) {
			if (vertex.getData().getNombre().equals(origen))
				inicio= vertex;
			if (vertex.getData().getNombre().equals(destino))
				fin= vertex;
		}
		
		if (inicio== null || fin==null) return 0; 
		
		List<ciudad> maxCamino =new LinkedList <ciudad>();
		
		resolver (ciudades, inicio, destino, maxControles, maxCamino, new LinkedList<ciudad>(), new boolean [ciudades.getSize()],0);
		
		return sumCamino (maxCamino);
	}
	
	private int sumCamino (List<ciudad> camino) {
		int sum=0;
		for (ciudad c: camino) {
			sum+= c.getDias();
		}
		return sum;
	}
	
	private void resolver (Graph<ciudad> ciudades, Vertex<ciudad> actual, String destino, int maxControles, List<ciudad> maxCamino, List<ciudad> caminoAct, boolean [] visitados, int diasAct) {
		caminoAct.add(actual.getData());
		diasAct+= actual.getData().getDias();
		System.out.println (caminoAct);
		System.out.println (diasAct);
		
		if (actual.getData().getNombre().equals(destino)) {
			if (diasAct>sumCamino(maxCamino)) {
				maxCamino.clear();
				maxCamino.addAll(caminoAct);
				
			}
			caminoAct.remove(caminoAct.size()-1);
			return;
		}

		visitados [actual.getPosition()]=true;
		
		for (Edge<ciudad> edge: ciudades.getEdges(actual)) {
			if (!visitados[edge.getTarget().getPosition()] && edge.getWeight()<=maxControles) {
				resolver (ciudades,edge.getTarget(),destino,maxControles,maxCamino,caminoAct,visitados,diasAct);
			}
		}
		visitados [actual.getPosition()]=false;
		caminoAct.remove(caminoAct.size()-1);
		return;	
		
	}
	
	public static void main(String[] args) {
		Graph<ciudad> grafo = new AdjListGraph<>();

        // Create vertices
        Vertex<ciudad> moreno = grafo.createVertex(new ciudad("Moreno", 2));
        Vertex<ciudad> quilmes = grafo.createVertex(new ciudad("Quilmes", 3));
        Vertex<ciudad> carlosKeen = grafo.createVertex(new ciudad("Carlos Keen", 2));
        Vertex<ciudad> suipacha = grafo.createVertex(new ciudad("Suipacha", 3));
        Vertex<ciudad> abasto = grafo.createVertex(new ciudad("Abasto", 3));
        Vertex<ciudad> laPlata = grafo.createVertex(new ciudad("La Plata", 1));
        Vertex<ciudad> navarro = grafo.createVertex(new ciudad("Navarro", 1));
        Vertex<ciudad> saladillo = grafo.createVertex(new ciudad("Saladillo", 2));
        Vertex<ciudad> lobos = grafo.createVertex(new ciudad("Lobos", 1));
        Vertex<ciudad> canuelas = grafo.createVertex(new ciudad("Cañuelas", 2));
        Vertex<ciudad> pinamar = grafo.createVertex(new ciudad("Pinamar", 0));

        // Connect vertices with edges and weights
        grafo.connect(moreno, carlosKeen, 2);
        grafo.connect(carlosKeen, suipacha, 2);
        grafo.connect(suipacha, navarro, 2);
        grafo.connect(navarro, saladillo, 2);
        grafo.connect(saladillo, lobos, 4);
        grafo.connect(carlosKeen, abasto, 3);
        grafo.connect(abasto, canuelas, 2);
        grafo.connect(quilmes, laPlata, 2);
        grafo.connect(laPlata, pinamar, 2);
        grafo.connect(moreno, quilmes, 2);
        grafo.connect(abasto, laPlata, 2);
        grafo.connect(navarro, canuelas, 2);
        // Puedes añadir conexiones bidireccionales si es necesario
        grafo.connect(canuelas, navarro, 2);
        grafo.connect(carlosKeen, moreno, 2);
        grafo.connect(suipacha, carlosKeen, 2);
        grafo.connect(navarro, suipacha, 2);
        grafo.connect(saladillo, navarro, 2);
        grafo.connect(lobos, saladillo, 4);
        grafo.connect(abasto, carlosKeen, 3);
        grafo.connect(canuelas, abasto, 2);
        grafo.connect(laPlata, quilmes, 2);
        grafo.connect(pinamar, laPlata, 2);
        grafo.connect(quilmes, moreno, 2);
        grafo.connect(laPlata, abasto, 2);
        
        parcial2 p= new parcial2();
        
        System.out.println (p.resolver(grafo, "La Plata", "Navarro", 2));
    }
}
		
