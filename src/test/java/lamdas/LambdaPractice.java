package lamdas;

import java.util.Comparator;
import java.util.Date;

public class LambdaPractice  {




    @FunctionalInterface
   static interface Function1 <R,T> {
        String toString(); // inherited from Object
        boolean equals(Object ob); // inherited from Object
        R apply(T t); // function with one param
    };


   static Comparator<String> comp = (s1, s2) -> {
        if (s1.length() < s2.length()) return -1;
        if (s1.length() > s2.length()) return +1;
        return 0;
    } ;


    public static void main(String[] args) {


        System.out.println(comp);


        System.out.println();




    }




}
