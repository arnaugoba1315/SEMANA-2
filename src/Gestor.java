import java.util.ArrayList;

public class Gestor {
    private ArrayList<Proyecto> proyectos;
    private ArrayList<Usuario> programadores;

    public Gestor(ArrayList<Usuario> usuarios) {
        proyectos = new ArrayList<>();
        programadores = new ArrayList<>();

        // Filtrar solo los usuarios con rol "Programador"
        for (Usuario usuario : usuarios) {
            if (usuario.getRol().equalsIgnoreCase("Programador")) {
                programadores.add(usuario);
            }
        }
    }

    // Crear un nuevo proyecto
    public void crearProyecto(String nombre) {
        Proyecto nuevoProyecto = new Proyecto(nombre);
        proyectos.add(nuevoProyecto);
        System.out.println("Proyecto creado: " + nombre);
    }

    // Listar todos los proyectos del gestor
    public void listarProyectos() {
        if (proyectos.isEmpty()) {
            System.out.println("No hay proyectos.");
        } else {
            System.out.println("Proyectos del gestor:");
            for (Proyecto proyecto : proyectos) {
                System.out.println(proyecto);
            }
        }
    }

    // Listar programadores
    public void listarProgramadores() {
        if (programadores.isEmpty()) {
            System.out.println("No hay programadores disponibles.");
        } else {
            System.out.println("Lista de programadores:");
            for (Usuario programador : programadores) {
                System.out.println(programador.getNombre());
            }
        }
    }

    // Asignar un programador a un proyecto
    public void asignarProgramadorAProyecto(String nombreProyecto, String nombreProgramador) {
        Proyecto proyecto = buscarProyecto(nombreProyecto);
        Usuario programador = buscarProgramador(nombreProgramador);

        if (proyecto != null && programador != null) {
            proyecto.asignarProgramador(programador);
        }
    }

    // Crear una tarea en un proyecto
    public void crearTareaEnProyecto(String nombreProyecto, String descripcion, String nombreProgramador) {
        Proyecto proyecto = buscarProyecto(nombreProyecto);
        Usuario programador = buscarProgramador(nombreProgramador);

        if (proyecto != null && programador != null) {
            proyecto.crearTarea(descripcion, programador);
        }
    }

    // Buscar proyecto por nombre
    protected Proyecto buscarProyecto(String nombre) {
        for (Proyecto proyecto : proyectos) {
            if (proyecto.getNombre().equalsIgnoreCase(nombre)) {
                return proyecto;
            }
        }
        System.out.println("Proyecto no encontrado: " + nombre);
        return null;
    }

    // Buscar programador por nombre
    private Usuario buscarProgramador(String nombre) {
        for (Usuario programador : programadores) {
            if (programador.getNombre().equalsIgnoreCase(nombre)) {
                return programador;
            }
        }
        System.out.println("Programador no encontrado: " + nombre);
        return null;
    }
}
