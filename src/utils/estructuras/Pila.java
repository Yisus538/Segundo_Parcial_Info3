package utils.estructuras;

public class Pila<T> {

    private T[] elementos;
    private int tope;
    private int capacidad;

    public Pila(int capacidad) {
        this.capacidad = capacidad;
        this.elementos = (T[]) new Object[capacidad];
        this.tope = -1;
    }

    // Método push para agregar un elemento a la pila
    public void push(T elemento) {
        if (tope == capacidad - 1) {
            throw new StackOverflowError("Pila llena");
        }
        elementos[++tope] = elemento;
    }
    // Método pop para eliminar el elemento de la cima de la pila
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Pila vacía");
        }
        return elementos[tope--];
    }
    // Método top para ver el elemento de la cima sin eliminarlo
    public T top() {
        if (isEmpty()) {
            throw new IllegalStateException("Pila vacía");
        }
        return elementos[tope];
    }
    // Verifica si la pila está vacía
    public boolean isEmpty() {
        return tope == -1;
    }
}

