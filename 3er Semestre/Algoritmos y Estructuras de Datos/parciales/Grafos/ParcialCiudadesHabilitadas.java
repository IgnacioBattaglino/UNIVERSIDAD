package parcial.Grafos;
import java.util.*;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;

public class ParcialCiudadesHabilitadas {
	public List<List<String>> resolver (Graph <String> ciudades, String origen, String destino, String pasandoPor){
		if (ciudades.isEmpty()) return null;
		
		Vertex<String> Inicio,Pasando,Fin;
		Inicio= ciudades.search(origen);
		Pasando= ciudades.search(pasandoPor);
		Fin= ciudades.search(destino);
		
		if (Inicio==null || Pasando==null || Fin == null) return null;
		
		ArrayList<List<String>> caminos = new ArrayList<> ();
		
		resolver (ciudades, Inicio, pasandoPor,destino, new ArrayList<String>(), caminos, false, new boolean [ciudades.getSize()]);
		
		return caminos;
		
	}
	
	private void resolver (Graph <String> ciudades,Vertex<String> actual, String pasando, 
			String destino, List<String> caminoAct, List<List<String>> caminos, boolean cumple, boolean [] visitados) {
		
		caminoAct.add(actual.getData());
		visitados[actual.getPosition()]=true;
		if (actual.getData().equals(pasando))
			cumple=true;
		
		if (actual.getData().equals(destino)) {
			if(cumple) 
				caminos.add(new ArrayList<String>(caminoAct));
		}
		else {
			for (Edge<String>edge : ciudades.getEdges(actual)) {
				if (!visitados[edge.getTarget().getPosition()] && edge.getWeight()==1) {
					resolver (ciudades,edge.getTarget(),pasando,destino,caminoAct,caminos,cumple,visitados);
				}
			}
		}
		
		caminoAct.remove (caminoAct.size()-1);
		visitados[actual.getPosition()]=false;
		
	}
	
	public static void main(String[] args) {
	    Graph<String> grafo = new AdjListGraph<>();

	    // Create vertices
	    Vertex<String> moreno = grafo.createVertex("Moreno");
	    Vertex<String> quilmes = grafo.createVertex("Quilmes");
	    Vertex<String> carlosKeen = grafo.createVertex("Carlos Keen");
	    Vertex<String> suipacha = grafo.createVertex("Suipacha");
	    Vertex<String> abasto = grafo.createVertex("Abasto");
	    Vertex<String> laPlata = grafo.createVertex("La Plata");
	    Vertex<String> navarro = grafo.createVertex("Navarro");
	    Vertex<String> saladillo = grafo.createVertex("Saladillo");
	    Vertex<String> lobos = grafo.createVertex("Lobos");
	    Vertex<String> canuelas = grafo.createVertex("Cañuelas");
	    Vertex<String> pinamar = grafo.createVertex("Pinamar");

	    
	    grafo.connect(moreno, carlosKeen, 1);
	    grafo.connect(moreno, abasto, 0);
	    grafo.connect(moreno, quilmes, 0);
	    grafo.connect(carlosKeen, suipacha, 1);
	    grafo.connect(carlosKeen, abasto, 1);
	    grafo.connect(suipacha, navarro, 1);
	    grafo.connect(navarro, saladillo, 1);
	    grafo.connect(navarro, lobos, 0);
	    grafo.connect(navarro, canuelas, 1);
	    grafo.connect(abasto, laPlata, 1);
	    grafo.connect(abasto, canuelas, 1);
	    grafo.connect(quilmes, laPlata, 1);
	    grafo.connect(laPlata, pinamar, 1);
	    
	    grafo.connect(carlosKeen, moreno, 1);
	    grafo.connect(abasto, moreno, 0);
	    grafo.connect(quilmes, moreno, 0);
	    grafo.connect(suipacha, carlosKeen, 1);
	    grafo.connect(abasto, carlosKeen, 1);
	    grafo.connect(navarro, suipacha, 1);
	    grafo.connect(saladillo, navarro, 1);
	    grafo.connect(lobos, navarro, 0);
	    grafo.connect(canuelas, navarro, 1);
	    grafo.connect(laPlata, abasto, 1);
	    grafo.connect(canuelas, abasto, 1);
	    grafo.connect(laPlata, quilmes, 1);
	    grafo.connect(pinamar, laPlata, 1);

	    
	    ParcialCiudadesHabilitadas p = new ParcialCiudadesHabilitadas();
	    System.out.println(p.resolver(grafo, "La Plata", "Suipacha", "Abasto"));
	}

}
