/**
 * @author joey pham
 * @date 25 November 2018
 * @description this class represents a BST
 */

public class BST {
	public static class Node {
		/**
		 * represents the word being made
		 */
		private Word data;
		
		/**
		 * represents a word to the left sorted by alphabetical order
		 */
		private Node left;
		
		/**
		 * represents a word to the right sorted by alphabetical order
		 */
		private Node right;
		
		/**
		 * constructor
		 * @param d word being passed in
		 */
		public Node ( Word d ) {
			data = d;
			left = null;
			right = null;
		}
		
		/**
		 * returns a string of the word
		 * @return word to return
		 */
		public String toString ( ) {
			return "" + data;
		}
	}
	
	/**
	 * represents the first node in the tree
	 */
	private Node root;
	
	/**
	 * constructor
	 */
	public BST ( ) {
		root = null;
	}
	
	/**
	 * checks if the tree is empty
	 * @return true or false depending on if it's empty
	 */
	public boolean isEmpty ( ) {
		return root == null;
	}
	
	/**
	 * facade function to add a word to the tree
	 * @param d word to add to the tree
	 */
	public void add ( Word d ) {
		root = add ( d, root );
	}
	
	/**
	 * adds a word to the tree in the correct order
	 * @param d word to put in the tree
	 * @param n node to set the word to
	 * @return node that is added
	 */
	private Node add ( Word d, Node n ) {
		if ( n == null ) {
			return new Node ( d );
		} else {
			if ( d.compareTo ( n.data ) == 0 ) { // if they're the same word
				n.data.increment ( ); // increment the freq
			} else if ( d.compareTo ( n.data ) < 0 ) { // if this then that
				n.left = add ( d, n.left ); // put this to the left
			} else { // if that then this
				n.right = add ( d, n.right ); // put this to the right
			}
			return n;
		}
	}
	
	/**
	 * facade fnction to print out the trees items in order
	 */
	public void printBST ( ) {
		if ( isEmpty ( ) ) {
			System.out.println ( "No items to print." );
		} else {
			System.out.print ( "\n" );
			printBST ( root );
			System.out.print ( "\n" );
		}
	}
	
	/**
	 * print out the current word and keep going until all nodes are printed
	 * @param n node to print out
	 */
	private void printBST ( Node n ) {
		if ( n.left != null ) {
			printBST ( n.left );
		}
		System.out.print ( n.data + "\n" );
		if ( n.right != null ) {
			printBST ( n.right );
		}
	}
	
	/**
	 * facade
	 * @param d word to check for
	 * @return the word and its frequency in the tree
	 */
	public Word getWord ( Word d ) {
		if ( root == null ) {
			return d;
		} else { 
			return getWord ( d, root );
		}
	}
	
	/**
	 * gets the word youre looking for
	 * @param d word to look for
	 * @param n nodes to look through
	 * @return the word and its frequency in the tree
	 */
	private Word getWord ( Word d, Node n ) {
		if ( d == n.data ) { // if the top node is the word youre searching
			return n.data;
		}
		if ( d.compareTo ( n.data ) == 0 ) { // if they're the same word
			return n.data; // return the word and the frequency
		} else if ( d.compareTo ( n.data ) < 0 ) { // if this then that
			if ( n.left == null ) { // if left is empty
				return d; // that means the word deosn't exist
			} else { 
				return getWord ( d, n.left ); 
			}
		} else { // if that then this
			if ( n.right == null ) {
				return d;
			} else { 
				return getWord ( d, n.right );
			}
		}
	}
		
	/**
	 * facade
	 * @param d word to check for
	 * @return the word and its frequency in the tree
	 */
	public boolean contains ( Word d ) {
		if ( root == null ) {
			return false;
		} else { 
			return contains ( d, root );
		}
	}
	
	/**
	 * gets the word youre looking for
	 * @param d word to look for
	 * @param n nodes to look through
	 * @return the word and its frequency in the tree
	 */
	private boolean contains ( Word d, Node n ) {
		if ( d.compareTo ( n.data ) == 0 ) { // if they're the same word
			return true; // return the word and the frequency
		} else if ( d.compareTo ( n.data ) < 0 ) { // if this then that
			if ( n.left == null ) { // if left is empty
				return false; // that means the word deosn't exist
			} else { 
				return contains ( d, n.left ); 
			}
		} else { // if that then this
			if ( n.right == null ) {
				return false;
			} else { 
				return contains ( d, n.right );
			}
		}
	}
}
