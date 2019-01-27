/**
 * @author joey pham
 * @date 28 November 2018
 * @desciption this represents a word string
 */

public class Word {
	/**
	 * represents a word
	 */
	private String word;
	
	/**
	 * represents the number of times this word appears 
	 */
	private int frequency;
	
	/**
	 * constructor
	 * @param w stirng to set the word to
	 * @return word that was added
	 */
	public Word ( String w ) {
		word = w;
		frequency = 1;
	}
	
	/**
	 * increase the frequency counter of the word
	 */
	public void increment ( ) {
		frequency = frequency + 1;
	}

	/**
	 * looks at two words and returns a number indicating what order the two words are in
	 * @param w word to compare to
	 * @return 0 if same word, - if this then that, + if that then this
	 */
	public int compareTo ( Word w ) {
		return ( this.word ).compareToIgnoreCase ( w.word );
	}
	
	/**
	 * prints out the word and its frequency
	 * @return string that contains the word and its freq
	 */
	public String toString ( ) {
		return word + " => " + frequency;
	}
	
	/**
	 * returns the string
	 * @return the string
	 */
	public String getWord ( ) {
		return word;
	}
}
