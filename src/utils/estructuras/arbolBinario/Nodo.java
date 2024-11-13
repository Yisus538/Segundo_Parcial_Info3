package utils.estructuras.arbolBinario;

public class Nodo {
    int valor;
    Nodo izquierdo;
    Nodo derecho;
    int altura;

    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
        this.altura = 1;
    }
}

