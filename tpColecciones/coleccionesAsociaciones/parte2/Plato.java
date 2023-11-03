package tpColecciones.coleccionesAsociaciones.parte2;

import java.util.ArrayList;

class Plato {
    private String nombreCompleto;
    private double precio;
    private boolean esBebida;
    private ArrayList<Ingrediente> ingredientes;

    public Plato(String nombreCompleto, double precio, boolean esBebida) {
        this.nombreCompleto = nombreCompleto;
        this.precio = precio;
        this.esBebida = esBebida;
        this.ingredientes = new ArrayList<>();
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder();
        resultado.append("-----------MENÚ----------------\n");
        resultado.append(nombreCompleto).append("\n");
        resultado.append("Precio: $").append(precio).append("\n");
        if (!esBebida) {
            resultado.append("Ingredientes:\n");
            resultado.append("Nombre\tCantidad\tUnidad de Medida\n");
            for (Ingrediente ingrediente : ingredientes) {
                resultado.append(ingrediente).append("\n");
            }
        }
        resultado.append("----------------------------------\n");
        return resultado.toString();
    }
}
