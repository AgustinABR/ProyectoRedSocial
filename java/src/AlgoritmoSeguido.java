/**
* @author Lourdes Molina Caselles
* @author Agustín Muriel Sánchez
*/

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlgoritmoSeguido implements AlgoritmoPresentacion {

    @Override
    public List<Publicacion> obtenerContenido(Usuario usuario, List<Publicacion> publicaciones) {

        Collections.sort(publicaciones, new Comparator<Publicacion>() {
            @Override
            public int compare(Publicacion p1, Publicacion p2) {

                boolean p1Seguido = usuario.getSeguidos().contains(p1.getAutor());
                boolean p2Seguido = usuario.getSeguidos().contains(p2.getAutor());

                if (p1Seguido && !p2Seguido) return -1;
                if (!p1Seguido && p2Seguido) return 1;
                return 0;
            }
        });

        return publicaciones;
    }
}