package Ejercicios;

/**
 * Ejercicio de frecuencia de números generados aleatoriamente
 * @author Pablo José Hernández Meléndez [0221910052]
 * @author Juan Camilo Narváez Torres [0221920007]
 */
public class Frecuencia {
    public static void run() {
        int[] arreglo = new int[1000];

        for(int i=0;i<1000;++i){
            arreglo[i]=((int)(Math.random()*1000));
            System.out.println(arreglo[i]);
        }

        int[] fr = new int[arreglo.length];
        int maxIdx = 0;

        for (int number : arreglo) {
            fr[number]++;

            if (fr[number] > fr[maxIdx]) {
                maxIdx = number;
            }
        }

        System.out.println("Ejercicio de Frecuencia");
        System.out.println("El elemento que más se repite es: " + maxIdx);
        System.out.println("Frecuencia de repetición: " + fr[maxIdx]);
    }
}