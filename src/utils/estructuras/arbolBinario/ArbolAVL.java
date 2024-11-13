package utils.estructuras.arbolBinario;

import java.util.Random;

public class ArbolAVL implements IArbol {

    private Nodo raiz;

    // Método para obtener la altura de un nodo
    private int altura(Nodo nodo) {
        return (nodo == null) ? 0 : nodo.altura;
    }
    // Factor de balanceo de un nodo
    private int factorBalance(Nodo nodo) {
        return (nodo == null) ? 0 : altura(nodo.izquierdo) - altura(nodo.derecho);
    }
    // Rotación a la derecha
    private Nodo rotarDerecha(Nodo y) {
        Nodo x = y.izquierdo;
        Nodo T2 = x.derecho;

        // Rotación
        x.derecho = y;
        y.izquierdo = T2;

        // Actualizar alturas
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;

        // Nueva raíz
        return x;
    }
    // Rotación a la izquierda
    private Nodo rotarIzquierda(Nodo x) {
        Nodo y = x.derecho;
        Nodo T2 = y.izquierdo;

        // Rotación
        y.izquierdo = x;
        x.derecho = T2;

        // Actualizar alturas
        x.altura = Math.max(altura(x.izquierdo), altura(x.derecho)) + 1;
        y.altura = Math.max(altura(y.izquierdo), altura(y.derecho)) + 1;

        // Nueva raíz
        return y;
    }
    // Método de inserción con balanceo
    @Override
    public void insertar(int valor) {
        raiz = insertarRecursivo(raiz, valor);
    }
    private Nodo insertarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return new Nodo(valor);
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        } else {
            return nodo; // No se permiten valores duplicados
        }

        // Actualizar altura del nodo actual
        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));

        // Balancear el nodo
        return balancear(nodo);
    }
    // Método para balancear el árbol en caso de desbalance
    private Nodo balancear(Nodo nodo) {
        int balance = factorBalance(nodo);

        // Rotación hacia la derecha (desbalance en la izquierda)
        if (balance > 1 && factorBalance(nodo.izquierdo) >= 0) {
            return rotarDerecha(nodo);
        }

        // Rotación hacia la izquierda-derecha (desbalance en la izquierda-derecha)
        if (balance > 1 && factorBalance(nodo.izquierdo) < 0) {
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            return rotarDerecha(nodo);
        }

        // Rotación hacia la izquierda (desbalance en la derecha)
        if (balance < -1 && factorBalance(nodo.derecho) <= 0) {
            return rotarIzquierda(nodo);
        }

        // Rotación hacia la derecha-izquierda (desbalance en la derecha-izquierda)
        if (balance < -1 && factorBalance(nodo.derecho) > 0) {
            nodo.derecho = rotarDerecha(nodo.derecho);
            return rotarIzquierda(nodo);
        }

        return nodo; // No necesita balanceo
    }
    // Método para eliminar un nodo con balanceo
    @Override
    public void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }
    // Método para generar un árbol AVL con valores aleatorios
    @Override
    public void generarArbol() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int valor = random.nextInt(26); // Genera valores entre 0 y 25
            insertar(valor);
        }
        System.out.println("Árbol AVL generado con valores aleatorios.");
    }
    private Nodo eliminarRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return null;
        }

        if (valor < nodo.valor) {
            nodo.izquierdo = eliminarRecursivo(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = eliminarRecursivo(nodo.derecho, valor);
        } else {
            if ((nodo.izquierdo == null) || (nodo.derecho == null)) {
                nodo = (nodo.izquierdo != null) ? nodo.izquierdo : nodo.derecho;
            } else {
                Nodo temp = encontrarMin(nodo.derecho);
                nodo.valor = temp.valor;
                nodo.derecho = eliminarRecursivo(nodo.derecho, temp.valor);
            }
        }

        if (nodo == null) return nodo;

        nodo.altura = Math.max(altura(nodo.izquierdo), altura(nodo.derecho)) + 1;
        return balancear(nodo);
    }
    private Nodo encontrarMin(Nodo nodo) {
        Nodo actual = nodo;
        while (actual.izquierdo != null) {
            actual = actual.izquierdo;
        }
        return actual;
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
        return altura(raiz);
    }
}

