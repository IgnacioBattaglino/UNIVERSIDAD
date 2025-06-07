package oo2;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Similaridad implements Strategy{

    @Override
    public List<Pelicula> recomendarPeliculas(Decodificador deco) {
        List<Pelicula> candidatas = deco.getPeliculasVistas().stream()
            .flatMap(peli -> peli.getSimilares().stream())
            .filter(similar -> !deco.yaLaVi(similar))
            .distinct()
            .collect(Collectors.toList());
        
        Collections.shuffle(candidatas);
        
        return candidatas.stream()
            .limit(3)
            .collect(Collectors.toList());
    }
}
