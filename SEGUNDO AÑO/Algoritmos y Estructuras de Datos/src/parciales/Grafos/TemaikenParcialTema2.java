package parcial.Grafos;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.*;
import java.util.*;

public class TemaikenParcialTema2 {
    public int resolver (Graph<Temaiken> sitios, int tiempo) {
        if (sitios.isEmpty()) return 0;
        
        Temaiken start = new Temaiken("Entrada", 15);
        
        Vertex<Temaiken> inicio = sitios.search(start);
        
        if (inicio == null) return 0;
        
        List<String> caminoMax = new ArrayList<>();
        
        resolver(sitios, inicio, 0, tiempo, new boolean[sitios.getSize()], new ArrayList<>(), caminoMax);
        System.out.println(caminoMax);
        return caminoMax.size();        
    }
    
    private void resolver (Graph<Temaiken> sitios, Vertex<Temaiken> actual, int sumtiempo, int tiempo, 
                           boolean[] visitados, List<String> caminoAct, List<String> caminoMax) {
        
        sumtiempo += actual.getData().getTiempo();
        if (sumtiempo > tiempo) {
        	System.out.println("return");
            return;
        }
        
        visitados[actual.getPosition()] = true;
        caminoAct.add(actual.getData().getName());
        System.out.println(caminoAct);
        System.out.println(sumtiempo);
        boolean hayNodosSiguientes = false;
        for (Edge<Temaiken> edge : sitios.getEdges(actual)) {
            if (!visitados[edge.getTarget().getPosition()]) {
                hayNodosSiguientes = true;
                resolver(sitios, edge.getTarget(), sumtiempo + edge.getWeight(), tiempo, visitados, caminoAct, caminoMax);
            }
        }
        
        if (!hayNodosSiguientes && caminoAct.size() > caminoMax.size()) {
            caminoMax.clear();
            caminoMax.addAll(caminoAct);
            System.out.println("--------------------------------");
            System.out.println(caminoMax);
            System.out.println("--------------------------------");
        }
        
        visitados[actual.getPosition()] = false;
        caminoAct.remove(caminoAct.size() - 1);
    }
    
    public static void main(String[] args) {
        // Crear el grafo
        Graph<Temaiken> grafo = new AdjListGraph<>();
        
        // Crear los vértices
        Vertex<Temaiken> entrada = grafo.createVertex(new Temaiken("Entrada", 15));
        Vertex<Temaiken> tigres = grafo.createVertex(new Temaiken("Tigres", 10));
        Vertex<Temaiken> cebras = grafo.createVertex(new Temaiken("Cebras", 10));
        Vertex<Temaiken> flamencos = grafo.createVertex(new Temaiken("Flamencos", 10));
        Vertex<Temaiken> murcielagos = grafo.createVertex(new Temaiken("Murciélagos", 20));
        Vertex<Temaiken> wallabies = grafo.createVertex(new Temaiken("Wallabies", 30));
        Vertex<Temaiken> tortugas = grafo.createVertex(new Temaiken("Tortugas", 10));
        Vertex<Temaiken> pumas = grafo.createVertex(new Temaiken("Pumas", 10));
        
        // Conectar los vértices con aristas y pesos
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
        
        grafo.connect(tortugas, pumas, 15);
        grafo.connect(pumas, tortugas, 15);
        
        grafo.connect(murcielagos, flamencos, 25);
        grafo.connect(flamencos, murcielagos, 25);
        
        grafo.connect(murcielagos, wallabies, 10);
        grafo.connect(wallabies, murcielagos, 10);
        
        TemaikenParcialTema2 p = new TemaikenParcialTema2();
        
        System.out.println(p.resolver(grafo, 100));
    }
}
