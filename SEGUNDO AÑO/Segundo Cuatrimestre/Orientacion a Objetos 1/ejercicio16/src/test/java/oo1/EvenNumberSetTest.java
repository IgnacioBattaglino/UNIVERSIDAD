package oo1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class EvenNumberSetTest {

    private Set<Integer> numbers;

    @BeforeEach
    public void setUp() {
        numbers = new EvenNumberSet();
    }

    @Test
    public void testAddEvenNumber() {
        assertTrue(numbers.add(2)); // Agrega correctamente
        assertTrue(numbers.contains(2));
    }

    @Test
    public void testAddOddNumber() {
        assertFalse(numbers.add(1)); // No se agrega porque es impar
        assertFalse(numbers.contains(1));
    }

    @Test
    public void testAddDuplicateEvenNumber() {
        assertTrue(numbers.add(4)); // Primer agregado de 4
        assertFalse(numbers.add(4)); // Segundo intento no agrega duplicados
        assertEquals(1, numbers.size());
    }

    @Test
    public void testAddAllWithMixedNumbers() {
        assertTrue(numbers.addAll(Set.of(2, 3, 4, 5, 6))); // Solo agrega 2, 4, y 6
        assertTrue(numbers.contains(2));
        assertTrue(numbers.contains(4));
        assertTrue(numbers.contains(6));
        assertFalse(numbers.contains(3));
        assertFalse(numbers.contains(5));
        assertEquals(3, numbers.size());
    }

    @Test
    public void testRemoveEvenNumber() {
        numbers.add(8);
        assertTrue(numbers.remove(8)); // Remueve correctamente
        assertFalse(numbers.contains(8));
    }

    @Test
    public void testClear() {
        numbers.add(2);
        numbers.add(4);
        numbers.clear();
        assertTrue(numbers.isEmpty());
    }
}
