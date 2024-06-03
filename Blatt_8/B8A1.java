
import java.util.Scanner;
import java.util.Arrays;

class B8A1 {
    // Wir speichern die Höhe des Baumes
    // damit wir später die Traversierungen durchführen können
    private int hoehe;
    // Same für die Wurzel des Baumes
    private BaumKnote wurzel;
    // die Länge des Baumes (Anzahl der Elemente)
    // damit wir die höhe des Baumes berechnen können

    // Wir erstellen eine innere Klasse,
    // die die Knoten des Baumes speichert
    // Jeder Knoten hat einen Wert und zwei Kinder
    // (links und rechts)
    private class BaumKnote {
        BaumKnote links;
        BaumKnote rechts;
        int wert;

        BaumKnote(int wert) {
            this.wert = wert;
            // Wenn wir eine neue Knote erstellen, haben wir keine Kinder
            // später wird jedes Kind auf den anderen Knote "zeigen"
            this.links = null;
            this.rechts = null;
        }
    }

    public B8A1(int[] array) {
        this.hoehe = 0;
        this.wurzel = null;
        for (int i = 0; i < array.length; i++) {
            // wir fügen jedes Element des Arrays zum Baum hinzu
            // aber erhöhen die Höhe des Baumes nicht hier
            // sondern in der Methode add
            add(array[i]);
        }

    }

    public void add(int v) {
        // Wenn der Baum leer ist, fügen wir das Element als Wurzel hinzu
        if (this.wurzel == null) {
            this.wurzel = new BaumKnote(v);
            return;
        } else {
            // Wir fangen mit der Wurzel an und gehen durch den Baum
            BaumKnote aktuell = this.wurzel;
            // bis unser aktueller Knoten leer ist
            while (aktuell != null) {
                // Wenn das Element kleiner als der aktuelle Wert ist
                // fügen wir es links hinzu
                // Wir aktualisieren die Höhe des Baumes nur dann, wenn wir ein neues Element
                // hinzufügen
                if (v < aktuell.wert) {
                    if (aktuell.links == null) {
                        aktuell.links = new BaumKnote(v);
                        this.hoehe = Math.max(this.hoehe, getHeigth(this.wurzel));
                        return;
                    } else {
                        aktuell = aktuell.links;
                    }
                    // Wenn das Element größer als der aktuelle Wert ist
                    // fügen wir es rechts hinzu
                } else {
                    if (aktuell.rechts == null) {
                        aktuell.rechts = new BaumKnote(v);
                        this.hoehe = Math.max(this.hoehe, getHeigth(this.wurzel));
                        return;
                    } else {
                        aktuell = aktuell.rechts;
                    }
                }
                // Wenn das Element gleich dem aktuellen Wert ist
                // fügen wir es nicht hinzu
            }
        }
    }

    // Wir berechnen die Höhe des Baumes rekursiv wie in DAP-1 :)
    private int getHeigth(BaumKnote knote) {
        if (knote == null) {
            return 0;
        } else {
            int left = getHeigth(knote.links);
            int right = getHeigth(knote.rechts);
            return 1 + Math.max(left, right);
        }
    }

    // 11 12 3 11 40 -10 17 -5 4 5 13 100

    // In-Order Traversierung
    // linkes Kind -> Wurzel -> rechtes Kind
    public void inOrder() {
        inOrder(this.wurzel);
    }

    private void inOrder(BaumKnote knote) {
        if (knote == null) {
            return;
        }
        inOrder(knote.links);
        System.out.print(knote.wert + " ");
        inOrder(knote.rechts);
    }

    // Pre-Order Traversierung
    // Wurzel -> linkes Kind -> rechtes Kind
    public void preOrder() {
        preOrder(this.wurzel);
    }

    private void preOrder(BaumKnote knote) {
        if (knote == null) {
            return;
        }
        System.out.print(knote.wert + " ");
        preOrder(knote.links);
        preOrder(knote.rechts);
    }

    // Post-Order Traversierung
    // linkes Kind -> rechtes Kind -> Wurzel
    public void postOrder() {
        postOrder(this.wurzel);
    }

    private void postOrder(BaumKnote knote) {
        if (knote == null) {
            return;
        }
        postOrder(knote.links);
        postOrder(knote.rechts);
        System.out.print(knote.wert + " ");
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

        B8A1 bst = new B8A1(arr);

        System.out.println("Hoehe des Baums: " + bst.hoehe);

        System.out.println("In-Order Traversierung:");
        bst.inOrder();
        System.out.println();
        System.out.println("Pre-Order Traversierung:");
        bst.preOrder();
        System.out.println();
        System.out.println("Post-Order Traversierung:");
        bst.postOrder();
        System.out.println();
    }

}
