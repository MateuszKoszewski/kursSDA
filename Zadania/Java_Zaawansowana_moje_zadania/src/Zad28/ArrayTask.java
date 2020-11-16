package Zad28;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayTask<E> extends ArrayList<E> {

    private List<E> list;

    public ArrayTask(List<E> list) {
        this.list = list;
    }

//     1 SPOSÓB
    public List<E> getEveryNthElement (int startIndex, int skip){
        List<E> newList = new ArrayList<>();
        for(int i=startIndex; i<list.size(); i+=skip+1){
            newList.add(list.get(i));
        }
        return newList;
    }
    //2 SPOSÓB - nie dziala ...
//    public List<E> getEveryNthElement(int startIndex, int skip) {
//return list.stream().filter(str -> list.indexOf(str)>=startIndex).filter(str -> list.indexOf(str)%skip==0).collect(Collectors.toList());
//    }
//
//    public List <E> getIndex (int index){
//        return list.stream().filter(str -> list.indexOf(str)>=index).collect(Collectors.toList());
//    }
//    public List<E> getSkip (int skip){
//        return list.stream().filter(str -> list.indexOf(str)%skip==0).collect(Collectors.toList());
//    }
//    public List<E> skip (int skip){
//        return list.stream().skip(skip).collect(Collectors.toList());
//    }
}