import java.util.ArrayList;

public class Programador {
    protected ArrayList<Proyecto> proyectosAsignados;

    public Programador() {
        proyectosAsignados = new ArrayList<>();
    }

    // Consultar todos los proyectos en los que el programador está asignado
    public void consultarProyectos() {
        if (proyectosAsignados.isEmpty()) {
            System.out.println("No estás asignado a ningún proyecto.");
        } else {
            System.out.println("Proyectos asignados:");
            for (Proyecto proyecto : proyectosAsignados) {
                System.out.println(proyecto.getNombre());
            }
        }
    }

    // Consultar todas las tareas asignadas en un proyecto
    public void consultarTareas(Proyecto proyecto) {
        proyecto.listarTareas();
    }

    // Marcar una tarea como finalizada
    public void marcarTareaComoFinalizada(Tarea tarea) {
        tarea.marcarComoFinalizada();
    }

    // Asignar un proyecto al programador
    public void asignarProyecto(Proyecto proyecto) {
        proyectosAsignados.add(proyecto);
    }
}
