package Ejercicios;

/**
 * Ejercicio de frecuencia de números generados aleatoriamente
 * @author Pablo José Hernández Meléndez [0221910052]
 * @author Juan Camilo Narváez Torres [0221920007]
 */
public class Frecuencia {
    public static void run() {
        int[] arreglo = new int[1000];//O(1)

        for(int i=0;i<1000;++i){//BUCLE 1
            arreglo[i]=((int)(Math.random()*1000));//O(1)
        }

        int[] fr = new int[arreglo.length];//O(1)
        int maxIdx = 0;//O(1)

        for (int number : arreglo) {//BUCLE 2
            System.out.print(number + " ; ");//O(1)
            fr[number]++;//O(1)

            if (fr[number] > fr[maxIdx]) {//O(1)
                maxIdx = number;//O(1)
            }
        }

        System.out.println("\n\nFRECUENCIA DE NÚMEROS");
        System.out.println("El elemento que más se repite es: " + maxIdx);
        System.out.println("Frecuencia de repetición: " + fr[maxIdx]);
    }
}