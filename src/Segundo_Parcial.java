import java.util.Scanner;
import utils.*;

public class Segundo_Parcial {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opcion = 0;

        do {
            System.out.println("---- MENU ----");
            System.out.println("1. Recursividad");
            System.out.println("2. Ordenamiento");
            System.out.println("3. Pila & Cola con Arreglo");
            System.out.println("4. Pila & Cola con Lista");
            System.out.println("5. Práctico 5");
            System.out.println("6. Práctico 6");
            System.out.println("7. Práctico 7");
            System.out.println("8. Práctico 8");
            System.out.println("9. Práctico 9");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            opcion = in.nextInt();

            switch (opcion) {
                case 1 -> PracticoRecursividad.mostrarMenu();
                case 2 -> PracticoOrdenamiento.mostrarMenu();
                case 3 -> PracticoColaPila.mostrarMenu();
                case 4 -> PracticoColaPilaLista.mostrarMenu();
                case 0 -> System.out.println("Saliendo...");
                default -> System.out.println("Error, Ingrese otra opcion...");
            }
        } while (opcion != 0);

        in.close();
    }
}
