package parcial.Grafos;
import tp5.ejercicio1.*;
import java.util.*;
import tp5.ejercicio1.adjList.*;

public class CaminoSinControles {
    Graph<String> mapa;

    public CaminoSinControles(Graph<String> mapa) {
        this.mapa = mapa;
    }

    public List<List<String>> devolverCaminos(String origen, String destino){
        List<List<String>> caminos = new ArrayList<>();
        if (mapa.isEmpty()) return caminos;
        
        Vertex<String> inicio = mapa.search(origen);
        Vertex<String> fin = mapa.search(destino);
        
        if (inicio == null || fin == null) return caminos;
        
        caminos = devolverCaminos(inicio, new ArrayList<>(), destino, new boolean[mapa.getSize()]);
        
        return caminos;
    }
    
    private List<List<String>> devolverCaminos(Vertex<String> actual, List<String> caminoAct, String destino, boolean[] visitados) {
        List<List<String>> caminos = new ArrayList<>();
        caminoAct.add(actual.getData());
        if (actual.getData().equals(destino)) {
            caminos.add(new ArrayList<>(caminoAct));
            caminoAct.remove(caminoAct.size() - 1);
            return caminos;
        }
        visitados[actual.getPosition()] = true;
        
        for (Edge<String> edge : mapa.getEdges(actual)) {
            if (!visitados[edge.getTarget().getPosition()] && edge.getWeight() == 0) {
                caminos.addAll(devolverCaminos(edge.getTarget(), caminoAct, destino, visitados));
            }
        }
        
        visitados[actual.getPosition()] = false;
        caminoAct.remove(caminoAct.size() - 1);
        
        return caminos;
    }
    
    public static void main(String[] args) {
        Graph<String> grafo = new AdjListGraph<>();

        // Crear vértices
        Vertex<String> stavanger = grafo.createVertex("Stavanger");
        Vertex<String> tromso = grafo.createVertex("Tromso");
        Vertex<String> bergen = grafo.createVertex("Bergen");
        Vertex<String> lofoten = grafo.createVertex("Lofoten");
        Vertex<String> molde = grafo.createVertex("Molde");
        Vertex<String> trondheim = grafo.createVertex("Trondheim");
        Vertex<String> mosjoen = grafo.createVertex("Mosjoen");
        Vertex<String> nordland = grafo.createVertex("Nordland");
        Vertex<String> oslo = grafo.createVertex("Oslo");

        // Conectar vértices con aristas y pesos
        grafo.connect(stavanger, lofoten, 3);
        grafo.connect(stavanger, tromso, 0);
        grafo.connect(stavanger, bergen, 0);
        grafo.connect(stavanger, trondheim, 2);
        grafo.connect(stavanger, mosjoen, 1);
        grafo.connect(stavanger, oslo, 1);
        grafo.connect(lofoten, nordland, 1);
        grafo.connect(lofoten, mosjoen, 2);
        grafo.connect(lofoten, tromso, 2);
        grafo.connect(tromso, trondheim, 1);
        grafo.connect(tromso, mosjoen, 0);
        grafo.connect(mosjoen, trondheim, 1);
        grafo.connect(mosjoen, molde, 2);
        grafo.connect(nordland, oslo, 2);
        grafo.connect(trondheim, oslo, 3);
        grafo.connect(bergen, oslo, 0);
        grafo.connect(molde, oslo, 2);

        // Conexiones bidireccionales si es necesario
        grafo.connect(lofoten, stavanger, 3);
        grafo.connect(tromso, stavanger, 0);
        grafo.connect(bergen, stavanger, 0);
        grafo.connect(trondheim, stavanger, 2);
        grafo.connect(mosjoen, stavanger, 1);
        grafo.connect(oslo, stavanger, 1);
        grafo.connect(nordland, lofoten, 1);
        grafo.connect(mosjoen, lofoten, 2);
        grafo.connect(tromso, lofoten, 2);
        grafo.connect(mosjoen, tromso, 0);
        grafo.connect(mosjoen, oslo, 0);
        grafo.connect(trondheim, tromso, 1);
        grafo.connect(trondheim, mosjoen, 1);
        grafo.connect(molde, mosjoen, 2);
        grafo.connect(oslo, nordland, 2);
        grafo.connect(oslo, trondheim, 3);
        grafo.connect(oslo, bergen, 0);
        grafo.connect(oslo, molde, 2);
        grafo.connect(oslo, mosjoen, 0);
        
        CaminoSinControles c = new CaminoSinControles(grafo);
        System.out.println(c.devolverCaminos("Bergen", "Mosjoen"));
    }
}
