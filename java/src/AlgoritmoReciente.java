/**
* @author 	Lourdes Molina Caselles
* @author Agustín Muriel Sánchez
*/

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlgoritmoReciente implements AlgoritmoPresentacion {

    @Override
    public List<Publicacion> obtenerContenido(Usuario usuario, List<Publicacion> publicaciones) {

        Collections.sort(publicaciones, new Comparator<Publicacion>() {
            @Override
            public int compare(Publicacion p1, Publicacion p2) {
                return p2.getFecha().compareTo(p1.getFecha());
            }
        });

        return publicaciones;
    }
}