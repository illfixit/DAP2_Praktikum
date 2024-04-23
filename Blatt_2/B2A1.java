import java.util.Scanner;


public class B2A1 {
    public static int compare_cnt = 0; // Zähler für die Vergleiche während des sortierens.

    /**
     * * @param args die Parameter aus der Kommandozeile
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /**********************************************************/
        /**** Kurzaufgabe 2.1: ****/

        // Schreiben Sie die main-Methode, die den Algorithmus wie folgt testet:
        // – Das Programm empfängt eine Ganzzahl n und dann eine Liste L von n
        // Ganzzahlen über Standard-In.
        // Beispiel:
        // { echo 100; seq 100; } | java B2A1.java
        // oder
        // { echo 100; shuf -i 0-9999 -n 100; } | java B2A1.java
        // Sie können davon ausgehen, dass die Eingabe korrekt ist und müssen den Code
        // nicht um diese Eingabe Robust gestalten.

        /**********************************************************/

        // Lese die Anzahl der Zahlen ein
        int n = input.nextInt();
        int[] L = new int[n];

        // Lese die Zahlen ein
        for (int i = 0; i < n; i++) {
            L[i] = input.nextInt();
        }

        // Wir erstellen eine Kopie des Arrays L, um später in printMetaInfo die beiden
        // Arrays zu benutzen.
        // Ursprünglich habe ich das mit L.clone gemacht, aber System.arraycopy aus B2A2
        // ist schneller und höher optimiert.
        int[] original = new int[L.length];
        System.arraycopy(L, 0, original, 0, L.length);

        // Ergänzen Sie die main-Methode, so dass die Methode insertionSort das befüllte
        // Array sortiert.
        insertionSort(L);

        assert isSorted(L) : "Array ist nicht sortiert!";

        printMetaInfo(original, L);

        input.close();
    }

    /**
     * Prüft, ob ein Array aufsteigend sortiert ist.
     *
     * @param numbers Das zu prüfende Array
     * @return true genau dann, wenn das Array sortiert ist
     */
    public static boolean isSorted(int[] numbers) {
        /**********************************************************/
        /**** Kurzaufgabe 2.1: ****/

        // Implementieren Sie eine Methode public static boolean isSorted(int[] array),
        // welche überprüft, ob das Array array aufsteigend sortiert ist.

        /**********************************************************/

        // basic Algorithmus um überprüfen ob ein Array aufsteigend sortiert ist. In der
        // Schleifeinitializierung soll i streng kleiner als numbers.length-1 sein, da
        // wir in der Schleife auf numbers[i+1] zugreifen.
        // Falls irgendwo ein Element größer ist als das nächste, dann ist das Array
        // nicht aufsteigend sortiert und wir geben false zurück. Ansonsten geben wir
        // immer true zurück, was bedeutet, dass das Array aufsteigend sortiert ist.

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return false;
            }
        }

        return true;
    }

    /**
     * Insertion-Sort-Algorithmus.
     *
     * @param numbers das zu sortierende Array
     */
    public static void insertionSort(int[] numbers) {

        /**********************************************************/
        /**** Kurzaufgabe 2.1: ****/

        // Implementieren Sie eine Methode public static void insertionSort(int[]
        // array), die den Algorithmus InsertionSort aus der Vorlesung implementiert,
        // das die Werte in einem Array in aufsteigender Reihenfolge sortiert.

        /**********************************************************/

        // das hier ist die einfache Implementierung des Algorithmus,
        // den wir in der Vorlesung gesehen haben, in Java.

        // InsertionSort: ein inkrementeller Algorithmus
        // vl-einfuehrung-sortieren-i.pdf
        // Seite 6/24

        for (int j = 1; j < numbers.length; j++) {
            int key = numbers[j];
            int i = j - 1;

            while (i >= 0 && numbers[i] > key) {
                numbers[i + 1] = numbers[i];
                i = i - 1;

                /*
                 * Zusätzlich soll die Anzahl der Vergleiche zwischen zwei Elementen des Arrays
                 * gezählt werden, die notwendig sind um das Array zu sortieren. Verwenden Sie
                 * dazu die Klassenvariable compare_cnt, die die Anzahl der benötigten
                 * Vergleiche speichert. Für jeden Vergleich von zwei Elementen in dem Array
                 * soll die Variable um 1 inkrementiert werden. Beachten Sie, dass auch bei
                 * bereits sortierten Arrays möglicherweise Vergleiche zwischen Elementen
                 * ausgeführt werden müssen.
                 * 
                 */

                // Todo: den Counter erhöhen, wenn wir einen Vergleich machen.
                compare_cnt++;
            }

            // ++ fürs letzte Vergleich
            compare_cnt++;

            numbers[i + 1] = key;
        }

    }

    public static void printMetaInfo(int[] original, int[] sorted) {

        if (original.length <= 100) {
            printArray(original);
            printArray(sorted);
        }

        System.out.println(isSorted(sorted) ? "Feld ist sortiert!" : "FEHLER: Feld ist NICHT sortiert!");
        System.out.println("Das Sortieren des Arrays hat " + compare_cnt + " Vergleiche benoetigt.");
    }

    public static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}