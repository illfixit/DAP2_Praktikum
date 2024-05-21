import java.util.Scanner;
import java.util.Arrays;

class B6A2 {

    //invertiert einen Array
    public static void reverseArray(int[] input){
        for(int i = 0; i < input.length/2; i++){
            int k = input[i];
            input[i] = input[input.length - i -1];
            input[input.length -i -1] = k;
        }
    }

    public static void sortByByte(int[] input, int l, int r, int b) {
        /**********************************************************/
        /****                Langaufgabe 6.2:                  ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
        // b-niederwertigster Byte von a: (a » (8 * b)) & 0xFF
        int counter = 0;
        //Neues Array für die b-Bytes
        int[] output = new int[r-l];
        //fülle output mit b-niederwertigsten Bytes
        for(int i = l; i < r; i++){
            output[counter] = (input[i] >> (8 * b)) & 0xFF;
            counter++;
        }
        //sortiere output und reverse, damit es absteigend sortiert ist
        Arrays.sort(output);
        reverseArray(output);
        //output und input von hinten
        int c = output.length-1;
        //solange wir noch in output sind
        while(c >= 0){
            for(int k = r-1; k >= l; k--){
                //wenn wir einen Wert finden, wo das b-niederwertigste Byte mit dem derzeitigen Wert
                //von output übersteinstimmt, fügen wir den Wert in output ein
                if(output[c] == ((input[k] >> (8 * b)) & 0xFF)){
                    output[c] = input[k];
                    c--;
                    //input[k] wird auf -1 gesetzt, damit wir keine Werte doppelt kriegen
                    input[k] = -1;
                }
                //sobald c kleiner als 0 ist, haben wir alle werte in output ersetzt und sind fertig
                if(c < 0){
                    break;
                }
            }
        }
        //überschreibe input, mit dem nach dem b-niederwertigsten Byte sortierten Array
        for(int i = l; i < r; i++){
            input[i] = output[i];
        }
        return;
    }

    public void radix(int[] data) {
        /**********************************************************/
        /****                Langaufgabe 6.2:                  ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
        //sortiere nach allen Bytes angefangen bei 0 bis 3
        for(int i = 0; i < 4; i++){
            sortByByte(data, 0, data.length, i);
        }
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
