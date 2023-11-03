package tpColecciones.coleccionesAsociaciones;

import java.util.ArrayList;
import java.util.Scanner;

public class CargaNotas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Alumno> alumnos = new ArrayList<>();

        boolean salirAlumno = false;
        while (!salirAlumno) {
            System.out.println("INGRESE DATOS DEL ALUMNO");
            System.out.println("INGRESE NOMBRE COMPLETO:");
            String nombreCompleto = scanner.nextLine();
            System.out.println("INGRESE LEGAJO:");
            long legajo = scanner.nextLong();
            scanner.nextLine(); // Consumir la nueva línea después de nextLong()

            Alumno alumno = new Alumno(nombreCompleto, legajo);

            boolean salirNotas = false;
            while (!salirNotas) {
                System.out.println("INGRESE NOMBRE CATEDRA:");
                String catedra = scanner.nextLine();
                System.out.println("Nota:");
                double notaExamen = scanner.nextDouble();
                scanner.nextLine(); // Consumir la nueva línea después de nextDouble()

                Nota nota = new Nota(catedra, notaExamen);
                alumno.agregarNota(nota);

                System.out.println("DESEA SALIR DE LA CARGA DE NOTAS? (true/false)");
                salirNotas = scanner.nextBoolean();
                scanner.nextLine(); // Consumir la nueva línea después de nextBoolean()
            }

            alumnos.add(alumno);

            System.out.println("DESEA SALIR DE CARGA DE ALUMNOS? (true/false)");
            salirAlumno = scanner.nextBoolean();
            scanner.nextLine(); // Consumir la nueva línea después de nextBoolean()
        }

        System.out.println("-----------INFORMACIÓN DE ALUMNOS----------------");
        for (Alumno alumno : alumnos) {
            System.out.println("Datos Alumno: " + alumno);
        }
    }
}
