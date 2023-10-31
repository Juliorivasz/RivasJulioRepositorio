package tpColecciones;
import java.util.HashMap;
import java.util.Scanner;

public class AgendaTelefonica {
    private HashMap<String, Long> agenda = new HashMap<>();

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1- Cargar Datos en la Agenda");
            System.out.println("2- Buscar Teléfono por Nombre");
            System.out.println("3- Listar Agenda");
            System.out.println("4- Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer del scanner
            
            switch (opcion) {
                case 1:
                    cargarDatos();
                    break;
                case 2:
                    buscarTelefono();
                    break;
                case 3:
                    listarAgenda();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 4);
    }

    private void cargarDatos() {
        Scanner scanner = new Scanner(System.in);
        String nombre;
        long telefono;
        String respuesta;

        do {
            System.out.print("Ingrese el nombre completo: ");
            nombre = scanner.nextLine();
            System.out.print("Ingrese el número de teléfono: ");
            telefono = scanner.nextLong();
            scanner.nextLine();  // Limpiar el buffer del scanner

            if (agenda.containsKey(nombre)) {
                System.out.println("La persona ya está en la agenda.");
            } else {
                agenda.put(nombre, telefono);
                System.out.println("Persona agregada a la agenda.");
            }

            System.out.print("¿Desea agregar otra persona? (SI/NO): ");
            respuesta = scanner.nextLine().toUpperCase();
        } while (respuesta.equals("SI"));
    }

    private void buscarTelefono() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de la persona a buscar: ");
        String nombre = scanner.nextLine();
        
        if (agenda.containsKey(nombre)) {
            System.out.println("Teléfono de " + nombre + ": " + agenda.get(nombre));
        } else {
            System.out.println("La persona buscada no se encuentra en la agenda.");
        }
    }

    private void listarAgenda() {
        System.out.println("Agenda Telefónica:");
        for (String nombre : agenda.keySet()) {
            System.out.println(nombre + ": " + agenda.get(nombre));
        }
    }
}
