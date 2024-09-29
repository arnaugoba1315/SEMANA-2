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
            StringBuilder listaProyectos = new StringBuilder("Proyectos asignados: ");
            for (Proyecto proyecto : proyectosAsignados) {
                listaProyectos.append(proyecto.getNombre()).append(", ");
            }
            listaProyectos.delete(listaProyectos.length() - 2, listaProyectos.length());
            System.out.print(listaProyectos);
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
