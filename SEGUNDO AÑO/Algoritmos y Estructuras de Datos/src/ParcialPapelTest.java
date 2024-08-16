import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;
import java.util.*;
import parcial.Grafos.ciudad;
import parcial.Grafos.parcial2;

public class ParcialPapelTest {
	
	private int calcularTiempo (List<ciudad> camino) {
		int cant=0;
		for (ciudad c: camino) {
			cant+= c.getDias();
		}
		return cant;
	}
	
	
	public int resolver (Graph <ciudad> ciudades, String origen, String destino, int maxControles) {
		if (ciudades.isEmpty()) return 0;
		
		Vertex<ciudad> Inicio=null;
		Vertex<ciudad> Fin=null;
		
		for (Vertex<ciudad> c: ciudades.getVertices()){
			if (c.getData().getNombre().equals(destino)) Fin=c;
			if (c.getData().getNombre().equals(origen)) Inicio=c;
		}
		
		if (Inicio == null || Fin== null) return 0;
		System.out.println("...");
		ArrayList<ciudad> caminoMax = new ArrayList<>();
		
		resolver (ciudades,Inicio,destino,maxControles,new ArrayList<ciudad>(), caminoMax, 0, new boolean [ciudades.getSize()]);
		
		int result= calcularTiempo (caminoMax);
		
		return result;
	}
		
	private void resolver (Graph <ciudad> ciudades, Vertex <ciudad> actual, String destino, int maxControles, 
			List<ciudad> caminoAct, List<ciudad> caminoMax, int tiempoAct, boolean [] visitados) {
		
		tiempoAct+= actual.getData().getDias();
		caminoAct.add(actual.getData());
		visitados[actual.getPosition()]=true;
		
		if (actual.getData().getNombre().equals(destino)) {
			if (tiempoAct>calcularTiempo (caminoMax)) {
				caminoMax.clear();
				caminoMax.addAll(caminoAct);
			}
		}
		else {
			for (Edge<ciudad> edge: ciudades.getEdges(actual)) {
				if (!visitados[edge.getTarget().getPosition()] && !(edge.getWeight()>maxControles)) {
					resolver (ciudades,edge.getTarget(),destino,maxControles,caminoAct,caminoMax,tiempoAct,visitados);
				}
			}
		}
		
		visitados[actual.getPosition()]=false;
		caminoAct.remove(caminoAct.size()-1);
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
        
        ParcialPapelTest p= new ParcialPapelTest();
        
        System.out.println (p.resolver(grafo, "La Plata", "Suipacha", 2));
    }
}

