package utils;

import utils.estructuras.*;
import java.util.Scanner;

public class PracticoEstructurasGenerales {

    public static void mostrarMenu() {
        MonticuloBinario monticulo = new MonticuloBinario(10);
        TablaHash tablaHash = new TablaHash(10);
        EstructurasGenerales estructuras = new EstructurasGenerales();
        Scanner in = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- PRACTICO 9 ---");
            System.out.println("1. Operaciones con Monticulo Binario");
            System.out.println("2. Operaciones con Tabla Hash");
            System.out.println("3. Operaciones Generales (ArrayList, LinkedList, Mapas)");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opc = in.nextInt();

            switch (opc) {
                case 1 -> menuMonticulo(monticulo, in);
                case 2 -> menuTablaHash(tablaHash, in);
                case 3 -> menuEstructurasGenerales(estructuras, in);
                case 4 -> {
                    salir = true;
                    System.out.println("Saliendo del programa.");
                }
                default -> System.out.println("Opcion no valida...");
            }
        }
        in.close();
    }

    private static void menuMonticulo(MonticuloBinario monticulo, Scanner in) {
        System.out.println("Montículo Binario:");
        System.out.print("1. Insertar\n2. Eliminar maximo\n3. Mostrar\nSeleccione: ");
        int opc = in.nextInt();
        switch (opc) {
            case 1 -> {
                System.out.print("Elemento a insertar: ");
                monticulo.insertar(in.nextInt());
            }
            case 2 -> System.out.println("Extraído: " + monticulo.eliminar());
            case 3 -> monticulo.mostrarMonticulo();
            default -> System.out.println("Opción no válida.");
        }
    }

    private static void menuTablaHash(TablaHash tablaHash, Scanner in) {
        System.out.println("Tabla Hash:");
        System.out.print("1. Insertar\n2. Buscar\n3. Eliminar\n4. Mostrar\nSeleccione: ");
        int opc = in.nextInt();
        in.nextLine();
        switch (opc) {
            case 1 -> {
                System.out.print("Clave (entero): ");
                int clave = in.nextInt();
                System.out.print("Valor (entero): ");
                tablaHash.insertar(clave, in.nextInt());
            }
            case 2 -> {
                System.out.print("Clave a buscar: ");
                System.out.println("Valor: " + tablaHash.buscar(in.nextInt()));
            }
            case 3 -> {
                System.out.print("Clave a eliminar: ");
                tablaHash.eliminar(in.nextInt());
            }
            case 4 -> tablaHash.mostrarTabla();
            default -> System.out.println("Opcion no valida...");
        }
    }

    private static void menuEstructurasGenerales(EstructurasGenerales estructuras, Scanner in) {
        System.out.print("Seleccione estructura (1.ArrayList, 2.LinkedList, 3.HashMap, 4.TreeMap, 5.LinkedHashMap): ");
        int estructura = in.nextInt();
        in.nextLine();
        System.out.print("Seleccione operacion (1.Agregar, 2.Eliminar, 3.Mostrar): ");
        int operacion = in.nextInt();
        in.nextLine();

        switch (estructura) {
            case 1 -> { // ArrayList
                if (operacion == 1) {
                    System.out.print("Elemento a agregar (String): ");
                    estructuras.agregarArrayList(in.nextLine());
                } else if (operacion == 2) {
                    System.out.print("Indice a eliminar: ");
                    estructuras.eliminarArrayList(in.nextInt());
                } else if (operacion == 3) {
                    estructuras.mostrarArrayList();
                }
            }
            case 2 -> { // LinkedList
                if (operacion == 1) {
                    System.out.print("Elemento a agregar (String): ");
                    estructuras.agregarLinkedList(in.nextLine());
                } else if (operacion == 2) {
                    System.out.print("Indice a eliminar: ");
                    estructuras.eliminarLinkedList(in.nextInt());
                } else if (operacion == 3) {
                    estructuras.mostrarLinkedList();
                }
            }
            case 3 -> { // HashMap
                if (operacion == 1) {
                    System.out.print("Clave (String): ");
                    String clave = in.nextLine();
                    System.out.print("Valor (String): ");
                    estructuras.agregarHashMap(clave, in.nextLine());
                } else if (operacion == 2) {
                    System.out.print("Clave a eliminar: ");
                    estructuras.eliminarHashMap(in.nextLine());
                } else if (operacion == 3) {
                    estructuras.mostrarHashMap();
                }
            }
            case 4 -> { // TreeMap
                if (operacion == 1) {
                    System.out.print("Clave (String): ");
                    String clave = in.nextLine();
                    System.out.print("Valor (String): ");
                    estructuras.agregarTreeMap(clave, in.nextLine());
                } else if (operacion == 2) {
                    System.out.print("Clave a eliminar: ");
                    estructuras.eliminarTreeMap(in.nextLine());
                } else if (operacion == 3) {
                    estructuras.mostrarTreeMap();
                }
            }
            case 5 -> { // LinkedHashMap
                if (operacion == 1) {
                    System.out.print("Clave (String): ");
                    String clave = in.nextLine();
                    System.out.print("Valor (String): ");
                    estructuras.agregarLinkedHashMap(clave, in.nextLine());
                } else if (operacion == 2) {
                    System.out.print("Clave a eliminar: ");
                    estructuras.eliminarLinkedHashMap(in.nextLine());
                } else if (operacion == 3) {
                    estructuras.mostrarLinkedHashMap();
                }
            }
            default -> System.out.println("Opcion no valida...");
        }
    }
}

