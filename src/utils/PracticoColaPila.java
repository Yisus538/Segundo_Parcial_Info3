package utils;

import java.util.Scanner;
import utils.estructuras.*;

public class PracticoColaPila {

    // Verificar si una cadena es un palíndromo usando una pila
    public static boolean esPalindromo(String cadena) {
        cadena = cadena.replaceAll("\\s+", "").toLowerCase();
        PilaArreglo<Character> pila = new PilaArreglo<>(); // Crear instancia de Pila

        int longitud = cadena.length();
        for (int i = 0; i < longitud / 2; i++) {
            pila.push(cadena.charAt(i));
        }

        for (int i = (longitud + 1) / 2; i < longitud; i++) {
            if (pila.pop() != cadena.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    // Verificar si una expresión matemática tiene paréntesis equilibrados
    public static boolean expresionEquilibrada(String expresion) {
        PilaArreglo<Character> pila = new PilaArreglo<>(); // Crear instancia de Pila

        for (char c : expresion.toCharArray()) {
            if (c == '(') {
                pila.push(c);
            } else if (c == ')') {
                if (pila.isEmpty() || pila.pop() != '(') {
                    return false;
                }
            }
        }
        return pila.isEmpty();
    }
    // Ordenar una cola en orden ascendente
    public static void ordenarColaAscendente(ColaArreglo<Integer> cola) {
        ColaArreglo<Integer> colaAuxiliar = new ColaArreglo<>();

        // Ordenamiento de la cola usando una cola auxiliar
        while (!cola.isEmpty()) {
            int min = cola.dequeue();

            // Encuentra el mínimo en la cola y vuelve a encolar los elementos no mínimos
            int size = cola.size();
            for (int i = 0; i < size; i++) {
                int current = cola.dequeue();
                if (current < min) {
                    cola.enqueue(min);
                    min = current;
                } else {
                    cola.enqueue(current);
                }
            }

            // Añadir el mínimo a la cola auxiliar
            colaAuxiliar.enqueue(min);
        }

        // Volver a pasar los elementos de la cola auxiliar a la cola original
        while (!colaAuxiliar.isEmpty()) {
            cola.enqueue(colaAuxiliar.dequeue());
        }

        // Mostrar la cola ordenada
        System.out.println("Cola ordenada en orden ascendente:");
        while (!cola.isEmpty()) {
            System.out.print(cola.dequeue() + " ");
        }
        System.out.println();
    }
    // Método para mostrar el menú y ejecutar las opciones del práctico 3
    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nSeleccione una opción del Práctico 3 - Pila & Cola:");
            System.out.println("1. Verificar Palíndromo");
            System.out.println("2. Verificar Expresión Equilibrada");
            System.out.println("3. Ordenar Cola Ascendentemente");
            System.out.println("0. Volver al menú principal");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese una cadena para verificar si es palíndromo: ");
                    String cadena = scanner.nextLine();
                    boolean esPalindromo = esPalindromo(cadena);
                    System.out.println("La cadena es " + (esPalindromo ? "" : "no ") + "un palíndromo.");
                }
                case 2 -> {
                    System.out.print("Ingrese una expresión matemática para verificar si está equilibrada: ");
                    String expresion = scanner.nextLine();
                    boolean equilibrada = expresionEquilibrada(expresion);
                    System.out.println("La expresión está " + (equilibrada ? "" : "no ") + "equilibrada.");
                }
                case 3 -> {
                    System.out.print("Ingrese la cantidad de elementos en la cola: ");
                    int cantidad = scanner.nextInt();
                    ColaArreglo<Integer> cola = new ColaArreglo<>(); // Crear instancia de Cola

                    System.out.println("Ingrese los elementos de la cola:");
                    for (int i = 0; i < cantidad; i++) {
                        cola.enqueue(scanner.nextInt());
                    }

                    ordenarColaAscendente(cola);
                }
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
        scanner.close();
    }
}
