package utils.estructuras;

import java.util.NoSuchElementException;

public class ColaLista<T> implements Cola<T> {

    private Nodo<T> frente;
    private Nodo<T> fin;
    private int tam;

    // Clase interna Nodo
    private static class Nodo<T> {
        T dato;
        Nodo<T> siguiente;

        Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }
    // Implementación de métodos de la interfaz Cola
    @Override
    public void enqueue(T elemento) {
        Nodo<T> nuevoNodo = new Nodo<>(elemento);
        if (isEmpty()) {
            frente = fin = nuevoNodo;
        } else {
            fin.siguiente = nuevoNodo;
            fin = nuevoNodo;
        }
        tam++;
    }
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        T dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null) {
            fin = null;
        }
        tam--;
        return dato;
    }
    @Override
    public T top() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        return frente.dato;
    }
    @Override
    public boolean isEmpty() {
        return frente == null;
    }
    // Método para obtener el tamaño de la cola
    public int size() {
        return tam;
    }
}

