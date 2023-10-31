package Practica_integradora_2;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class CalculoBonoSueldo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> codigosIngresados = new ArrayList<>();
        String[][] haberes = {{"100", "Presentismo", "9"}, {"101", "Titulo Profesional", "9"},
                {"102", "Horas Extraordinarias", "M"}, {"103", "Horas Nocturnas", "M"}, {"104", "Otros Haberes", "M"}};
        String[][] deducciones = {{"200", "Obra Social", "3"}, {"201", "Jubilacion", "11"},
                {"202", "Sindicato", "2"}, {"203", "Seguro", "1.5"}, {"204", "Otros", "M"}};

        Empleado empleado = new Empleado();
        System.out.print("Ingrese nombre completo del empleado: ");
        empleado.setNombreEmpleado(scanner.nextLine());
        System.out.print("Ingrese CUIL del empleado: ");
        empleado.setCuil(Long.parseLong(scanner.nextLine()));
        System.out.print("Ingrese año de ingreso: ");
        int anioIngreso = Integer.parseInt(scanner.nextLine());
        while (anioIngreso > 2023) {
            System.out.println("El año de ingreso no puede ser mayor al año actual. Ingrese nuevamente.");
            System.out.print("Ingrese año de ingreso: ");
            anioIngreso = Integer.parseInt(scanner.nextLine());
        }
        empleado.setAnioIngreso(anioIngreso);
        System.out.print("Ingrese mes de liquidación: ");
        int mesLiquidacion = Integer.parseInt(scanner.nextLine());
        System.out.print("Ingrese año de liquidación: ");
        int anioLiquidacion = Integer.parseInt(scanner.nextLine());
        while (anioLiquidacion > 2023 || (anioLiquidacion == 2023 && mesLiquidacion > 10)) {
            System.out.println("La fecha de liquidación no puede ser mayor al mes actual. Ingrese nuevamente.");
            System.out.print("Ingrese mes de liquidación: ");
            mesLiquidacion = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese año de liquidación: ");
            anioLiquidacion = Integer.parseInt(scanner.nextLine());
        }

        BonoSueldo bonoSueldo = new BonoSueldo();
        bonoSueldo.setEmpleado(empleado);
        bonoSueldo.setMesLiquidacion(mesLiquidacion);
        bonoSueldo.setAnioLiquidacion(anioLiquidacion);

        String[][] bonoCalculado = new String[10][4];
        int row = 0;
        double sueldoBasico = empleado.getSueldoBasico();
        double montoAntiguedad = sueldoBasico * 0.02 * (anioLiquidacion - anioIngreso);

        while (true) {
            System.out.println("Ingrese los Haberes del Empleado");
            System.out.print("Ingrese el código del ítem (o 000 para finalizar): ");
            String codigo = scanner.nextLine();
            if (codigo.equals("000")) {
                if (row == 0) {
                    System.out.println("Debe ingresar al menos 1 haber.");
                    continue;
                } else {
                    break;
                }
            }

            if (codigosIngresados.contains(Integer.parseInt(codigo))) {
                System.out.println("El código ya ha sido cargado. Ingrese otro código.");
                continue;
            }

            String[][] arrayToSearch = haberes;
            boolean isDeduction = false;
            for (String[] item : deducciones) {
                if (item[0].equals(codigo)) {
                    arrayToSearch = deducciones;
                    isDeduction = true;
                    break;
                }
            }

            boolean found = false;
            for (String[] item : arrayToSearch) {
                System.out.print("Ingrese el monto o 'M' para porcentaje: ");
                String monto = scanner.nextLine();

                if (monto != null && !monto.trim().isEmpty()) {
                    double value;
                    if (monto.equals("M")) {
                        System.out.print("Ingrese el valor correspondiente: ");
                        monto = scanner.nextLine();
                        if (monto != null && !monto.trim().isEmpty()) {
                            value = Double.parseDouble(monto);
                        } else {
                            System.out.println("El valor ingresado es inválido. Ingrese nuevamente.");
                            continue; // Vuelve a solicitar el ingreso del código y el monto.
                        }
                    } else {
                        value = sueldoBasico * Double.parseDouble(monto);
                    }
                    bonoCalculado[row][0] = item[0];
                    bonoCalculado[row][1] = item[1];
                    bonoCalculado[row][2] = String.valueOf(value);
                    bonoCalculado[row][3] = isDeduction ? "-" : "+";
                    codigosIngresados.add(Integer.parseInt(codigo));
                    row++;
                    found = true;
                } else {
                    System.out.println("El valor ingresado es inválido. Ingrese nuevamente.");
                }

            }

            if (!found) {
                System.out.println("El código ingresado es incorrecto.");
            }
        }

        double totalHaberes = 0;
        double totalDeducciones = 0;

        for (String[] item : bonoCalculado) {
            if (item != null) {
                double monto = Double.parseDouble(item[2]);
                if (item[3].equals("+")) {
                    totalHaberes += monto;
                } else {
                    totalDeducciones += monto;
                }
            }
        }

        double montoLiquidacion = sueldoBasico + montoAntiguedad + totalHaberes - totalDeducciones;
        bonoSueldo.setMontoLiquidacion(montoLiquidacion);

        System.out.print("¿Desea generar otro bono de sueldo? (Sí/No): ");
        String respuesta = scanner.nextLine();
        while (respuesta.equalsIgnoreCase("Sí")) {
            // Reiniciar el proceso para un nuevo bono
            codigosIngresados.clear();
            row = 0;
            totalHaberes = 0;
            totalDeducciones = 0;

            System.out.print("Ingrese mes de liquidación: ");
            mesLiquidacion = Integer.parseInt(scanner.nextLine());
            System.out.print("Ingrese año de liquidación: ");
            anioLiquidacion = Integer.parseInt(scanner.nextLine());
            while (anioLiquidacion > 2023 || (anioLiquidacion == 2023 && mesLiquidacion > 10)) {
                System.out.println("La fecha de liquidación no puede ser mayor al mes actual. Ingrese nuevamente.");
                System.out.print("Ingrese mes de liquidación: ");
                mesLiquidacion = Integer.parseInt(scanner.nextLine());
                System.out.print("Ingrese año de liquidación: ");
                anioLiquidacion = Integer.parseInt(scanner.nextLine());
            }

            bonoSueldo.setMesLiquidacion(mesLiquidacion);
            bonoSueldo.setAnioLiquidacion(anioLiquidacion);

            while (true) {
                System.out.println("Ingrese los Haberes del Empleado");
                System.out.print("Ingrese el código del ítem (o 000 para finalizar): ");
                String codigo = scanner.nextLine();
                if (codigo.equals("000")) {
                    if (row == 0) {
                        System.out.println("Debe ingresar al menos 1 haber.");
                        continue;
                    } else {
                        break;
                    }
                }

                if (codigosIngresados.contains(Integer.parseInt(codigo))) {
                    System.out.println("El código ya ha sido cargado. Ingrese otro código.");
                    continue;
                }

                String[][] arrayToSearch = haberes;
                boolean isDeduction = false;
                for (String[] item : deducciones) {
                    if (item[0].equals(codigo)) {
                        arrayToSearch = deducciones;
                        isDeduction = true;
                        break;
                    }
                }

                boolean found = false;
                for (String[] item : arrayToSearch) {
                    if (item[0].equals(codigo)) {
                        System.out.print("Ingrese el monto o 'M' para porcentaje: ");
                        String monto = scanner.nextLine();
                        double value;
                        if (monto.equals("M")) {
                            System.out.print("Ingrese el valor correspondiente: ");
                            value = Double.parseDouble(scanner.nextLine());
                        } else {
                            value = sueldoBasico * Double.parseDouble(monto);
                        }
                        bonoCalculado[row][0] = item[0];
                        bonoCalculado[row][1] = item[1];
                        bonoCalculado[row][2] = String.valueOf(value);
                        bonoCalculado[row][3] = isDeduction ? "-" : "+";
                        codigosIngresados.add(Integer.parseInt(codigo));
                        row++;
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("El código ingresado es incorrecto.");
                }
            }

            for (String[] item : bonoCalculado) {
                if (item != null) {
                    double monto = Double.parseDouble(item[2]);
                    if (item[3].equals("+")) {
                        totalHaberes += monto;
                    } else {
                        totalDeducciones += monto;
                    }
                }
            }

            montoLiquidacion = sueldoBasico + montoAntiguedad + totalHaberes - totalDeducciones;
            bonoSueldo.setMontoLiquidacion(montoLiquidacion);

            System.out.print("¿Desea generar otro bono de sueldo? (Sí/No): ");
            respuesta = scanner.nextLine();
        }

        // Mostrar bonos de sueldo
        System.out.println("Nombre: " + empleado.getNombreEmpleado());
        System.out.println("CUIL: " + empleado.getCuil());
        System.out.println("Mes Liquidación: " + bonoSueldo.getMesLiquidacion() +
                " Año Liquidación: " + bonoSueldo.getAnioLiquidacion());
        System.out.println("Sueldo Básico: " + sueldoBasico);
        System.out.println("Año Ingreso: " + empleado.getAnioIngreso());
        System.out.println("Código  Ítem                 Denominación           Haberes/Deducciones");
        for (String[] item : bonoCalculado) {
            if (item != null) {
                System.out.printf("%-8s%-24s%-24s%-16s%n", item[0], item[1], item[2],
                        item[3].equals("+") ? "Haberes" : "Deducciones");
            }
        }
        System.out.println("SUB TOTAL: " + (sueldoBasico + montoAntiguedad + totalHaberes) +
                " " + totalDeducciones);
        System.out.println("NETO: " + montoLiquidacion);
    }
}
