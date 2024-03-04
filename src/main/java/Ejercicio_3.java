



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author sergi
 */




public class Ejercicio_3 {

    public static void main(String[] args) {
       // Generar números aleatorios.
        int[] arreglo = new int[1000];
        for (int i = 0; i < 1000; ++i) {
            arreglo[i] = (int) (Math.random() * 1000);
        }

        // Contar la frecuencia de cada número dentro del conjunto.
        int[] contador = new int[1000];
        for (int num : arreglo) {
            contador[num]++;
        }

        // Identificar el numero que más se repite.
        int elementoMasRepetido = 0;
        int repeticiones = contador[0];
        for (int i = 1; i < contador.length; i++) {
            if (contador[i] > repeticiones) {
                elementoMasRepetido = i;
                repeticiones = contador[i];
            }
        }

        // Mostrar en pantalla el número que aparece con mayor frecuencia y cuantas veces se repite.
        System.out.println("El elemento que más se repite es " + elementoMasRepetido + ", se repite " + repeticiones + " veces.");
    }
}
