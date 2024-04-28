import java.util.Arrays;
import java.util.Scanner;

class B3A1 {
    public static int removeDuplicates(int[] data) {
        /**********************************************************/
                        /**** Kurzaufgabe 3.1: ****/
        /**********************************************************/
        Arrays.sort(data);
        int length = data.length;
        for(int i = 0; i < length; i++){
            for(int k = i+1; k < length; k++){
                if(data[i] == data[k]){
                    for(int p = k; p < data.length-1; p++){
                        data[p] = data[p+1];
                    }
                    k--;
                    length--;
                }
            }
        }
        return length;
    }


    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Scanner input = new Scanner(System.in);
        // Initialize the scanner and read the amount of expected integers
        int n = input.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        input.close();
        System.out.print("Before removing duplicates: ");
        System.out.println(Arrays.toString(arr));
        int distinct = removeDuplicates(arr);
        System.out.println("Distinct ints: " + distinct);
        System.out.print("After removing duplicates: ");
        printArray(arr, distinct);
        /**********************************************************/
                        /**** Kurzaufgabe 3.1: ****/
        /**********************************************************/
        if(distinct < k)
            k = distinct;

        boolean[] used = new boolean[distinct];
        int nOs = kSubset(arr, distinct, k, 0);
        System.out.println("Number of Subset: " + nOs);
    }

    /*
     * int n = Länge des Arrays ohne Duplikate
     * int k = Länge der Teilmengen
     */
    public static int kSubset(int[] data, int index, int n, int k){
        int numberOfSubsets = 0;

        // if(index < n ){
        //     System.out.print("[");
        //     if(k == 0){
        //         System.out.println("]");
        //         numberOfSubsets++;
        //     } else {
        //         System.out.print(data[index] + ", ");
        //         kSubset(data, index + 1, n, k - 1);

        //         kSubset(data, index+1, n, k);
        //     }
        // }

            if (k == 0) {
                System.out.println("]");
                return 1;
            }

            if (index >= n) {
                return 0;
            }

            System.out.print("[");
            System.out.print(data[index] + ", ");
            numberOfSubsets += kSubset(data, index + 1, n, k - 1);
            numberOfSubsets += kSubset(data, index + 1, n, k);
            System.out.print("]");
        return numberOfSubsets;
    }

    public static void printArray(int[] data, int n){
        for(int i = 0; i < n ; i++){
            if(i == 0){
                System.out.print("[" + data[0]+ ", ");
            } else if (i == n - 1){
                System.out.println(data[i] + "]");
            } else {
                System.out.print(data[i] + ", ");
            }
        }
    }
}
    

