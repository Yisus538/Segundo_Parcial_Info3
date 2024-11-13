package utils;

import utils.estructuras.*;
import java.util.Scanner;

public class PracticoColaPilaLista {

    // Ejercicio 1: Pila de palabras
    public static void pilaDePalabras() {
        PilaLista<String> pila = new PilaLista<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese palabras (escriba 'fin' para terminar):");

        while (true) {
            String palabra = in.nextLine();
            if (palabra.equalsIgnoreCase("fin")) break;
            pila.push(palabra);
        }

        System.out.println("Palabras en orden inverso:");
        while (!pila.isEmpty()) {
            System.out.println(pila.pop());
        }
    }

    // Ejercicio 2: Verificación de paréntesis balanceados
    public static boolean verificarParentesis(String expresion) {
        PilaLista<Character> pila = new PilaLista<>();
        for (char ch : expresion.toCharArray()) {
            if (ch == '(') {
                pila.push(ch);
            } else if (ch == ')') {
                if (pila.isEmpty() || pila.pop() != '(') {
                    return false;
                }
            }
        }
        return pila.isEmpty();
    }

    // Ejercicio 3: Conversión de decimal a binario
    public static String convertirDecimalABinario(int numero) {
        PilaLista<Integer> pila = new PilaLista<>();
        while (numero > 0) {
            pila.push(numero % 2);
            numero /= 2;
        }

        StringBuilder binario = new StringBuilder();
        while (!pila.isEmpty()) {
            binario.append(pila.pop());
        }
        return binario.toString();
    }

    // Ejercicio 4: Suma de números en una Cola
    public static int sumaCola() {
        ColaLista<Integer> cola = new ColaLista<>();
        Scanner in = new Scanner(System.in);
        System.out.println("Ingrese numeros para encolar (escriba 'fin' para terminar):");

        while (in.hasNext()) {
            String entrada = in.next();
            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }
            try {
                int numero = Integer.parseInt(entrada);
                cola.enqueue(numero);
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un numero o 'fin' para terminar.");
            }
        }

        int suma = 0;
        while (!cola.isEmpty()) {
            suma += cola.dequeue();
        }
        return suma;
    }

    // Ejercicio 5: Ordenamiento de una cola usando una pila
    public static void ordenarColaAscendente(ColaLista<Integer> cola) {
        ColaLista<Integer> colaOrdenada = new ColaLista<>();

        // Proceso de selección para ordenar los elementos en orden ascendente
        while (!cola.isEmpty()) {
            int min = cola.dequeue();

            // Encuentra el mínimo en la cola actual y mueve los elementos restantes
            while (!cola.isEmpty()) {
                int current = cola.dequeue();
                if (current < min) {
                    cola.enqueue(min);  // El mínimo anterior se mueve de vuelta a la cola
                    min = current;      // Nuevo mínimo encontrado
                } else {
                    cola.enqueue(current);
                }
            }

            // Añadir el mínimo encontrado a la cola ordenada
            colaOrdenada.enqueue(min);
        }

        // Transferir los elementos de colaOrdenada de vuelta a la cola original
        while (!colaOrdenada.isEmpty()) {
            cola.enqueue(colaOrdenada.dequeue());
        }
    }

    // Ejercicio 6: Verificación de palíndromos con cola
    public static boolean esPalindromo(String cadena) {
        cadena = cadena.replaceAll("[\\s\\p{Punct}]", "").toLowerCase();
        ColaLista<Character> cola = new ColaLista<>();
        PilaLista<Character> pila = new PilaLista<>();

        for (char c : cadena.toCharArray()) {
            cola.enqueue(c);
            pila.push(c);
        }

        while (!cola.isEmpty()) {
            if (!cola.dequeue().equals(pila.pop())) {
                return false;
            }
        }
        return true;
    }

    public static void mostrarMenu() {
        Scanner in = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nPractico 4 - Pila & Cola con Lista:");
            System.out.println("1. Pila de Palabras");
            System.out.println("2. Verificar Parentesis Balanceados");
            System.out.println("3. Convertir Decimal a Binario");
            System.out.println("4. Suma de Numeros en Cola");
            System.out.println("5. Ordenar Cola Ascendentemente(Comentado)");
            System.out.println("6. Verificar Palíndromo");
            System.out.println("0. Salir");

            int opc = in.nextInt();
            in.nextLine();

            switch (opc) {
                case 1 -> pilaDePalabras();
                case 2 -> {
                    System.out.print("Ingrese una expresioin matematica: ");
                    String expresion = in.nextLine();
                    System.out.println("La expresion esta " + (verificarParentesis(expresion) ? "balanceada." : "desbalanceada."));
                }
                case 3 -> {
                    System.out.print("Ingrese un numero decimal para convertir a binario: ");
                    System.out.println("Representacion en binario: " + convertirDecimalABinario(in.nextInt()));
                }
                case 4 -> {
                    System.out.println("La suma de los numeros en la cola es: " + sumaCola());
                }
                /*case 5 -> {
                    ColaLista<Integer> cola = new ColaLista<>();
                    System.out.println("Ingrese números para la cola (escriba 'fin' para terminar):");

                    while (true) {
                        String entrada = scanner.next();
                        if (entrada.equalsIgnoreCase("fin")) break;
                        try {
                            int numero = Integer.parseInt(entrada);
                            cola.enqueue(numero);
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. Ingrese un número o 'fin' para terminar.");
                        }
                    }

                    ordenarColaAscendente(cola);
                    System.out.print("Cola ordenada en orden ascendente: ");
                    while (!cola.isEmpty()) {
                        System.out.print(cola.dequeue() + " ");
                    }
                    System.out.println();
                }*/
                case 6 -> {
                    System.out.print("Ingrese una palabra o frase para verificar si es palidromo: ");
                    String cadena = in.nextLine();
                    System.out.println("La frase es " + (esPalindromo(cadena) ? "" : "no ") + "un palindromo.");
                }
                case 0 -> {
                    salir = true;
                    System.out.println("Saliendo del programa.");
                }
                default -> System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
        in.close();
    }

}
