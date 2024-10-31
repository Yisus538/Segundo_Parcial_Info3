package utils.estructuras.arbolBinario;

import java.util.Random;

public class ArbolBinario {
    private Nodo raiz;

    // Insertar un valor en el árbol
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }

        if (valor < actual.valor) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, valor);
        } else if (valor > actual.valor) { // Para evitar duplicados
            actual.derecho = insertarRecursivo(actual.derecho, valor);
        }

        return actual;
    }

    // Generar el árbol con 10 valores aleatorios entre 0 y 25
    public void generarArbol() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int valor = random.nextInt(26); // Valores entre 0 y 25
            insertar(valor);
        }
    }

    // Recorrido Inorden
    public void inorder() {
        inorderRecursivo(raiz);
        System.out.println();
    }

    private void inorderRecursivo(Nodo nodo) {
        if (nodo != null) {
            inorderRecursivo(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inorderRecursivo(nodo.derecho);
        }
    }

    // Calcular la profundidad del árbol
    public int profundidad() {
        return calcularProfundidad(raiz);
    }

    private int calcularProfundidad(Nodo nodo) {
        if (nodo == null) {
            return 0;
        }
        int profundidadIzquierda = calcularProfundidad(nodo.izquierdo);
        int profundidadDerecha = calcularProfundidad(nodo.derecho);
        return Math.max(profundidadIzquierda, profundidadDerecha) + 1;
    }

    // Método para eliminar un nodo con un valor dado
    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    private Nodo eliminarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            System.out.println("El valor " + valor + " no se encuentra en el árbol.");
            return null;
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = eliminarRecursivo(nodo.derecho, valor);
        } else {
            // Nodo con un solo hijo o sin hijos
            if (nodo.izquierdo == null) return nodo.derecho;
            if (nodo.derecho == null) return nodo.izquierdo;

            // Nodo con dos hijos: obtener el valor mínimo en el subárbol derecho
            nodo.valor = encontrarMin(nodo.derecho);
            nodo.derecho = eliminarRecursivo(nodo.derecho, nodo.valor);
        }
        return nodo;
    }

    private int encontrarMin(Nodo nodo) {
        int minValor = nodo.valor;
        while (nodo.izquierdo != null) {
            minValor = nodo.izquierdo.valor;
            nodo = nodo.izquierdo;
        }
        return minValor;
    }
}

