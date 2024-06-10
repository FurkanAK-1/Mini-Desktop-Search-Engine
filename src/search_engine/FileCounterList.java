/**
 *
 * @author Furkan AK @Kowachka
 */

package search_engine;

public class FileCounterList {

	FileCounter head; // Reference to the head of the file counter list

	// Method to add a file name and its frequency or increment the frequency if the
	// file name already exists
	public void addInformationOrIncrement(String fileName) {
		if (head == null) {
			head = new FileCounter(fileName, 1); // If the list is empty, create a new node with the file name and a
													// frequency of 1
			return;
		}

		FileCounter current = head;
		while (current != null) {
			if (current.fileName.equals(fileName)) {
				current.counter++; // If the file name already exists, increment its frequency
				return;
			}
			if (current.next == null) {
				current.next = new FileCounter(fileName, 1); // If the file name doesn't exist, add a new node with the
																// file name and a frequency of 1
				return;
			}
			current = current.next; // Move to the next node
		}
	}

	// Method to print the file names and their frequencies stored in the list
	public String printInformation() {
		String result = "";
		FileCounter current = head;
		while (current != null) {
			result += current.fileName + ": " + current.counter + "\n"; // Concatenate file name and its frequency to
																		// the result string
			current = current.next; // Move to the next node
		}
		return result; // Return the result string
	}

}

class FileCounter {

	String fileName; // Name of the file
	int counter; // Frequency counter for the file
	FileCounter next; // Reference to the next FileCounter node

	// Constructor to initialize a FileCounter node with a file name and a counter
	public FileCounter(String fileName, int counter) {
		this.fileName = fileName;
		this.counter = counter;
		this.next = null; // Initialize next reference as null
	}
}