package utils;

import utils.estructuras.arbolBinario.*;

import java.util.Scanner;

public class PracticoArbolRojoyNegro {

    public static void mostrarMenu() {
        ArbolRojiNegro arbol = new ArbolRojiNegro();
        Scanner in = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- PRACTICO 8 - ARBOL ROJINEGRO ---");
            System.out.println("1. Insertar un valor");
            System.out.println("2. Insertar valores predefinidos");
            System.out.println("3. Visualizar el árbol");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opc = in.nextInt();

            switch (opc) {
                case 1 -> {
                    System.out.print("Ingrese el valor a insertar: ");
                    arbol.insertar(in.nextInt());
                    System.out.println("Valor insertado correctamente.");
                }
                case 2 -> {
                    insertarValoresPredefinidos(arbol);
                    System.out.println("Valores predefinidos insertados.");
                }
                case 3 -> {
                    System.out.println("Visualización del arbol rojinegro:");
                    arbol.visualizarArbol();
                }
                case 4 -> {
                    salir = true;
                    System.out.println("Saliendo del menú de Árbol Rojinegro.");
                }
                default -> System.out.println("Opcion no válida...");
            }
        }
        in.close();
    }
    private static void insertarValoresPredefinidos(ArbolRojiNegro arbol) {
        int[] valores = {10, 20, 30, 40, 50, 60, 70};
        for (int valor : valores) {
            arbol.insertar(valor);
        }
    }
}
