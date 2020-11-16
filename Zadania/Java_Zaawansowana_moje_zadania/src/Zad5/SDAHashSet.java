package Zad5;

import java.util.HashMap;
import java.util.HashSet;
//Zaimplementuj klasę
//SDAHashSet<E> E>, która będzie implementować logikę HashSet<E> E>. W tym celu
//zaimplementuj obsługę metod:
//•
//add
//•
//remove
//•
//size
//•
//contains
//•
//clear
public class SDAHashSet<E> {
    private HashMap<E, Object> map;

    public SDAHashSet() {
        map = new HashMap<>();
    }

    public void add(E element) {
        map.put(element, new Object());
    }

    public void remove(E element) {
        map.remove(element);
    }

    public int size() {
        return map.size();
    }

    public boolean contains(E element) {
        return map.containsKey(element);
    }

    public void clear() {
        map.clear();
    }
}
