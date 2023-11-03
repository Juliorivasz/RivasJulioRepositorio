package tpColecciones.coleccionesJava;
import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio2 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese 20 números decimales:");
        for (int i = 0; i < 20; i++) {
            numeros.add(scanner.nextInt());
        }
        
        int max = numeros.get(0);
        int min = numeros.get(0);
        
        for (int numero : numeros) {
            if (numero > max) {
                max = numero;
            }
            if (numero < min) {
                min = numero;
            }
        }
        
        int rango = max - min;
        System.out.println("Mayor número: " + max);
        System.out.println("Menor número: " + min);
        System.out.println("Rango: " + rango);
    }
}
