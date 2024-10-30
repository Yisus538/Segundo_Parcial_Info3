package utils.estructuras;

import java.util.NoSuchElementException;

public class PilaLista<T> implements Pila<T> {
    private Nodo<T> cima;

    // Clase interna Nodo
    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato, Nodo<T> siguiente) {
            this.dato = dato;
            this.siguiente = siguiente;
        }
    }

    // Implementación de métodos de la interfaz Pila
    @Override
    public void push(T elemento) {
        cima = new Nodo<>(elemento, cima);
    }

    @Override
    public T pop() {
        if (cima == null) {
            throw new NoSuchElementException("La pila está vacía");
        }
        T dato = cima.dato;
        cima = cima.siguiente;
        return dato;
    }

    @Override
    public T top() {
        if (cima == null) {
            throw new NoSuchElementException("La pila está vacía");
        }
        return cima.dato;
    }

    @Override
    public boolean isEmpty() {
        return cima == null;
    }
}
