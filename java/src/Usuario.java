import java.util.ArrayList;

public class Usuario {

    private String nombre;
    private String contrasena;
    private ArrayList<Usuario> seguidos;
    private ArrayList<String> intereses;

    public Usuario(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.seguidos = new ArrayList<>();
        this.intereses = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public ArrayList<Usuario> getSeguidos() {
        return seguidos;
    }

    public ArrayList<String> getIntereses() {
        return intereses;
    }

    public void seguirUsuario(Usuario u) {
        if (!seguidos.contains(u)) {
            seguidos.add(u);
        }
    }

    public void agregarInteres(String interes) {
        intereses.clear();
        intereses.add(interes);
    }
}