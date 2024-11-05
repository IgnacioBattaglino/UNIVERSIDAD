package oo1;

import java.util.Collection;
import java.util.HashSet;

public class EvenNumberSet extends HashSet<Integer> {

    @Override
    public boolean add(Integer num) {
        if (num % 2 == 0) {
            return super.add(num); // Usa el método add de HashSet para añadir si es par
        }
        return false; // No se agrega si no es par
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        boolean modified = false;
        for (Integer num : c) {
            if (num % 2 == 0) {
                modified |= super.add(num); // Agrega solo pares
            }
        }
        return modified;
    }
}


