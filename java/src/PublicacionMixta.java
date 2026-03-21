/**
* @author Lourdes Molina Caselles
* @author Agustín Muriel Sánchez
*/

import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;

public class PublicacionMixta extends Publicacion {

    private String texto;
    private String ruta;

    public PublicacionMixta(Usuario autor, String texto, String ruta, ArrayList<Etiqueta> etiquetas) {
        super(autor, etiquetas);
        this.texto = texto;
        this.ruta = ruta;
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
        try {
            File archivo = new File(ruta);
            if (archivo.exists()) {
                Desktop.getDesktop().open(archivo);
            } else {
                System.out.println("Archivo no encontrado");
            }
        } catch (Exception e) {
            System.out.println("No se pudo abrir el archivo");
        }
    }
}
