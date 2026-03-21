/**
* @author 	Lourdes Molina Caselles
* @author Agustín Muriel Sánchez
*/

import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Publicacion {

    protected Usuario autor;
    protected ArrayList<Etiqueta> etiquetas;
    protected LocalDateTime fecha;

    public Publicacion(Usuario autor, ArrayList<Etiqueta> etiquetas) {
        this.autor = autor;
        this.etiquetas = etiquetas;
        this.fecha = LocalDateTime.now();
    }

    public Usuario getAutor() {
        return autor;
    }

    public ArrayList<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public abstract String resumen ();

    public abstract void mostrar();
}
