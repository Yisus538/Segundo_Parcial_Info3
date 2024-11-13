package utils;

import utils.estructuras.arbolBinario.*;
import java.util.Scanner;

public class PracticoArbolAVL {

    public static void mostrarMenu() {
        ArbolAVL arbolAVL = new ArbolAVL();
        Scanner in = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- MENÚ PRÁCTICO 7 - ÁRBOL AVL ---");
            System.out.println("1. Insertar un valor en el árbol AVL");
            System.out.println("2. Mostrar el árbol en recorrido InOrden");
            System.out.println("3. Generar árbol con valores: 10, 100, 20, 80, 40, 70");
            System.out.println("4. Generar árbol con valores: 5, 10, 20, 30, 40, 50, 60");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opc = in.nextInt();

            switch (opc) {
                case 1 -> {
                    System.out.print("Ingrese el valor a insertar: ");

                    arbolAVL.insertar(in.nextInt());
                    System.out.println("Valor insertado.");
                }
                case 2 -> {
                    System.out.print("Árbol AVL en InOrden: ");
                    arbolAVL.mostrarInOrden();
                }
                case 3 -> {
                    int[] valores = {10, 100, 20, 80, 40, 70};
                    arbolAVL = new ArbolAVL();
                    for (int valor : valores) {
                        arbolAVL.insertar(valor);
                    }
                    System.out.println("Árbol generado con los valores {10, 100, 20, 80, 40, 70}");
                }
                case 4 -> {
                    int[] valoresOrdenados = {5, 10, 20, 30, 40, 50, 60};
                    arbolAVL = new ArbolAVL();
                    for (int valor : valoresOrdenados) {
                        arbolAVL.insertar(valor);
                    }
                    System.out.println("Árbol generado con los valores {5, 10, 20, 30, 40, 50, 60}");
                }
                case 5 -> {
                    salir = true;
                    System.out.println("Saliendo del menú de Árbol AVL.");
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        in.close();
    }
}
