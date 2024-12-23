import java.util.Scanner;
import utils.*;

public class Segundo_Parcial {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int opc;

        do {
            System.out.println("---- MENU ----");
            System.out.println("1. Recursividad"); // DONE -> Lean
            System.out.println("2. Ordenamiento"); // DONE -> Lean y Jesus
            System.out.println("3. Pila & Cola con Arreglo"); // DONE -> Lean
            System.out.println("4. Pila & Cola con Lista"); // DONE -> Jesus
            System.out.println("5. Arbol Binario");// DONE -> Jesus
            System.out.println("6. Arbol AVL");// DONE -> Jesus
            System.out.println("7. Arbol Rojo & Negro"); // DONE -> Vale y Gringo
            System.out.println("8. Monticulo & Tabla Hash"); // DONE -> Vale y Gringo
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opc = in.nextInt();

            switch (opc) {
                case 1 -> PracticoRecursividad.mostrarMenu();
                case 2 -> PracticoOrdenamiento.mostrarMenu();
                case 3 -> PracticoColaPila.mostrarMenu();
                case 4 -> PracticoColaPilaLista.mostrarMenu();
                case 5 -> PracticoArbolBinario.mostrarMenu();
                case 6 -> PracticoArbolAVL.mostrarMenu();
                case 7 -> PracticoArbolRojoyNegro.mostrarMenu();
                case 8 -> PracticoEstructurasGenerales.mostrarMenu();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Error,Ingrese otra opcion...");
            }
        } while (opc != 0);

        in.close();
    }
}
