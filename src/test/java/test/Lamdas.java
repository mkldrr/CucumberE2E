package test;

import java.util.Comparator;

public class Lamdas {


   static Comparator<String> comp = (s1, s2) -> {
        if (s1.length() < s2.length()) return -1;
        if (s1.length() > s2.length()) return +1;
        return 0;
    } ;


    public static void main(String[] args) {


        System.out.println(comp );
    }



}
