package utils.estructuras;

import java.util.EmptyStackException;

public class PilaArreglo<T> implements Pila<T> {
    private static final int CAPACIDAD_INICIAL = 10;
    private T[] elementos;
    private int tope;

    @SuppressWarnings("unchecked")
    public PilaArreglo() {
        elementos = (T[]) new Object[CAPACIDAD_INICIAL];
        tope = -1;
    }

    @Override
    public void push(T elemento) {
        if (tope + 1 == elementos.length) {
            expandirCapacidad();
        }
        elementos[++tope] = elemento;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos[tope--];
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elementos[tope];
    }

    @Override
    public boolean isEmpty() {
        return tope == -1;
    }

    private void expandirCapacidad() {
        T[] nuevoArreglo = (T[]) new Object[elementos.length * 2];
        System.arraycopy(elementos, 0, nuevoArreglo, 0, elementos.length);
        elementos = nuevoArreglo;
    }
}

