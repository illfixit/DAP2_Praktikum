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
		Node newNode = new Node(value);
		if(root == null){
			root = newNode;
			root.color = BLACK;
			System.out.println("Fuege " + value + " in den Rot-Schwarz-Baum ein.");
		} else {
			insert(root, newNode);
			fixInsert(newNode);
			System.out.println("Fuege " + value + " in den Rot-Schwarz-Baum ein.");
		}
	}

	// Hilfsmethode zum Einfügen eines neuen Knotens
	private void insert(Node root, Node newNode) {
		/**********************************************************/
		/**** Longaufgabe 8.2: ****/

		// Ersetzen Sie diese Kommentarzeile durch Ihren Code!

		/**********************************************************/
		if(newNode.value < root.value) {
			if(root.left == null) {
				root.left = newNode;
				newNode.parent = root;
			} else {
				insert(root.left, newNode);
			}
		} else {
			if(root.right == null) {
				root.right = newNode;
				newNode.parent = root;
			} else {
				insert(root.right, newNode);
			}
		}
		
		
	}

	// Balancierung nach dem Einfügen
	private void fixInsert(Node node) {
		/**********************************************************/
		/**** Longaufgabe 8.2: ****/

		// Ersetzen Sie diese Kommentarzeile durch Ihren Code!

		/**********************************************************/
	

		while(node != root  && node.parent.color == RED){

			if(node.parent == node.parent.parent.left){
				Node aunt = node.parent.parent.right;
				if(aunt != null && aunt.color == RED){
					node.parent.parent.color = RED;
					node.parent.color = BLACK;
					aunt.color = BLACK;
					node = node.parent.parent;
				} else {
					if(node == node.parent.right){
						node = node.parent;
						rotateLeft(node);
					}
					node.parent.color = BLACK;
					node.parent.parent.color = RED;
					rotateRight(node.parent.parent);
				}
			} else {
				Node aunt = node.parent.parent.left;
				if(aunt != null && aunt.color == RED){
					node.parent.parent.color = RED;
					node.parent.color = BLACK;
					aunt.color = BLACK;
					node = node.parent.parent;
				} else {
					if(node == node.parent.left){
						node = node.parent;
						rotateRight(node);
					}
					node.parent.color = BLACK;
					node.parent.parent.color = RED;
					rotateLeft(node.parent.parent);
				}
			}
		}
		root.color = BLACK;
	}

	// Links-Rotation
	private void rotateLeft(Node node) {
		/**********************************************************/
		/**** Longaufgabe 8.2: ****/

		// Ersetzen Sie diese Kommentarzeile durch Ihren Code!

		/**********************************************************/
		
		Node child;
		if(node == null){
			return;
		}

		child = node.right;
		if(child == null) {
			return;
		}

		node.right = child.left;
		if(child.left != null){
			child.left.parent = node;
		}

		child.parent = node.parent;
		if(node == root){
			root = child;
		} else if(node == node.parent.left){
			node.parent.left = child;
		} else {
			node.parent.right = child;
		}

		child.left = node;
		node.parent = child;
		System.out.println("Fuehre Links-Rotation durch bei Knoten: " + node.value);
		
	}

	// Rechts-Rotation
	private void rotateRight(Node node) {
		/**********************************************************/
		/**** Longaufgabe 8.2: ****/

		// Ersetzen Sie diese Kommentarzeile durch Ihren Code!

		/**********************************************************/
		Node child;
		if(node == null){
			return;
		}

		child = node.left;
		if(child == null) {
			return;
		}

		node.right = child.right;
		if(child.right != null){
			child.right.parent = node;
		}

		child.parent = node.parent;
		if(node == root){
			root = child;
		} else if(node == node.parent.left){
			node.parent.left = child;
		} else {
			node.parent.right = child;
		}

		child.right = node;
		node.parent = child;
		System.out.println("Fuehre Rechts-Rotation durch bei Knoten: " + node.value);
	}

	// In-Order Traversierung mit Ausgabe der Farben
	public void inOrderTraversal(Node node) {
		
		/**********************************************************/
		/**** Longaufgabe 8.2: ****/

		// Ersetzen Sie diese Kommentarzeile durch Ihren Code!

		/**********************************************************/
		if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
		String color = node.color == RED? "rot" : "schwarz";
        System.out.print("( " + node.value + ", " + color + " )");
        inOrderTraversal(node.right);
	}

    // Gibt die Höhe des Baums zurück
	public int height(Node node) {
		/**********************************************************/
		/**** Longaufgabe 8.2: ****/

		// Ersetzen Sie diese Kommentarzeile durch Ihren Code!

		/**********************************************************/
		if (node == null) {
            return 0;
        } else {
            int left = height(node.left);
            int right = height(node.right);
            return 1 + Math.max(left, right);
        }
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
