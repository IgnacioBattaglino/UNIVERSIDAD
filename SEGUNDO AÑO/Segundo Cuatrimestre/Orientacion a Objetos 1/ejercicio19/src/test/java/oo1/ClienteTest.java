package oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClienteTest {
    private Empresa empresa;
    private PersonaFisica persona;
    private EnvioInternacional envio1;
    private EnvioInterurbano envio2;

    @BeforeEach
    void setUp() {
        empresa = new Empresa("Empresa","Direccion1" , "1");
        persona = new PersonaFisica ("Persona","Direccion2","12345");
        envio1 = new EnvioInternacional(LocalDate.of(2024, 3, 1), "DireccionOrigen", "DireccionDestino", 100, "Francia");
        envio2 = new EnvioInterurbano(LocalDate.of(2024, 3, 1), "DireccionOrigen", "DireccionDestino", 100,1000);
        persona.agregarEnvio(envio1);
        persona.agregarEnvio(envio2);
        empresa.agregarEnvio(envio1);
        empresa.agregarEnvio(envio2);
    }

    @Test
    void testPrecioEnviosPeriodoEmpresa (){
        double precioEsperado = envio1.getPrecio() + envio2.getPrecio();
        assertEquals(precioEsperado, empresa.precioEnviosPeriodo(LocalDate.now().minusDays(300), LocalDate.now().plusDays(300)));
    }

    @Test 
    void testPrecioEnviosPeriodoPersona () {
        double precioEsperado = (envio1.getPrecio() + envio2.getPrecio()) * 0.9;
        assertEquals(precioEsperado, persona.precioEnviosPeriodo(LocalDate.now().minusDays(300), LocalDate.now().plusDays(300)));
    }

}
