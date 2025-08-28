package parcial.Grafos;
import tp5.ejercicio1.*;
import java.util.*;
import tp5.ejercicio1.adjList.*;

public class ElPasoCity {
    public Graph<vertice> mapa;

    public List<String> resolver() {
        List<String> camino = new ArrayList<>();
        if (mapa.isEmpty()) return camino;

        Vertex<vertice> origen = mapa.search(new vertice("Casa del intendente", false));
        Vertex<vertice> destino = mapa.search(new vertice("Municipalidad", false));

        if (origen == null || destino == null) return camino;

        int[] cant = new int[1];
        cant[0] = Integer.MAX_VALUE;
        resolver(origen, new ArrayList<>(), camino, new boolean[mapa.getSize()], 0, cant);

        return camino;
    }

    private void resolver(Vertex<vertice> actual, List<String> caminoAct, List<String> caminoFinal, boolean[] visitados, int cant, int[] cantMin) {
        caminoAct.add(actual.getData().getNombre());

        if (actual.getData().getNombre().equals("Municipalidad") && cantMin[0] > cant) {
            cantMin[0] = cant;
            caminoFinal.clear();
            caminoFinal.addAll(caminoAct);
            caminoAct.remove(caminoAct.size() - 1);
            return;
        }

        visitados[actual.getPosition()] = true;

        for (Edge<vertice> edge : mapa.getEdges(actual)) {
            if (!visitados[edge.getTarget().getPosition()]) {
                int nuevoCant = cant;
                if (edge.getTarget().getData().isControlado()) nuevoCant++;
                if (edge.getWeight() == 1) nuevoCant++;
                resolver(edge.getTarget(), caminoAct, caminoFinal, visitados, nuevoCant, cantMin);
            }
        }

        visitados[actual.getPosition()] = false;
        caminoAct.remove(caminoAct.size() - 1);
    }

    public static void main(String[] args) {
        Graph<vertice> grafo = new AdjListGraph<>();

        // Crear vértices
        Vertex<vertice> casaIntendente = grafo.createVertex(new vertice("Casa del intendente", false));
        Vertex<vertice> sitio1 = grafo.createVertex(new vertice("Sitio 1", false));
        Vertex<vertice> sitio2 = grafo.createVertex(new vertice("Sitio 2", true)); // Controlado por la mafia
        Vertex<vertice> sitio3 = grafo.createVertex(new vertice("Sitio 3", true));
        Vertex<vertice> sitio4 = grafo.createVertex(new vertice("Sitio 4", false)); // Controlado por la mafia
        Vertex<vertice> municipalidad = grafo.createVertex(new vertice("Municipalidad", false));

        // Conectar vértices con aristas bidireccionales y pesos
        grafo.connect(casaIntendente, sitio1, 1);
        grafo.connect(sitio1, casaIntendente, 1);

        grafo.connect(casaIntendente, sitio2, 0);
        grafo.connect(sitio2, casaIntendente, 0);

        grafo.connect(casaIntendente, sitio3, 0);
        grafo.connect(sitio3, casaIntendente, 0);

        grafo.connect(sitio1, sitio2, 0);
        grafo.connect(sitio2, sitio1, 0);
        
        grafo.connect(sitio1, municipalidad, 1);
        grafo.connect(municipalidad, sitio1, 1);

        grafo.connect(sitio2, municipalidad, 1);
        grafo.connect(municipalidad, sitio2, 1);

        grafo.connect(sitio3, sitio4, 0);
        grafo.connect(sitio4, sitio3, 0);

        grafo.connect(sitio4, municipalidad, 0);
        grafo.connect(municipalidad, sitio4, 0);

        ElPasoCity epc = new ElPasoCity();
        epc.mapa = grafo;

        System.out.println(epc.resolver());
    }
}
