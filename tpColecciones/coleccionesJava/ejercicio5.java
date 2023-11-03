package tpColecciones.coleccionesJava;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese 10 dígitos enteros:");
        for (int i = 0; i < 10; i++) {
            numeros.add(scanner.nextInt());
        }
        
        ArrayList<Integer> ascendente = new ArrayList<>(numeros);
        ArrayList<Integer> descendente = new ArrayList<>(numeros);
        
        Collections.sort(ascendente);
        Collections.sort(descendente, Collections.reverseOrder());
        
        System.out.println("Lista en orden ascendente: " + ascendente);
        System.out.println("Lista en orden descendente: " + descendente);
    }
}

