package tpColecciones;
import java.util.Scanner;

public class CostoComputadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String respuesta;

        do {
            Computadora computadora = new Computadora();
            System.out.print("Ingrese la marca de la computadora: ");
            computadora.marca = scanner.nextLine();
            System.out.print("Ingrese el modelo de la computadora: ");
            computadora.modelo = scanner.nextLine();

            System.out.print("Ingrese la cantidad de componentes de CPU: ");
            int numComponentes = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer del scanner

            for (int i = 0; i < numComponentes; i++) {
                System.out.print("Componente: ");
                String componente = scanner.nextLine();
                System.out.print("Marca: ");
                String marca = scanner.nextLine();
                System.out.print("Cantidad: ");
                int cantidad = scanner.nextInt();
                System.out.print("Precio por unidad: ");
                double precio = scanner.nextDouble();
                scanner.nextLine();  // Limpiar el buffer del scanner

                ComponenteCPU componenteCPU = new ComponenteCPU(componente, marca, cantidad, precio);
                computadora.componentes.add(componenteCPU);
            }

            double costoTotal = 0;
            for (ComponenteCPU componente : computadora.componentes) {
                costoTotal += componente.cantidad * componente.precio;
            }

            double precioVenta;
            if (costoTotal < 50000) {
                precioVenta = costoTotal + 0.4 * costoTotal;
            } else {
                precioVenta = costoTotal + 0.3 * costoTotal;
            }

            System.out.println("-----------Computadora----------------");
            System.out.println("Marca: " + computadora.marca);
            System.out.println("Modelo: " + computadora.modelo);
            System.out.println("Componentes:");
            System.out.printf("%-20s%-20s%-10s%-15s%-15s\n", "Componente", "Marca", "Cantidad", "Precio X Unidad", "SubTotal");
            for (ComponenteCPU componente : computadora.componentes) {
                System.out.printf("%-20s%-20s%-10s%-15s%-15s\n",
                        componente.componente, componente.marca, componente.cantidad, componente.precio,
                        componente.cantidad * componente.precio);
            }
            System.out.println("Costo Total " + costoTotal);
            System.out.println("El precio sugerido de venta es " + precioVenta);

            System.out.print("¿Desea cotizar una nueva computadora? (SI/NO): ");
            respuesta = scanner.nextLine().toUpperCase();
        } while (respuesta.equals("SI"));
    }
}

