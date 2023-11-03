package tpColecciones.coleccionesJava;

import java.util.Scanner;

public class ejercicio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Matriz matriz = new Matriz();

        while (true) {
            System.out.print("Ingrese un valor para la celda (o 'FIN' para salir): ");
            String valor = scanner.next();

            if (valor.equals("FIN")) {
                break;
            }

            System.out.print("Ingrese la fila: ");
            int fila = scanner.nextInt();
            System.out.print("Ingrese la columna: ");
            int columna = scanner.nextInt();

            Celda celda = new Celda(fila, columna, valor);
            matriz.agregarCelda(celda);
        }

        System.out.println("Valores cargados en matrizCuadrada:");
        for (Celda celda : matriz.matrizCuadrada) {
            System.out.println("Fila: " + celda.fila + ", Columna: " + celda.columna + ", Valor: " + celda.valor);
        }

        System.out.print("Ingrese la fila para buscar: ");
        int filaBuscada = scanner.nextInt();
        System.out.print("Ingrese la columna para buscar: ");
        int columnaBuscada = scanner.nextInt();

        String valorEncontrado = matriz.obtenerValor(filaBuscada, columnaBuscada);
        System.out.println("Valor encontrado: " + valorEncontrado);
    }
}
