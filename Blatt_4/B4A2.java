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

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
        int count = 0;
        // for(int i = 0; i < numbers.length; i++){
        //     System.out.println(i);
        //     if(i < numbers.length){
        //         if(counters[i] < i){
        //             System.out.println(counters[i] + " ist kleiner als " + i);
        //             if(i % 2 == 0){
        //                 swap(numbers, 0, i);
        //             } else {
        //                 swap(numbers, i, counters[i]);
                        
        //             }
        //             counters[i]++;
        //             return;
        //         } else if(counters[i] >= i){
        //             counters[i] = 0;
        //             i = 0;
        //         }
        //     }
        //     System.out.println(i + " " + counters[i]);
        //     count++;
        // }
        int i = 1;
        while (i < numbers.length){
            if(counters[i] < i){
                if(i % 2 == 0){
                    swap(numbers, 0, i);
                } else {
                    swap(numbers, i, counters[i]);
                }
                counters[i]++;
                return;
                //System.out.println(Arrays.toString(numbers));
            } else {
                counters[i] = 0;
                i++;
            }
       
        }
    }
    

    public static void shufflePermutation(int[] numbers) {
        /**********************************************************/
        /****                Langaufgabe 4.2:                  ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
        int rnd;
        int temp;
        for(int i = 0; i < numbers.length; i++){
            rnd = ThreadLocalRandom.current().nextInt(numbers.length);
            temp = numbers[i];
            numbers[i] = numbers[rnd];
            numbers[rnd] = temp;
        }

    }

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

        return swap_cnt;
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);


        int nFact = fact(n);

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = i + 1;
        }
        int[] counters = new int[n];
        for (int i = 0; i < n; i++){
            counters[i] = 0;
        }
        
        double average = 0;
        int biggest = -1;
        int swaps = 0;
        if(n <= 10){
            for(int i = 0; i < nFact; i++){
                swaps = insertionSort(numbers.clone());
                average += swaps;
                if(biggest == -1 || biggest < swaps){
                    biggest = swaps;
                } 
                
                // System.out.println(Arrays.toString(numbers));
                // System.out.println("Swaps: " + swaps + ". Biggest: " + biggest + ". Average: " + average);
                updatePremutation(numbers, counters);
            }
            average = average / nFact;
            average = round(average, 1);
            System.out.println("Durschnittliche Anzahl von Verschiebungen: " + average);
            System.out.println("Schlimmste Anzahl von Verschiebungen: " + biggest);
        } else {
            for(int i = 0; i < k; i++){
                shufflePermutation(numbers);
                swaps = insertionSort(numbers.clone());
                average += swaps;
                if(biggest == -1 || biggest < swaps){
                    biggest = swaps;
                } 
            }
            average = average / k-1;
            average = round(average, 1);
            System.out.println("Durschnittliche Anzahl von Verschiebungen: " + average);
     }
    }
        
        /**********************************************************/
        /****                Langaufgabe 4.2:                  ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
    

    private static double round (double value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (double) Math.round(value * scale) / scale;
    }
}
