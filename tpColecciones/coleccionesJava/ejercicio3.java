package tpColecciones.coleccionesJava;
import java.util.ArrayList;
import java.util.Random;

public class ejercicio3 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        Random random = new Random();
        
        for (int i = 0; i < 20; i++) {
            numeros.add(random.nextInt(50) * 2 + 1);
        }
        
        int suma = 0;
        for (int numero : numeros) {
            suma += numero;
        }
        double promedio = (double) suma / numeros.size();
        
        int igualPromedio = 0;
        int mayorPromedio = 0;
        int menorPromedio = 0;
        
        for (int numero : numeros) {
            if (numero == promedio) {
                igualPromedio++;
            } else if (numero > promedio) {
                mayorPromedio++;
            } else {
                menorPromedio++;
            }
        }
        
        System.out.println("Promedio aritmético: " + promedio);
        System.out.println("Números iguales al promedio: " + igualPromedio);
        System.out.println("Números mayores que el promedio: " + mayorPromedio);
        System.out.println("Números menores que el promedio: " + menorPromedio);
    }
}

