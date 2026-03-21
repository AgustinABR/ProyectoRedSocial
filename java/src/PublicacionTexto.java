/**
* @author Lourdes Molina Caselles
* @author Agustín Muriel Sánchez
*/

import java.util.ArrayList;

public class PublicacionTexto extends Publicacion {

    private String texto;

    public PublicacionTexto(Usuario autor, String texto, ArrayList<Etiqueta> etiquetas) {
        super(autor, etiquetas);
        this.texto = texto;
    }

    @Override
    public String resumen() {
        if (texto.length() > 50) {
            return texto.substring(0, 50);
        }
        return texto;
    }

    @Override
    public void mostrar() {
        System.out.println("Texto:");
        System.out.println(texto);
    }
}
