import java.util.ArrayList;

public class Programador {

    protected ArrayList<Proyecto> proyectosAsignados;

    public Programador(ArrayList<Proyecto> proyectos) {
        proyectosAsignados = proyectos;
    }

    // Consultar todos los proyectos en los que el programador está asignado
    public void consultarProyectos() {
        if (proyectosAsignados.isEmpty()) {
            System.out.println("Usuario no asignado a ningún proyecto.");
        } else {
            System.out.println("Proyectos asignados:");
            for (Proyecto proyecto : proyectosAsignados) {
                System.out.println(proyecto.getNombre());
            }
        }
    }

    // Marcar una tarea como finalizada
    public void marcarTareaComoFinalizada(Tarea tarea) {
        if (!tarea.getEstado())
        {
            tarea.marcarComoFinalizada();
        }
        else
        {
            System.out.println("Tarea " + tarea.getDescripcion() + " ya finalizada previamente.");
        }
    }
}
