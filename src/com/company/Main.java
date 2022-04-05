//package com.company;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.stream.IntStream;
import java.util.Map;

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
        int[] a8 = new int[] { -14, 0, 1, 19, 144, 161, 191, 195 };
        int[] b8 = new int[] { 0, 1, 196, 361, 20736, 25921, 36481, 38025 };


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

        // System.out.println("tEST 8 :");
        // System.out.print(AreSame(a8, b8));
    }

    static boolean AreSame(int[] a, int[] b) {
            Arrays.sort(a);
            Arrays.sort(b);
            //określa czy dana tablica jest podzielna przez drugą
            int jest = 0;
            //suma długośći obu tablic
            int suma = IntStream.of(a).sum();
            int sumb = IntStream.of(b).sum();
            
            LinkedHashSet<Integer> = new 

            // dlugosci tablic a i b
            int dla = a.length;
            int dlb = b.length;

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
                    for(int i = 0 ; i < dla ; i++){
                        // Sprawdzanie po kolei czy kwadrat danej liczby
                        // jest kwadratem licbzy z tablicy a
                        if (pow(b[j], 2) == a[i]) {
                            // System.out.println("Jest równa tablicy b");
                            jest++;
                            // Sprawdzanie czy wartość zmiennej a i b jest taka sama
                        } else if (b[j] == 0 && a[i] == 0) {
                            jest++;
                            // alternatywne wyniki do warunków powyżej
                        }
                    }
                }
                // jeżeli sumy długości obu tablic sa jednakowe
            } else if (suma == sumb) {
                // sprawdzanie każdej kómórki pamieci
                for (int j = 0; j < dla; j++) {
                    for(int i = 0; i < dla; i++){
                        if (pow(b[j], 2) == a[i]) {
                            // sprawdzanie czy długość dla jest dłuższe od dlb
                            jest++;
                        } else if (b[j] == 0 && a[i] == 0) {
                            jest++;
                        }
                    }
                }
            } else if (sumb > suma) {
                for(int i = 0; i < dlb; i++){
                    for(int j = 0; j < dlb; j++){
                        if( pow(a[i] , 2) == b[j]){
                            jest++;
                        } else if(pow(a[i] , 2) == b[j]){
                            jest ++;
                        } else if( a[i] == 0 && b[i] == 0){
                            jest++;
                        }
                    }
                }
                
            } else{
                System.out.println("Coś poszło nie tak");
            }

            // zwraca ostateczny wynik działania funkcji
            if (jest == dla) {
                return true;
            }else if(jest == dlb){
                return true;
            }
            else {
                return false;
            }
        }

        // static int[] ridOFF(int[] a){
        //     // int[] temp = new int[a.length];
            
        //     // int tempprarily = 0;

        //     // for(int i = 0 ; i < a.length - 1; i++){
        //     //     int curr = a[i];

        //     //     if(curr != a[i+1]){
        //     //         temp[tempprarily++] = curr;
        //     //     }
        //     // }
            
        //     // temp[tempprarily++] = a[a.length - 1 ];

        //     LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(a.length));

        //     // bez dyplikatów
        //     Integer[] bezdup = linkedHashSet.toArray(new Integer[] {});

        //     return bezdup;
        // }
    }
