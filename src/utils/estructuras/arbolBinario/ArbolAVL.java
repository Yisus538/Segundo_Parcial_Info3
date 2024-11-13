package utils.estructuras.arbolBinario;

public class ArbolAVL {
    private Nodo raiz;

    // Obtener la altura de un nodo
    private int altura(Nodo nodo) {
        return (nodo == null) ? 0 : nodo.altura;
    }

    // Actualizar altura de un nodo
    private void actualizarAltura(Nodo nodo) {
        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
    }

    // Obtener factor de equilibrio
    private int obtenerFactorEquilibrio(Nodo nodo) {
        return (nodo == null) ? 0 : altura(nodo.izquierdo) - altura(nodo.derecho);
    }

    // Rotación a la derecha
    private Nodo rotacionDerecha(Nodo y) {
        Nodo x = y.izquierdo;
        Nodo T2 = x.derecho;

        x.derecho = y;
        y.izquierdo = T2;

        actualizarAltura(y);
        actualizarAltura(x);

        return x;
    }

    // Rotación a la izquierda
    private Nodo rotacionIzquierda(Nodo x) {
        Nodo y = x.derecho;
        Nodo T2 = y.izquierdo;

        y.izquierdo = x;
        x.derecho = T2;

        actualizarAltura(x);
        actualizarAltura(y);

        return y;
    }

    // Rotación doble a la derecha
    private Nodo rotacionDobleDerecha(Nodo nodo) {
        nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
        return rotacionDerecha(nodo);
    }

    // Rotación doble a la izquierda
    private Nodo rotacionDobleIzquierda(Nodo nodo) {
        nodo.derecho = rotacionDerecha(nodo.derecho);
        return rotacionIzquierda(nodo);
    }

    // Inserción de un valor en el árbol AVL
    public Nodo insertar(Nodo nodo, int valor) {
        if (nodo == null) return new Nodo(valor);

        if (valor < nodo.valor) {
            nodo.izquierdo = insertar(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = insertar(nodo.derecho, valor);
        } else {
            return nodo; // No se permiten valores duplicados
        }

        actualizarAltura(nodo);
        int balance = obtenerFactorEquilibrio(nodo);

        // Aplicación de las rotaciones en caso de desbalance
        if (balance > 1 && valor < nodo.izquierdo.valor) {
            return rotacionDerecha(nodo);
        }
        if (balance < -1 && valor > nodo.derecho.valor) {
            return rotacionIzquierda(nodo);
        }
        if (balance > 1 && valor > nodo.izquierdo.valor) {
            return rotacionDobleDerecha(nodo);
        }
        if (balance < -1 && valor < nodo.derecho.valor) {
            return rotacionDobleIzquierda(nodo);
        }

        return nodo;
    }

    // Método público para insertar
    public void insertar(int valor) {
        raiz = insertar(raiz, valor);
    }

    // Mostrar árbol en InOrden
    public void mostrarInOrden(Nodo nodo) {
        if (nodo != null) {
            mostrarInOrden(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            mostrarInOrden(nodo.derecho);
        }
    }

    public void mostrarInOrden() {
        mostrarInOrden(raiz);
        System.out.println();
    }
}
