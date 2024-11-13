package utils.estructuras;

import java.util.LinkedList;

public class TablaHash {
    private LinkedList<Entry>[] tabla;
    private int capacidad;

    public TablaHash(int capacidad) {
        this.capacidad = capacidad;
        tabla = new LinkedList[capacidad];
        for (int i = 0; i < capacidad; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    private int hashFunction(int clave) {
        return clave % capacidad;
    }

    public void insertar(int clave, int valor) {
        int index = hashFunction(clave);
        for (Entry entry : tabla[index]) {
            if (entry.clave == clave) {
                entry.valor = valor;
                return;
            }
        }
        tabla[index].add(new Entry(clave, valor));
    }

    public Integer buscar(int clave) {
        int index = hashFunction(clave);
        for (Entry entry : tabla[index]) {
            if (entry.clave == clave) return entry.valor;
        }
        return null;
    }

    public void eliminar(int clave) {
        int index = hashFunction(clave);
        tabla[index].removeIf(entry -> entry.clave == clave);
    }

    public void mostrarTabla() {
        for (int i = 0; i < capacidad; i++) {
            System.out.print(i + ": ");
            for (Entry entry : tabla[i]) {
                System.out.print("{" + entry.clave + ": " + entry.valor + "} ");
            }
            System.out.println();
        }
    }

    private static class Entry {
        int clave, valor;
        public Entry(int clave, int valor) {
            this.clave = clave;
            this.valor = valor;
        }
    }
}

