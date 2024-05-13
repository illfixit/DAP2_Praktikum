import java.util.Scanner;
import java.util.Arrays;
import java.time.Instant;
import java.time.Duration;

class B5A1 {
    // test if the data[l,r] is partitioned with pivotelement p at position m.
    // data[i] >=p for l<=i < m
    // data[i] <= p for m < i <=r
    public static boolean isPartitioned(int[] data, int l, int r, int m, int p) {
        /**********************************************************/
        /**** Kurzaufgabe 5.1: ****/
        /**********************************************************/
        boolean part = true;
        for(int i = l; i < m; i++){
            if(data[i] >= p){
                part = true;
            } else {
                return false;
            }
        }
        for(int i = m+1; i < r; i++){
            if(data[i] <= p){
                part = true;
            } else {
                return false;
            }
        }
        
        return part;
    }

    // l,r inclusive -> partition data[l,r]
    public static int partition(int[] data, int l, int r) {

        /**********************************************************/
        /**** Kurzaufgabe 5.1: ****/
        /**********************************************************/
        int p = data[l];
        int m = l;
        for(int i = l+1; i < r; i++){
            if(data[i]>=p){
                m++;
                int temp = data[i];
                data[i] = data[m];
                data[m] = temp;
            }
        }
        int temp = data[m];
        data[m] = data[l];
        data[l] = temp;
        assert isPartitioned(data, l, r, m, p) : "Array wurde nicht richte partitioniert";
        return m;
    }

    // l,r inclusive -> sort data[l,r]
    public static void qsort(int[] data, int l, int r) {

        /**********************************************************/
        /**** Kurzaufgabe 5.1: ****/
        /**********************************************************/
        if(l >= r){
            return;
        } else {
            int m = partition(data, l, r);
            qsort(data, l, m-1);
            qsort(data, m+1, r);
        }
    }

    // check if the array sorted discreading.
    public static boolean isSorted(int[] data) {
        /**********************************************************/
        /**** Kurzaufgabe 5.3: ****/
        /**********************************************************/
        boolean sorted = false;
        for(int i = 1; i < data.length; i++){
            if(data[i-1] >= data[i]){
                sorted = true;
            } else {
                return false;
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Initialize the scanner and read the amount of expected integers
        int n = input.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        input.close();

        // Drucken, wenn die Länge for dem Sortieren weniger als 20 beträgt
        if (arr.length < 20) {
            System.out.println("Input Array:");
            System.out.println(Arrays.toString(arr));
        }
        qsort(arr, 0, n);
        if (arr.length < 20) {
            System.out.println("After sorting:");
            System.out.println(Arrays.toString(arr));
        }
        /**********************************************************/
        /**** Kurzaufgabe 5.1, 5.3 & 5.4: ****/
        /**********************************************************/
        assert isSorted(arr) : "Array wurde nicht richtig sortiert";
    }
}
