import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

class SolutionB4A2New {
    // Hilfsfunktion zum Vertauschen zweier Werte
    public static void swap(int[] data, int i, int j) {
        int h = data[i];
        data[i] = data[j];
        data[j] = h;
    }

    // Hilfsfunktion zum Berechnen von n!
    public static int fact(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public static void updatePremutation(int[] numbers, int[] counters) {
        /**********************************************************/
        /****                Langaufgabe 4.2:                  ****/
        /**********************************************************/
        int i = 0;
        while (i < numbers.length){                     //solange Index im Array
            if(counters[i] < i){
                if(i % 2 == 0){                         //wenn i gerade: vertausche 0 und i
                    swap(numbers, 0, i);
                } else {
                    swap(numbers, i, counters[i]);      //wenn ungerade: vertausche i und counters[i]
                }
                counters[i]++;
                return;                                 //Permutation ist fertig
            } else {
                counters[i] = 0;                        //counters reset
                i++;                                    //überprüfe den nächsten Index
            }
       
        }
    }
    

    public static void shufflePermutation(int[] numbers) {
        /**********************************************************/
        /****                Langaufgabe 4.2:                  ****/
        /**********************************************************/
        int rnd;
        for(int i = 0; i < numbers.length; i++){
            rnd = ThreadLocalRandom.current().nextInt(numbers.length);  //random Index
            swap(numbers, i, rnd);                                      //vertausche i mit rnd
        }

    }

    //Übernommen von vorherigem Blatt
    public static int insertionSort(int[] permutation) {
        int swap_cnt = 0;

        for (int j = 1; j < permutation.length; j++) {
            int key = permutation[j];
            int i = j - 1;

            while (i >= 0 && permutation[i] > key) {
                permutation[i + 1] = permutation[i];
                i = i - 1;

                swap_cnt++;
            }
            

            permutation[i + 1] = key;
        }

        return swap_cnt;                          //return Anzahl der swaps, um Durschnitt zuberechnen
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);  //Länge des Arrays
        int k = Integer.parseInt(args[1]);  //Anzahl der Permutationen die durch shuffelPermutation erzeugt werden sollen


        int nFact = fact(n);            //Anzahl der Permutationen 

        int[] numbers = new int[n];     //Initalisierung des zu sortierenden Arrays
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        int[] counters = new int[n];    //Initialisierung des counters Arrays, für den updatePermutation-Algorithmus
        for (int i = 0; i < n; i++){
            counters[i] = 0;
        }
        
        double average = 0;             //Durschnitt
        int biggest = -1;               //Schlimmster Fall, muss mit -1 initialisiert werden, damit der schlimmste Fall richtig verglichen werden kann
        int swaps = 0;                  //Zwischenspeicherung der Anzahl der swaps
        if(n <= 10){                    //wenn das Array kleiner gleich 10 Elemente hat
            for(int i = 0; i < nFact; i++){                 //Alle Permutationen
                swaps = insertionSort(numbers.clone());     //sortieren des Arrays
                average += swaps;                           //Aufaddieren der Swaps
                if(biggest == -1 || biggest < swaps){       //Vergleich für den schlimmsten Fall  
                    biggest = swaps;
                } 
                
                updatePremutation(numbers, counters);       //Erzeuge die nächste Permutation
            }
            average = average / nFact;                      //Berechnung des arithmetischen Mittels
            average = round(average, 1);          //Runden auf eine Nachkommastelle
            //Ausgabe
            System.out.println("Durschnittliche Anzahl von Verschiebungen: " + average);
            System.out.println("Schlimmste Anzahl von Verschiebungen: " + biggest);
        } else {                                            //wenn length länger als 10
            for(int i = 0; i < k; i++){                     //erzeuge k Permutationen
                shufflePermutation(numbers);
                swaps = insertionSort(numbers.clone());
                average += swaps;
            }
            average = average / k-1;
            average = round(average, 1);
            System.out.println("Durschnittliche Anzahl von Verschiebungen: " + average);
     }
    }
        
        /**********************************************************/
        /****                Langaufgabe 4.2:                  ****/
        /**********************************************************/
    
    //Hilfsfunktion fürs Runden von Zahlen auf percision-Nachkommastellen
    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
