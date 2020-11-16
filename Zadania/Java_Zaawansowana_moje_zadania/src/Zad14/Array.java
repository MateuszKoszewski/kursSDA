package Zad14;

import java.util.*;
import java.util.stream.Collectors;

public class Array {
    private List<Integer> array;
    private int size;

    public Array(int size) {
        Random random = new Random();
        this.size = size;
        array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            array.add(random.nextInt(size));
        }
    }

    public List<Integer> getArray() {
        return array;
    }

    public Map<Integer, Integer> getMap() {
        return array.stream().collect(Collectors.groupingBy(x -> x)).entrySet().stream().collect(Collectors.toMap(str -> str.getKey(), val -> val.getValue().size()));
    }

    public List<Integer> getUniqueValues() {
        return getMap().entrySet().stream().filter(str -> str.getValue() == 1).map(str -> str.getKey()).collect(Collectors.toList());
    }

    public List<Integer> getAtLeast2Values() {
        return getMap().entrySet().stream().filter(str -> str.getValue() >= 2).map(str -> str.getKey()).collect(Collectors.toList());
    }

    public List<Integer> get25MostCommon() {
        return getMap().entrySet().stream().filter(str -> str.getValue() >= 2).sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(25).map(str -> str.getKey()).collect(Collectors.toList());
    }
    //metoda deduplikuje wszystkie duplikaty, dopóki nie staną się unikatami - ostatnie powtórzenie duplikatu staje się unikatem i zostaje na liście
    // natomiast można zrozumieć zadanie w inny sposób - metoda ma zastępować duplikat, a element staje się duplikatem, kiedy się powtarza, zatem póki się nie powtórzy
    // przechodząc po liście - jest unikatem. Należy wtedy zastąpić go inną wartością, dopiero kiedy się powtórzy.

    // wersja PIERWSZA
//        public void deduplicateValues(){
//for (int i=0; i<array.size();){
//    Integer value = array.get(i);
//    if (getUniqueValues().contains(value)){
//        i++;
//    }
//    else {
//        array.set(i, new Random().nextInt(size));
//    }
//
//}
//        }

    // wersja DRUGA - zastępowane są wartości, dopiero kiedy się powtórzą
    public void deduplicateValues() {
        for (int i = 0; i < array.size(); i++ ) {
            Integer value = array.get(i);
            if (getAtLeast2Values().contains(value)) {
                for (int j = 0; j < i; j++) {
                    if (array.get(j).equals(array.get(i))) {
                        array.set(i, new Random().nextInt(size));
                        j=-1;
                    }

                }
            }
        }
    }
}