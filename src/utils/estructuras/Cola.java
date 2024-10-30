package utils.estructuras;

public class Cola<T> {
    private T[] elementos;
    private int frente;
    private int fondo;
    private int tamaño;
    private int capacidad;

    // Constructor
    public Cola(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = (T[]) new Object[capacidad];
        this.frente = 0;
        this.fondo = -1;
        this.tamaño = 0;
    }

    // Método enqueue para agregar un elemento a la cola
    public void enqueue(T elemento) {
        if (tamaño == capacidad) {
            throw new IllegalStateException("Cola llena");
        }
        fondo = (fondo + 1) % capacidad;
        elementos[fondo] = elemento;
        tamaño++;
    }

    // Método dequeue para eliminar el elemento al frente de la cola
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Cola vacía");
        }
        T elemento = elementos[frente];
        frente = (frente + 1) % capacidad;
        tamaño--;
        return elemento;
    }

    // Método para ver el elemento al frente sin eliminarlo
    public T top() {
        if (isEmpty()) {
            throw new IllegalStateException("Cola vacía");
        }
        return elementos[frente];
    }

    // Verifica si la cola está vacía
    public boolean isEmpty() {
        return tamaño == 0;
    }
    public int getCapacidad() {
        return capacidad;
    }
}
