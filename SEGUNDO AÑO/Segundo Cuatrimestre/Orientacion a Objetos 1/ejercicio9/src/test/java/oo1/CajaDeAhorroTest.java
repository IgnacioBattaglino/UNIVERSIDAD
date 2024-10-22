package oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CajaDeAhorroTest {
    private CajaDeAhorro caja;

    @BeforeEach
    void setUp() {
        caja = new CajaDeAhorro();
    }

    @Test
    void testConstructor() {
        assertEquals(0, caja.getSaldo(), "El saldo inicial de la caja de ahorro debe ser 0.");
    }

    @Test
    void testDepositar() {
        caja.depositar(500);
        assertEquals(500, caja.getSaldo(), "El saldo después de depositar 500 debería ser 500.");
    }

    @Test
    void testPuedeExtraerConFondosSuficientes() {
        caja.depositar(500);
        assertTrue(caja.puedeExtraer(100), "Debería poder extraer 100 con saldo de 500.");
    }

    @Test
    void testPuedeExtraerSinFondosSuficientes() {
        caja.depositar(500);
        assertFalse(caja.puedeExtraer(600), "No debería poder extraer 600 con saldo de 500.");
    }


    @Test
    void testExtraerConFondosSuficientes() {
        caja.depositar(500);
        boolean resultado = caja.extraer(100);
        assertTrue(resultado, "Debería haber sido posible extraer 100.");
        assertEquals(400, caja.getSaldo(), "El saldo después de extraer 100 debería ser 400.");
    }

    @Test
    void testExtraerSinFondosSuficientes() {
        caja.depositar(500);
        boolean resultado = caja.extraer(600);
        assertFalse(resultado, "No debería ser posible extraer 600 con un saldo de 500.");
        assertEquals(500, caja.getSaldo(), "El saldo debería seguir siendo 500.");
    }

    @Test
    void testTransferirACuenta() {
        CajaDeAhorro otraCaja = new CajaDeAhorro();
        caja.depositar(500);
        boolean resultado = caja.transferirACuenta(100, otraCaja);
        assertTrue(resultado, "Debería haber sido posible transferir 100 a otra cuenta.");
        assertEquals(400, caja.getSaldo(), "El saldo de la caja de ahorro debería ser 400 después de la transferencia.");
        assertEquals(100, otraCaja.getSaldo(), "El saldo de la otra caja de ahorro debería ser 100 después de la transferencia.");
    }

    @Test
    void testTransferirSinFondosSuficientes() {
        CajaDeAhorro otraCaja = new CajaDeAhorro();
        caja.depositar(500);
        boolean resultado = caja.transferirACuenta(600, otraCaja);
        assertFalse(resultado, "No debería ser posible transferir 600 con un saldo de 500.");
        assertEquals(500, caja.getSaldo(), "El saldo de la caja de ahorro debería seguir siendo 500.");
        assertEquals(0, otraCaja.getSaldo(), "El saldo de la otra caja de ahorro debería seguir siendo 0.");
    }

    
}
