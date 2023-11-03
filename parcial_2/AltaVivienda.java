import java.util.HashMap;
import java.util.Scanner;

public class AltaVivienda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String calle = "";
        String provincia;
        int nroCalle = 0;
        String nroCalleStr;
        boolean continuar = true;

        String[][] tiposAmbiente = {{"P", "Pieza"}, {"B", "Baño"}, {"C", "Cocina"}, {"PA", "Patio"},
            {"L", "Lavanderia"}};

        HashMap<String, String> provinciasMap = new HashMap<>();
            provinciasMap.put("1", "Buenos Aires");
            provinciasMap.put("2", "Catamarca");
            provinciasMap.put("3", "Chaco");
            provinciasMap.put("4", "Chubut");
            provinciasMap.put("5", "Córdoba");
            provinciasMap.put("6", "Corrientes");
            provinciasMap.put("7", "Entre Ríos");
            provinciasMap.put("8", "Formosa");
            provinciasMap.put("9", "Jujuy");
            provinciasMap.put("10", "La Pampa");
            provinciasMap.put("11", "La Rioja");
            provinciasMap.put("12", "Mendoza");
            provinciasMap.put("13", "Misiones");
            provinciasMap.put("14", "Neuquén");
            provinciasMap.put("15", "Río Negro");
            provinciasMap.put("16", "Salta");
            provinciasMap.put("17", "San Juan");
            provinciasMap.put("18", "San Luis");
            provinciasMap.put("19", "Santa Cruz");
            provinciasMap.put("20", "Santa Fe");
            provinciasMap.put("21", "Santiago del Estero");
            provinciasMap.put("22", "Tierra del Fuego");
            provinciasMap.put("23", "Tucumán");

        while (continuar) {
            System.out.println("Ingrese la calle de la vivienda:");
            calle = scanner.nextLine();
            if (calle == "") {
                continue;
            }
            break;
        }

        while (continuar) {
            System.out.println("Ingrese el número de la calle:");
            nroCalleStr = scanner.nextLine();
            if (nroCalleStr == "") {
                continue;
            }
            nroCalle = Integer.parseInt(nroCalleStr);
            break;
        }

        do {
            System.out.println("Ingrese el código de la provincia (entre 1 y 23):");
            int provinciaCode = Integer.parseInt(scanner.nextLine());
            provincia = provinciasMap.get(String.valueOf(provinciaCode));

            if (provinciaCode < 1 || provinciaCode > 23) {
                System.out.println("Código de provincia inválido. Intente nuevamente.");
                provincia = null;
            }
        } while (provincia == null);

        Vivienda vivienda = new Vivienda(calle, nroCalle, provincia);

        do {
            System.out.println("Ingrese el tipo de ambiente (Código):");
            String tipoAmbienteCodigo = scanner.nextLine();
            String tipoAmbiente = null;
            for (String[] tipo : tiposAmbiente) {
                if (tipo[0].equals(tipoAmbienteCodigo)) {
                    tipoAmbiente = tipo[1];
                    break;
                }
            }

            if (tipoAmbiente == null) {
                System.out.println("Tipo de ambiente inválido. Intente nuevamente.");
                continue;
            }

            System.out.println("Ingrese los metros cuadrados del ambiente:");
            double metrosCuadrados = Double.parseDouble(scanner.nextLine());

            if (metrosCuadrados <= 0) {
                System.out.println("Metros cuadrados inválidos. Intente nuevamente.");
                continue;
            }

            Ambiente ambiente = new Ambiente(tipoAmbiente, metrosCuadrados);
            vivienda.agregarAmbiente(ambiente);

            if (!tipoAmbienteCodigo.equals("B")) {
                System.out.println("El tipo de ambiente elegido incluye un Baño!");
                System.out.println("Introduce los metros cuadrados del Baño: ");
                double retreteMetros = scanner.nextInt();
                Ambiente ambiente2 = new Ambiente("Baño", retreteMetros);
                vivienda.agregarAmbiente(ambiente2);
                continuar = false;
            } else {
                System.out.println("¿Desea agregar otro ambiente? (S/N)");
                String respuesta = scanner.nextLine().toUpperCase();
                if (respuesta.equals("N")) {
                    continuar = false;
                }
            }
        } while (continuar || vivienda.getAmbientes().size() < 2);

        System.out.println("Vivienda Familiar");
        System.out.println("Calle: " + vivienda.getCalle() + " Nro: " + vivienda.getNroCalle() +
                " Provincia: " + vivienda.getProvincia());
        System.out.println("-------------------Ambientes de la Vivienda ------------------");

        for (Ambiente ambiente : vivienda.getAmbientes()) {
            System.out.println("Tipo Ambiente: " + ambiente.getTipoAmbiente());
            System.out.println("Metros Cuadrados: " + ambiente.getMetrosCuadrados());
            System.out.println("---------------------------------------------------------------------");
        }

        System.out.println("Total Metros Cuadrados: " + vivienda.totalMetrosCuadradosVivienda());
    }

}
