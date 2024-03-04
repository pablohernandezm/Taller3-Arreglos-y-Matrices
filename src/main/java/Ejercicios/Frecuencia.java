package Ejercicios;

/**
 * Ejercicio de frecuencia de números generados aleatoriamente
 * @author Pablo José Hernández Meléndez [0221910052]
 * @author Jorge David Junior Sierra Morales [0221910025]
 * @author Sergio Alejandro Severiche Guerrero [0222010041]
 */
public class Frecuencia {
    public static void run() {
        int arreglo[] = new int[1000];

        for (int i = 0; i < 1000; ++i) {
            arreglo[i] = ((int) (Math.random() * 1000));
        }

        int[] frecuencia = new int[1001]; // Incrementamos el tamaño del arreglo para abarcar todos los posibles valores (0 a 1000)

        for (int i = 0; i < 1000; ++i) {
            int num = arreglo[i];
            frecuencia[num]++;
        }

        int elementoMasRepetido = -1;
        int maxFrecuencia = 0;

        for (int i = 0; i < frecuencia.length; i++) {
            int actualFrecuencia = frecuencia[i];
            if (actualFrecuencia > maxFrecuencia) {
                maxFrecuencia = actualFrecuencia;
                elementoMasRepetido = i;
            }
        }

        System.out.println("Ejercicio de Frecuencia");
        System.out.println("El elemento que más se repite es: " + elementoMasRepetido);
        System.out.println("Frecuencia de repetición: " + maxFrecuencia);
    }
}