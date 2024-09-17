import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Administrador admin = new Administrador();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        // Crear algunos usuarios predefinidos
        admin.crearUsuario("admin", "Administrador");  // El Administrador está predefinido
        admin.crearUsuario("Ana", "Gestor");
        admin.crearUsuario("Carlos", "Programador");

        while (!salir) {
            System.out.println("\nBienvenido a la gestión de proyectos.");
            System.out.print("Introduce tu nombre de usuario: ");
            String nombreUsuario = sc.nextLine();
            Usuario usuario = admin.buscarUsuario(nombreUsuario);

            if (usuario == null) {
                System.out.println("Usuario no encontrado.");
            } else {
                System.out.println("Bienvenido, " + usuario.getNombre() + ". Tu rol es: " + usuario.getRol());

                switch (usuario.getRol().toLowerCase()) {
                    case "administrador":
                        boolean salirAdmin = false;
                        while (!salirAdmin) {
                            System.out.println("\nOpciones del Administrador:");
                            System.out.println("1. Crear usuario");
                            System.out.println("2. Eliminar usuario");
                            System.out.println("3. Listar usuarios");
                            System.out.println("4. Volver al inicio");
                            System.out.print("Elige una opción: ");
                            int opcionAdmin = sc.nextInt();
                            sc.nextLine();  // Limpiar buffer

                            switch (opcionAdmin) {
                                case 1:
                                    System.out.print("Introduce el nombre del nuevo usuario: ");
                                    String nuevoNombre = sc.nextLine();
                                    System.out.print("Introduce el rol del nuevo usuario (Gestor/Programador): ");
                                    String nuevoRol = sc.nextLine();
                                    admin.crearUsuario(nuevoNombre, nuevoRol);
                                    break;
                                case 2:
                                    System.out.print("Introduce el nombre del usuario a eliminar: ");
                                    String nombreEliminar = sc.nextLine();
                                    admin.eliminarUsuario(nombreEliminar);
                                    break;
                                case 3:
                                    admin.listarUsuarios();
                                    break;
                                case 4:
                                    salirAdmin = true;
                                    break;
                                default:
                                    System.out.println("Opción no válida.");
                            }
                        }
                        break;

                    case "gestor":
                        // Aquí puedes añadir el código del Gestor
                        System.out.println("Ingresaste como Gestor.");
                        break;

                    case "programador":
                        // Aquí puedes añadir el código del Programador
                        System.out.println("Ingresaste como Programador.");
                        break;

                    default:
                        System.out.println("Rol no reconocido.");
                }
            }

            System.out.println("\n¿Quieres salir del sistema? (s/n)");
            String opcionSalir = sc.nextLine();
            if (opcionSalir.equalsIgnoreCase("s")) {
                salir = true;
                System.out.println("Saliendo del programa...");
            }
        }

        sc.close();
    }
}
