import java.util.Arrays;
import java.util.Scanner;

class B3A2 {
    /**********************************************************/
    /**** Kurzaufgabe 3.2: ****/

    // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

    /**********************************************************/

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        input.close();

        Arrays.sort(arr);
        System.err.println("Sorted input:");
        System.out.println(Arrays.toString(arr));
        System.err.println("The " + k + "-smallest permutation is:");
        /**********************************************************/
        /**** Kurzaufgabe 3.2: ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
        int[] out = new int[arr.length];             
        find(arr, out, 0 ,k);
        System.out.println(Arrays.toString(out));
        
    }

    // Finded die k-kleinste Permutation
    // @param arr ist der Array aus dem die Permutation gefunden werden soll
    // @param out ist der Array, in den die k-kleinste Permutation eingefügt werden soll
    // @param o ist der aktuelle Index im Array, in den die Permutation geschrieben werde soll
    public static int[] find(int[] arr, int[] out, int o, int k){
        int n = arr.length; 
        int i = (k-1)/factorOf(n-1);                //berechnet den Index in arr, der für die nächste Stelle in der Permutation übernommen werden muss
        if(arr.length > 0){                         //wenn noch Elemente in arr enthalten, soll die Rekursion weiter gehen
            int[] newArr = removeElement(arr, i);   //es wird ein neues Array erstellt, indem der Wert an der Stelle i nicht mehr vorhanden ist
            int newK = k - i *(factorOf(n-1));      //damit der Algorithmus funktioniert, muss nach jeder Rekursion ein neues k berechnet werden
            out[o] = arr[i];                        //der Wert an der Stelle i wird an den aktuellen Index in sou kopiert
            find(newArr, out, o+1, newK);           //Rekursion mit neuem Array, neuem K. Der Index im out wird erhöht
        }
        return out;
    }

    //entfernt ein Element in einem Array
    public static int[] removeElement(int[] arr, int index){
        if(arr == null || index < 0 || index >= arr.length){    
            return arr;
        }
        int[] newArr = new int[arr.length - 1];     //ein Wert wird entfernt. Also Länge - 1

        int k = 0;
        for(int i = 0; i < arr.length; i++){
            if(i == index){                         //der Wert der Entfernt werden soll, wird einfach geskippt
                continue;
            }
            newArr[k] = arr[i];
            k++;
        }
        return newArr;
    }

    //berechnet den Faktor einer Zahl
    public static int factorOf(int n){
        int result = 1;
        for(int i = 1; i <= n; i ++){
            result *= i;
        }
        return result;
    }
}
