import java.util.Arrays;
import java.util.Scanner;

class B6A1 {
    public static int getMin(int[] data) {
        /**********************************************************/
        /****                Langaufgabe 6.1:                  ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
        return 0;

    }

    public static int getMax(int[] data) {
        /**********************************************************/
        /****                Langaufgabe 6.1:                  ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
        return 0;

    }

    public static int[] count(int[] data, int min, int max) {

        int C[] = new int[max - min + 1];

        /**********************************************************/
        /****                Langaufgabe 6.1:                  ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
        return C;
    }

    public static int[] countingSort(int[] data) {
        int B[] = new int[data.length];
        /**********************************************************/
        /****                Langaufgabe 6.1:                  ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
        return B;
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
        int min = getMin(arr);
        System.out.printf("The minimum value: %d\n", min);
        int max = getMax(arr);
        System.out.printf("The minimum value: %d\n", max);
        int[] count = count(arr, min, max);
        System.out.print("Frequencies: ");
        System.out.println(Arrays.toString(count));
        int[] output = countingSort(arr);
        System.out.print("After sorting: ");
        System.out.println(Arrays.toString(output));
    }
}
