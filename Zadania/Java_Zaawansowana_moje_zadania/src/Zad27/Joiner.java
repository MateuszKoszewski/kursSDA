package Zad27;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class Joiner <T> {
    private String separator;

    public Joiner(String separator) {
        this.separator = separator;
    }

    // 1 SPOSÓB
//   public String join(T... value){
//       String chain=value[0].toString();
//       for (int i=1;i<value.length; i++){
//           chain+=separator+value[i];
//       }
//       return chain;
//   }

    //2 SPOSÓB
//    public String join (Collection<T> collection){
//       return collection.stream().map(str -> str.toString()).reduce("",(input,output) ->input+ separator + output).replaceFirst("-","");
//    }
    //3 SPOSÓB
    public String join(Collection<T> collection) {
        return collection.stream().map(str -> str.toString()).collect(Collectors.joining(separator));
    }
}