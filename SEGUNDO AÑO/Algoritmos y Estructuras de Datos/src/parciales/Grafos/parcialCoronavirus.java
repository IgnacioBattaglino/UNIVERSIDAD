package parcial.Grafos;
import java.util.*;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;

public class parcialCoronavirus {

	public List <ciudad2> resolver (Graph <ciudad2> ciudad2es, String origen, String destino){
		
		if (ciudad2es.isEmpty()) return null;
		
		Vertex<ciudad2> Inicio=null;
		Vertex<ciudad2> Fin=null;
		
		for (Vertex<ciudad2> vertex: ciudad2es.getVertices()) {
			if (vertex.getData().getNombre().equals(origen)) {
				Inicio=vertex;
			}
			if (vertex.getData().getNombre().equals(destino)) {
				Fin=vertex;
			}
		}
		
		if (Inicio==null || Fin==null)return null;
		
		List<ciudad2> camino= new ArrayList<> ();
		
		resolver (ciudad2es,Inicio,new boolean [ciudad2es.getSize()],camino,destino);
		
		return camino;
	}
	
	private boolean resolver (Graph<ciudad2> ciudad2es, Vertex<ciudad2> actual, boolean[] visitados, List<ciudad2> camino, String destino) {
		camino.add(actual.getData());
		
		if (actual.getData().getNombre().equals(destino)) return true;
		
		visitados [actual.getPosition()]=true;
		
		boolean aux= false;
		
		for (Edge<ciudad2> edge: ciudad2es.getEdges(actual)) {
			if (!aux && !visitados[edge.getTarget().getPosition()] && edge.getTarget().getData().getFase()!=1) {
				aux = resolver (ciudad2es,edge.getTarget(),visitados,camino,destino);
			}
		}
		if (!aux) {
			visitados[actual.getPosition()]=false;
			camino.remove(camino.size()-1);
		}
		return aux;
	}
	public static void main(String[] args) {
		Graph<ciudad2> grafo = new AdjListGraph<>();

        // Create vertices
        Vertex<ciudad2> moreno = grafo.createVertex(new ciudad2("Moreno", 1));
        Vertex<ciudad2> quilmes = grafo.createVertex(new ciudad2("Quilmes", 1));
        Vertex<ciudad2> carlosKeen = grafo.createVertex(new ciudad2("Carlos Keen", 3));
        Vertex<ciudad2> suipacha = grafo.createVertex(new ciudad2("Suipacha", 5));
        Vertex<ciudad2> abasto = grafo.createVertex(new ciudad2("Abasto", 2));
        Vertex<ciudad2> laPlata = grafo.createVertex(new ciudad2("La Plata", 2));
        Vertex<ciudad2> navarro = grafo.createVertex(new ciudad2("Navarro", 4));
        Vertex<ciudad2> saladillo = grafo.createVertex(new ciudad2("Saladillo", 4));
        Vertex<ciudad2> lobos = grafo.createVertex(new ciudad2("Lobos", 3));
        Vertex<ciudad2> canuelas = grafo.createVertex(new ciudad2("Cañuelas", 1));
        Vertex<ciudad2> pinamar = grafo.createVertex(new ciudad2("Pinamar", 3));

        // Connect vertices with edges and weights
        grafo.connect(moreno, carlosKeen);
        grafo.connect(carlosKeen, suipacha);
        grafo.connect(suipacha, navarro);
        grafo.connect(navarro, saladillo);
        grafo.connect(saladillo, lobos);
        
        grafo.connect(abasto, canuelas);
        grafo.connect(quilmes, laPlata);
        grafo.connect(laPlata, pinamar);
        grafo.connect(moreno, quilmes);
        grafo.connect(abasto, laPlata);
        grafo.connect(navarro, canuelas);
        // Puedes añadir conexiones bidireccionales si es necesario
        grafo.connect(canuelas, navarro);
        grafo.connect(carlosKeen, moreno);
        grafo.connect(suipacha, carlosKeen);
        grafo.connect(navarro, suipacha);
        grafo.connect(saladillo, navarro);
        grafo.connect(lobos, saladillo);
        
        grafo.connect(canuelas, abasto);
        grafo.connect(laPlata, quilmes);
        grafo.connect(pinamar, laPlata);
        grafo.connect(quilmes, moreno);
        grafo.connect(laPlata, abasto);
        
        parcialCoronavirus p= new parcialCoronavirus();
        
        System.out.println (p.resolver(grafo, "La Plata", "Carlos Keen"));
    }
}
