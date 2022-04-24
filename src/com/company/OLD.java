
// package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.IntStream;
import java.util.Map;

import static java.lang.Math.pow;

public class OLD {

    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        // int[] a = new int[] { 0, 144, 19, 161, 19, 144, 19, 11 };
        // int[] b = new int[] { 0, 14641, 20736, 361, 25921, 361, 20736, 361 };
        // int[] a1 = new int[] { 2, 2, 3 };
        // int[] b1 = new int[] { 4, 4, 9 };
        int[] a2 = new int[] { 11, 19, 19, 121, 144, 144, 161, 161 };
        int[] b2 = new int[] { 121, 361, 361, 361, 14641, 20736, 20736, 25921 };
        // int[] a3 = new int[] {};
        // int[] b3 = new int[] {};
        int[] a4 = new int[] { 0 };
        int[] b4 = new int[] { 0 };
        int[] a6 = new int[] { 11, 19, 19, 19, 121, 144, 144, 161, 1008 };
        int[] b6 = new int[] { 121, 361, 361, 14641, 20736, 20736, 25921, 36100 };
        int[] a7 = new int[] { 2, 2, 3 };
        int[] b7 = new int[] { 4, 9, 9 };
        int[] a8 = new int[] { -14, 0, 1, 19, 144, 161, 191, 195 };
        int[] b8 = new int[] { 0, 1, 196, 361, 20736, 25921, 36481, 38025 };

        // System.out.println("Test 1: ");
        // System.out.println(AreSame(a, b));
        System.out.println("Test 2 Wartosc ktora powinna wyjsc : True");
        System.out.println(AreSame(a2, b2));
        // System.out.println("Test 3: ");
        // System.out.println(AreSame(a2, b2));
        // System.out.println("Test 4: ");
        // System.out.println(AreSame(a3, b3));
        // System.out.println("Test 5: ");
        // System.out.println(AreSame(a4, b4));
        // System.out.println("Test 6: ");
        // System.out.println(AreSame(a6, b6));
        System.out.println(":Test 7");
        System.out.println(AreSame(a7, b7));

        // System.out.println("tEST 8 :");
        // System.out.print(AreSame(a8, b8));
    }

    static boolean AreSame(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        // suma długośći obu tablic
        int suma = IntStream.of(a).sum();
        int sumb = IntStream.of(b).sum();


        // sprawdzanei podstawowowych założeń 
        if (a.length != b.length) {
            System.out.println("Nie są jednkaowej długośći ");
            return false;
        } else if (a == null || b == null) {
            System.out.println("Tablice są puste");
            return false;
        }
        int[] sortedA = Arrays.stream(a).map(Math::abs).sorted().toArray();
        int[] sortedB = Arrays.stream(b).sorted().toArray();


        for(int i = 0; i < a.length; i++){
            if(sortedA[i] * sortedA[i] != sortedB[i]){
                return false;
            }
        }
        return true;
    }

    
}
