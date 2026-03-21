import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlgoritmoInteres implements AlgoritmoPresentacion {

    @Override
    public List<Publicacion> obtenerContenido(Usuario usuario, List<Publicacion> publicaciones) {

        Collections.sort(publicaciones, new Comparator<Publicacion>() {
            @Override
            public int compare(Publicacion p1, Publicacion p2) {

                int c1 = contarCoincidencias(usuario, p1);
                int c2 = contarCoincidencias(usuario, p2);

                return Integer.compare(c2, c1);
            }
        });

        return publicaciones;
    }

    private int contarCoincidencias(Usuario usuario, Publicacion p) {
        int contador = 0;
        for (Etiqueta e : p.getEtiquetas()) {
            if (usuario.getIntereses().contains(e)) {
                contador++;
            }
        }
        return contador;
    }
}