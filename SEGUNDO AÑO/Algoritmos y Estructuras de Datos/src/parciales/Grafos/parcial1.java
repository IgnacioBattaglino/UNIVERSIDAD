package parcial.Grafos;
import tp5.ejercicio1.adjList.*;
import tp5.ejercicio1.*;
import java.util.*;

public class parcial1 {
	public String resolver (Graph<Temaiken> sitios, int tiempo) {
		Vertex<Temaiken> entrada = null;
        for (Vertex<Temaiken> v : sitios.getVertices()) {
            if (v.getData().getName().equals("Entrada")) {
                entrada = v;
                break;
            }
        }
        
		if (entrada==null) return "No se encontro la ENTRADA";
		
		if (resolver(sitios, entrada ,tiempo, 0 ,new ArrayList<String> (), new boolean [sitios.getSize()],0)) {
			return "Alcanzable";
		}
		
		return "No Alcanzable";
	}
	
	private boolean resolver (Graph<Temaiken> sitios, Vertex<Temaiken> actual, int tiempo, int tiempoAct, List<String> camino, boolean[] visitados, int visita) {
		tiempoAct+= actual.getData().getTiempo();
		if (tiempoAct>tiempo) return false;
		
		boolean found=false;
		
		camino.add(actual.getData().getName());
		System.out.println (camino);
		visitados[actual.getPosition()]=true;
		visita++;
		if (visita== sitios.getSize()) return true;
		
		for (Edge<Temaiken> edge: sitios.getEdges(actual)) {
			if (found) break;
			if (!visitados[edge.getTarget().getPosition()]) {
				found= resolver (sitios,edge.getTarget(),tiempo,tiempoAct+edge.getWeight(), camino, visitados, visita);
			}
		}
		
		if (!found) {
			camino.remove(camino.size()-1);
			visitados[actual.getPosition()]=false;
		}
		
		return found;
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
        
        parcial1 p = new parcial1 ();
        
        System.out.println(p.resolver(grafo, 120));

    }
}

