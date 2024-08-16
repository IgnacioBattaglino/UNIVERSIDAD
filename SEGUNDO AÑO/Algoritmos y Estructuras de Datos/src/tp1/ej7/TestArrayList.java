package tp1.ej7;
import java.util.*;

public class TestArrayList {
	
	public static void incisoD () {
		List<Estudiante> estudiantes = new ArrayList ();
		Estudiante e1 = new Estudiante ("Nacho" , 1);
		Estudiante e2 = new Estudiante ("Fede" , 2);
		Estudiante e3 = new Estudiante ("Alejo" , 3);
		
		estudiantes.add(e1);
		estudiantes.add(e2);
		estudiantes.add(e3);
		
		List <Estudiante> estudiantesCopia = new ArrayList ();
		estudiantesCopia.addAll(estudiantes);
		
		System.out.println(estudiantes.toString());
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println(estudiantesCopia.toString());
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		
		e1.setNombre("Carlos");
		
        System.out.println(estudiantes.toString());
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println(estudiantesCopia.toString());
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		
		Estudiante e4 = new Estudiante ("Franco",4);
		
		boolean found=false;
		for (Estudiante e:estudiantes) {
			if (e.equals(e4)) { found=true; break; }
		}
		
		if (!found) {
			estudiantes.add(e4);
		}
		
		System.out.println(estudiantes.toString());

		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		
		System.out.println(estudiantesCopia.toString());
		
		System.out.println("---------------------------------------------------------------------------------------------------------------------------");
		
	}
	
	
	public static boolean esCapicua(List<Integer> list) {
		boolean capicua = true;
		int i = 0;
		int j = list.size()-1;
		while ((i!=j) && (i<j)){
			if (list.get(i)!=list.get(j)) {
				capicua=false;
				break;
			}
			i++;
			j--;
		}
			
		return capicua;
	}
	
	

	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		System.out.print("Ingrese los numeros a agregar (-1 para terminar):");
		
		int n;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		while (n!=-1) {
			list.add(n);
			n = s.nextInt();
		}
		
		
		
		if (esCapicua(list)) {System.out.println ("ES CAPICUA"); }
		else {System.out.println ("No es capicua");}
		
		// incisoD();
	}
}
