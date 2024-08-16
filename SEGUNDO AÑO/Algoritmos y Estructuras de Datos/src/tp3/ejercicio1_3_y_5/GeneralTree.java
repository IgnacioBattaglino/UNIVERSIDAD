package tp3.ejercicio1_3_y_5;
import tp1.ejercicio8.Queue;
import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	
	@Override
	public String toString() {
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
        cola.enqueue(this);
        String aux= "";
        while (!cola.isEmpty()) {
        	int act=cola.size();
        	for (int i=0; i<act; i++) {
        		GeneralTree<T> current = cola.dequeue();
                aux+= current.getData()+ " ";
                for (GeneralTree<T> child : current.getChildren()) {
                	cola.enqueue(child);
            }
        	}
            aux+= "\n";
        }
        return aux;
    }
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {	 
		if (this.isLeaf()) return 0;
		else {
			int maxchild=-1;	
			for	(GeneralTree<T> child: this.getChildren()) {
				maxchild= Math.max(maxchild,child.altura());
			}
			return maxchild +1;
		}
		}
			
	public int nivel(T dato){
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
        cola.enqueue(this);
        int nivel=0;
        
        while (!cola.isEmpty()) {
        	int act=cola.size();
            for (int i=0; i<act; i++) {
            	GeneralTree<T> current = cola.dequeue();
            	if (current.getData().equals(dato)) return nivel;
            	for (GeneralTree<T> child : current.getChildren()) {
            		cola.enqueue(child);
            	}
            }
            nivel++;
        }
        return -1;
	}
	
	
	public int ancho(){
	
	Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
    cola.enqueue(this);
    int max=-1;
    while (!cola.isEmpty()) {
    	int act=cola.size();
    	if (max<act) max=act;
        for (int i=0; i<act; i++) {
        	GeneralTree<T> current = cola.dequeue();
        	for (GeneralTree<T> child : current.getChildren()) {
        		cola.enqueue(child);
        	}
        }
    }
    return max;
	}
	
	
	public List<Integer> numerosImparesMayoresQuePreOrden (Integer n) {
		List<Integer> lista= new LinkedList<Integer> ();
		if (!this.isEmpty()) { this.numImparesPreOrden(lista, n);}
		return lista;
	}
		
	private void numImparesPreOrden (List<Integer> lista, Integer n) {
		int data = (Integer) this.getData();
		if (!(data%2==0) && data>n) lista.add(data); 
		if (this.hasChildren()) {
			List<GeneralTree<T>> children= this.getChildren();
			for (GeneralTree<T> child: children) {
				child.numImparesPreOrden(lista, n);
			}
		}
	}
		
	public List<Integer> numerosImparesMayoresQueInOrden (Integer n) {
		List<Integer> lista= new LinkedList<Integer> ();
		if (!this.isEmpty()) { this.numImparesInOrden(lista, n);}
		return lista;
	}
		
	private void numImparesInOrden (List<Integer> lista, Integer n) {
		if (this.hasChildren()) { 
			this.getChildren().get(0).numImparesInOrden(lista, n);
		}	
			
		int data = (Integer) this.getData();
		if ((!(data%2==0)) && (data>n)) lista.add(data); 
			
		if (this.hasChildren()) {
			List<GeneralTree<T>> children= this.getChildren();
			for (int i=1; i<children.size(); i++) {
				children.get(i).numImparesInOrden(lista, n);
			}
		}
	}
		
	public List<Integer> numerosImparesMayoresQuePostOrden (Integer n) {
		List<Integer> lista= new LinkedList<Integer> ();
		if (!this.isEmpty()) { this.numImparesPostOrden(lista, n);}
		return lista;
	}
		
	private void numImparesPostOrden (List<Integer> lista, Integer n) {
		int data = (Integer) this.getData();
		if (this.hasChildren()) {
			List<GeneralTree<T>> children= this.getChildren();
			for (GeneralTree<T> child: children) child.numImparesPostOrden(lista, n);
		}
		if ((!(data%2==0)) && (data>n)) lista.add(data); 
		}

		
	public List<Integer> numerosImparesMayoresQuePorNiveles(Integer n) {
		List<Integer> lista= new LinkedList<Integer> ();
		if (!this.isEmpty()) { this.numImparesPorNiveles(lista, n);}
		return lista;
	}
		
	private void numImparesPorNiveles (List<Integer> lista, Integer n) {
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
	    cola.enqueue(this);

	    while (!cola.isEmpty()) {
	        GeneralTree<T> current = cola.dequeue();
	        try {
	            int data = (Integer) current.getData();
	            if (data % 2 != 0 && data > n) {
	                lista.add(data);
	            }
	        } catch (ClassCastException e) {
	            System.out.println("Error: El tipo de dato no es Integer.");
	        }

	        for (GeneralTree<T> child : current.getChildren()) {
	            cola.enqueue(child);
	        }
	    }
	}
	  
	private GeneralTree<T> findNode(T value) {
	    Queue<GeneralTree<T>> queue = new Queue<>();
	    queue.enqueue(this);

	    while (!queue.isEmpty()) {
	        GeneralTree<T> current = queue.dequeue();
	        if (current.getData().equals(value)) {
	            return current;
	        }
	        for (GeneralTree<T> child : current.getChildren()) {
	            queue.enqueue(child);
	        }
	    }
	    return null;
	}
	
	public boolean esAncestro(T a, T b) {
		GeneralTree<T> arbolA= this.findNode(a);
		
		if (arbolA==null) return false;
		
		GeneralTree<T> res= arbolA.findNode(b);
		
		if (res!=null) {
			return true;
		}
		else return false;
	}
	
	
	
		public static void main(String[] args) {
		    List<GeneralTree<Integer>> children = new LinkedList<GeneralTree<Integer>>();
		    
		    children.add(new GeneralTree<Integer>(21));
		    children.add(new GeneralTree<Integer>(22));
		    children.add(new GeneralTree<Integer>(23));
		    children.add(new GeneralTree<Integer>(24));
		    
		    children.get(0).addChild(new GeneralTree<Integer>(25));
		    children.get(0).addChild(new GeneralTree<Integer>(26));
		    
		    children.get(1).addChild(new GeneralTree<Integer>(27));
		    
		    children.get(2).addChild(new GeneralTree<Integer>(28));
		    children.get(2).addChild(new GeneralTree<Integer>(29));
		    
		    children.get(3).addChild(new GeneralTree<Integer>(30));
		    children.get(3).addChild(new GeneralTree<Integer>(31));
		    
		    children.get(0).getChildren().get(0).addChild(new GeneralTree<Integer>(5));
		    children.get(0).getChildren().get(0).addChild(new GeneralTree<Integer>(8));
		    children.get(0).getChildren().get(1).addChild(new GeneralTree<Integer>(12));
		    
		    children.get(1).getChildren().get(0).addChild(new GeneralTree<Integer>(17));
		    
		    children.get(2).getChildren().get(1).addChild(new GeneralTree<Integer>(14));
		    
		    children.get(2).getChildren().get(1).getChildren().get(0).addChild(new GeneralTree<Integer>(12));
		    
		    GeneralTree<Integer> a = new GeneralTree<Integer>(1, children);

		    
		    System.out.println("En que nivel esta el num 21? Nivel:" + a.nivel(21));
		    System.out.println("En que nivel esta el num 22? Nivel:" + a.nivel(25));
		    System.out.println("En que nivel esta el num 24? Nivel:" + a.nivel(14));
		    
		    System.out.println("Ancho=" + a.ancho());
		    System.out.println("AlturaMax=" + a.altura());
		    
		    
		    System.out.println("PREORDEN:" + a.numerosImparesMayoresQuePreOrden(0));
		    
		    System.out.println("INORDEN:" + a.numerosImparesMayoresQueInOrden(0));
		    
		    System.out.println("POSTORDEN:" + a.numerosImparesMayoresQuePostOrden(0));
		    
		    System.out.println("POR NIVELES:" + a.numerosImparesMayoresQuePorNiveles(0));   
		    
		    System.out.println(a.toString());
		    
		    
		    System.out.println (a.esAncestro(0, 12));
	}
	}
