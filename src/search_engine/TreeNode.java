/**
 *
 * @author Furkan AK @Kowachka
 */

package search_engine;

public class TreeNode {

	String word; // The word stored in this node
	int counter; // Counter to keep track of the frequency of the word
	TreeNode left;
	TreeNode right; // References to the left and right child nodes
	FileCounterList fileCounter; // List to store file names and their corresponding frequencies

	// Constructor to initialize the node with a word and the file name it occurs in
	public TreeNode(String word, String fileName) {
		this.word = word;
		this.counter = 1; // Initialize the counter to 1 since it's the first occurrence of the word
		this.left = null; // Initialize the left child as null
		this.right = null; // Initialize the right child as null
		this.fileCounter = new FileCounterList(); // Initialize the file counter list
		this.fileCounter.addInformationOrIncrement(fileName); // Add the file name and increment its counter
	}

	// Method to increment the counter for a word occurring in a given file
	public void incrementCounter(String fileName) {
		this.counter++; // Increment the total counter for the word
		this.fileCounter.addInformationOrIncrement(fileName); // Increment the counter for the given file name
	}

}