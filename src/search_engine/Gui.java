/**
 *
 * @author Furkan AK @Kowachka
 */

package search_engine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Gui extends javax.swing.JFrame {

	private LinkedList forbiddenWords; // Linked list to store forbidden words
	private BinarySearchTree bst; // Binary search tree to store words from files

	/**
	 * Creates new form FurkanAKHacerEbraOZDEMIRGui2
	 */
	public Gui() {
		initComponents(); // Initialize GUI components
		setLocationRelativeTo(null); // Center the GUI window
		bst = new BinarySearchTree(); // Initialize the binary search tree
		initializeForbiddenWords(); // Initialize the list of forbidden words
	}

	// Method to initialize the list of forbidden words from a file
	private void initializeForbiddenWords() {
		forbiddenWords = new LinkedList(); // Initialize the linked list for forbidden words
		JOptionPane.showMessageDialog(this,
				"Before selecting your files, select the file in the list you want to be banned.", "To inform",
				JOptionPane.INFORMATION_MESSAGE);

		JFileChooser fileChooser = new JFileChooser(); // Create a file chooser dialog
		fileChooser.setDialogTitle("Select Banned Words File");
		fileChooser.setAcceptAllFileFilterUsed(true);
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		int result = fileChooser.showOpenDialog(this); // Show the file chooser dialog
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile(); // Get the selected file
			try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
				String line;
				while ((line = reader.readLine()) != null) {
					if (!line.trim().isEmpty()) {
						forbiddenWords.addWord(line.trim().toLowerCase()); // Add each word from the file to the
																			// forbidden words list
					}
				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(this, "File read error: " + e.getMessage(), "Error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(this, "No file selected.", "Failed to Select File",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	// Method to update the display area with the contents of the binary search tree
	private void updateBSTOfArea() {
		String orderType = (String) selectTraversal.getSelectedItem(); // Get the selected traversal order
		String traversalType = "";
		switch (orderType) {
		case "In-order":
			traversalType = bst.inOrderTraversal(); // Perform in-order traversal
			break;
		case "Pre-order":
			traversalType = bst.preOrderTraversal(); // Perform pre-order traversal
			break;
		case "Post-order":
			traversalType = bst.postOrderTraversal(); // Perform post-order traversal
			break;
		default:
			traversalType = "Selection is invalid.";
			break;
		}
		bstOfFileArea.setText(traversalType); // Update the display area with the traversal result
	}

	// Method to read and process a file
	private void readFile(File file) {
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String text;
			while ((text = reader.readLine()) != null) {

				Scanner scanner = new Scanner(text);
				while (scanner.hasNext()) {
					String word = scanner.next();
					if (!word.matches("<[^>]+>")) {
						String filteredWord = word.toLowerCase().replaceAll("[^a-zA-Z0-9']", "");
						if (!filteredWord.isEmpty() && !filteredWord.matches("^[0-9]+$")
								&& !forbiddenWords.ifContainsWord(filteredWord)) {
							bst.insert(filteredWord, file.getName()); // Insert filtered words into the binary search
																		// tree
						}
					}
				}
			}
			updateBSTOfArea(); // Update the display area with the updated binary search tree
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		searchWordTextField = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		selectFilesButton = new javax.swing.JButton();
		selectTraversal = new javax.swing.JComboBox<>();
		jScrollPane1 = new javax.swing.JScrollPane();
		bstOfFileArea = new javax.swing.JTextArea();
		jScrollPane2 = new javax.swing.JScrollPane();
		searchWordArea = new javax.swing.JTextArea();
		searchWordButton = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("MINI DESKTOP SEARCH ENGINE");
		setBackground(new java.awt.Color(255, 255, 255));
		setMinimumSize(new java.awt.Dimension(755, 551));

		searchWordTextField.setBackground(new java.awt.Color(212, 148, 243));
		searchWordTextField.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
		searchWordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyReleased(java.awt.event.KeyEvent evt) {
				searchWordTextFieldKeyReleased(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(102, 0, 153));
		jLabel1.setText("Enter the word you want to search:");

		selectFilesButton.setBackground(new java.awt.Color(102, 0, 153));
		selectFilesButton.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
		selectFilesButton.setForeground(new java.awt.Color(255, 255, 255));
		selectFilesButton.setText("Select File");
		selectFilesButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				selectFilesButtonActionPerformed(evt);
			}
		});

		selectTraversal.setBackground(new java.awt.Color(102, 0, 153));
		selectTraversal.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
		selectTraversal.setModel(
				new javax.swing.DefaultComboBoxModel<>(new String[] { "In-order", "Pre-order", "Post-order" }));
		selectTraversal.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				selectTraversalActionPerformed(evt);
			}
		});

		bstOfFileArea.setEditable(false);
		bstOfFileArea.setBackground(new java.awt.Color(246, 249, 109));
		bstOfFileArea.setColumns(20);
		bstOfFileArea.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
		bstOfFileArea.setRows(5);
		bstOfFileArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
		jScrollPane1.setViewportView(bstOfFileArea);

		searchWordArea.setEditable(false);
		searchWordArea.setBackground(new java.awt.Color(246, 249, 109));
		searchWordArea.setColumns(20);
		searchWordArea.setFont(new java.awt.Font("Helvetica Neue", 0, 15)); // NOI18N
		searchWordArea.setRows(5);
		searchWordArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
		jScrollPane2.setViewportView(searchWordArea);

		searchWordButton.setBackground(new java.awt.Color(102, 0, 153));
		searchWordButton.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
		searchWordButton.setForeground(new java.awt.Color(255, 255, 255));
		searchWordButton.setText("Search Word");
		searchWordButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchWordButtonActionPerformed(evt);
			}
		});

		jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 15)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(102, 0, 153));
		jLabel2.setText("Select files and traversal:");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jLabel2)
								.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
								.addComponent(selectTraversal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(selectFilesButton, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(searchWordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 380,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1).addComponent(searchWordButton,
										javax.swing.GroupLayout.PREFERRED_SIZE, 380,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(jLabel2))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(searchWordTextField, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(selectTraversal, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(
								layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 442,
												Short.MAX_VALUE)
										.addComponent(jScrollPane1))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(searchWordButton).addComponent(selectFilesButton))
						.addContainerGap(16, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	// Method invoked when the "Search Word" button is clicked
	private void searchWordButtonActionPerformed(java.awt.event.ActionEvent evt) {
		String word = searchWordTextField.getText().toLowerCase(); // Get the word to search for
		TreeNode foundNode = bst.findTreeNode(bst.root, word); // Find the node containing the word in the binary search
																// tree
		if (foundNode != null) {
			searchWordArea.setText("'" + word + "' " + "the word " + "found in the following files:\n"
					+ foundNode.fileCounter.printInformation()); // Display search result
		} else {
			searchWordArea.setText("Word not found."); // Display message if word is not found
		}
		searchWordArea.setVisible(true); // Make the search result area visible
	}

	// Method invoked when the "Select File" button is clicked
	private void selectFilesButtonActionPerformed(java.awt.event.ActionEvent evt) {
		JFileChooser fileChooser = new JFileChooser(); // Create a file chooser dialog
		fileChooser.setDialogTitle("Select File");
		fileChooser.setMultiSelectionEnabled(true); // Allow multiple file selection
		int result = fileChooser.showOpenDialog(this); // Show the file chooser dialog
		if (result == JFileChooser.APPROVE_OPTION) {
			File[] selectedFiles = fileChooser.getSelectedFiles(); // Get the selected files
			for (File file : selectedFiles) {
				readFile(file); // Read and process each selected file
			}
		}
	}

	// Method invoked when the traversal order is changed
	private void selectTraversalActionPerformed(java.awt.event.ActionEvent evt) {
		updateBSTOfArea();// Update the display area with the binary search tree contents based on the
							// selected traversal order
	}

	// Method invoked when a key is released in the search word text field
	private void searchWordTextFieldKeyReleased(java.awt.event.KeyEvent evt) {
		if (searchWordTextField.getText().isEmpty()) {
			searchWordArea.setText("");// If the search word text field is empty, clear the search result area
		}
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Gui().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JTextArea bstOfFileArea;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextArea searchWordArea;
	private javax.swing.JButton searchWordButton;
	private javax.swing.JTextField searchWordTextField;
	private javax.swing.JButton selectFilesButton;
	private javax.swing.JComboBox<String> selectTraversal;
	// End of variables declaration
}
