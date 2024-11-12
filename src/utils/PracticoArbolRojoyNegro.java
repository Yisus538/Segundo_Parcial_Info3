package utils.estructuras;

import utils.estructuras.arbolBinario.*;

import java.util.Scanner;

public class PracticoArbolRojoyNegro {
    public static void mostrarMenu() {  // Cambiado de main() a mostrarMenu()
        ArbolRojiNegro arbol = new ArbolRojiNegro();
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ PRÁCTICO 8 - ÁRBOL ROJINEGRO ---");
            System.out.println("1. Insertar un valor");
            System.out.println("2. Visualizar el árbol");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Ingrese el valor a insertar: ");
                    int valor = scanner.nextInt();
                    arbol.insertar(valor);
                    System.out.println("Valor insertado correctamente.");
                }
                case 2 -> {
                    System.out.println("Visualización del árbol rojinegro:");
                    arbol.visualizarArbol();
                }
                case 3 -> {
                    salir = true;
                    System.out.println("Saliendo del menú de Árbol Rojinegro.");
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}

