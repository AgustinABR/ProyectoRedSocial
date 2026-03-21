/**
* @author 	Lourdes Molina Caselles
* @author Agustín Muriel Sánchez
*/

import java.util.ArrayList;

public class Usuario {

    private String nombre;
    private String contrasena;
    private ArrayList<Usuario> seguidos;
    private ArrayList<Etiqueta> intereses;
    private AlgoritmoPresentacion algoritmo;

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

    public ArrayList<Etiqueta> getIntereses() {
        return intereses;
    }

    public void seguirUsuario(Usuario u) {
        if (!seguidos.contains(u)) {
            seguidos.add(u);
        }
    }

    public void agregarInteres(Etiqueta interes) {
        intereses.clear();
        intereses.add(interes);
    }

    public AlgoritmoPresentacion getAlgoritmo() {
        return algoritmo;
    }

    public void setAlgoritmo(AlgoritmoPresentacion algoritmo) {
        this.algoritmo = algoritmo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Usuario)) return false;
        Usuario u = (Usuario) o;
        return nombre.equals(u.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}