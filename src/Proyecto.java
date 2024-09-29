import java.util.ArrayList;
import java.util.Objects;

public class Proyecto {
    protected String nombre;
    protected String gestor;
    protected ArrayList<Usuario> programadores;
    protected ArrayList<Tarea> tareas;

    public Proyecto(String nombre, String gestor) {
        this.nombre = nombre;
        this.gestor = gestor;
        this.programadores = new ArrayList<>();
        this.tareas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Usuario> getProgramadores() {
        return programadores;
    }

    public void asignarProgramador(Usuario programador) {
        programadores.add(programador);
        System.out.println("Programador " + programador.getNombre() + " asignado al proyecto " + nombre);
    }

    public void crearTarea(String descripcion, Usuario programador) {
        Tarea nuevaTarea = new Tarea(descripcion, programador);
        tareas.add(nuevaTarea);  // Agregar la tarea a la lista de tareas del proyecto
        System.out.println("Tarea '" + descripcion + "' creada y asignada a " + programador.getNombre());
    }

    public void listarTareasAsignadas(Usuario usuario) {
        boolean tareaEncontrada = false;
        while (!tareaEncontrada)
        {
            for (Tarea tarea : tareas) {
                if (usuario.getNombre().equalsIgnoreCase(tarea.getProgramador().getNombre()) && !tarea.getEstado()) {
                    tareaEncontrada = true;
                }
            }
            break;
        }
        if (tareaEncontrada)
        {
            StringBuilder listaTareas = new StringBuilder("Tareas del proyecto " + nombre + " asignadas a " + usuario.getNombre() + ": ");
            for (Tarea tarea : tareas) {
                if (usuario.getNombre().equalsIgnoreCase(tarea.getProgramador().getNombre()) && !tarea.getEstado())
                {
                    listaTareas.append(tarea.getDescripcion()).append(", ");
                }
            }
            listaTareas.delete(listaTareas.length() - 2, listaTareas.length());
            System.out.print(listaTareas);
        }
        else
        {
            System.out.println("No hay tareas pendientes del proyecto " + nombre + " asignadas a " + usuario.getNombre() + ".");
        }
    }

    public Tarea[] getTareas() {
        return tareas.toArray(new Tarea[0]);
    }
}

