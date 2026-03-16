
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RedSocial {
    private Usuario sesion;
    private Set<Usuario> usuarios;
    private List<Publicacion> publicaciones;

    public RedSocial() {
        usuarios = new HashSet<>();
        publicaciones = new ArrayList<>();
    }

    public boolean registrarUsuario(Usuario nuevoUsuario) {
        return usuarios.add(nuevoUsuario);
    }

}
