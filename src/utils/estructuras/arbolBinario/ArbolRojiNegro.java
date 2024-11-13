package utils.estructuras.arbolBinario;

public class ArbolRojiNegro {

    private NodoRojinegro raiz;
    private final NodoRojinegro nodoNulo;

    public ArbolRojiNegro() {
        nodoNulo = new NodoRojinegro(0);
        nodoNulo.esRojo = false; // Las hojas nulas son negras
        raiz = nodoNulo;
    }

    /**
     * Inserta un valor en el árbol rojinegro y lo balancea según las reglas.
     * Esta función cumple con el requerimiento de insertar y balancear nodos.
     *
     * @param valor El valor a insertar en el árbol.
     */
    public void insertar(int valor) {
        NodoRojinegro nodo = new NodoRojinegro(valor);
        nodo.izquierdo = nodoNulo;
        nodo.derecho = nodoNulo;

        NodoRojinegro tempPadre = null;
        NodoRojinegro temp = raiz;

        while (temp != nodoNulo) {
            tempPadre = temp;
            if (nodo.valor < temp.valor) {
                temp = temp.izquierdo;
            } else {
                temp = temp.derecho;
            }
        }

        nodo.padre = tempPadre;
        if (tempPadre == null) {
            raiz = nodo;
        } else if (nodo.valor < tempPadre.valor) {
            tempPadre.izquierdo = nodo;
        } else {
            tempPadre.derecho = nodo;
        }

        if (nodo.padre == null) {
            nodo.esRojo = false;
            return;
        }

        if (nodo.padre.padre == null) {
            return;
        }

        balancearInsercion(nodo);
    }

    /**
     * Realiza las rotaciones necesarias para balancear el árbol rojinegro tras una inserción.
     * Esta función cumple con la consigna de balancear el árbol tras cada inserción.
     *
     * @param nodo El nodo recién insertado que puede haber causado desbalance.
     */
    private void balancearInsercion(NodoRojinegro nodo) {
        NodoRojinegro temp;
        while (nodo.padre.esRojo) {
            if (nodo.padre == nodo.padre.padre.izquierdo) {
                temp = nodo.padre.padre.derecho;
                if (temp.esRojo) {
                    nodo.padre.esRojo = false;
                    temp.esRojo = false;
                    nodo.padre.padre.esRojo = true;
                    nodo = nodo.padre.padre;
                } else {
                    if (nodo == nodo.padre.derecho) {
                        nodo = nodo.padre;
                        rotarIzquierda(nodo);
                    }
                    nodo.padre.esRojo = false;
                    nodo.padre.padre.esRojo = true;
                    rotarDerecha(nodo.padre.padre);
                }
            } else {
                temp = nodo.padre.padre.izquierdo;
                if (temp.esRojo) {
                    nodo.padre.esRojo = false;
                    temp.esRojo = false;
                    nodo.padre.padre.esRojo = true;
                    nodo = nodo.padre.padre;
                } else {
                    if (nodo == nodo.padre.izquierdo) {
                        nodo = nodo.padre;
                        rotarDerecha(nodo);
                    }
                    nodo.padre.esRojo = false;
                    nodo.padre.padre.esRojo = true;
                    rotarIzquierda(nodo.padre.padre);
                }
            }
            if (nodo == raiz) break;
        }
        raiz.esRojo = false;
    }

    /**
     * Realiza una rotación a la izquierda alrededor de un nodo para mantener el equilibrio del árbol.
     * Esta función cumple con la consigna de realizar rotaciones necesarias en el árbol.
     *
     * @param nodo El nodo sobre el cual se realizará la rotación.
     */
    private void rotarIzquierda(NodoRojinegro nodo) {
        NodoRojinegro temp = nodo.derecho;
        nodo.derecho = temp.izquierdo;
        if (temp.izquierdo != nodoNulo) {
            temp.izquierdo.padre = nodo;
        }
        temp.padre = nodo.padre;
        if (nodo.padre == null) {
            raiz = temp;
        } else if (nodo == nodo.padre.izquierdo) {
            nodo.padre.izquierdo = temp;
        } else {
            nodo.padre.derecho = temp;
        }
        temp.izquierdo = nodo;
        nodo.padre = temp;
    }

    /**
     * Realiza una rotación a la derecha alrededor de un nodo para mantener el equilibrio del árbol.
     * Esta función cumple con la consigna de realizar rotaciones necesarias en el árbol.
     *
     * @param nodo El nodo sobre el cual se realizará la rotación.
     */
    private void rotarDerecha(NodoRojinegro nodo) {
        NodoRojinegro temp = nodo.izquierdo;
        nodo.izquierdo = temp.derecho;
        if (temp.derecho != nodoNulo) {
            temp.derecho.padre = nodo;
        }
        temp.padre = nodo.padre;
        if (nodo.padre == null) {
            raiz = temp;
        } else if (nodo == nodo.padre.derecho) {
            nodo.padre.derecho = temp;
        } else {
            nodo.padre.izquierdo = temp;
        }
        temp.derecho = nodo;
        nodo.padre = temp;
    }

    /**
     * Imprime una representación visual del árbol rojinegro, mostrando el valor y color de cada nodo.
     * Esta función cumple con la consigna de visualizar el árbol y los colores de cada nodo.
     */
    public void visualizarArbol() {
        imprimirArbol(raiz, "", true);
    }

    private void imprimirArbol(NodoRojinegro nodo, String indent, boolean ultimo) {
        if (nodo != nodoNulo) {
            System.out.print(indent);
            if (ultimo) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }

            String color = nodo.esRojo ? "ROJO" : "NEGRO";
            System.out.println(nodo.valor + "(" + color + ")");
            imprimirArbol(nodo.izquierdo, indent, false);
            imprimirArbol(nodo.derecho, indent, true);
        }
    }
}

