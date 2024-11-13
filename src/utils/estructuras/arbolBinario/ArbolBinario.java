package utils.estructuras.arbolBinario;

import java.util.Random;
import utils.estructuras.ColaLista;

public class ArbolBinario implements IArbol {
    private Nodo raiz;

    @Override
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }

    private Nodo insertarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }

        if (valor < actual.valor) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, valor);
        } else if (valor > actual.valor) { // Evita duplicados
            actual.derecho = insertarRecursivo(actual.derecho, valor);
        }

        return actual;
    }

    public void generarArbol() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int valor = random.nextInt(26);
            insertar(valor);
        }
    }

    @Override
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

    @Override
    public int profundidad() {
        return calcularProfundidad(raiz);
    }

    private int calcularProfundidad(Nodo nodo) {
        if (nodo == null) return 0;
        int profundidadIzquierda = calcularProfundidad(nodo.izquierdo);
        int profundidadDerecha = calcularProfundidad(nodo.derecho);
        return Math.max(profundidadIzquierda, profundidadDerecha) + 1;
    }

    @Override
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
            if (nodo.izquierdo == null) return nodo.derecho;
            if (nodo.derecho == null) return nodo.izquierdo;

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

    public void imprimirArbol() {
        if (raiz == null) {
            System.out.println("El arbol está vacio.");
            return;
        }

        ColaLista<Nodo> cola = new ColaLista<>();
        cola.enqueue(raiz);
        int nivel = 0;

        while (!cola.isEmpty()) {
            int tamañoNivel = cola.size();
            System.out.print("Nivel " + nivel + ": ");

            for (int i = 0; i < tamañoNivel; i++) {
                Nodo actual = cola.dequeue();
                if (actual != null) {
                    System.out.print(actual.valor + " ");
                    cola.enqueue(actual.izquierdo);
                    cola.enqueue(actual.derecho);
                }
            }
            System.out.println();
            nivel++;
        }
    }

}


