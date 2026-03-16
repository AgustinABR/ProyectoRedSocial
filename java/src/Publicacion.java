import java.time.LocalDateTime;
import java.util.ArrayList;

public abstract class Publicacion {

    protected Usuario autor;
    protected ArrayList<String> etiquetas;
    protected LocalDateTime fecha;

    public Publicacion(Usuario autor, ArrayList<String> etiquetas) {
        this.autor = autor;
        this.etiquetas = etiquetas;
        this.fecha = LocalDateTime.now();
    }

    public Usuario getAutor() {
        return autor;
    }

    public ArrayList<String> getEtiquetas() {
        return etiquetas;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public abstract String resumen ();

    public abstract void mostrar();
}
