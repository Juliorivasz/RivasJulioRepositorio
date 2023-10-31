package tpMutantes;
import java.util.Scanner;

public class DetectorMutante {

    public static void main(String[] args) {
        String[] dna = new String[6];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese las filas de la matriz de ADN:");
        for (int i = 0; i < 6; i++) {
            System.out.print("Fila " + (i + 1) + ": ");
            dna[i] = scanner.nextLine();
        }

        if (esMutante(dna)) {
            System.out.println("¡El humano es un mutante!");
        } else {
            System.out.println("El humano NO es un mutante.");
        }
    }

    public static boolean esMutante(String[] dna) {
        int count = 0;

        // Verificar horizontal y verticalmente
        for (int i = 0; i < 6; i++) {
            // Horizontal
            count += contarSecuenciasMutantes(dna[i]);

            // Vertical
            StringBuilder columna = new StringBuilder();
            for (int j = 0; j < 6; j++) {
                columna.append(dna[j].charAt(i));
            }
            count += contarSecuenciasMutantes(columna.toString());
        }

        // Verificar diagonalmente (de izquierda a derecha)
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                StringBuilder diagonal = new StringBuilder();
                for (int k = 0; k < 4; k++) {
                    diagonal.append(dna[i + k].charAt(j + k));
                }
                count += contarSecuenciasMutantes(diagonal.toString());
            }
        }

        // Verificar diagonalmente (de derecha a izquierda)
        for (int i = 0; i <= 2; i++) {
            for (int j = 3; j < 6; j++) {
                StringBuilder diagonal = new StringBuilder();
                for (int k = 0; k < 4; k++) {
                    diagonal.append(dna[i + k].charAt(j - k));
                }
                count += contarSecuenciasMutantes(diagonal.toString());
            }
        }

        return count > 1;
    }

    private static int contarSecuenciasMutantes(String secuencia) {
        int count = 0;
        for (int i = 0; i <= secuencia.length() - 4; i++) {
            if (secuencia.charAt(i) == secuencia.charAt(i + 1) &&
                secuencia.charAt(i) == secuencia.charAt(i + 2) &&
                secuencia.charAt(i) == secuencia.charAt(i + 3)) {
                count++;
            }
        }
        return count;
    }
}

