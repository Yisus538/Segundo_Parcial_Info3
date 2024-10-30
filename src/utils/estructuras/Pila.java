package utils.estructuras;

public interface Pila<T> {
    void push(T elemento);
    T pop();
    T top();
    boolean isEmpty();
}
