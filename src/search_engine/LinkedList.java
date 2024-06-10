/**
 *
 * @author Furkan AK @Kowachka
 */

package search_engine;

public class LinkedList {

	ListNode head; // Reference to the head of the linked list

	// Constructor to initialize the linked list with a null head
	public LinkedList() {
		head = null;
	}

	// Inner class to represent a node in the linked list
	class ListNode {

		ListNode next; // Reference to the next node in the list
		String word; // The word stored in this node

		// Constructor to initialize a node with a given word and a null next reference
		ListNode(String word) {
			this.word = word;
			this.next = null;
		}
	}

	// Method to add a new word to the end of the linked list
	public void addWord(String word) {
		if (head == null) {
			head = new ListNode(word); // If the list is empty, create a new node and set it as the head
		} else {
			ListNode temp = head;
			while (temp.next != null) {
				temp = temp.next; // Traverse the list to find the last node
			}
			temp.next = new ListNode(word); // Add the new node to the end of the list
		}
	}

	// Method to check if the linked list contains a given word
	public boolean ifContainsWord(String word) {
		ListNode temp = head;
		while (temp != null) {
			if (temp.word.equalsIgnoreCase(word)) {
				return true; // If the word is found, return true
			}
			temp = temp.next; // Move to the next node
		}
		return false; // If the word is not found, return false
	}

}
