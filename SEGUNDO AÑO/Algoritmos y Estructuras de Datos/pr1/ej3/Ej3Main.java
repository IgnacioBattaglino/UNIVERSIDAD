package tp1.ej3;

public class Ej3Main {
	public static void main (String[]args) {
		
		Estudiante [] Estudiantes = new Estudiante[2] ;
		Profesor [] Profesores = new Profesor[3];
	
		Profesor p1= new Profesor ();
		p1.setNombre("Ignacio");
		p1.setApellido("Battaglino");
		p1.setCatedra("Taller de programacion");
		p1.setEmail("battaglinoignacio@gmail.com");
		p1.setFacultad("Informatica");
		
		Profesores [0]= p1;
		
		Profesor p2= new Profesor ();
		p2.setNombre("Federico");
		p2.setApellido("Kesselman");
		p2.setCatedra("Matematica A");
		p2.setEmail("fedek@gmail.com");
		p2.setFacultad("Ingenieria Civil");
		
		Profesores [1]= p2;
		
		Profesor p3= new Profesor ();
		p3.setNombre("Alejo");
		p3.setApellido("Angheben");
		p3.setCatedra("Economia 1");
		p3.setEmail("aleangh@gmail.com");
		p3.setFacultad("Ciencias Economicas");
		
		Profesores [2]= p3;
		
		Estudiante e= new Estudiante();
		e.setNombre("Antonio");
		e.setApellido("Mayocchi");
		e.setComision(3);
		e.setDireccion("Grand Bell lote 10");
		e.setEmail("antoniomayocchi@gmail.com");
		
		Estudiantes [0]= e;
		
		Estudiante e2= new Estudiante();
		e2.setNombre("Juan");
		e2.setApellido("Otonello");
		e2.setComision(1);
		e2.setDireccion("Calle 42 entre 6 y 7");
		e2.setEmail("jpotonello@gmail.com");
		
		Estudiantes [1]= e2;
		
		System.out.println ("Profesores: ");
		for (int i=0; i<3; i++) {
			System.out.println (Profesores[i].tusDatos());
		}
		
		System.out.println ("Alumnos: ");
		for (int i=0; i<2; i++) {
			System.out.println (Estudiantes[i].tusDatos());
		}
		
		
	}

}
