package Ejercicios;

import java.util.HashMap;

/**
 * Ejercicio de frecuencia de números generados aleatoriamente
 * @author Pablo José Hernández Meléndez [0221910052]
 * @author Jorge David Junior Sierra Morales [0221910025]
 * @author Sergio Alejandro Severiche Guerrero [0222010041]
 */
public class Frecuencia {
    public static void run(){
        int arreglo[] = new int[1000];

        for (int i = 0; i < 1000; ++i) {
            arreglo[i] = ((int) (Math.random() * 1000));
        }

        HashMap<Integer, Integer> frecuencia = new HashMap<>();
        for (int i = 0; i < 1000; ++i) {
            int num = arreglo[i];
            frecuencia.put(num, frecuencia.getOrDefault(num, 0) + 1);
        }

        int elementoMasRepetido = -1;
        int maxFrecuencia = 0;

        for (int num : frecuencia.keySet()) {
            int actualFrecuencia = frecuencia.get(num);
            if (actualFrecuencia > maxFrecuencia) {
                maxFrecuencia = actualFrecuencia;
                elementoMasRepetido = num;
            }
        }

        System.out.println("Ejercicio de Frecuencia");
        System.out.println("El elemento que más se repite es: " + elementoMasRepetido);
        System.out.println("Frecuencia de repetición: " + maxFrecuencia);
    }
}
