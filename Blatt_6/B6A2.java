import java.util.Scanner;
import java.util.Arrays;

class B6A2 {

    public static void sortByByte(int[] input, int l, int r, int b) {
        /**********************************************************/
        /****                Langaufgabe 6.2:                  ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
        return;
    }

    public void radix(int[] data) {
        /**********************************************************/
        /****                Langaufgabe 6.2:                  ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
        return;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Initialize the scanner and read the amount of expected integers
        int n = input.nextInt();
        assert n > 0 : "Error: length of the Input Array < 1";
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        input.close();
        System.out.print("Input Array: ");
        System.out.println(Arrays.toString(arr));
        B6A2 Sorter = new B6A2();
        Sorter.radix(arr);
        System.out.println("After Sorting: " + Arrays.toString(arr));
    }

}
