import java.util.Arrays;
import java.util.Scanner;

class B3A1 {

    private static int counter = 0;

    public static int removeDuplicates(int[] data) {

        if (data == null || data.length == 0) {
            return 0;
        }

        // Sortieren des Arrays
        Arrays.sort(data);

        // count ist auch die Index des letzten einzigartigen Elements
        int count = 0;

        // Wir gehen durch den vorher sortierten Array und suchen nach Duplikaten.
        // Wenn wir ein Duplikat finden, bewegen wir das Element an die nächste Position
        for (int i = 1; i < data.length; i++) {
            // Wenn das aktuelle Element nicht gleich dem letzten einzigartigen Element ist,
            // bewegen wir es an die nächste Position im 'unique' Bereich des Arrays
            if (data[count] != data[i]) {
                count++;
                data[count] = data[i];
            }

            // Debugging
            // System.out.println("arr:" + Arrays.toString(data));
            // System.out.println("count:" + count + " i: " + i);
        }

        // Die Anzahl der einzigartigen Elemente ist count + 1
        // da count der Index des letzten einzigartigen Elements ist
        return count + 1;
    }

    public static void main(String[] args) {

        

        // START TEST DATA
        // int k = 2;
        //int[] arr = { 2, 2, 4, 6, 8 };
        // int[] arr = { 0, 1, 2, 2, 3, 3, 3, 4, 5, 5 };
        // END TEST DATA

        // Initialize the scanner and read the amount of expected integers
        int k = Integer.parseInt(args[0]);
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
        arr[i] = input.nextInt();
        }
        input.close();

        System.out.print("Before removing duplicates: ");
        System.out.println(Arrays.toString(arr));
        int distinct = removeDuplicates(arr);
        System.out.print("After removing duplicates: ");
        printArray(arr, distinct);

        // debugging
        // System.out.println("Number of distinct elements: " + distinct);

        if (distinct < k) {
        k = distinct;
        }

        //int[] array = { 2, 4, 6, 8, 10 };

        // Test for different values of k
        // for (int k = 1; k <= array.length; k++) {
        //     printSubarrays(array, k);
        //     System.out.println("\nTotal subarrays for k = " + k + ": " + counter);
        //     counter = 0; // Reset the counter after each use
        // }
        printSubarrays(arr, k, distinct);
        System.out.println("Number of Subsets: " + counter);

        /**********************************************************/
        /**** Kurzaufgabe 3.1: ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/

    }

    // number of combinations is
    // n! / (k! * (n - k)!) =

    // [4/0] 4! / (0! * (4 - 0)!) = 1
    // [4/1] 4! / (1! * (4 - 1)!) = 4
    // [4/2] 4! / (2! * (4 - 2)!) = 6
    // [4/3] 4! / (3! * (4 - 3)!) = 4
    // [4/4] 4! / (4! * (4 - 4)!) = 1

    // []
    // [2][4][6][8]
    // [2,4][2,6][2,8][4,6][4,8][6,8]
    // [2,4,6][2,4,8][2,6,8][4,6,8]
    // [2,4,6,8]

    // []
    // [2][4][6][8][10]
    // [2,4][2,6][2,8][2,10][4,6][4,8][4,10][6,8][6,10][8,10]
    // [2,4,6][2,4,8][2,4,10][2,6,8][2,6,10][2,8,10][4,6,8][4,6,10][4,8,10][6,8,10]
    // [2,4,6,8][2,4,6,10][2,4,8,10][2,6,8,10][4,6,8,10]
    // [2,4,6,8,10]

    public static void printSubarrays(int[] array, int k, int end) {
        printSubarrays(array, k, 0, end, "");

    }

    // Overloaded recursive function to print all subarrays of length k over the array of the length end
    private static void printSubarrays(int[] array, int k, int start, int end, String current) {
        if (k == 0) {
            // When k reaches 0, we have a complete subarray of desired length
            System.out.println("[" + current + "]");
            counter++; // Increment the counter each time a subarray is printed
            return ;
        }
        for (int i = start; i <= end - k; i++) {
            // Append the current element and a comma if more elements are expected
            String newCurrent = current + (current.isEmpty() ? "" : ",") + array[i];
            printSubarrays(array, k - 1, i + 1, end, newCurrent);
        }
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