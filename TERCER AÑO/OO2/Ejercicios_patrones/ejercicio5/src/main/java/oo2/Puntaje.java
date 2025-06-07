package oo2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Puntaje implements Strategy {

    @Override
    public List<Pelicula> recomendarPeliculas(Decodificador deco) {
        return deco.getGrillaPeliculas().stream()
            .filter(peli -> !deco.yaLaVi(peli))
            .sorted(Comparator.comparing(Pelicula::getPuntaje).reversed()
                    .thenComparing(Comparator.comparing(Pelicula::getAñoEstreno).reversed()))
            .limit(3)
            .collect(Collectors.toList());
    }

}
