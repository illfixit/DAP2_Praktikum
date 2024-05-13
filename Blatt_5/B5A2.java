
import java.util.Scanner;
import java.util.Arrays;
import java.time.Instant;
import java.time.Duration;

class B5A2 {
    // test if the data[l,r] is partitioned with pivotelement p1 at position m1, p2
    // at m2.
    // m1 <= m2 and p1 >= p2
    // data[i] >=p1 for l<=i < m1
    // p2<=data[i] <= p1 for m1 < p < m2
    // data[i] <= p2 for m2 < p <=r

    public static boolean isPartitioned(int[] data, int l, int r, int m1, int p1, int m2, int p2) {

        /**********************************************************/
        /**** Kurzaufgabe 5.2: ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
        return true;

    }

    // l,r inclusive -> partition data[l,r]
    public static int[] partition(int[] data, int l, int r) {

        /**********************************************************/
        /**** Kurzaufgabe 5.2: ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/

        return new int[] {
                0,
                0
        };
    }

    // l,r inclusive -> sort data[l,r]
    public static void qsort(int[] data, int l, int r) {

        /**********************************************************/
        /**** Kurzaufgabe 5.2: ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/

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

        /**********************************************************/
        /**** Kurzaufgabe 5.2: ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
    }
}