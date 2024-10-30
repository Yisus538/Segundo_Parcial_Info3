package utils.estructuras;

public interface Cola<T> {
    void enqueue(T elemento);
    T dequeue();
    T top();
    boolean isEmpty();
}