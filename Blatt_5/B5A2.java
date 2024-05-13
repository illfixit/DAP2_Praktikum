
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
        if (m1 > m2 || p1 < p2)
            return false;

        for (int i = l; i < m1; i++) {
            if (data[i] < p1)
                return false;
        }
        for (int i = m1 + 1; i < m2; i++) {
            if (data[i] < p2 || data[i] > p1)
                return false;
        }
        for (int i = m2 + 1; i <= r; i++) {
            if (data[i] > p2)
                return false;
        }
        return true;

    }

    // l,r inclusive -> partition data[l,r]
    public static int[] partition(int[] data, int l, int r) {

        if (data[l] < data[r])
            swap(data, l, r);
        int p1 = data[l];
        int p2 = data[r];
        int m1 = l + 1;
        int m2 = r - 1;
        int i = l + 1;

        while (i <= m2) {
            if (data[i] > p1) {
                swap(data, i, m1);
                m1++;
            } else if (data[i] < p2) {
                swap(data, i, m2);
                m2--;
                i--;
            }
            i++;
        }

        m1--;
        m2++;
        swap(data, l, m1);
        swap(data, r, m2);
        return new int[] { m1, m2 };
    }

    // l,r inclusive -> sort data[l,r]
    public static void qsort(int[] data, int l, int r) {

        /**********************************************************/
        /**** Kurzaufgabe 5.2: ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/

        if (l < r) {
            int[] pivots = partition(data, l, r);
            int m1 = pivots[0];
            int m2 = pivots[1];
            assert isPartitioned(data, l, r, m1, data[m1], m2, data[m2]);
            qsort(data, l, m1 - 1);
            qsort(data, m1 + 1, m2 - 1);
            qsort(data, m2 + 1, r);
        }

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

        // Laufzeitmessung starten
        Instant start = Instant.now();

        qsort(arr, 0, arr.length - 1);

        // Laufzeitmessung beenden
        Instant finish = Instant.now();
        long time = Duration.between(start, finish).toMillis();
        System.out.println("Time: " + time + " ms");

        // Nach dem Sortieren ausgeben, wenn die Länge weniger als 20 beträgt
        if (arr.length < 20) {
            System.out.println("After sorting:");
            System.out.println(Arrays.toString(arr));
        }

        assert isSorted(arr) : "Array is not sorted!";
    }

    // utils Methoden

    // Methode zum swapen von zwei Elementen in einem Array
    private static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // Methode zur Überprüfung, ob das Array absteigend sortiert ist
    public static boolean isSorted(int[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i - 1] < data[i])
                return false;
        }
        return true;
    }
}