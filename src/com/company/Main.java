import java.util.*;
// https://www.gamedev.tv/courses/enrolled/1111834 tutorial
// import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;


import static java.lang.Math.pow;

public class Main {
    public static void main(String[] args) {
        // Strefa Testów:

        int[] a = new int[] { 0, 144, 19, 161, 19, 144, 19, 11 };
        int[] b = new int[] { 0, 14641, 20736, 361, 25921, 361, 20736, 361 };
        int[] a1 = new int[] { 2, 2, 3 };
        int[] b1 = new int[] { 4, 4, 9 };
        int[] a2 = new int[] { 11, 19, 19, 121, 144, 144, 161, 161 };
        int[] b2 = new int[] { 121, 361, 361, 361, 14641, 20736, 20736, 25921 };
        int[] a3 = new int[] {};
        int[] b3 = new int[] {};
        int[] a4 = new int[] { 0 };
        int[] b4 = new int[] { 0 };
        int[] a6 = new int[] { 11, 19, 19, 19, 121, 144, 144, 161, 1008 };
        int[] b6 = new int[] { 121, 361, 361, 14641, 20736, 20736, 25921, 36100 };
        int[] a7 = new int[] { 2, 2, 3 };
        int[] b7 = new int[] { 4, 9, 9 };
        int[] a8 = new int[] { 0, -14, 191, 161, 19, 144, 195, 1};
        int[] b8 = new int[] { 1, 0, 196, 36481, 25921, 361, 20736, 38025 };
        int[] a9 = new int[] { 4, 4 };
        int[] b9 = new int[] { 1, 31 };
        int[] a10 = new int[] { 121, 144, 19,  161, 19, 144, 19, 11 };
        int[] b10 = new int[] { 121, 14641, 20736, 361, 25921, 361, 20736,361};
        int[] a11 = new int[] { 2, 2, 3 };
        int[] b11 = new int[] { 4, 9, 9 };

        // zakonnczone testy :
        System.out.println("Test 1a : wartosc true");
        System.out.println(AreSame(a1, b1));
        System.out.println("Test 2a : wartosc false");
        System.out.println(AreSame(a9, b9));
        System.out.println("Test 1: wartosc true");
        System.out.println(AreSame(a10, b10));

        System.out.println("Test 7: wartosc true");
        System.out.println(AreSame(a7, b7));
        System.out.println("Test 1: wartosc true");
        System.out.println(AreSame(a10, b10));
        System.out.println("Test 10: wartosc false");
        System.out.println(AreSame(a11, b11));

        // System.out.println(AreSame(a4, b4));
        // System.out.println("Test 6: ");
        // System.out.println(AreSame(a6, b6));
        // System.out.println("Test 2 : ");
        // System.out.println(AreSame(a6, b6));

        System.out.println("tEST 8: wartosc true");
        System.out.print(AreSame(a8, b8));
    }

    public static boolean AreSame(int[] a, int[] b) {
        // Sprawdzanie podstawowych założeń:
        // *czy dlugosci tablic nie sa rozne
        // *czy  dlugosc tablic nie jest rowna zeru albo czy nie sa one rowne dlugosci null
        // *(dodatakowa) sprawdzanie czy tablice maja taka sama ilosc duplikatow 
        if (a.length != b.length) {
            System.out.println("Nie są jednakowej długośći");
            return false;
        } else if (a.length == 0 && b.length == 0 || a == null || b == null) {
            System.out.println("");
        }else if(countDuplicates(a) != countDuplicates(b)){
            return false;
        }

        // Wypisywanie wartosci przed operacjami
        // System.out.println("Wartosc zmiennych a: ");
        // for (int i = 0; i < a.length; i++) {
        //     System.out.print(a[i] + ", ");
        // }
        // System.out.println("\n Wartosc zmeinnych b ");
        // for (int j = 0; j < b.length; j++) {
        //     System.out.print(b[j] + ", ");
        // }

        // Tymczasowe wartości potrzebne do zamiany int[] na Integer[]
        // przez boxowanie
        Integer[] aa = Arrays.stream(a).boxed().toArray(Integer[]::new);
        Integer[] bb = Arrays.stream(b).boxed().toArray(Integer[]::new);

        // Zamiania Integer[] na Listę
        // dodani do Arralist-a wartość z tablic aa i bb
        // też zmienne pomocnicze
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(aa));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(bb));

        // Sortowanie ArrayList-ow
        Collections.sort(A);
        Collections.sort(B);
        // Pomocnicze zmienne
        int dla = A.size();
        int dlb = B.size();
        int ilejest = 0;
        int sumA = 0;
        int sumB = 0;

        // Usuwanie duplikatów z Arraylist
        // zapisywanie do zmiennej pomocniczej
        ArrayList<Integer> newlistA = getRidOff(A);
        ArrayList<Integer> newlistB = getRidOff(B);

        // zliczanie sumy ciągu
        // newlistA metodą advanced for
        for (int i : newlistA) {
            sumA += i;
        }

        // zliczanie sumy ciągu
        // newlistB metodą standardową for
        // for(int i = 0; i < newlistA.size(); i++){
        // sumB += newlistB.get(i);
        // }

        // zlicznaie sumy ciagu newlistB
        for (Integer ji : newlistB) {
            sumB += ji;
        }

        // System.out.println("Wartosci zmiennych a i b");
        // // Wypisywanie elementow z listy a i b
        // for (int i = 0; i < newlistA.size(); i++) {
        // int temp1 = newlistA.get(i);
        // System.out.println( temp1);
        // for (int j = 0; j < newlistB.size(); j++) {
        // int temp2 = newlistB.get(i);
        // System.out.println( temp2);
        // }
        // }

        if (sumA > sumB) {
            for (int i = 0; i < newlistA.size(); i++) {
                int temp1 = newlistA.get(i);
                int temp2 = B.get(i);
                    if (pow(temp1, 2) == temp2) {
                        ilejest++;
                    } else if (temp2 == 0 && temp1 == 0) {
                        ilejest++;
                    }
            }
        } else if (sumA == sumB) {
            // sprawdzanie kazdej komorki pamieci
            for (int i = 0; i < newlistA.size(); i++) {
                int temp1 = newlistB.get(i);
                int temp2 = B.get(i); 
                    if (pow(temp1, 2) == temp2) {
                        ilejest++;
                    } else if (temp1 == 0 && temp2 == 0) {
                        ilejest++;
                    }
            }
        } else if (sumB > sumA) {
            // tutja jest caly czas problem
            for (int i = 0; i < newlistB.size(); i++) {
                int temp1 = newlistB.get(i);
                for (int j = 0; j < aa.length; j++) {
                    int temp2 = A.get(j);
                        if (pow(temp2, 2) == temp1) {
                            ilejest ++;
                        } else if (temp2 == 0 && temp1 == 0) {
                            ilejest++;
                        }
                }
            }
        } else {
            System.out.println("Sumwing went rong");
        }

        if (ilejest == a.length) {
            return true;
        } else if (ilejest == b.length) {
            return true;
        } else {
            return false;
        }
    }

    public static <T> ArrayList<T> getRidOff(ArrayList<T> list) {
        // Create a new ArrayList
        ArrayList<T> newList = new ArrayList<T>();

        // Traverse through the first list
        for (T element : list) {

            // If this element is not present in newList
            // then add it
            if (!newList.contains(element)) {

                newList.add(element);
            }
        }

        // return the new list
        return newList;
    }
    public static int countDuplicates(int[] a){
        // ilosc duplikatow
        int temp1 =0;

        for (int i = 0; i < a.length; i++) {
           for (int j = i + 1; j < a.length; j++) {
               if (a[i] == a[j]) {
                   temp1++;
               }
           }
        }
        return temp1;
    }
}
