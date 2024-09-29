import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.lang.System;

public class Gestor {
    protected ArrayList<Proyecto> proyectos;
    protected ArrayList<Usuario> programadores;

    public Gestor(ArrayList<Usuario> usuarios, ArrayList<Proyecto> proyectos) {
        getUsuarios(usuarios);
        this.proyectos = proyectos;
    }

    public void getUsuarios(ArrayList<Usuario> usuarios)
    {
        programadores = new ArrayList<>();

        // Filtrar solo los usuarios con rol "Programador"
        for (Usuario usuario : usuarios) {
            if (usuario.getRol().equalsIgnoreCase("Programador")) {
                programadores.add(usuario);
            }
        }
    }
    // Crear un nuevo proyecto
    public void crearProyecto(String nombre, String gestor) {
        Proyecto nuevoProyecto = new Proyecto(nombre, gestor);
        proyectos.add(nuevoProyecto);
        System.out.println("Proyecto creado con el nombre " + nombre + " administrado por " + gestor);
    }

    // Listar todos los proyectos del gestor
    public void listarProyectos(String gestor) {
        if (proyectos.isEmpty()) {
            System.out.println("No hay proyectos.");
        } else {
            StringBuilder listaProyectos = new StringBuilder("Proyectos del gestor: " );
            for (int i = 0; i < proyectos.size(); i++)
            {
                if (Objects.equals(proyectos.get(i).gestor, gestor))
                {
                    listaProyectos.append(proyectos.get(i).nombre).append(", ");
                }
            }
            listaProyectos.delete(listaProyectos.length() - 2, listaProyectos.length());
            System.out.print(listaProyectos);
        }
    }

    // Listar programadores
    public void listarProgramadores() {
        if (programadores.isEmpty()) {
            System.out.println("No hay programadores disponibles.");
        } else {
            StringBuilder listaProgramadores = new StringBuilder("Lista de programadores: " );
            for (Usuario programador : programadores) {
                listaProgramadores.append(programador.getNombre()).append(", ");
            }
            listaProgramadores.delete(listaProgramadores.length() - 2, listaProgramadores.length());
            System.out.print(listaProgramadores);
        }
    }

    public void listarProgramadoresAsignados(String nombreProyecto)
    {
        Proyecto proyecto = buscarProyecto(nombreProyecto);
        if (proyecto.getProgramadores() != null)
        {
            int i = 0;
            StringBuilder listaProgramadoresAsignados = new StringBuilder();
            while (i < proyecto.getProgramadores().size()) {
                listaProgramadoresAsignados.append(proyecto.getProgramadores().get(i).getNombre()).append(", ");
                i++;
            }
            listaProgramadoresAsignados.delete(listaProgramadoresAsignados.length() - 2, listaProgramadoresAsignados.length());
            System.out.print(listaProgramadoresAsignados);
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
        System.out.println("Proyecto " + nombre + " no encontrado.");
        return null;
    }

    // Buscar programador por nombre
    private Usuario buscarProgramador(String nombre) {
        for (Usuario programador : programadores) {
            if (programador.getNombre().equalsIgnoreCase(nombre)) {
                return programador;
            }
        }
        System.out.println("Programador " + nombre + " no encontrado.");
        return null;
    }
}
