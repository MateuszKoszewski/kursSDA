package Zad4;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
//Stwórz klasę Storage , która będzie miała prywatne pole typu Map , publiczny konstruktor oraz metody:
//addToStorage(String key, String value)
//→ dodawanie elementów do przechowywalni
//printValues(String key)
//→ wyświetlanie wszystkich elementów pod danym kluczem
//findValues(String value)
//→ wyświetlanie wszystkich kluczy, które mają podaną wartość
//Klasa
//Storage powinna pozwalać na przechowywanie wielu wartości pod jednym kluczem.

public class Storage {
    private Map<String, List<String>> map;

    public Storage() {
        map = new HashMap<>();
    }

    public void addToStorage(String key, String value) {
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            List<String> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }

    }

    public void printValues(String key) {
        if (map.containsKey(key)) {
            System.out.println(map.get(key));
        } else {
            System.out.println("no key " + key);
        }
    }
//1 SPOSÓB
//    public void findValues(String value) {
//        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
//            if (entry.getValue().contains(value)) {
//                System.out.println(entry.getKey());
//            }
//        }
//    }
//    2 SPOSÓB
public void findValues(String value) {
       map.entrySet().stream().filter(str -> str.getValue().contains(value)).map(str -> str.getKey()).forEach(key -> System.out.println(key));

}


}
