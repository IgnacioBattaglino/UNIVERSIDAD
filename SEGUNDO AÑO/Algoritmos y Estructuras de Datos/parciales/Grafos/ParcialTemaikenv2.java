package parcial.Grafos;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;
import java.util.*;


public class ParcialTemaikenv2 {
	public String resolver (Graph<Temaiken> sitios, int tiempo) {
		
		if (sitios.isEmpty()) return "No Alcanzable";
		
		Temaiken start= new Temaiken ("Entrada",15);
		Vertex<Temaiken> Inicio = sitios.search(start);
		
		if (Inicio==null) return "No Alcanzable";
		
		if (resolver (sitios, Inicio, tiempo, 0,new ArrayList<String> (), new boolean [sitios.getSize()])) return "Alcanzable";
		
		return "No Alcanzable";
		
		
	}
	
	private boolean resolver (Graph<Temaiken> sitios, Vertex<Temaiken> actual, int tiempo, int tiempotot, List<String> camino, boolean[] visitados) {
		tiempotot+= actual.getData().getTiempo();
		
		if (tiempotot>tiempo) return false;

		camino.add(actual.getData().getName());
		
		visitados[actual.getPosition()]=true;
	
		System.out.println (camino);
		
		
		if (camino.size()==sitios.getSize()) return true;
		
		boolean aux= false;
		for (Edge<Temaiken> edge: sitios.getEdges(actual)) {
			if (!aux && !visitados[edge.getTarget().getPosition()]) aux= resolver (sitios,edge.getTarget(),tiempo, tiempotot+edge.getWeight(), camino, visitados);
		}
		
		if (aux) return true;
		
		visitados [actual.getPosition()] =false;
		camino.remove(camino.size()-1);
		
		return false;	
	}
	public static void main(String[] args) {
        // Create a new graph
        Graph<Temaiken> grafo = new AdjListGraph<>();
        
        // Create vertices
        Vertex<Temaiken> entrada = grafo.createVertex(new Temaiken("Entrada", 15));
        Vertex<Temaiken> tigres = grafo.createVertex(new Temaiken("Tigres", 10));
        Vertex<Temaiken> cebras = grafo.createVertex(new Temaiken("Cebras", 10));
        Vertex<Temaiken> flamencos = grafo.createVertex(new Temaiken("Flamencos", 10));
        Vertex<Temaiken> murcielagos = grafo.createVertex(new Temaiken("Murciélagos", 20));
        Vertex<Temaiken> wallabies = grafo.createVertex(new Temaiken("Wallabies", 30));
        Vertex<Temaiken> tortugas = grafo.createVertex(new Temaiken("Tortugas", 10));
        Vertex<Temaiken> pumas = grafo.createVertex(new Temaiken("Pumas", 10));
        
        // Connect vertices with edges and weights
        grafo.connect(entrada, cebras, 10);
        grafo.connect(cebras, entrada, 10);
        
        grafo.connect(entrada, tigres, 15);
        grafo.connect(tigres, entrada, 15);
        
        grafo.connect(entrada, flamencos, 25);
        grafo.connect(flamencos, entrada, 25);
        
        grafo.connect(entrada, murcielagos, 20);
        grafo.connect(murcielagos, entrada, 20);
        
        grafo.connect(tigres, cebras, 8);
        grafo.connect(cebras, tigres, 8);
        
        grafo.connect(cebras, tortugas, 5);
        grafo.connect(tortugas, cebras, 5);
        
        grafo.connect(wallabies, tortugas, 10);
        grafo.connect(tortugas, wallabies, 10);
        
        grafo.connect(wallabies, pumas, 2);
        grafo.connect(pumas, wallabies, 2);
        
        grafo.connect(tortugas, pumas, 15);
        grafo.connect(pumas, tortugas, 15);
        
        grafo.connect(murcielagos, flamencos, 25);
        grafo.connect(flamencos, murcielagos, 25);
        
        grafo.connect(murcielagos, wallabies, 10);
        grafo.connect(wallabies, murcielagos, 10);
        
        ParcialTemaikenv2 p = new ParcialTemaikenv2 ();
        
        System.out.println(p.resolver(grafo, 120));

    }
}
