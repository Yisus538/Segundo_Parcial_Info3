package utils;

import utils.estructuras.*;

import java.util.Scanner;

public class PracticoPilaCola{

    // Verificar si una cadena es un palíndromo usando una pila
    public static boolean esPalindromo(String cadena) {
        cadena = cadena.replaceAll("\\s+", "").toLowerCase();
        Pila<Character> pila = new Pila<>(cadena.length()); // Crear instancia de Pila

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
        Pila<Character> pila = new Pila<>(expresion.length()); // Crear instancia de Pila

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

    // Ordenar una cola en orden ascendente usando una cola auxiliar
    public static void ordenarColaAscendente(Cola<Integer> cola) {
        Cola<Integer> colaAuxiliar = new Cola<>(cola.getCapacidad()); // Crear instancia de Cola auxiliar

        while (!cola.isEmpty()) {
            int temp = cola.dequeue();
            while (!colaAuxiliar.isEmpty() && colaAuxiliar.top() < temp) {
                cola.enqueue(colaAuxiliar.dequeue());
            }
            colaAuxiliar.enqueue(temp);
        }

        while (!colaAuxiliar.isEmpty()) {
            cola.enqueue(colaAuxiliar.dequeue());
        }
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
            scanner.nextLine();  // Consumir la línea en blanco

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
                    Cola<Integer> cola = new Cola<>(cantidad); // Crear instancia de Cola

                    System.out.println("Ingrese los elementos de la cola:");
                    for (int i = 0; i < cantidad; i++) {
                        cola.enqueue(scanner.nextInt());
                    }

                    ordenarColaAscendente(cola);
                    System.out.print("Cola ordenada en orden ascendente: ");
                    while (!cola.isEmpty()) {
                        System.out.print(cola.dequeue() + " ");
                    }
                    System.out.println();
                }
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }
}
