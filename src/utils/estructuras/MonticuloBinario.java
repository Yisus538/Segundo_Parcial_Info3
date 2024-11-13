package utils.estructuras;

public class MonticuloBinario {

    private int[] monticulo;
    private int tamanio;

    public MonticuloBinario(int capacidad) {
        monticulo = new int[capacidad];
        tamanio = 0;
    }

    public void insertar(int elemento) {
        if (tamanio == monticulo.length) {
            System.out.println("El montículo está lleno");
            return;
        }
        monticulo[tamanio] = elemento;
        percolateUp(tamanio);
        tamanio++;
    }

    public Integer eliminar() {
        if (tamanio == 0) {
            System.out.println("El montículo está vacío");
            return null;
        }
        int max = monticulo[0];
        monticulo[0] = monticulo[--tamanio];
        percolateDown(0);
        return max;
    }

    private void percolateUp(int index) {
        int elemento = monticulo[index];
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (elemento <= monticulo[parentIndex]) break;
            monticulo[index] = monticulo[parentIndex];
            index = parentIndex;
        }
        monticulo[index] = elemento;
    }

    private void percolateDown(int index) {
        int elemento = monticulo[index];
        int half = tamanio / 2;
        while (index < half) {
            int hijoIzquierdo = 2 * index + 1;
            int hijoDerecho = hijoIzquierdo + 1;
            int hijoMayor = hijoDerecho < tamanio && monticulo[hijoDerecho] > monticulo[hijoIzquierdo]? hijoDerecho : hijoIzquierdo;

            if (elemento >= monticulo[hijoMayor]) break;
            monticulo[index] = monticulo[hijoMayor];
            index = hijoMayor;
        }
        monticulo[index] = elemento;
    }

    public void mostrarMonticulo() {
        System.out.print("Montículo: ");
        for (int i = 0; i < tamanio; i++) {
            System.out.print(monticulo[i] + " ");
        }
        System.out.println();
    }
}

