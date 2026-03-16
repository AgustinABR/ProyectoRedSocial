import java.util.ArrayList;
import java.awt.Desktop;
import java.io.File;

public class PublicacionArchivo extends Publicacion {

    private String ruta;

    public PublicacionArchivo(Usuario autor, String ruta, ArrayList<String> etiquetas) {
        super(autor, etiquetas);
        this.ruta = ruta;
    }

    @Override
    public String resumen() {
        return "Archivo: " + ruta;
    }

    @Override
    public void mostrar() {
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