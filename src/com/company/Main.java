package com.company;

import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.pow;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello, World!");

        int[] a = new int[]{121, 144, 19, 161, 19, 144, 19, 11};
        int[] b = new int[]{121, 14641, 20736, 361, 25921, 361, 20736, 361};

        System.out.println(AreSame(a , b));
    }

     static boolean AreSame(int[] a, int[] b ){
         Arrays.sort(a);
         Arrays.sort(b);
         boolean jest = false;
         //dlugosci tablic a i b
         int dla = a.length;
         int dlb = b.length;
         int suma = IntStream.of(a).sum();
         int sumb = IntStream.of(b).sum();

         System.out.println("Suma wartośći a " + suma);
         System.out.println("Suma wartośći b " + sumb);

        //sprawdzanie czy długości arrayów są równe
         if( dla != dlb || a == null || dla == 0 || dlb != dla || b == null || dlb == 0){
             //System.out.println("Nie są jednakowej długośći");
             return false;
         }


         if(suma > sumb){
             //sprawdzanie wszystkich elementów tablicy a
             for (int j = 0; j < dla; j++) {
                 //Sprawdzanie po kolei czy kwadrat danej liczby
                 //jest kwadratem liczby z tablicy a
                 if ( (int)pow(b[j], 2) == a[j]) {
                     //System.out.println("Jest równa tablicy b");
                     jest = true;
                     //break;
                 } else {
                     //System.out.println("tablica b Nie jest równa z indeksem: " + a[j]);
                     jest = false;
                     break;
                 }

             }
         } else {
             for (int j = 0; j < dla; j++) {
                 //Sprawdzanie po kolei czy kwadrat danej liczby
                 //jest kwadratem liczby z tablicy b
                 if ( (int)pow(a[j], 2) == b[j]) {
                     //System.out.println("Tablica a jest równa tablica b");
                     jest = true;
                     //break;
                 } else {
                     //System.out.println("Tablica b nie jest równa z indeksem: " + b[j]);
                     jest = false;
                     break;
                 }

             }
         }

         //ostateczne zwracanie wartości
         if(jest){
             return true;
         } else{
             return false;
         }

    }


}

