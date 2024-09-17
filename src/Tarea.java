public class Tarea {
    private String descripcion;
    private Usuario programador;
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

    @Override
    public String toString() {
        return "Tarea: " + descripcion + ", Programador: " + programador.getNombre() + ", Finalizada: " + finalizada;
    }
}
