package oo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaCorrienteTest {
    private CuentaCorriente cuenta;

    @BeforeEach
    void setUp() {
        cuenta = new CuentaCorriente();
    }

    @Test
    void testConstructor() {
        assertEquals(0, cuenta.getSaldo(), "El saldo inicial de la cuenta corriente debe ser 0.");
        assertEquals(0, cuenta.getDescubierto(), "El límite de descubierto inicial debe ser 0.");
    }

    @Test
    void testDepositar() {
        cuenta.depositar(1000);
        assertEquals(1000, cuenta.getSaldo(), "El saldo después de depositar 1000 debería ser 1000.");
    }

    @Test
    void testExtraerConFondosSuficientes() {
        cuenta.depositar(1000);
        boolean resultado = cuenta.extraer(500);
        assertTrue(resultado, "Debería haber sido posible extraer 500.");
        assertEquals(500, cuenta.getSaldo(), "El saldo después de extraer 500 debería ser 500.");
    }

    @Test
    void testExtraerConLimiteDescubierto() {
        cuenta.setDescubierto(200);
        cuenta.depositar(500); // Asegura que el saldo inicial sea 0
        boolean resultado = cuenta.extraer(600); // Saldo = 0, extrae 600, límite = -200
        assertTrue(resultado, "Debería haber sido posible extraer 600 dentro del límite de descubierto.");
        assertEquals(-100, cuenta.getSaldo(), "El saldo después de extraer 600 debería ser -100.");
    }

    @Test
    void testExtraerSinFondosSuficientesSinDescubierto() {
        boolean resultado = cuenta.extraer(100);
        assertFalse(resultado, "No debería ser posible extraer 100 con saldo de 0 y sin límite de descubierto.");
        assertEquals(0, cuenta.getSaldo(), "El saldo debería seguir siendo 0.");
    }

    @Test
    void testTransferirACuenta() {
        CuentaCorriente otraCuenta = new CuentaCorriente();
        cuenta.depositar(1000);
        boolean resultado = cuenta.transferirACuenta(300, otraCuenta);
        assertTrue(resultado, "Debería haber sido posible transferir 300 a otra cuenta.");
        assertEquals(700, cuenta.getSaldo(), "El saldo de la cuenta corriente debería ser 700 después de la transferencia.");
        assertEquals(300, otraCuenta.getSaldo(), "El saldo de la otra cuenta corriente debería ser 300 después de la transferencia.");
    }

    @Test
    void testTransferirSinFondosSuficientes() {
        CuentaCorriente otraCuenta = new CuentaCorriente();
        cuenta.depositar(500);
        boolean resultado = cuenta.transferirACuenta(600, otraCuenta);
        assertFalse(resultado, "No debería ser posible transferir 600 con un saldo de 500.");
        assertEquals(500, cuenta.getSaldo(), "El saldo de la cuenta corriente debería seguir siendo 500.");
        assertEquals(0, otraCuenta.getSaldo(), "El saldo de la otra cuenta corriente debería seguir siendo 0.");
    }
}
