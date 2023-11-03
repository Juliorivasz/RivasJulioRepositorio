package tpColecciones.coleccionesJava;
import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Scanner;

class Celda {
    int fila;
    int columna;
    String valor;
    
    public Celda(int fila, int columna, String valor) {
        this.fila = fila;
        this.columna = columna;
        this.valor = valor;
    }
}

public class Matriz {
    ArrayList<Celda> matrizCuadrada = new ArrayList<>();

    public void agregarCelda(Celda celda) {
        matrizCuadrada.add(celda);
    }

    public String obtenerValor(int fila, int columna) {
        for (Celda celda : matrizCuadrada) {
            if (celda.fila == fila && celda.columna == columna) {
                return celda.valor;
            }
        }
        return "La fila y columna indicada no ha sido asignada";
    }

}

