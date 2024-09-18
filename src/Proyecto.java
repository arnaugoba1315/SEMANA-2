import java.util.ArrayList;

public class Proyecto {
    private String nombre;
    private ArrayList<Usuario> programadores;
    private Tarea[] tareas;

    public Proyecto(String nombre) {
        this.nombre = nombre;
        this.programadores = new ArrayList<>();
        this.tareas = new ArrayList<>().toArray(new Tarea[0]);
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
        try {
            tareas.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Tarea creada y asignada al programador " + programador.getNombre());
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
        return tareas;
    }

    public void setTareas(Tarea[] tareas) {
        this.tareas = tareas;
    }
}

