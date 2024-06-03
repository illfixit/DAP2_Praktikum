import java.util.Scanner;
import java.util.Arrays;

class B8A2 {

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private class Node {
		int value;
		Node left, right, parent;
		boolean color;

		Node(int value) {
			this.value = value;
			this.color = RED; // Neue Knoten sind zunächst rot
		}
	}

	private Node root;

	public B8A2(int[] array) {
		for (int i = 0; i < array.length; i++) {
			this.add(array[i]);
		}
	}

	// Methode zum Hinzufügen eines Werts
	public void add(int value) {
		
		/**********************************************************/
		/**** Longaufgabe 8.2: ****/

		// Ersetzen Sie diese Kommentarzeile durch Ihren Code!

		/**********************************************************/
	}

	// Hilfsmethode zum Einfügen eines neuen Knotens
	private void insert(Node root, Node newNode) {
		/**********************************************************/
		/**** Longaufgabe 8.2: ****/

		// Ersetzen Sie diese Kommentarzeile durch Ihren Code!

		/**********************************************************/
	}

	// Balancierung nach dem Einfügen
	private void fixInsert(Node node) {
		/**********************************************************/
		/**** Longaufgabe 8.2: ****/

		// Ersetzen Sie diese Kommentarzeile durch Ihren Code!

		/**********************************************************/
	}

	// Links-Rotation
	private void rotateLeft(Node node) {
		/**********************************************************/
		/**** Longaufgabe 8.2: ****/

		// Ersetzen Sie diese Kommentarzeile durch Ihren Code!

		/**********************************************************/
	}

	// Rechts-Rotation
	private void rotateRight(Node node) {
		/**********************************************************/
		/**** Longaufgabe 8.2: ****/

		// Ersetzen Sie diese Kommentarzeile durch Ihren Code!

		/**********************************************************/
	}

	// In-Order Traversierung mit Ausgabe der Farben
	public void inOrderTraversal(Node node) {
		
		/**********************************************************/
		/**** Longaufgabe 8.2: ****/

		// Ersetzen Sie diese Kommentarzeile durch Ihren Code!

		/**********************************************************/
	}

    // Gibt die Höhe des Baums zurück
	public int height(Node node) {
		/**********************************************************/
		/**** Longaufgabe 8.2: ****/

		// Ersetzen Sie diese Kommentarzeile durch Ihren Code!

		/**********************************************************/
		return -1;
	}

	// Hauptmethode
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

		B8A2 tree = new B8A2(arr);

		System.out.println("Hoehe: " + tree.height(tree.root));
		System.out.print("In-Order Traversierung: ");
		tree.inOrderTraversal(tree.root);
	}
}
