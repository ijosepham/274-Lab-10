import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab10 {
	public static void main ( String [ ] args ) {
		BST tree = readFile ( );
		int menuChoice = getMenuChoice ( );
		while ( menuChoice != 3 ) {
			if ( menuChoice == 1 ) {
				displayList ( tree );
			} else {
				Word searchee = getSearchWord ( );
				search ( searchee );
			}
			menuChoice = getMenuChoice ( );
		}
		System.out.print ( "\n" + "Goodbye!" );
	}
	
	public static BST readFile ( ) {
		BST tree = new BST ( );
		try {
			Scanner read = new Scanner ( new File ( "words.txt" ) );
			do {
				Word word = new Word ( read.nextLine ( ) ); 
				tree.add ( word );
				// add the new contact with values to set to to the LinkedList
			} while ( read.hasNextLine ( ) ); // as long as there is another line to read in
		} catch ( FileNotFoundException fnf ) {
			System.out.print ( "File was not found." );
		}
		return tree;
	}
	
	public static int getMenuChoice ( ) {
		System.out.print ( "Menu" );
		System.out.print ( "\n" + "1. Display List" );
		System.out.print ( "\n" + "2. Search" );
		System.out.print ( "\n" + "3. Exit" );
		System.out.print ( "\n" + "Enter an option: " );
		int menuChoice = CheckInput.getIntRange ( 1, 3 );
		return menuChoice;
	}
	
	public static void displayList ( BST tree ) {
		tree.printBST ( );
	}
	
	public static Word getSearchWord ( ) {
		System.out.print ( "Enter the word you are searching for: ");
		Word searchee = new Word ( CheckInput.getString ( ) );
		return searchee;
	}
	
	public static void search ( Word searchee ) {
		System.out.print ( "\n" + searchee.toString ( ) + "\n" + "\n");
	}
}
