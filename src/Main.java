import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Administrador admin = new Administrador();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        // Crear algunos usuarios y un gestor para probar
        admin.crearUsuario("Carlos", "Programador");
        admin.crearUsuario("Ana", "Gestor");
        admin.crearUsuario("Juan", "Programador");

        while (!salir) {
            System.out.println("\nBienvenido a la gestión de proyectos:");
            System.out.println("1. Ingresar como Administrador");
            System.out.println("2. Ingresar como Gestor");
            System.out.println("3. Ingresar como Programador");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();  // Limpiar buffer

            switch (opcion) {
                case 1:
                    // Opciones para Administrador
                    boolean salirAdmin = false;
                    while (!salirAdmin) {
                        System.out.println("\nOpciones del Administrador:");
                        System.out.println("1. Crear usuario");
                        System.out.println("2. Eliminar usuario");
                        System.out.println("3. Listar usuarios");
                        System.out.println("4. Volver al menú principal");
                        System.out.print("Elige una opción: ");
                        int opcionAdmin = sc.nextInt();
                        sc.nextLine();  // Limpiar buffer

                        switch (opcionAdmin) {
                            case 1:
                                System.out.print("Introduce el nombre del usuario: ");
                                String nombre = sc.nextLine();
                                System.out.print("Introduce el rol del usuario (Gestor/Programador): ");
                                String rol = sc.nextLine();
                                admin.crearUsuario(nombre, rol);
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
                case 2:
                    // Aquí puedes añadir el código para el Gestor
                    System.out.println("Ingresaste como Gestor.");
                    break;
                case 3:
                    // Aquí puedes añadir el código para el Programador
                    System.out.println("Ingresaste como Programador.");
                    break;
                case 4:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }
}
