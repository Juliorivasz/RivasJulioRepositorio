package tpColecciones.coleccionesAsociaciones.parte2;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuRestaurant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Plato> platosMenu = new ArrayList<>();

        boolean salirMenu = false;
        while (!salirMenu) {
            System.out.println("Ingrese nombre del plato:");
            String nombrePlato = scanner.nextLine();
            System.out.println("Ingrese precio del plato:");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Consumir la nueva línea después de nextDouble()

            System.out.println("¿Es una bebida? (true/false):");
            boolean esBebida = scanner.nextBoolean();
            scanner.nextLine(); // Consumir la nueva línea después de nextBoolean()

            Plato plato = new Plato(nombrePlato, precio, esBebida);

            if (!esBebida) {
                boolean salirIngredientes = false;
                while (!salirIngredientes) {
                    System.out.println("Ingrese nombre del ingrediente:");
                    String nombreIngrediente = scanner.nextLine();
                    System.out.println("Ingrese cantidad:");
                    double cantidad = scanner.nextDouble();
                    scanner.nextLine(); // Consumir la nueva línea después de nextDouble()
                    System.out.println("Ingrese unidad de medida:");
                    String unidadMedida = scanner.nextLine();

                    Ingrediente ingrediente = new Ingrediente(nombreIngrediente, cantidad, unidadMedida);
                    plato.agregarIngrediente(ingrediente);

                    System.out.println("¿Desea agregar otro ingrediente? (true/false):");
                    salirIngredientes = !scanner.nextBoolean();
                    scanner.nextLine(); // Consumir la nueva línea después de nextBoolean()
                }
            }

            platosMenu.add(plato);

            System.out.println("¿Desea agregar otro plato al menú? (true/false):");
            salirMenu = !scanner.nextBoolean();
            scanner.nextLine(); // Consumir la nueva línea después de nextBoolean()
        }

        System.out.println("-----------MENÚ DEL RESTAURANT----------------");
        for (Plato plato : platosMenu) {
            System.out.println(plato);
        }
    }
}
