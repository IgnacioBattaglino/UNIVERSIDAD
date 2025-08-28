package oo1;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
    private Usuario usuario;
    private Propiedad propiedad1;
    private Propiedad propiedad2;
    private DateLapse lapso;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("Ignacio","Plaza Paso 167","46269132");
        propiedad1 = new Propiedad ("Direccion1","Propiedad1",100,new CancelacionFlexible() );
        propiedad2 = new Propiedad ("Direccion2","Propiedad2",1000,new CancelacionFlexible());
        
        Set<Propiedad> propiedades = new HashSet<> ();
        propiedades.add(propiedad1);
        propiedades.add(propiedad2);
        usuario.setPropiedades(propiedades);
        lapso = new DateLapse(LocalDate.of(2024, 12, 10), LocalDate.of(2024,12,20));
    }

    @Test
    void testCalcularIngresos (){
        propiedad1.reservar(lapso, new Usuario ("Cliente1","Direccion1","12345"));
        propiedad2.reservar(lapso, new Usuario ("Client2","Direccion2","67890"));
        
        double ingresosEsperados = (propiedad1.totalReservasInLapse(lapso) + propiedad2.totalReservasInLapse(lapso)) *0.75;
        assertEquals(usuario.calcularIngresos(lapso) , ingresosEsperados );
        
    }
}

