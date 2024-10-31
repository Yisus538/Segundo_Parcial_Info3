package utils.estructuras.arbolBinario;

public interface IArbol {
    void insertar(int valor);
    void inorder();
    int profundidad();
    void eliminar(int valor);
    void generarArbol();

}