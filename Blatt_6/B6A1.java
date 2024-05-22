import java.util.Arrays;
import java.util.Scanner;

class B6A1 {
    // sehr einfacher Algorithmus der vergleciht in for Schleife
    // alle Elemente mit min und gibt das kleinste Element zurück
    public static int getMin(int[] data) {
        int min = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }

    // ähnlich für max
    public static int getMax(int[] data) {
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    // Schreiben Sie eine Methode count, die ein Array data von Ganzzahlen sowie
    // zwei zusätzliche Schlüssel min und max erhält. Ausgabe der Methode ist ein
    // Array C der Länge max−min+1,sodass C[i] die Anzahl der Vorkommen
    // von i + min in der Liste A ist.
    public static int[] count(int[] data, int min, int max) {
        // wie in der Aufgabe beschrieben, wird ein Array C der Länge max - min + 1
        // erstellt
        int[] C = new int[max - min + 1];
        // es gibt nur eine Schleife wo wir eine einfache Operation machen
        // deswegen ist die Laufzeit O(n)
        for (int i = 0; i < data.length; i++) {
            C[data[i] - min]++;
        }
        return C;
    }

    public static int[] countingSort(int[] data) {
        // mit Hilfe der Methoden getMin, getMax und count wird das Array sortiert
        int min = getMin(data);
        int max = getMax(data);
        int[] count = count(data, min, max);

        int[] B = new int[data.length];
        int index = 0;

        // das Array B wird erstellt und mit Hilfe von count sortiert
        // laut dem counting Sort Algorithmus gehen wir von recht nach links
        for (int i = max - min; i >= 0; i--) {
            while (count[i] > 0) {
                B[index++] = i + min;
                count[i]--;
            }
        }

        return B;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        assert n > 0 : "Error: length of the Input Array < 1";
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        input.close();

        // für Testzwecke
        // int[] arr = { 1, 2, 2, 3, 4, 4 };

        System.out.print("Input Array: ");
        System.out.println(Arrays.toString(arr));

        int min = getMin(arr);
        System.out.printf("The minimum value: %d\n", min);

        int max = getMax(arr);
        System.out.printf("The maximum value: %d\n", max);

        int[] count = count(arr, min, max);
        System.out.print("Frequencies: ");
        System.out.println(Arrays.toString(count));

        int[] output = countingSort(arr);
        System.out.print("After sorting: ");
        System.out.println(Arrays.toString(output));
    }
}
