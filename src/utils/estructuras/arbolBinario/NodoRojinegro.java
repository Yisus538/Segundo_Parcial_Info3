package utils.estructuras.arbolBinario;

public class NodoRojinegro {
    int valor;
    NodoRojinegro izquierdo, derecho, padre;
    boolean esRojo; // True para rojo, false para negro

    public NodoRojinegro(int valor) {
        this.valor = valor;
        this.esRojo = true; // Los nuevos nodos en un árbol rojinegro se insertan inicialmente como rojos
        this.izquierdo = null;
        this.derecho = null;
        this.padre = null;
    }
}

