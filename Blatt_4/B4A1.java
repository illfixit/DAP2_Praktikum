import java.util.Arrays;
import java.util.Scanner;

class B4A1 {
    // Hilfsfunktion zum Vertauschen zweier Werte
    public static void swap(int[] data, int i, int j) {
        int h = data[i];
        data[i] = data[j];
        data[j] = h;
    }

    public static void maxHeapifyUp(int[] data, int i) {
        /**********************************************************/
        /****                Langaufgabe 4.1:                  ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
    }

    public static void maxHeapifyDown(int[] data, int n) {
        /**********************************************************/
        /****                Langaufgabe 4.1:                  ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
    }

    public static void buildMaxHeap(int[] data) {
        /**********************************************************/
        /****                Langaufgabe 4.1:                  ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
    }

    public static int extractMax(int[] data, int n) {
        /**********************************************************/
        /****                Langaufgabe 4.1:                  ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
        return 0;
    }

    public static int heapSelect(int[] data, int k) {
        /**********************************************************/
        /****                Langaufgabe 4.1:                  ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
        return 0;
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
        System.out.print("Input Array: ");
        System.out.println(Arrays.toString(arr));

        int v = heapSelect(arr, k);
        System.out.println("The " + k + "-biggest element is " + v);

    }
}