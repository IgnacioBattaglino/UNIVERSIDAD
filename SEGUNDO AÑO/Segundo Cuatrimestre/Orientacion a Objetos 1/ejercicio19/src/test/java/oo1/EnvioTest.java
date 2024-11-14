package oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

public class EnvioTest {

    @Test 
    void testGetPrecioInternacional() {
        // Partición 1: Peso ≤ 100 g
        EnvioInternacional envio = new EnvioInternacional(LocalDate.of(2024, 3, 1), "DireccionOrigen", "DireccionDestino", 50, "Francia");
        double precioEsperado = 5000 + 10 * 50;
        assertEquals(precioEsperado, envio.getPrecio(), 0.001, "Error en el precio para peso de 50 kg (partición 1)");

        // Valor de borde: Peso = 100 g
        envio.setPeso(100);
        precioEsperado = 5000 + 10 * 100;
        assertEquals(precioEsperado, envio.getPrecio(), 0.001, "Error en el precio para peso de 100 kg (límite superior de partición 1)");

        // Valor de borde: Peso = 101 g (inicio de partición 2)
        envio.setPeso(101);
        precioEsperado = 5000 + 12 * 101;
        assertEquals(precioEsperado, envio.getPrecio(), 0.001, "Error en el precio para peso de 101 kg (límite inferior de partición 2)");

        // Partición 2: Peso > 100 g
        envio.setPeso(200);
        precioEsperado = 5000 + 12 * 200;
        assertEquals(precioEsperado, envio.getPrecio(), 0.001, "Error en el precio para peso de 200 kg (partición 2)");
    }   


    @Test 
    void testGetPrecioInterurbano () {
        EnvioInterurbano envio = new EnvioInterurbano(LocalDate.of(2024, 3, 1), "DireccionOrigen", "DireccionDestino", 50, 50);
        double precioEsperado = 20 * 50;
        assertEquals(precioEsperado, envio.getPrecio(), 0.001, "Error en el precio para distancia de 50 km (partición 1)");

        // Valor de borde: Distancia = 99 km
        envio.setDistancia(99);
        precioEsperado = 20 * 50;
        assertEquals(precioEsperado, envio.getPrecio(), 0.001, "Error en el precio para distancia de 100 km (límite superior de partición 1)");

        // Valor de borde: Distancia = 101 km (inicio de partición 2)
        envio.setDistancia(101);
        precioEsperado = 25 * 50;
        assertEquals(precioEsperado, envio.getPrecio(), 0.001, "Error en el precio para distancia de 101 km (límite inferior de partición 2)");

        // Partición 2: 100 < Distancia ≤ 500 km
        envio.setDistancia(300);
        precioEsperado = 25 * 50;
        assertEquals(precioEsperado, envio.getPrecio(), 0.001, "Error en el precio para distancia de 300 km (partición 2)");

        // Valor de borde: Distancia = 500 km
        envio.setDistancia(500);
        precioEsperado = 25 * 50;
        assertEquals(precioEsperado, envio.getPrecio(), 0.001, "Error en el precio para distancia de 500 km (límite superior de partición 2)");

        // Valor de borde: Distancia = 501 km (inicio de partición 3)
        envio.setDistancia(501);
        precioEsperado = 30 * 50;
        assertEquals(precioEsperado, envio.getPrecio(), 0.001, "Error en el precio para distancia de 501 km (límite inferior de partición 3)");

        // Partición 3: Distancia > 500 km
        envio.setDistancia(600);
        precioEsperado = 30 * 50;
        assertEquals(precioEsperado, envio.getPrecio(), 0.001, "Error en el precio para distancia de 600 km (partición 3)");
    }

    @Test 
    void testGetPrecioLocal () {
        EnvioLocal envio = new EnvioLocal(LocalDate.of(2024, 3, 1), "DireccionOrigen", "DireccionDestino", 50);
        double precioEsperado = 500;
        assertEquals(envio.getPrecio(), precioEsperado);
        envio.setEntregaRapida(true);
        precioEsperado= 1000;
        assertEquals(envio.getPrecio(), precioEsperado);
    }
    
    @Test
    void testEnvioEntreFechas (){
        PersonaFisica persona = new PersonaFisica ("Persona","Direccion2","12345");
        EnvioInternacional envio1 = new EnvioInternacional(LocalDate.of(2024, 3, 1), "DireccionOrigen", "DireccionDestino", 100, "Francia");
        persona.agregarEnvio(envio1);
        
        assertTrue(envio1.envioEntreFechas(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 4, 1)));
        assertTrue (envio1.envioEntreFechas(LocalDate.of(2024, 3, 1), LocalDate.of(2024, 4, 1)));
        assertTrue (envio1.envioEntreFechas(LocalDate.of(2024, 1, 1), LocalDate.of(2024, 3, 1)));
        assertFalse(envio1.envioEntreFechas(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 4, 1)));
    }

    


}
