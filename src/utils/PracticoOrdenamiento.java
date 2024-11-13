package utils;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PracticoOrdenamiento {

    // Método de ordenación por inserción
    public static <T extends Comparable<T>> void insertionSort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    // Método de ordenación Shellsort
    public static <T extends Comparable<T>> void shellSort(T[] array) {
        int gap = array.length / 2;
        while (gap > 0) {
            for (int i = gap; i < array.length; i++) {
                T temp = array[i];
                int j = i;
                while (j >= gap && array[j - gap].compareTo(temp) > 0) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }
            gap /= 2;
        }
    }

    // Método de ordenación Quicksort
    public static <T extends Comparable<T>> void quickSort(T[] array, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(array, left, right);
            quickSort(array, left, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, right);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        T pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i + 1];
        array[i + 1] = array[right];
        array[right] = temp;
        return i + 1;
    }

    // Función para mostrar el array en pantalla
    public static <T> void mostrarArray(T[] array) {
        System.out.println(Arrays.toString(array));
    }

    // Función que genera un array aleatorio de enteros
    public static Integer[] generarArrayAleatorio(int length) {
        Random random = new Random();
        Integer[] array = new Integer[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }

    // Medición del tiempo de ordenamiento para diferentes tamaños
    public static <T extends Comparable<T>> long medirTiempoOrdenamiento(T[] array, String tipoOrdenamiento) {
        long startTime = System.nanoTime();

        switch (tipoOrdenamiento) {
            case "insercion" -> insertionSort(array);
            case "shell" -> shellSort(array);
            case "quick" -> quickSort(array, 0, array.length - 1);
            default -> throw new IllegalArgumentException("Tipo de ordenamiento no soportado");
        }

        return System.nanoTime() - startTime;
    }


    public static void mostrarMenu() {
        Scanner in = new Scanner(System.in);
        int opc;

        do {

            System.out.println("\nPractico 2 - Ordenamiento:");
            System.out.println("1. Ordenamiento por Insercion");
            System.out.println("2. Ordenamiento Shellsort");
            System.out.println("3. Ordenamiento Quicksort");
            System.out.println("4. Mostrar tiempo de ordenamiento");
            System.out.println("0. Volver al menu");
            opc = in.nextInt();

            switch (opc) {
                case 1, 2, 3 -> {
                    System.out.print("Ingrese el tamaño del arreglo: ");
                    int len = in.nextInt();

                    Integer[] arr = generarArrayAleatorio(len);

                    System.out.println("Arreglo original:");
                    mostrarArray(arr);

                    switch (opc) {
                        case 1 -> {
                            insertionSort(arr);
                            System.out.println("Arreglo ordenado por Insercion:");
                        }
                        case 2 -> {
                            shellSort(arr);
                            System.out.println("Arreglo ordenado por Shellsort:");
                        }
                        case 3 -> {
                            quickSort(arr, 0, arr.length - 1);
                            System.out.println("Arreglo ordenado por Quicksort:");
                        }
                    }
                    mostrarArray(arr);
                }
                case 4 -> {
                    System.out.print("Ingrese el tamaño del arreglo para medir tiempo: ");
                    int len = in.nextInt();
                    Integer[] arr = generarArrayAleatorio(len);

                    System.out.print("Seleccione el tipo de ordenamiento (insercion, shell, quick): ");
                    String tipoOrdenamiento = in.next();

                    long tiempo = medirTiempoOrdenamiento(arr.clone(), tipoOrdenamiento);
                    System.out.printf("Tiempo de ordenamiento para %d elementos usando %s: %d ns%n",
                            len, tipoOrdenamiento, tiempo);
                }
                case 0 -> System.out.println("Volviendo al menu...");
                default -> System.out.println("Opción no valida.");
            }
        } while (opc != 0);
    }
}

