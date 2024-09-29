import java.util.ArrayList;

public class Administrador {
    private final ArrayList<Usuario> usuarios;

    public Administrador() {
        usuarios = new ArrayList<>();
    }

    // Crear un nuevo usuario
    public void crearUsuario(String nombre, String rol) {
        // Verificar si ya existe un usuario con el mismo nombre
        if (buscarUsuario(nombre) != null) {
            System.out.println("Error: Ya existe un usuario con el nombre '" + nombre + "'. No se puede crear otro usuario con el mismo nombre.");
        } else {
            Usuario nuevoUsuario = new Usuario(nombre, rol);
            usuarios.add(nuevoUsuario);  // Añadir el nuevo usuario a la lista
            System.out.println("Usuario '" + nombre + "' creado con el rol '" + rol + "'.");
        }
    }

    // Eliminar un usuario por nombre
    public void eliminarUsuario(String nombre) {
        Usuario usuario = buscarUsuario(nombre);
        if (usuario != null) {
            usuarios.remove(usuario);
            System.out.println("Usuario eliminado: " + nombre);
        } else {
            System.out.println("Usuario no encontrado: " + nombre);
        }
    }

    // Listar todos los usuarios
    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios.");
        } else {
            System.out.println("Lista de usuarios:");
            for (Usuario usuario : usuarios) {
                System.out.println(usuario.getNombre() + " - " + usuario.getRol());
            }
        }
    }

    // Buscar un usuario por nombre
    public Usuario buscarUsuario(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                return usuario;
            }
        }
        return null; // No se encontró el usuario
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

}
