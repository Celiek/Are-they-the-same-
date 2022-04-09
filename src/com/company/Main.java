import java.util.*;
import java.util.stream.*;

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
        int[] a8 = new int[] { -14, 0, 1, 19, 144, 161, 191, 195 };
        int[] b8 = new int[] { 0, 1, 196, 361, 20736, 25921, 36481, 38025 };

        System.out.println("Test 1: ");
        System.out.println(AreSame(a, b));
        System.out.println("Test 2 Wartosc ktora powinna wyjsc : True");
        System.out.println(AreSame(a2, b2));
        System.out.println("Test 3: ");
        System.out.println(AreSame(a2, b2));
        System.out.println("Test 4: ");
        System.out.println(AreSame(a3, b3));
        System.out.println("Test 5: ");
        System.out.println(AreSame(a4, b4));
        System.out.println("Test 6: ");
        System.out.println(AreSame(a6, b6));
        System.out.println(":Test 7");
        System.out.println(AreSame(a7, b7));

        // System.out.println("tEST 8 :");
        // System.out.print(AreSame(a8, b8));
    }

    static boolean AreSame(int[] a, int[] b){

        //Sprawdzanie podstawowych założeń
        //programowych zdefioniowanych przez program
        if(a.length != b.length){
            System.out.println("Nie są jednakowej długośći");
            return false; 
        } else if(a.length ==0 && b.length ==0){
            System.out.println("");
        }

        //Tymczasowe wartości potrzebne do zamiany int[] na Integer[]
        //przez boxowanie
        Integer[] aa = Arrays.stream( a).boxed().toArray(Integer[]::new);
        Integer[] bb = Arrays.stream( b).boxed().toArray(Integer[]::new);

        //Zamiania Integer[] na Listę
        //dodani do Arralist-a wartość z tablic aa i bb
        // też zmienne pomocnicze
        ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(aa));
        ArrayList<Integer> B = new ArrayList<Integer>(Arrays.asList(bb));

        //Sortowanie ArrayList-ow
        Collections.sort(A);
        Collections.sort(B);
        //Pomocnicze zmienne 
        int dla = A.size();
        int dlb = B.size();
        int ilejest = 0;
        int sumA =0;
        int sumB =0;
        
        // Usuwanie dulpikatóww z Arraylist
        // zapisywanie do zmiennej pomocniczej
        ArrayList<Integer> newlistA = getRidOff(A);
        ArrayList<Integer> newlistB = getRidOff(B);
        
        // zliczanie długości arraylisty 
        // newlistA metodą advanced for
        for(int i : newlistA){
            sumA +=i;
        }

        // zliczanie długości arraylisty
        // newlistB metodą standardową for
        for(int i = 0; i < newlistA.size(); i++){
            sumB += newlistA.get(i);
        }

        if(dla > dlb){

        } else if(dla == dlb){

        } else if(dlb > dla){

        }

        return false;
    }

    public static <T> ArrayList<T> getRidOff(ArrayList<T> list){
        // Tworzenie nowej hashmapy
        Set<T> set = new LinkedHashSet<>();
        // dodawniae elementu do hashmapy
        set.addAll(list);

        // czyszczenie wejściowej listy
        list.clear();
        // dodawanie elementów listy
        // 
        list.addAll(set);
        return list;
    }
}
