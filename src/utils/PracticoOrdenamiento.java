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
            array[i] = random.nextInt(1000); // valores entre 0 y 999
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

    // Menú para el Práctico 2 - Ordenamiento
    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nSeleccione el tipo de ordenamiento:");
            System.out.println("1. Ordenamiento por Inserción");
            System.out.println("2. Ordenamiento Shellsort");
            System.out.println("3. Ordenamiento Quicksort");
            System.out.println("4. Mostrar tiempo de ordenamiento");
            System.out.println("0. Volver al menú principal");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1, 2, 3 -> {
                    System.out.print("Ingrese la longitud del arreglo: ");
                    int length = scanner.nextInt();
                    Integer[] array = generarArrayAleatorio(length);

                    System.out.println("Arreglo original:");
                    mostrarArray(array);

                    switch (opcion) {
                        case 1 -> {
                            insertionSort(array);
                            System.out.println("Arreglo ordenado por Inserción:");
                        }
                        case 2 -> {
                            shellSort(array);
                            System.out.println("Arreglo ordenado por Shellsort:");
                        }
                        case 3 -> {
                            quickSort(array, 0, array.length - 1);
                            System.out.println("Arreglo ordenado por Quicksort:");
                        }
                    }
                    mostrarArray(array);
                }
                case 4 -> {
                    System.out.print("Ingrese la longitud del arreglo para medir tiempo: ");
                    int length = scanner.nextInt();
                    Integer[] array = generarArrayAleatorio(length);

                    System.out.print("Seleccione el tipo de ordenamiento (insercion, shell, quick): ");
                    String tipoOrdenamiento = scanner.next();

                    long tiempo = medirTiempoOrdenamiento(array.clone(), tipoOrdenamiento);
                    System.out.printf("Tiempo de ordenamiento para %d elementos usando %s: %d ns%n",
                            length, tipoOrdenamiento, tiempo);
                }
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}

