import java.util.Scanner;
import utils.*;
import utils.PracticoArbolRojoyNegro;

public class Segundo_Parcial {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int opc;

        do {
            System.out.println("---- MENU ----");
            System.out.println("1. Recursividad"); // DONE
            System.out.println("2. Ordenamiento"); // DONE
            System.out.println("3. Pila & Cola con Arreglo"); // DONE
            System.out.println("4. Pila & Cola con Lista"); // DONE
            System.out.println("5. Arbol Binario");// DONE
            System.out.println("6. Arbol Rojo & Negro"); // DONE
            System.out.println("7. Monticulo & Tabla Hash"); // DONE
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opc = in.nextInt();

            switch (opc) {
                case 1 -> PracticoRecursividad.mostrarMenu();
                case 2 -> PracticoOrdenamiento.mostrarMenu();
                case 3 -> PracticoColaPila.mostrarMenu();
                case 4 -> PracticoColaPilaLista.mostrarMenu();
                case 5 -> PracticoArbolBinario.mostrarMenu();
                case 6 -> PracticoArbolRojoyNegro.mostrarMenu();
                case 7-> PracticoEstructurasGenerales.mostrarMenu();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Error,Ingrese otra opcion...");
            }
        } while (opc != 0);

        in.close();
    }
}
