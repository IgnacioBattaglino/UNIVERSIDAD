package oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
    private Conductor conductor;
    private Pasajero pasajero;
    private Pasajero pasajero2;
    private Viaje viaje;

    @BeforeEach
    void setUp() {
        conductor = new Conductor("Conductor", 10000, new Vehiculo("Toyota Corolla", 5, 2020, 15000000));
        pasajero = new Pasajero("Pasajero1", 10000);
        pasajero2 = new Pasajero("Pasajero2", 10000);
    }

    @Test
    void testDescontarSaldoConductor () {
        double saldoEsperado = conductor.getSaldo() - 10000 + conductor.calcularBonificacion();
        conductor.descontarSaldo(10000);
        assertEquals(saldoEsperado, conductor.getSaldo());
    }

    @Test 
    void testDecontarSaldoPasajero () {
        double saldoEsperado = pasajero.getSaldo() - 10000 + pasajero.calcularBonificacion();
        pasajero.descontarSaldo(10000);
        assertEquals(saldoEsperado, pasajero.getSaldo());
    }

    @Test
    void testCargarSaldoConductor () {
        double saldoEsperado = this.conductor.getSaldo() + 3000 * this.conductor.calcularComision();
        this.conductor.cargarSaldo(3000);
        assertEquals(saldoEsperado, conductor.getSaldo());
    }

    @Test
    void testCargarSaldoPasajero () {
        double saldoEsperado = this.pasajero.getSaldo() + 3000 * this.pasajero.calcularComision();
        this.pasajero.cargarSaldo(3000);
        assertEquals(saldoEsperado, pasajero.getSaldo());
    }
    
    @Test
    void testRegistrarseAViajePorCapacidad () {
        viaje = conductor.registrarViaje("", "", 50000, LocalDate.now().plusDays(3));
        // Caso de borde: ya se cubrió la capacidad máxima
        conductor.getVehiculo().setcapacidadMaxima(1);
        assertFalse(pasajero.registrarseAViaje(viaje));
        // Caso de borde: se llega a la capacidad máxima
        conductor.getVehiculo().setcapacidadMaxima(2);
        assertTrue(pasajero.registrarseAViaje(viaje));
        // Partición equivalente: valor por fuera de los límites
        conductor.getVehiculo().setcapacidadMaxima(1);
        assertFalse(pasajero2.registrarseAViaje(viaje));
        // Partición equivalente: valor entre medio de los límites
        conductor.getVehiculo().setcapacidadMaxima(4);
        assertTrue(pasajero2.registrarseAViaje(viaje));
    }

    @Test 
    void testRegistrarseAViajePorFecha () {
        viaje = conductor.registrarViaje("", "", 50000, LocalDate.now().plusDays(1));
        // Partición1: fuera del límite
        assertFalse(pasajero.registrarseAViaje(viaje));
        // Caso de borde: límite de días
        viaje = conductor.registrarViaje("", "", 50000, LocalDate.now().plusDays(2));
        assertTrue(pasajero.registrarseAViaje(viaje));
        // Partición2: dentro de los límites
        viaje = conductor.registrarViaje("", "", 50000, LocalDate.now().plusDays(4));
        assertTrue(pasajero.registrarseAViaje(viaje));
    }

    @Test
    void testRegistrarseAViajePorSaldo () {
        viaje = conductor.registrarViaje("", "", 50000, LocalDate.now().plusDays(4));
        // Partición 1: saldo en rojo 
        pasajero.setSaldo(-10);
        assertFalse(pasajero.registrarseAViaje(viaje));
        // Borde: saldo neutro
        pasajero.setSaldo(0);
        assertTrue(pasajero.registrarseAViaje(viaje));
        // Partición 2: saldo positivo
        pasajero2.setSaldo(10);
        assertTrue(pasajero2.registrarseAViaje(viaje));
    }

    @Test 
    void testRegistrarseAViajeYaEsta () {
        viaje = conductor.registrarViaje("", "", 50000, LocalDate.now().plusDays(4));
        // Caso de borde: pasajero no está en el viaje
        assertTrue(pasajero.registrarseAViaje(viaje));
        // Caso de borde: pasajero ya está en el viaje
        assertFalse(pasajero.registrarseAViaje(viaje));
    }
    
    @Test 
    void testCalcularBonificacionPasajero () {
        viaje = conductor.registrarViaje("", "", 50000, LocalDate.now().plusDays(4));
        Viaje viaje2 = conductor.registrarViaje("", "", 50000, LocalDate.now().plusDays(4));
        assertEquals(pasajero.calcularBonificacion(), 0);
        pasajero.registrarseAViaje(viaje);
        pasajero.registrarseAViaje(viaje2);
        assertEquals(pasajero.calcularBonificacion(), 500);
    }

    @Test 
    void testCalcularComisionPasajero () {
        // Partición 1: pasajero sin viajes
        assertEquals(pasajero.calcularComision(), 0.9);
        // Caso de borde: pasajero con viaje hace 1 mes. 
        viaje = conductor.registrarViaje("", "", 50000, LocalDate.now().minusMonths(1));
        pasajero.getViajesPrevios().add(viaje);
        assertEquals(pasajero.calcularComision(), 0.9);
        // Partición 2: pasajero con viaje en el mes
        Viaje viaje2 = conductor.registrarViaje("", "", 50000, LocalDate.now().minusDays(10));
        pasajero.getViajesPrevios().add(viaje2);
        assertEquals(pasajero.calcularComision(), 1);
    }

    // Tests para Conductor

    @Test
    void testCalcularBonificacionConductor() {
        // Partición 1: vehículo con valor positivo (bonificación calculada correctamente)
        conductor.getVehiculo().setValor(15000000);  // Valor del vehículo
        assertEquals(0.99 * 15000000, conductor.calcularBonificacion(), 0.01);  // Bonificación calculada correctamente

        // Partición 2: vehículo con valor cero (bonificación cero)
        conductor.getVehiculo().setValor(0);
        assertEquals(0, conductor.calcularBonificacion(), 0.01);  // Bonificación debe ser cero

        // Partición 3: vehículo con valor negativo (bonificación cero)
        conductor.getVehiculo().setValor(-1000);
        assertEquals(0, conductor.calcularBonificacion(), 0.01);  // Bonificación debe ser cero
    }

    @Test
    void testCalcularComisionConductor() {
        // Partición 1: vehículo nuevo (comisión del 0.99)
        conductor.getVehiculo().setValor(15000000);  // Vehículo nuevo
        assertEquals(0.99, conductor.calcularComision(), 0.01);  // Comisión debería ser 0.99 para vehículos nuevos

        // Partición 2: vehículo viejo (comisión del 0.85)
        conductor.getVehiculo().setValor(30000);  // Vehículo viejo
        assertEquals(0.85, conductor.calcularComision(), 0.01);  // Comisión debería ser 0.85 para vehículos viejos

        // Caso de borde: comisión para un vehículo con valor intermedio
        conductor.getVehiculo().setValor(1000000);  // Vehículo con valor intermedio
        assertEquals(0.92, conductor.calcularComision(), 0.01);  // Comisión calculada correctamente para un vehículo con valor intermedio
    }
}
