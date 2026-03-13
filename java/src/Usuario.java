public class Usuario {
    private AlgoritmoPresentacion algoritmoSeleccionado;
    private String nombre;
    private String contrasenia;


    public Usuario(String nombre, String contrasenia, AlgoritmoPresentacion algoritmoSeleccionado) {
        this.algoritmoPresentacion = setAlgoritmoSeleccionado(algoritmoSeleccionado);
    }

    public AlgoritmoPresentacion getAlgoritmoSeleccionado() {
        return algoritmoSeleccionado;
    }

    public void setAlgoritmoSeleccionado(AlgoritmoPresentacion algoritmoSeleccionado) {
        this.algoritmoSeleccionado = algoritmoSeleccionado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }


}
