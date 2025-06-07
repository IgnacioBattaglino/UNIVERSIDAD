package oo2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

public class DecodificadorTest {
    
    private Decodificador decodificador;
    private Pelicula thor, capitanAmerica, ironMan, dunkirk, rocky, rambo;
    
    @BeforeEach
    void setUp() {
        // Crear decodificador
        decodificador = new Decodificador();
        
        // Crear películas según el ejemplo de la consigna
        thor = new Pelicula(2007, "Thor", 7.9);
        capitanAmerica = new Pelicula(2016, "Capitan America", 7.8);
        ironMan = new Pelicula(2010, "Iron Man", 7.9);
        dunkirk = new Pelicula(2017, "Dunkirk", 7.9);
        rocky = new Pelicula(1976, "Rocky", 8.1);
        rambo = new Pelicula(1979, "Rambo", 7.8);
        
        // Establecer relaciones de similaridad según la consigna
        // Thor es similar a Capitan America e Iron Man
        thor.agregarSimilar(capitanAmerica);
        thor.agregarSimilar(ironMan);
        // Capitan America es similar a Iron Man (además de Thor)
        capitanAmerica.agregarSimilar(ironMan);
        // Rocky es similar a Rambo
        rocky.agregarSimilar(rambo);
        
        // Agregar todas las películas a la grilla
        decodificador.agregarPeliculaGrilla(thor);
        decodificador.agregarPeliculaGrilla(capitanAmerica);
        decodificador.agregarPeliculaGrilla(ironMan);
        decodificador.agregarPeliculaGrilla(dunkirk);
        decodificador.agregarPeliculaGrilla(rocky);
        decodificador.agregarPeliculaGrilla(rambo);
        
        // El decodificador reprodujo Thor y Rocky
        decodificador.agregarPeliculaVista(thor);
        decodificador.agregarPeliculaVista(rocky);
    }
    
    @Test
    void testRecomendacionesPorSimilaridadYPuntaje() {
        System.out.println("=== EJECUTANDO TEST CASE SEGÚN CONSIGNA ===\n");
        
        // PASO 1: Configurar al decodificador para que sugiera por similaridad (ii)
        System.out.println("Paso 1: Configurando decodificador para sugerir por SIMILARIDAD");
        decodificador.setStrategy(new Similaridad());
        
        // PASO 2: Solicitar al mismo decodificador las sugerencias
        System.out.println("Paso 2: Solicitando sugerencias por similaridad...");
        List<Pelicula> sugerenciasSimilaridad = decodificador.recomendarPeliculas();
        
        // Mostrar resultados
        System.out.print("Sugerencias por SIMILARIDAD: ");
        sugerenciasSimilaridad.forEach(p -> System.out.print(p.getTitulo() + " "));
        System.out.println("\n");
        
        // Verificaciones para similaridad
        assertTrue(sugerenciasSimilaridad.size() <= 3, "Debe sugerir máximo 3 películas");
        assertTrue(sugerenciasSimilaridad.size() > 0, "Debe sugerir al menos 1 película");
        
        // Verificar que las sugeridas son similares a las vistas y no fueron vistas
        for (Pelicula sugerida : sugerenciasSimilaridad) {
            assertFalse(decodificador.yaLaVi(sugerida), 
                       "No debe sugerir películas ya vistas: " + sugerida.getTitulo());
            
            // Debe ser similar a Thor o Rocky
            boolean esSimilarAThor = thor.getSimilares().contains(sugerida);
            boolean esSimilarARocky = rocky.getSimilares().contains(sugerida);
            assertTrue(esSimilarAThor || esSimilarARocky, 
                      sugerida.getTitulo() + " debe ser similar a Thor o Rocky");
        }
        
        // PASO 3: Configurar al mismo decodificador para que sugiera por puntaje (iii)
        System.out.println("Paso 3: Configurando el MISMO decodificador para sugerir por PUNTAJE");
        decodificador.setStrategy(new Puntaje());
        
        // PASO 4: Solicitar al mismo decodificador las sugerencias
        System.out.println("Paso 4: Solicitando sugerencias por puntaje...");
        List<Pelicula> sugerenciasPuntaje = decodificador.recomendarPeliculas();
        
        // Mostrar resultados
        System.out.print("Sugerencias por PUNTAJE: ");
        sugerenciasPuntaje.forEach(p -> System.out.print(p.getTitulo() + " "));
        System.out.println("\n");
        
        // Verificaciones para puntaje
        assertTrue(sugerenciasPuntaje.size() <= 3, "Debe sugerir máximo 3 películas");
        assertTrue(sugerenciasPuntaje.size() > 0, "Debe sugerir al menos 1 película");
        
        // Verificar que no fueron vistas
        for (Pelicula sugerida : sugerenciasPuntaje) {
            assertFalse(decodificador.yaLaVi(sugerida), 
                       "No debe sugerir películas ya vistas: " + sugerida.getTitulo());
        }
        
        // Verificar orden esperado por puntaje y año (según la consigna):
        // Esperado: Dunkirk (7.9, 2017), Iron Man (7.9, 2010), Capitan America (7.8, 2016)
        if (sugerenciasPuntaje.size() >= 3) {
            assertEquals("Dunkirk", sugerenciasPuntaje.get(0).getTitulo(), 
                        "Primera sugerencia debe ser Dunkirk (mayor puntaje reciente)");
            assertEquals("Iron Man", sugerenciasPuntaje.get(1).getTitulo(), 
                        "Segunda sugerencia debe ser Iron Man (mismo puntaje que Dunkirk pero menos reciente)");
            assertEquals("Capitan America", sugerenciasPuntaje.get(2).getTitulo(), 
                        "Tercera sugerencia debe ser Capitan America (menor puntaje)");
        }
        
        System.out.println("=== TEST COMPLETADO EXITOSAMENTE ===");
    }
    
    @Test
    void testResultadosEsperadosSegunConsigna() {
        System.out.println("\n=== VERIFICANDO RESULTADOS ESPERADOS SEGÚN CONSIGNA ===");
        
        // Testear Similaridad - esperado: Capitán América, Iron man, Rambo
        decodificador.setStrategy(new Similaridad());
        List<Pelicula> similaridad = decodificador.recomendarPeliculas();
        
        // Verificar que contiene las películas esperadas (orden puede variar por aleatorio)
        assertTrue(similaridad.stream().anyMatch(p -> p.getTitulo().equals("Capitan America")));
        assertTrue(similaridad.stream().anyMatch(p -> p.getTitulo().equals("Iron Man")));
        assertTrue(similaridad.stream().anyMatch(p -> p.getTitulo().equals("Rambo")));
        
        // Testear Puntaje - esperado: Dunkirk, Iron man, Capitan America
        decodificador.setStrategy(new Puntaje());
        List<Pelicula> puntaje = decodificador.recomendarPeliculas();
        
        assertEquals(3, puntaje.size());
        assertEquals("Dunkirk", puntaje.get(0).getTitulo());
        assertEquals("Iron Man", puntaje.get(1).getTitulo());
        assertEquals("Capitan America", puntaje.get(2).getTitulo());
        
        System.out.println("Similaridad (puede variar orden): " + 
                          similaridad.stream().map(Pelicula::getTitulo).toList());
        System.out.println("Puntaje (orden fijo): " + 
                          puntaje.stream().map(Pelicula::getTitulo).toList());
    }
}