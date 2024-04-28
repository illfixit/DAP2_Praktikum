import java.util.Scanner;


public class B2A2 {
    public static int compare_cnt = 0; // Zähler für die Vergleiche während des sortierens.
    /**
     * @param args die Parameter aus der Kommandozeile
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        /**********************************************************/
        /****                 Kurzaufgabe 2.2:                 ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
        // Lese die Anzahl der Zahlen ein
        int n = input.nextInt();
        int[] arr = new int[n];

        // Lese die Zahlen ein
        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        input.close();
        mergeSort(arr);
    }

    /**
     * Führt den Merge-Sort-Algorithmus aus.
     *
     * @param numbers das zu sortierende Array
     */
    public static void mergeSort(int[] numbers) {
        int[] tmpArray = new int[numbers.length];
        System.arraycopy(numbers, 0, tmpArray, 0, numbers.length);

        System.out.println("Unsorted: ");
        printArray(numbers);
        mergeSort(numbers, tmpArray, 0, numbers.length);

        System.out.println("Sorted: ");
        printArray(numbers);
        System.out.println("Comparisons: " + compare_cnt);

        // make sure that you have implemented and compiled B2A1 (run: javac B2A1.java)
        assert B2A1.isSorted(numbers) : "Array ist nicht sortiert";
    }

    /**
     * Hilfsfunktion, welche die rekursiven Aufrufe ausführt.
     *
     * @param target Zielarray für die sortierte Folge
     * @param source ein zu sortierendes Array mit Integer Zahlen
     * @param left   die linke Grenze des zu sortierenden Teilarrays, inklusiv
     * @param right  die rechte Grenze des zu sortierenden Teilarrays, exklusiv
     */
    public static void mergeSort(int[] target, int[] source, int left, int right) {
        /**********************************************************/
        /****                 Kurzaufgabe 2.2:                 ****/
        /**********************************************************/
        if(left < right-1){ //bricht ab sobald der Array nurnoch ein Element im Array und somit kein weiteres Aufteilen nötig ist
            int middle = left + (right-left) / 2;       //neues right für linken Teilarray, neues left für rechten Teilarray
            mergeSort(target, source, left, middle);    //Rekursion auf dem linken Teilarray
            mergeSort(target, source, middle, right);   //Rekursion auf dem rechten Teilarray
            merge(target, source, left, middle, right);
        }
    }

    public static void merge(int[] target, int[] source, int left, int middle, int right){

        int i = left;       //Startindex für den linke Teilarray    
        int j = middle;     //Startindex für den rechten Teilarray
        int k = left;       //Startindex für Target um Elemente an richtige Stelle zu bringen

        while (i < middle && j < right){    //solange beide Indexe in ihrem Array bleiben
            if(source[i] <= source[j]){     //vergleiche eine Zahl aus dem linken, mit einer Zahl aus dem rechten Array
                target[k] = source[i];      
                i++;        
            } else {                        //das kleinere wird in Target kopiert
                target[k] = source[j];
                j++;
            }
            k++;                             
            compare_cnt++;
        }

        //die restlichen Zahlen aus dem Teilarray, der nicht leer ist, wird hinten an target gehangen.
        //diese sind in der richtigen Reihenfolge, da die Teilarrays schon sortiert sind
        while(i < middle){                  
            target[k] = source[i];
            i++;
            k++;
        }
        while(j< right){
            target[k] = source[j];
            j++;
            k++;
        }

        //Source wird auf den neusten Stand gebracht, damit in der nächsten Rekursion, mit dem geupdateten Array gearbeitet wird
        for(int p = left; p < right; p++){
            source[p] = target[p];
        }
    }

    //Gibt einen Array aus
    public static void printArray(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}

