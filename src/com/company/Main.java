//package com.company;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.io.*;

import static java.lang.Math.pow;

public class Main {

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
        int[] a7 = new int[]{2,2,3};
        int[] b7 = new int[]{4,9,9};


        // System.out.println("Test 1: ");
        // System.out.println(AreSame(a, b));
        // System.out.println("Test 2 Wartosc ktora powinna wyjsc : True");
        // System.out.println(AreSame(a1, b1));
        // System.out.println("Test 3: ");
        // System.out.println(AreSame(a2, b2));
        // System.out.println("Test 4: ");
        // System.out.println(AreSame(a3, b3));
        // System.out.println("Test 5: ");
        // System.out.println(AreSame(a4, b4));
        // System.out.println("Test 6: ");
        // System.out.println(AreSame(a6, b6));
        System.out.println(":Test 7" );
        System.out.println(AreSame(a7, b7));
    }

    static boolean AreSame(int[] a, int[] b) {
            Arrays.sort(a);
            Arrays.sort(b);
            boolean jest = false;
            // dlugosci tablic a i b
            int dla = a.length;
            int dlb = b.length;
            int suma = IntStream.of(a).sum();
            int sumb = IntStream.of(b).sum();

            // for (int i = 0; i < a.length; i++) {
            // System.out.println("Wartosc zmiennej a: " + a[i]);
            // System.out.println("Wartosc zmiennej b: " + b[i]);
            // }

            // wyświetla sume wartośći poszczególnych tablic
            System.out.println("Suma wartośći a " + suma);
            System.out.println("Suma wartośći b " + sumb);

            if (dla != dlb) {
                System.out.println("Nie są jednkaowej długośći ");
                return false;
            } else if(a == null || b == null){
                System.out.println("Tablice są puste");
                return false; 
            } else if( dla == 0 && dlb == 0){
                System.out.println("Tablice mają tylko zero w sobie ");
                return true;
            }

            // for (int i = 0; i < dla; i++) {
            // System.out.println("Wartosc zmiennej a: " + a[i]);
            // System.out.println("Wartosc zmiennej b: " + b[i]);
            // }


            if (suma > sumb) {
                // sprawdzanie wszystkich elementów tablicy a
                for (int j = 0; j < dla; j++) {
                    // Sprawdzanie po kolei czy kwadrat danej liczby
                    // jest kwadratem licbzy z tablicy a
                    if (pow(b[j], 2) == a[j]) {
                        // System.out.println("Jest równa tablicy b");
                        jest = true;
                        // Sprawdzanie czy wartość zmiennej a i b jest taka sama
                    } else if (b[j] == 0 && a[j] == 0) {
                        jest = true;
                        // alternatywne wyniki do warunków powyżej
                    } else {
                        jest = false;
                        //jeżeli chociaż jedna liczba się nie zgadza to nie ma sensu sprawdzac dalej
                        break;
                    }

                }
                // jeżeli sumy długości obu tablic sa jednakowe
            } else if (suma == sumb) {
                // sprawdzanie każdej kómórki pamieci
                for (int j= 0; j < dla; j++) {
                    if (pow(b[j], 2) == a[j]) {
                        // sprawdzanie czy długość dla jest dłuższe od dlb
                        jest = true;
                    } else if (b[j] == 0 && a[j] == 0) {
                        jest = true;
                    } else {
                        jest = false;
                    }
                }
            } else if (sumb > suma) {
                for (int j = 0; j < dla; j++) {
                    
                    // Sprawdzanie po kolei czy kwadrat liczby z talicy a
                    // jest liczbą z tablicy b
                    if (pow(a[j], 2) == b[j]) {
                        // System.out.println("Tablica a jest równa tablica b");
                        jest = true;
                        // poniżej dodana nowa wartość
                    } else if (a[j] == 0 && b[j] == 0) {
                        jest = true;
                    } else {
                        // jezeli chociaz jedna z liczb sie nie zgodzi to po co dalej sprawdzać
                        jest = false;
                    }

                }
            }

            // zwraca ostateczny wynik działania funkcji
            if (jest) {
                return true;
            } else {
                return false;
            }

        }

    }
