package oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReservaTest {
    private Reserva reserva;
    private Usuario inquilino;
    private DateLapse lapso; 

    @BeforeEach
    void setUp() {
        lapso=new DateLapse(LocalDate.of(2024,12,10), LocalDate.of(2024, 12, 20));
        inquilino = new Usuario("Inquilino", "Direccion inquilino", "12345678");
        reserva = new Reserva(100, lapso, inquilino);
    }

    @Test
    void testReservaInDateLapse (){
        DateLapse lapsoFuera = new DateLapse(LocalDate.of(2023,12,5), LocalDate.of(2023, 12, 20));
        DateLapse lapsoDentro = new DateLapse(LocalDate.of(2024,12,15), LocalDate.of(2024, 12, 18));
        DateLapse lapsoLimiteBajo = new DateLapse(LocalDate.of(2024,12,1), LocalDate.of(2024, 12, 10));
        DateLapse lapsoLimiteAlto = new DateLapse(LocalDate.of(2024,12,20), LocalDate.of(2024, 12, 30));
        DateLapse lapsoLimiteCruzadoBajo = new DateLapse(LocalDate.of(2024,12,1), LocalDate.of(2024, 12, 15));
        DateLapse lapsoLimiteCruzadoAlto = new DateLapse(LocalDate.of(2024,12,15), LocalDate.of(2024, 12, 23));
        assertFalse(reserva.reservaInDateLapse(lapsoFuera));
        assertTrue(reserva.reservaInDateLapse(lapsoDentro));
        assertTrue (reserva.reservaInDateLapse(lapsoLimiteBajo));
        assertTrue (reserva.reservaInDateLapse(lapsoLimiteAlto));
        assertTrue (reserva.reservaInDateLapse(lapsoLimiteCruzadoBajo));
        assertTrue (reserva.reservaInDateLapse(lapsoLimiteCruzadoAlto));
    }

    @Test
    void testGetPrecioTotal(){
        double precioEsperado = lapso.sizeInDays() * 100 ;
        assertEquals (precioEsperado,reserva.getPrecioTotal());
    }

}
