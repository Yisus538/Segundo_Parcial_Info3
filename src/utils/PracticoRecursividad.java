package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PracticoRecursividad {

    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nSeleccione un ejercicio del Práctico 1 - Recursividad:");
            System.out.println("1. Factorial de un número");
            System.out.println("2. Suma de los primeros n enteros");
            System.out.println("3. Potencia de un número");
            System.out.println("4. Conteo regresivo");
            System.out.println("5. Producto de dos números (sumas sucesivas)");
            System.out.println("6. Imprimir arreglo en orden inverso");
            System.out.println("7. Contar unos en la representación binaria de N");
            System.out.println("0. Volver al menú principal");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese un número: ");
                    int n = scanner.nextInt();
                    System.out.println("Factorial: " + factorial(n));
                }
                case 2 -> {
                    System.out.print("Ingrese un número: ");
                    int n = scanner.nextInt();
                    System.out.println("Suma: " + sumaEnteros(n));
                }
                case 3 -> {
                    System.out.print("Ingrese la base: ");
                    int base = scanner.nextInt();
                    System.out.print("Ingrese el exponente: ");
                    int exponente = scanner.nextInt();
                    System.out.println("Potencia: " + potencia(base, exponente));
                }
                case 4 -> {
                    System.out.print("Ingrese un número: ");
                    int n = scanner.nextInt();
                    conteoRegresivo(n);
                    System.out.println();
                }
                case 5 -> {
                    System.out.print("Ingrese el primer número: ");
                    int a = scanner.nextInt();
                    System.out.print("Ingrese el segundo número: ");
                    int b = scanner.nextInt();
                    System.out.println("Producto: " + productoPorSuma(a, b));
                }
                case 6 -> {
                    try {
                        System.out.print("Ingrese el tamaño del arreglo: ");
                        int size = scanner.nextInt();
                        int[] arr = new int[size];
                        System.out.println("Ingrese los elementos del arreglo:");

                        for (int i = 0; i < size; i++) {
                            arr[i] = scanner.nextInt();
                        }

                        System.out.print("Arreglo en orden inverso: ");
                        imprimirInverso(arr, size - 1);
                        System.out.println();

                    } catch (InputMismatchException e) {
                        System.out.println(""+e);
                        scanner.nextLine(); // Limpiar el buffer del scanner para evitar bucles infinitos
                    }
                }
                case 7 -> {
                    System.out.print("Ingrese un número: ");
                    int n = scanner.nextInt();
                    System.out.println("Número de unos en binario: " + contarUnos(n));
                }
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    public static int factorial(int n) {
        return (n<=1)? 1 : n * factorial(n-1);
    }
    public static int sumaEnteros(int n) {
        return (n<=1)? n : n+sumaEnteros(n-1);
    }
    public static int potencia(int base, int exponente) {
        return (exponente==0)? 1 : base*potencia(base,exponente-1);
    }
    public static void conteoRegresivo(int n) {
        System.out.print((n < 1) ? "" : n + " ");
        if (n >= 1) conteoRegresivo(n - 1);
    }
    public static int productoPorSuma(int a, int b) {
        return (b == 0) ? 0 : a + productoPorSuma(a, b - 1);
    }
    public static void imprimirInverso(int[] arr, int index) {
        System.out.print((index < 0) ? "" : arr[index] + " ");
        if (index >= 0) imprimirInverso(arr, index - 1);
    }
    public static int contarUnos(int n) {
        return (n == 0) ? 0 : (n % 2) + contarUnos(n / 2);
    }
}
