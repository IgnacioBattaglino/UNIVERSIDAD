package oo2;

import java.util.List;
import java.util.stream.Collectors;

public class Novedad implements Strategy {

    @Override
    public List<Pelicula> recomendarPeliculas(Decodificador deco) {
        return deco.getGrillaPeliculas().stream()
            .filter(peli -> !deco.yaLaVi(peli))
            .sorted((p1, p2) -> Integer.compare(p2.getAñoEstreno(), p1.getAñoEstreno()))
            .limit(3)
            .collect(Collectors.toList());
    }
}
