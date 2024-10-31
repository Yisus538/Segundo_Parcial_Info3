package utils;

import java.util.Scanner;
import utils.estructuras.arbolBinario.ArbolBinario;

public class PracticoArbolBinario {

    public static void mostrarMenu() {
        ArbolBinario arbol = new ArbolBinario();
        arbol.generarArbol();

        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nSeleccione una opción del Práctico 5 - Árbol Binario:");
            System.out.println("1. Mostrar Árbol (Recorrido Inorden)");
            System.out.println("2. Determinar si el Árbol permite duplicados");
            System.out.println("3. Cambiar configuración de duplicados en el Árbol");
            System.out.println("4. Calcular Profundidad del Árbol");
            System.out.println("5. Eliminar un valor del Árbol");
            System.out.println("0. Volver al menú principal");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1 -> arbol.inorder();
                case 2 -> System.out.println("Este árbol no permite duplicados.");
                case 3 -> System.out.println("Para permitir duplicados, modifique el método de inserción.");
                case 4 -> System.out.println("La profundidad del árbol es: " + arbol.profundidad());
                case 5 -> {
                    System.out.print("Ingrese el valor a eliminar: ");
                    int valor = scanner.nextInt();
                    arbol.eliminar(valor);
                    System.out.println("Recorrido Inorden después de eliminar:");
                    arbol.inorder();
                }
                case 0 -> salir = true;
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        scanner.close();
    }
}
