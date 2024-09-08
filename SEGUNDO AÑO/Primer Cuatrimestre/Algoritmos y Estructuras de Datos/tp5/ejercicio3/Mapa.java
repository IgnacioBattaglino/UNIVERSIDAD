package tp5.ejercicio3;
import tp5.ejercicio1.*;
import tp5.ejercicio1.adjList.AdjListGraph;

import java.util.*;
import tp1.ejercicio8.Queue;

public class Mapa {
	public Graph<String> mapaCiudades;
	
	public Mapa(Graph<String> mapa) {
        this.setMapaCiudades(mapa);
    }

    public Graph<String> getMapaCiudades() {
        return mapaCiudades;
    }

    public void setMapaCiudades(Graph<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }
	
	public List<String> devolverCamino (String ciudad1, String ciudad2){
		List<String> camino= new ArrayList <String>();
		// Si la ciudad esta vacia, retornamos una lista vacia.
		if (this.mapaCiudades.isEmpty()) 
			return camino;
		
		// Sino, obtenemos los vertices de la ciudad origen y la ciudad destino.
		Vertex<String> origen= mapaCiudades.search(ciudad1);
		Vertex<String> destino= mapaCiudades.search(ciudad2);
		
		// Si alguna de las ciudades no existe, retornamos una lista vacia.
		if (origen==null || destino ==null) 
			return camino;
		
		// Implementacion BFS para camino minimo:
		// Creacion de tabla valor distancia.
		Integer [] distancia = new Integer [this.mapaCiudades.getSize()];
		for (int i=0; i< this.mapaCiudades.getSize(); i++) {
			distancia [i]= Integer.MAX_VALUE;
		}
		// Asignacion distancia origen.
		distancia[origen.getPosition()]=0;
		
		// Creamos un array de predecesores para guardar el camino hacia la ciudad destino.
		Vertex<String> [] predecesores = new Vertex [this.mapaCiudades.getSize()]; 
		
		Queue<Vertex<String>> cola= new Queue<>();
		cola.enqueue(origen);
		boolean encontrado=false;
		
		while (!cola.isEmpty()) {
			Vertex<String> actual= cola.dequeue();
			if (actual.equals(destino)) {
				encontrado=true;
				break;
			}
			
			for (Edge<String> arista: this.getMapaCiudades().getEdges(actual)) {
				if (distancia[arista.getTarget().getPosition()]== Integer.MAX_VALUE) {
					distancia[arista.getTarget().getPosition()]= distancia[actual.getPosition()] +1;
					predecesores[arista.getTarget().getPosition()] = actual;
					cola.enqueue(arista.getTarget());
			}
				
			}
			
		}
		
		if (!encontrado) return camino;
		
		for (Vertex<String> at= destino; at!=null; at = predecesores[at.getPosition()]) {
			camino.add(0, at.getData());
		}
		
		return camino;
	}
	
	private boolean isIn (String ciudad, List <String> ciudades) {
		for (String c: ciudades) {
			if (c==ciudad)
				return true;
		}
		return false;
	}
	
	
	public List<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, List<String> ciudades){
		List<String> camino= new ArrayList <String>();
		// Si la ciudad esta vacia, retornamos una lista vacia.
		if (this.mapaCiudades.isEmpty()) 
			return camino;
		
		// Sino, obtenemos los vertices de la ciudad origen y la ciudad destino.
		Vertex<String> origen= mapaCiudades.search(ciudad1);
		Vertex<String> destino= mapaCiudades.search(ciudad2);
		
		// Si alguna de las ciudades no existe, retornamos una lista vacia.
		if (origen==null || destino ==null) 
			return camino;
		
		// Implementacion BFS para camino minimo:
		// Creacion de tabla valor distancia.
		Integer [] distancia = new Integer [this.mapaCiudades.getSize()];
		for (int i=0; i< this.mapaCiudades.getSize(); i++) { 
			if (isIn(this.mapaCiudades.getVertex(i).getData(),ciudades))
				distancia[i]= -1;
			else
				distancia [i]= Integer.MAX_VALUE;
		}
		// Asignacion distancia origen.
		distancia[origen.getPosition()]=0;
		
		// Creamos un array de predecesores para guardar el camino hacia la ciudad destino.
		Vertex<String> [] predecesores = new Vertex [this.mapaCiudades.getSize()]; 
		
		Queue<Vertex<String>> cola= new Queue<>();
		cola.enqueue(origen);
		boolean encontrado=false;
		
		while (!cola.isEmpty()) {
			Vertex<String> actual= cola.dequeue();
			if (actual.equals(destino)) {
				encontrado=true;
				break;
			}
			
			for (Edge<String> arista: this.getMapaCiudades().getEdges(actual)) {
				if (distancia[arista.getTarget().getPosition()]== Integer.MAX_VALUE) {
					distancia[arista.getTarget().getPosition()]= distancia[actual.getPosition()] +1;
					predecesores[arista.getTarget().getPosition()] = actual;
					cola.enqueue(arista.getTarget());
			}
				
			}
			
		}
		
		if (!encontrado) return camino;
		
		for (Vertex<String> at= destino; at!=null; at = predecesores[at.getPosition()]) {
			camino.add(0, at.getData());
		}
		
		return camino;
	}
	
	
	private int getMinDist(int[] distancia, boolean[] conocidos) {
	    int min = Integer.MAX_VALUE;
	    int minIndex = -1;
	    for (int i = 0; i < distancia.length; i++) {
	        if (!conocidos[i] && distancia[i] < min) {
	            min = distancia[i];
	            minIndex = i;
	        }
	    }
	    return minIndex;
	}
	
	public List<String> caminoMasCorto(String ciudad1, String ciudad2){
		List <String> camino= new ArrayList<String> (); 
		
		if (this.mapaCiudades.isEmpty()) 
			return camino;		
		
		Vertex<String> origen = this.mapaCiudades.search(ciudad1);
		Vertex<String> destino = this.mapaCiudades.search(ciudad2);
		
		if (origen==null || destino == null) 
			return camino;
		
		int [] distancia = new int [this.mapaCiudades.getSize()];
		Vertex<String> [] predecesor = new Vertex [this.mapaCiudades.getSize()];
		boolean [] conocidos = new boolean [this.mapaCiudades.getSize()];
		
		for (int i=0; i<this.mapaCiudades.getSize(); i++) {
			distancia[i]= Integer.MAX_VALUE;
			conocidos[i]= false; // chequear
		}
		
		distancia[origen.getPosition()]= 0;
		
		for (int i=0; i<this.mapaCiudades.getSize(); i++) {
			int index= getMinDist(distancia,conocidos);
			Vertex <String> actual = this.mapaCiudades.getVertex(index);
			if (actual.equals(destino)) break;
			
			conocidos[index]=true;
			
			for (Edge<String> edge : this.mapaCiudades.getEdges(actual)) {
				int aristaIndex = edge.getTarget().getPosition();
				if (!conocidos[aristaIndex]) {
					if (distancia[aristaIndex]> distancia [index] + edge.getWeight()) {
						distancia[aristaIndex]= distancia [index] + edge.getWeight();
						predecesor[aristaIndex]= actual;
					}
				}
			}
		}
		
		if (predecesor[destino.getPosition()]==null)
			return camino;
		
		for (Vertex<String> vertex= destino; vertex!= origen; vertex= predecesor[vertex.getPosition()]) {
			camino.add(0, vertex.getData());
		}
		camino.add(0, origen.getData());
		
		return camino;
	}
	
	/*
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		
	}
	
	public List<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto){
		
	}
	*/
	public static void main(String[] args) {
        Graph<String> mapaCiudades = new AdjListGraph<String>();
        Vertex<String> v1 = mapaCiudades.createVertex("La Plata"); 
        Vertex<String> v2 = mapaCiudades.createVertex("Ensenada"); 
        Vertex<String> v3 = mapaCiudades.createVertex("Berisso"); 
        Vertex<String> v4 = mapaCiudades.createVertex("Berazategui"); 
        Vertex<String> v5 = mapaCiudades.createVertex("Florencio Varela"); 
        Vertex<String> v6 = mapaCiudades.createVertex("Presidente Peron"); 
        Vertex<String> v7 = mapaCiudades.createVertex("San Vicente"); 
        mapaCiudades.connect(v1, v2, 4);
        mapaCiudades.connect(v2, v1, 4);
        mapaCiudades.connect(v1, v3, 3);
        mapaCiudades.connect(v3, v1, 3);
        mapaCiudades.connect(v1, v4, 4);
        mapaCiudades.connect(v4, v1, 4);
        mapaCiudades.connect(v2, v5, 15);
        mapaCiudades.connect(v5, v2, 15);
        mapaCiudades.connect(v3, v5, 3);
        mapaCiudades.connect(v5, v3, 3);
        mapaCiudades.connect(v4, v3, 4);
        mapaCiudades.connect(v3, v4, 4);
        mapaCiudades.connect(v4, v5, 11);
        mapaCiudades.connect(v5, v4, 11);
        mapaCiudades.connect(v4, v6, 10);
        mapaCiudades.connect(v6, v4, 10);
        mapaCiudades.connect(v5, v7, 4);
        mapaCiudades.connect(v7, v5, 4);
        mapaCiudades.connect(v6, v7, 9);
        mapaCiudades.connect(v7, v6, 9);
        
        Mapa mapa = new Mapa(mapaCiudades);
        
        System.out.print("LISTA DEVOLVER CAMINO: ");
        System.out.print(mapa.devolverCamino("Presidente Peron", "Berisso"));
        
        System.out.println("");
        
        System.out.print("LISTA DEVOLVER CAMINO EXCEPTUANDO LUGARES:");
        List<String> restringidos = new LinkedList<String>();

        restringidos.add("Berazategui");
        
        System.out.print(mapa.devolverCaminoExceptuando("Presidente Peron", "Berisso", restringidos));
        
        System.out.println("");
        
        System.out.print("LISTA CAMINO MAS CORTO (SEGUN DISTANCIA): ");
        System.out.print(mapa.caminoMasCorto("La Plata", "San Vicente"));
        
        System.out.println("");
}
}

