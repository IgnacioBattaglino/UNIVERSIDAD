package oo1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class PropiedadTest {
    private Propiedad propiedad;
    private Usuario inquilino;
    private DateLapse periodo;
    private DateLapse periodo2;
    private Reserva reserva;
    private Reserva reserva2;

    @BeforeEach
    void setUp() {
        // Se añade una política de cancelación (por ejemplo, flexible)
        propiedad = new Propiedad("Calle Ejemplo 123", "Casa", 300, new CancelacionFlexible());
        inquilino = new Usuario("Inquilino", "Direccion Inquilino", "987654321");
        periodo = new DateLapse(LocalDate.now().plusDays(45), LocalDate.now().plusDays(50));
        reserva = propiedad.reservar(periodo, inquilino);
        periodo2 = new DateLapse(LocalDate.now().minusDays(5), LocalDate.now().plusDays(5));
        reserva2 = propiedad.reservar(periodo2, inquilino);
    }

    @Test
    void testReservar() {
        // Intentamos reservar el mismo periodo nuevamente, lo que debería devolver null
        Reserva reserva3 = propiedad.reservar(periodo, inquilino);
        assertNull(reserva3, "La reserva no debería haberse creado debido a la disponibilidad del periodo");
        assertFalse(propiedad.getReservas().contains(reserva3), "La reserva no debería estar en la lista de reservas");
        
        // Verificamos que la primera reserva se haya creado correctamente
        assertNotNull(reserva, "La reserva debería haberse creado");
        assertTrue(propiedad.getReservas().contains(reserva), "La reserva debería estar en la lista de reservas");
    }

    @Test
    void testEliminarReserva() {
        propiedad.eliminarReserva(reserva2);
        assertTrue (propiedad.getReservas().contains(reserva2));
        propiedad.eliminarReserva(reserva);
        assertFalse(propiedad.getReservas().contains(reserva), "La reserva debería haberse eliminado");
    }
    @Test
    void testTotalReservasInLapse() {
        // Calculamos el total de las reservas en un lapso
        double totalEsperado = reserva.getPrecioTotal() + reserva2.getPrecioTotal();
        assertEquals(totalEsperado, propiedad.totalReservasInLapse(new DateLapse(LocalDate.now().minusDays(100), LocalDate.now().plusDays(100))), "El total de reservas en el lapso no coincide");
    }

    @Test
    void testIsAvailable () {
        // Verificamos la disponibilidad de la propiedad en el periodo reservado
        assertFalse(propiedad.isAvailable(periodo), "La propiedad no debería estar disponible en el periodo reservado");
        
        // Verificamos la disponibilidad de la propiedad en un periodo futuro
        assertTrue(propiedad.isAvailable(new DateLapse(LocalDate.now().plusYears(1), LocalDate.now().plusYears(2))), "La propiedad debería estar disponible en un periodo futuro");
    }
}
