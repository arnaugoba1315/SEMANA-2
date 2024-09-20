import java.util.ArrayList;
public class Tarea {
    private final String descripcion;
    private final Usuario programador;
    private boolean finalizada;

    public Tarea(String descripcion, Usuario programador) {
        this.descripcion = descripcion;
        this.programador = programador;
        this.finalizada = false;
    }

    public void marcarComoFinalizada() {
        this.finalizada = true;
        System.out.println("Tarea " + descripcion + " finalizada por " + programador.getNombre());
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Usuario getProgramador()
    {
        return programador;
    }

    public boolean getEstado()
    {
        return finalizada;
    }
}
