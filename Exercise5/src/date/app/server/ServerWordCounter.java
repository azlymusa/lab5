package date.app.server;


import java.util.StringTokenizer;

public class ServerWordCounter {

	
	/**
	 * This method count the number of words in a text
	 * @param text: Text to be process
	 * @return number of words
	 */
	public int countWord (String text) {
		
		// Tokenize text
		StringTokenizer tokenizer = new StringTokenizer (text, " ");
		
		return tokenizer.countTokens();
		
	}
}
