package utils;

import utils.estructuras.arbolBinario.*;
import java.util.Scanner;

public class PracticoArbolBinario {

    public static void mostrarMenu() {
        ArbolBinario arbol = new ArbolBinario();
        arbol.generarArbol();

        Scanner in = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nPractico 5 - Árbol Binario:");
            System.out.println("1. Mostrar Arbol");
            System.out.println("2. Determinar si el Arbol permite duplicados");
            System.out.println("3. Cambiar configuración de duplicados en el Arbol");
            System.out.println("4. Calcular Profundidad del Árbol");
            System.out.println("5. Eliminar un valor del Arbol");
            System.out.println("6. Imprimir el Arbol en forma jerárquica");
            System.out.println("0. Volver al menu");

            int opc = in.nextInt();
            switch (opc) {
                case 1 -> arbol.inorder();
                case 2 -> System.out.println("Este arbol no permite duplicados.");
                case 3 -> System.out.println("Para cambiar configuración de duplicados, modifica la instancia del árbol.");
                case 4 -> System.out.println("La profundidad del árbol es: " + arbol.profundidad());
                case 5 -> {
                    System.out.print("Ingrese el valor a eliminar: ");
                    int valor = in.nextInt();
                    arbol.eliminar(valor);
                    System.out.println("Recorrido Inorden despues de eliminar:");
                    arbol.inorder();
                }
                case 6 -> arbol.imprimirArbol();
                case 0 -> salir = true;
                default -> System.out.println("Opcion no valida...");
            }
        }
        in.close();
    }
}
