/**
* @author 	Lourdes Molina Caselles
* @author Agustín Muriel Sánchez
*/

import java.util.List;

public interface AlgoritmoPresentacion {
    List<Publicacion> obtenerContenido(Usuario usuario, List<Publicacion> publicaciones);

}
