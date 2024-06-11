/**
 *
 * @author Furkan AK @Kowachka
 */

package search_engine;

public class BinarySearchTree {

	TreeNode root; // Reference to the root node of the binary search tree.

	// Constructor to initialize the binary search tree with a null root
	public BinarySearchTree() {
		root = null;
	}

	// Method to insert a new word and its file name into the binary search tree
	public void insert(String word, String fileName) {
		root = insertRec(root, word, fileName); // Call the recursive insertion method
	}

	// Recursive method to insert a new node into the binary search tree
	private TreeNode insertRec(TreeNode current, String word, String fileName) {
		if (current == null) {
			return new TreeNode(word, fileName); // Create a new node if the current node is null
		}
		int check = word.compareTo(current.word); // Compare the word with the current node's word
		if (check < 0) {
			current.left = insertRec(current.left, word, fileName); // Insert into the left subtree if the word is less
																	// than the current node's word
		} else if (check > 0) {
			current.right = insertRec(current.right, word, fileName); // Insert into the right subtree if the word is
																		// greater than the current node's word
		} else {
			current.incrementCounter(fileName); // Increment the counter if the word already exists in the tree
		}
		return current;
	}

	// Method to find a specific node containing a given word
	public TreeNode findTreeNode(TreeNode current, String word) {
		while (current != null) {
			if (word.compareTo(current.word) < 0) {
				current = current.left; // Traverse to the left subtree if the word is less than the current node's word
			} else if (word.compareTo(current.word) > 0) {
				current = current.right; // Traverse to the right subtree if the word is greater than the current node's
											// word
			} else {
				return current; // Return the current node if the word is found
			}
		}
		return null; // Return null if the word is not found
	}

	// Method to perform pre-order traversal of the binary search tree
	public String preOrderTraversal() {
		return preOrder(root); // Call the recursive pre-order traversal method
	}

	// Recursive method to perform pre-order traversal of the binary search tree
	private String preOrder(TreeNode node) {
		if (node == null) {
			return ""; // Return an empty string if the node is null
		} else {
			return node.word + ": " + node.counter + "\n" + preOrder(node.left) + preOrder(node.right); // Perform
																										// pre-order
																										// traversal
																										// recursively
		}
	}

	// Method to perform in-order traversal of the binary search tree
	public String inOrderTraversal() {
		return inOrder(root); // Call the recursive in-order traversal method.
	}

	// Recursive method to perform in-order traversal of the binary search tree
	private String inOrder(TreeNode node) {
		if (node == null) {
			return ""; // Return an empty string if the node is null
		} else {
			return inOrder(node.left) + node.word + ": " + node.counter + "\n" + inOrder(node.right); // Perform
																										// in-order
																										// traversal
																										// recursively
		}
	}

	// Method to perform post-order traversal of the binary search tree
	public String postOrderTraversal() {
		return postOrder(root); // Call the recursive post-order traversal method
	}

	// Recursive method to perform post-order traversal of the binary search tree
	private String postOrder(TreeNode node) {
		if (node == null) {
			return ""; // Return an empty string if the node is null
		} else {
			return postOrder(node.left) + postOrder(node.right) + node.word + ": " + node.counter + "\n"; // Perform
																											// post-order
																											// traversal
																											// recursively
		}
	}

}
