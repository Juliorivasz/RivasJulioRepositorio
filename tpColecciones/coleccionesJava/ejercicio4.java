package tpColecciones.coleccionesJava;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        Random random = new Random();
        
        for (int i = 0; i < 50; i++) {
            numeros.add(random.nextInt(100) + 1);
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el valor que desea buscar: ");
        int valorBuscado = scanner.nextInt();
        
        boolean encontrado = false;
        int posicion = -1;
        
        for (int i = 0; i < numeros.size(); i++) {
            if (numeros.get(i) == valorBuscado) {
                encontrado = true;
                posicion = i;
                break;
            }
        }
        
        if (encontrado) {
            System.out.println("El valor " + valorBuscado + " se encuentra en la posición " + posicion);
        } else {
            System.out.println("El valor " + valorBuscado + " no se encuentra en la lista.");
        }
    }
}

