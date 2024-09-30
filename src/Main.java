import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Administrador admin = new Administrador();
        ArrayList<Proyecto> proyectos = new ArrayList<>();
        Gestor gestor = new Gestor(admin.getUsuarios(), proyectos);
        Programador programador = new Programador(proyectos);
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        boolean sesioniniciada;

        // Crear algunos usuarios predefinidos
        admin.crearUsuario("admin", "Administrador");  // El Administrador está predefinido
        admin.crearUsuario("Ana", "Gestor");
        admin.crearUsuario("Carlos", "Programador");
        admin.crearUsuario("Juan", "Programador");

        while (!salir) {
            System.out.println("\nBienvenido a la gestión de proyectos.");
            System.out.print("Introduce tu nombre de usuario: ");
            String nombreUsuario = sc.nextLine().toLowerCase();
            Usuario usuario = admin.buscarUsuario(nombreUsuario);

            if (usuario == null) {
                System.out.println("Usuario no encontrado.");
            }
            else
            {
                sesioniniciada = true;
                while (sesioniniciada)
                {
                    System.out.println("Bienvenido, " + usuario.getNombre() + ". Tu rol es: " + usuario.getRol());

                    switch (usuario.getRol().toLowerCase()) {
                        case "administrador":
                            boolean salirAdmin = false;
                            while (!salirAdmin) {
                                System.out.println("\nOpciones del Administrador:");
                                System.out.println("1. Crear usuario");
                                System.out.println("2. Eliminar usuario");
                                System.out.println("3. Listar usuarios");
                                System.out.println("4. Cerrar sesión");
                                System.out.print("Elige una opción: ");
                                int opcionAdmin = sc.nextInt();
                                sc.nextLine();  // Limpiar buffer

                                switch (opcionAdmin) {
                                    case 1:
                                        admin.listarUsuarios();
                                        System.out.print("Introduce el nombre del nuevo usuario: ");
                                        String nuevoNombre = sc.nextLine();
                                        System.out.print("Introduce el rol del nuevo usuario (Gestor/Programador): ");
                                        String nuevoRol = sc.nextLine();
                                        admin.crearUsuario(nuevoNombre, nuevoRol);
                                        break;
                                    case 2:
                                        admin.listarUsuarios();
                                        System.out.print("Introduce el nombre del usuario a eliminar: ");
                                        String nombreEliminar = sc.nextLine();
                                        admin.eliminarUsuario(nombreEliminar);
                                        break;
                                    case 3:
                                        admin.listarUsuarios();
                                        break;
                                    case 4:
                                        salirAdmin = true;
                                        sesioniniciada = false;
                                        break;
                                    default:
                                        System.out.println("Opción no válida.");
                                }
                            }
                            break;

                        case "gestor":
                            // Iniciar sesión como gestor
                            gestor.getUsuarios(admin.getUsuarios());  // Obtener los usuarios desde el administrador
                            boolean salirGestor = false;

                            while (!salirGestor) {
                                System.out.println("\nOpciones del Gestor:");
                                System.out.println("1. Crear proyecto");
                                System.out.println("2. Listar proyectos");
                                System.out.println("3. Listar programadores");
                                System.out.println("4. Asignar programador a proyecto");
                                System.out.println("5. Crear tarea en un proyecto");
                                System.out.println("6. Listar programadores asignados a proyecto");
                                System.out.println("7. Cerrar sesión");
                                System.out.print("Elige una opción: ");
                                int opcionGestor = sc.nextInt();
                                sc.nextLine();  // Limpiar buffer

                                switch (opcionGestor) {
                                    case 1:
                                        gestor.Proyectos();
                                        System.out.print("Introduce el nombre del proyecto: ");
                                        String nombreProyecto = sc.nextLine();
                                        gestor.crearProyecto(nombreProyecto, nombreUsuario);
                                        break;
                                    case 2:
                                        gestor.listarProyectos(nombreUsuario);
                                        break;
                                    case 3:
                                        gestor.listarProgramadores();
                                        break;
                                    case 4:
                                        gestor.Proyectos();
                                        System.out.print("Introduce el nombre del proyecto: ");
                                        String proyectoAsignar = sc.nextLine();
                                        System.out.print("Introduce el nombre del programador: ");
                                        String programadorAsignar = sc.nextLine();
                                        gestor.asignarProgramadorAProyecto(proyectoAsignar, programadorAsignar);
                                        break;
                                    case 5:
                                        gestor.Proyectos();
                                        System.out.print("Introduce el nombre del proyecto: ");
                                        String proyectoTarea = sc.nextLine();
                                        System.out.print("Introduce la descripción de la tarea: ");
                                        String descripcion = sc.nextLine();
                                        System.out.print("Introduce el nombre del programador: ");
                                        String programadorTarea = sc.nextLine();
                                        gestor.crearTareaEnProyecto(proyectoTarea, descripcion, programadorTarea);
                                        break;
                                    case 6:
                                        if (proyectos.isEmpty())
                                        {
                                            System.out.print("No existe ningún proyecto creado");
                                            break;
                                        }
                                        gestor.Proyectos();
                                        System.out.print("Introduce el nombre del proyecto: ");
                                        String proyectoAsignado = sc.nextLine();
                                        gestor.listarProgramadoresAsignados(proyectoAsignado);
                                        break;
                                    case 7:
                                        salirGestor = true;
                                        sesioniniciada = false;
                                        break;
                                    default:
                                        System.out.println("Opción no válida.");
                                }
                            }
                            break;

                        case "programador":
                            // Iniciar sesión como programador
                            boolean salirProgramador = false;

                            while (!salirProgramador) {
                                System.out.println("\nOpciones del Programador:");
                                System.out.println("1. Consultar proyectos asignados");
                                System.out.println("2. Consultar tareas en un proyecto");
                                System.out.println("3. Marcar tarea como finalizada");
                                System.out.println("4. Cerrar sesión");
                                System.out.print("Elige una opción: ");
                                int opcionProgramador = sc.nextInt();
                                sc.nextLine();  // Limpiar buffer

                                switch (opcionProgramador) {
                                    case 1:
                                        programador.consultarProyectos();
                                        break;
                                    case 2:
                                        gestor.Proyectos();
                                        System.out.print("Introduce el nombre del proyecto: ");
                                        String nombreProyectoConsultar = sc.nextLine();
                                        Proyecto proyectoaConsultar = gestor.buscarProyecto(nombreProyectoConsultar);
                                        if (proyectoaConsultar != null)
                                        {
                                            proyectoaConsultar.listarTareasAsignadas(usuario);
                                        }
                                        break;
                                    case 3:
                                        gestor.Proyectos();
                                        System.out.print("Introduce el nombre del proyecto: ");
                                        String nombreProyectoFinalizar = sc.nextLine();
                                        Proyecto proyectoFinalizar = gestor.buscarProyecto(nombreProyectoFinalizar);
                                        if (proyectoFinalizar != null) {
                                            System.out.print("Introduce la descripción de la tarea a finalizar: ");
                                            String descripcionTarea = sc.nextLine();
                                            Tarea tareaFinalizar = null;
                                            for (Tarea tarea : proyectoFinalizar.getTareas()) {
                                                if (tarea.getDescripcion().equalsIgnoreCase(descripcionTarea) && tarea.getProgramador().getNombre().equalsIgnoreCase(usuario.getNombre())) {
                                                    tareaFinalizar = tarea;
                                                    break;
                                                }
                                            }
                                            if (tareaFinalizar != null) {
                                                programador.marcarTareaComoFinalizada(tareaFinalizar);
                                            }
                                            else {
                                                System.out.println("Tarea no encontrada.");
                                            }
                                        }
                                        break;
                                    case 4:
                                        salirProgramador = true;
                                        sesioniniciada = false;
                                        break;
                                    default:
                                        System.out.println("Opción no válida.");
                                }
                            }
                            break;

                        default:
                            System.out.println("Rol no reconocido.");
                    }
                }
                System.out.println("\nSesión cerrada.");
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
