package utils.estructuras;

import java.util.NoSuchElementException;

public class ColaArreglo<T> implements Cola<T> {
    private static final int CAPACIDAD_INICIAL = 10;
    private T[] elementos;
    private int frente, fin, tamanio;

    @SuppressWarnings("unchecked")
    public ColaArreglo() {
        elementos = (T[]) new Object[CAPACIDAD_INICIAL];
        frente = 0;
        fin = -1;
        tamanio = 0;
    }

    @Override
    public void enqueue(T elemento) {
        if (tamanio == elementos.length) {
            expandirCapacidad();
        }
        fin = (fin + 1) % elementos.length;
        elementos[fin] = elemento;
        tamanio++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        T elemento = elementos[frente];
        frente = (frente + 1) % elementos.length;
        tamanio--;
        return elemento;
    }

    @Override
    public T top() {
        if (isEmpty()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        return elementos[frente];
    }

    @Override
    public boolean isEmpty() {
        return tamanio == 0;
    }

    private void expandirCapacidad() {
        T[] nuevoArreglo = (T[]) new Object[elementos.length * 2];
        for (int i = 0; i < tamanio; i++) {
            nuevoArreglo[i] = elementos[(frente + i) % elementos.length];
        }
        elementos = nuevoArreglo;
        frente = 0;
        fin = tamanio - 1;
    }
    public int size() {
        return tamanio;
    }

}

