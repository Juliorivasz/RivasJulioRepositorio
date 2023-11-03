package tpColecciones.coleccionesJava;
import java.util.ArrayList;
import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        int num;
        System.out.println("Ingrese números (ingrese un número menor a 0 para detenerse):");
        do {
            num = scanner.nextInt();
            if (num >= 0) {
                numeros.add(num);
            }
        } while (num >= 0);
        
        System.out.println("Números ingresados:");
        for (int numero : numeros) {
            System.out.println(numero);
        }
    }
}
