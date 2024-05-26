import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

class B7A2<K, V> {

    private ArrayList<LinkedList<Pair<K, V>>> table;
    private int m;

    // Constructor
    public B7A2(int m) {
        this.m = m;
        table = new ArrayList<LinkedList<Pair<K, V>>>(m);
        for (int i = 0; i < m; i++) {
            table.add(new LinkedList<Pair<K, V>>());
        }
    }

    // Private inner class to represent key-value pairs
    private static class Pair<K, V> {
        // Hier sind die Schlüssel und Werte generisch
        // und nicht fest auf Integer gesetzt wie in B7A1
        K wert;
        V schluessel;

        Pair(K wert, V schluessel) {
            this.wert = wert;
            this.schluessel = schluessel;
        }
    }

    // Private helper method to calculate the index of the linked list based on
    // key's hash code
    private int addressOfList(K key) {

        // wir dürfen nicht einfach den Hashcode des Schlüssels nehmen
        // denn der Modulo-Operator ist nicht für alle möglichen Schlüsseltypen K
        // definiert.
        return key.hashCode() % m;
    }

    // Public method to insert a key-value pair into the hash table
    public void insert(K key, V value) {
        int index = addressOfList(key);
        Pair<K, V> pair = new Pair<K, V>(key, value);
        if (table.get(index) == null) {
            table.get(index).add(pair);
        } else {
            for (Pair<K, V> p : table.get(index)) {
                if (p.wert.equals(key)) {
                    table.get(index).remove(p);
                }
            }
            table.get(index).add(pair);
        }

    }

    // Public method to retrieve the value associated with a key
    public V get(K key) {
        int idx = addressOfList(key);
        LinkedList<Pair<K, V>> l = table.get(idx);
        for (Pair<K, V> p : l) {
            if (p.wert.equals(key)) {
                return p.schluessel;
            }
        }

        return null;
    }

    // Public method to remove a key-value pair from the hash table
    public boolean remove(K key) {
        int idx = addressOfList(key);

        LinkedList<Pair<K, V>> l = table.get(idx);
        for (Pair<K, V> p : l) {
            if (p.wert.equals(key)) {
                l.remove(p);
                return true; // Schlüssel gefunden und entfernt
            }
        }
        return false; // Key not found
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Initialize the scanner and read the amount of expected integers
        int n = input.nextInt();
        assert n > 0 : "Error: length of the Input Array < 1";

        B7A2<Integer, String> table = new B7A2<>(n);

        String command;
        while (true) {
            System.out.print("Enter command (i to insert, g to get, r to remove, q to quit): ");
            command = input.next();
            if (command.equals("i")) {
                int key = input.nextInt();
                String value = input.next();
                table.insert(key, value);
                System.out.println("Inserted (" + key + ", " + value + ")");
            } else if (command.equals("g")) {
                // wir haben nextInt hier, das bedeutet, dass wir einen Integer erwarten und
                // nicht einen beliebigen Schlüssel
                int key = input.nextInt();
                String result = table.get(key);
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
