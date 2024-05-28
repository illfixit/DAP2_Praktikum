import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class B7A1 {
    // Constructor

    // in der Aufabe steht "n" nicht "m" wie im Code

    /*
     * Abgesehen vom Konstruktor und den Grundoperationen hat die Klasse keine
     * öffentlichen
     * Methoden oder Attribute!
     * Ich glaube das bedeutet wir müssen nur private Methoden und Attribute
     * implementieren.
     */
    private ArrayList<LinkedList<Pair>> table;
    private int n;

    public B7A1(int n) {
        this.n = n;
        table = new ArrayList<LinkedList<Pair>>(n);
        for (int i = 0; i < n; i++) {
            table.add(new LinkedList<Pair>());
        }

    }

    // Private inner class to represent key-value pairs
    private static class Pair {
        Integer schluessel;
        Integer wert;

        /*
         * Ein Objekt vom Typ B7A1 verwaltet eine Menge von Schlüssel-Wert-Paaren, wobei
         * Schlüssel und Werte vom Typ Integer sind. Legen Sie in B7A1 eine private
         * innere Klasse Pair an, sodass ein Pair-Objekt genau ein Schlüssel-Wert-Paar
         * beinhaltet.
         */
        Pair(Integer schluessel, Integer wert) {
            this.schluessel = schluessel;
            this.wert = wert;
        }
    }

    // Private helper method to calculate the index of the linked list based on key
    private int addressOfList(Integer key) {
        return Math.floorMod(key, n);
    }

    // Public method to insert a key-value pair into the hash table
    public void insert(Integer key, Integer value) {
        // in allen Methoden müssen wir die Adresse der Liste berechnen
        // indem wir die Funktion addressOfList aufrufen
        int index = addressOfList(key);
        // wir erstellen ein neues Pair Objekt und fügen es in die Liste ein
        Pair pair = new Pair(key, value);
        if (table.get(index) == null) {
            table.get(index).add(pair);
        } else {
            table.remove(index);
            table.get(index).add(pair);
        }
    }

    // Public method to retrieve the value associated with a key
    public Integer get(Integer key) {
        // in allen Methoden müssen wir die Adresse der Liste berechnen
        // indem wir die Funktion addressOfList aufrufen
        int idx = addressOfList(key);
        // wir bekommen den Index der Liste und iterieren durch die Liste
        LinkedList<Pair> l = table.get(idx);
        for (Pair p : l) {
            if (p.schluessel.equals(key)) {
                return p.wert;
            }
        }
        return null;
    }

    // Public method to remove a key-value pair from the hash table
    public boolean remove(Integer key) {
        // in allen Methoden müssen wir die Adresse der Liste berechnen
        // indem wir die Funktion addressOfList aufrufen
        int idx = addressOfList(key);
        // wir bekommen den Index der Liste und iterieren durch die Liste
        // wenn wir das Paar gefunden haben, entfernen wir es
        LinkedList<Pair> l = table.get(idx);
        for (Pair p : l) {
            if (p.schluessel.equals(key)) {
                l.remove(p);
                return true;
            }
        }
        return false;
    }

    // private void iterateAndApply(LinkedList<Pair> list, Function<Pair, Boolean>
    // f) {
    // for (Pair p : list) {
    // if (f.apply(p)) {
    // return;
    // }
    // }
    // }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Initialize the scanner and read the amount of expected integers
        int n = input.nextInt();
        assert n > 0 : "Error: length of the Input Array < 1";

        B7A1 table = new B7A1(n);

        String command;
        while (true) {
            System.out.print("Enter command (i to insert, g to get, r to remove, q to quit): ");
            command = input.next();
            if (command.equals("i")) {
                int key = input.nextInt();
                int value = input.nextInt();
                table.insert(key, value);
                System.out.println("Inserted (" + key + ", " + value + ")");
            } else if (command.equals("g")) {
                int key = input.nextInt();
                Integer result = table.get(key);
                if (result != null) {
                    System.out.println("Key: " + key + ", Value: " + result);
                } else {
                    System.out.println("Key not found.");
                }
            } else if (command.equals("r")) {
                int key = input.nextInt();
                boolean removed = table.remove(key);
                System.out.println("Key " + key + " removed: " + removed);
            } else if (command.equals("q")) {
                break;
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
        input.close();
    }

}