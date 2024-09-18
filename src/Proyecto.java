import java.util.ArrayList;

public class Proyecto {
    private String nombre;
    private ArrayList<Usuario> programadores;
    private ArrayList<Tarea> tareas;

    public Proyecto(String nombre) {
        this.nombre = nombre;
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

    public void listarTareas() {
        System.out.println("Tareas del proyecto " + nombre + ":");
        for (Tarea tarea : tareas) {
            System.out.println(tarea);
        }
    }

    @Override
    public String toString() {
        return nombre;
    }

    public Tarea[] getTareas() {
        return tareas.toArray(new Tarea[0]);
    }

    public void setTareas(ArrayList<Tarea> tareas) {
        this.tareas = tareas;
    }
}

