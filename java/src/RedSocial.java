/**
* @author Lourdes Molina Caselles
* @author Agustín Muriel Sánchez
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.io.File;

public class RedSocial {

    private Usuario sesion;
    private Set<Usuario> usuarios;
    private List<Publicacion> publicaciones;
    private Scanner sc;

    public RedSocial() {
        usuarios = new HashSet<>();
        publicaciones = new ArrayList<>();
        sc = new Scanner(System.in);
        cargarDatosPrueba();
    }

    public void iniciar() {
        while (true) {
            System.out.println("\n--- RED SOCIAL ---");
            System.out.println("1. Login");
            System.out.println("2. Registro");

            int op = sc.nextInt();
            sc.nextLine();

            if (op == 1) login();
            else registrar();

            if (sesion != null) menu();
        }
    }

    private void login() {
        System.out.print("Usuario: ");
        String nombre = sc.nextLine();

        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        for (Usuario u : usuarios) {
            if (u.getNombre().equals(nombre) && u.getContrasena().equals(pass)) {
                sesion = u;
                System.out.println("Login correcto");
                return;
            }
        }

        System.out.println("Error en login");
    }

    private void registrar() {
        System.out.print("Nuevo usuario: ");
        String nombre = sc.nextLine();

        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        Usuario u = new Usuario(nombre, pass);
        u.setAlgoritmo(new AlgoritmoReciente());

        if (usuarios.add(u)) {
            System.out.println("Usuario creado");
        } else {
            System.out.println("Ya existe");
        }
    }

    private void menu() {
        int op;

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Ver contenido");
            System.out.println("2. Crear contenido");
            System.out.println("3. Configuración");
            System.out.println("4. Logout");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1 -> verContenido();
                case 2 -> crearContenido();
                case 3 -> configuracion();
            }

        } while (op != 4);

        sesion = null;
    }

    private void verContenido() {
        List<Publicacion> feed = sesion.getAlgoritmo()
                .obtenerContenido(sesion, publicaciones);

        if (feed.isEmpty()) {
            System.out.println("No hay publicaciones disponibles.");
            return;
        }

        for (int i = 0; i < feed.size(); i++) {
            System.out.println(i + ". " + feed.get(i).resumen());
        }

        int i;
        do {
            System.out.print("Selecciona publicación (-1 para cancelar): ");
            i = sc.nextInt();
            sc.nextLine();
            if (i == -1) return;
        } while (i < 0 || i >= feed.size());

        Publicacion p = feed.get(i);
        p.mostrar();

        if (!p.getEtiquetas().isEmpty()) {
            sesion.agregarInteres(p.getEtiquetas().get(0));
        }

        System.out.println("¿Seguir autor? (s/n)");
        String r = sc.nextLine();
        if (r.equalsIgnoreCase("s")) {
            sesion.seguirUsuario(p.getAutor());
        }
    }

    private void crearContenido() {
        System.out.print("Texto (enter vacío si no): ");
        String texto = sc.nextLine();

        System.out.print("Ruta archivo (enter vacío si no): ");
        String ruta = sc.nextLine();

        if (texto.isEmpty() && ruta.isEmpty()) {
            System.out.println("No ingresaste texto ni archivo. Cancelando creación.");
            return;
        }

        ArrayList<Etiqueta> etiquetas = new ArrayList<>();
        etiquetas.add(Etiqueta.TECNOLOGIA);

        Publicacion p;

        if (!texto.isEmpty() && !ruta.isEmpty()) {
            File archivo = new File(ruta);
            if (!archivo.exists()) {
                System.out.println("Archivo no encontrado. Creando publicación solo con texto.");
                p = new PublicacionTexto(sesion, texto, etiquetas);
            } else {
                p = new PublicacionMixta(sesion, texto, ruta, etiquetas);
            }
        } else if (!texto.isEmpty()) {
            p = new PublicacionTexto(sesion, texto, etiquetas);
        } else {
            File archivo = new File(ruta);
            if (!archivo.exists()) {
                System.out.println("Archivo no encontrado. No se puede crear publicación.");
                return;
            }
            p = new PublicacionArchivo(sesion, ruta, etiquetas);
        }

        publicaciones.add(p);
        System.out.println("Publicación creada correctamente.");
    }

    private void configuracion() {
        System.out.println("Selecciona algoritmo de presentación:");
        System.out.println("1. Intereses");
        System.out.println("2. Reciente");
        System.out.println("3. Seguidos");

        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1 -> sesion.setAlgoritmo(new AlgoritmoInteres());
            case 2 -> sesion.setAlgoritmo(new AlgoritmoReciente());
            case 3 -> sesion.setAlgoritmo(new AlgoritmoSeguido());
        }
    }

    private void cargarDatosPrueba() {
        Usuario u1 = new Usuario("ana", "123");
        Usuario u2 = new Usuario("juan", "123");

        u1.setAlgoritmo(new AlgoritmoReciente());
        u2.setAlgoritmo(new AlgoritmoReciente());

        usuarios.add(u1);
        usuarios.add(u2);

        ArrayList<Etiqueta> etMusica = new ArrayList<>();
        etMusica.add(Etiqueta.MUSICA);

        ArrayList<Etiqueta> etViajes = new ArrayList<>();
        etViajes.add(Etiqueta.VIAJES);

        ArrayList<Etiqueta> etTecnologia = new ArrayList<>();
        etTecnologia.add(Etiqueta.TECNOLOGIA);

        publicaciones.add(new PublicacionTexto(u1, "Hola mundo desde Java", etMusica));
        publicaciones.add(new PublicacionTexto(u2, "Me gusta viajar mucho", etViajes));

        publicaciones.add(new PublicacionArchivo(u1, "java/archivosPrueba/bmw.jpg", etTecnologia));
        publicaciones.add(new PublicacionMixta(u2, "Documento + imagen", "java/archivosPrueba/textoImagen.pdf", etTecnologia));
    }
}