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
	
	//
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
		// if root not initialised, set it to newNode
		if(root == null){
			root = newNode;
			root.color = BLACK;			//set root.color black bc of characteristic E1
			System.out.println("Fuege " + value + " in den Rot-Schwarz-Baum ein.");
		} else {
			//insert into red-black-tree and fix
			insert(root, newNode);
			fixInsert(newNode);
			System.out.println("Fuege " + value + " in den Rot-Schwarz-Baum ein.");
		}
	}

	// Hilfsmethode zum Einfügen eines neuen Knotens
	private void insert(Node root, Node newNode) {
		/**********************************************************/
					/**** Longaufgabe 8.2: ****/
		/**********************************************************/
		//if newNode smaller than root
		if(newNode.value < root.value) {
			//if left of root is empty assigne it newNode
			if(root.left == null) {
				root.left = newNode;
				newNode.parent = root;
			//else go left and check again
			} else {
				insert(root.left, newNode);
			}
		} else {
			//same as above but with right
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
		/**********************************************************/
	
		//if we are not looking at the root and the parents color is red
		while(node != root  && node.parent.color == RED){
			//if parent is left child
			if(node.parent == node.parent.parent.left){
				Node aunt = node.parent.parent.right;	//aunt is right child of grandparent
				//if aunt exists and is red
				if(aunt != null && aunt.color == RED){
					//CASE 1:aunt is red
					//adjust colors and make node grandparent
					node.parent.parent.color = RED;
					node.parent.color = BLACK;
					aunt.color = BLACK;
					node = node.parent.parent;
				} else {
					//CASE 2: Node is rightChild and aunt is not red
					if(node == node.parent.right){
						//make node parent and rotate left
						node = node.parent;
						rotateLeft(node);
					}
					//CASE 3: aunt is not red
					//adjust colors and rotate right
					node.parent.color = BLACK;
					node.parent.parent.color = RED;
					rotateRight(node.parent.parent);
				}
			} else { //same as above, but left <-> right
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
		root.color = BLACK; 	//make root black to have characteristic E1
	}

	// Links-Rotation
	private void rotateLeft(Node node) {
		/**********************************************************/
		/**** Longaufgabe 8.2: ****/

		// Ersetzen Sie diese Kommentarzeile durch Ihren Code!

		/**********************************************************/
		
		Node child;
		//cannot rotate around an empty node
		if(node == null){
			return;
		}

		//cannot rotate with an empty node
		child = node.right;
		if(child == null) {
			return;
		}

		//rightChild of node becomes leftChild of child
		node.right = child.left;
		if(child.left != null){
			//node is parent of leftChild of child
			child.left.parent = node;
		}

		//parent of node is now the parent of child
		child.parent = node.parent;
		//if node is the root, the new root becomes child
		if(node == root){
			root = child;
		} else if(node == node.parent.left){	//assign new child to the parent of node
			node.parent.left = child;
		} else {
			node.parent.right = child;
		}

		//connect child and node
		child.left = node;
		node.parent = child;
		System.out.println("Fuehre Links-Rotation durch bei Knoten: " + node.value);
		
	}

	// Rechts-Rotation, gleich wie Links, nur right <-> left
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
	//ähnlich wie in A1, nur dass noch die Farbe mit ausgegeben wird
	public void inOrderTraversal(Node node) {
		
		/**********************************************************/
		/**** Longaufgabe 8.2: ****/
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
	//gleich wie in A1
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
