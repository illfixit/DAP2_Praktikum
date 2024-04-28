import java.util.Arrays;
import java.util.Scanner;

class B3A2 {
    /**********************************************************/
    /**** Kurzaufgabe 3.2: ****/

    // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

    /**********************************************************/

    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }
        input.close();

        Arrays.sort(arr);
        System.err.println("Sorted input:");
        System.out.println(Arrays.toString(arr));
        System.err.println("The " + k + "-smallest permutation is:");
        /**********************************************************/
        /**** Kurzaufgabe 3.2: ****/

        // Ersetzen Sie diese Kommentarzeile durch Ihren Code!

        /**********************************************************/
        int[] source = new int[arr.length];
        int[] perm = find(arr, source, 0 ,k);
        System.out.println(Arrays.toString(perm));
        
    }


    public static int[] find(int[] arr, int[] sou, int o, int k){
        int n = arr.length;
        int i = (k-1)/factorOf(n-1);
        if(arr.length > 0){
            int[] newArr = removeElement(arr, i);
            int newK = k - i *(factorOf(n-1));
            sou[o] = arr[i];
            find(newArr, sou, o+1, newK);
        }
        return sou;
    }

    public static int[] removeElement(int[] arr, int index){
        if(arr == null || index < 0 || index >= arr.length){
            return arr;
        }

        int[] newArr = new int[arr.length - 1];

        int k = 0;
        for(int i = 0; i < arr.length; i++){
            if(i == index){
                continue;
            }

            newArr[k] = arr[i];
            k++;
        }
        return newArr;
    }


    public static int factorOf(int n){
        int result = 1;
        for(int i = 1; i <= n; i ++){
            result *= i;
        }
        return result;
    }
}
