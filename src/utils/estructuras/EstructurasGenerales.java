package utils.estructuras;

import java.util.*;

public class EstructurasGenerales {
    private ArrayList<Object> arrayList = new ArrayList<>();
    private LinkedList<Object> linkedList = new LinkedList<>();
    private HashMap<String, Object> hashMap = new HashMap<>();
    private TreeMap<String, Object> treeMap = new TreeMap<>();
    private LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap<>();

    public void agregarArrayList(Object obj) {
        arrayList.add(obj);
    }
    public void mostrarArrayList() {
        System.out.println("ArrayList: " + arrayList);
    }
    public void eliminarArrayList(int index) {
        if (index >= 0 && index < arrayList.size()) {
            arrayList.remove(index);
        }
    }
    public void agregarLinkedList(Object obj) {
        linkedList.add(obj);
    }
    public void mostrarLinkedList() {
        System.out.println("LinkedList: " + linkedList);
    }
    public void eliminarLinkedList(int index) {
        if (index >= 0 && index < linkedList.size()) {
            linkedList.remove(index);
        }
    }
    public void agregarHashMap(String clave, Object valor) {
        hashMap.put(clave, valor);
    }
    public void mostrarHashMap() {
        System.out.println("HashMap: " + hashMap);
    }
    public void eliminarHashMap(String clave) {
        hashMap.remove(clave);
    }
    public void agregarTreeMap(String clave, Object valor) {
        treeMap.put(clave, valor);
    }
    public void mostrarTreeMap() {
        System.out.println("TreeMap: " + treeMap);
    }
    public void eliminarTreeMap(String clave) {
        treeMap.remove(clave);
    }
    public void agregarLinkedHashMap(String clave, Object valor) {
        linkedHashMap.put(clave, valor);
    }
    public void mostrarLinkedHashMap() {
        System.out.println("LinkedHashMap: " + linkedHashMap);
    }
    public void eliminarLinkedHashMap(String clave) {
        linkedHashMap.remove(clave);
    }
}

