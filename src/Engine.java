import java.io.Serializable;

public class Engine implements Serializable {

	/* The engine contains a method to either turn the original text into ciphered text, or 
	 * to turn the ciphered text into the original text. The method does this by taking the 
	 * String passed through it, and turning it into a character array called 'word'.
	 * Then each letter in the array is compared to the alphabet String. 
	 * Once the same letter is found in the alphabet String, the letter in word is replaced with the char
	 * in the alphabet String that shifts 'i' positions to the left or right, depending on what String will be
	 * returned. For a ' ', the char is not replaced with anything.
	 * In order not to hit an error if the new char goes past the letter z in the alphabet String, '%' is used. 
	 */
	private static final long serialVersionUID = -4699178650373192374L;
	
	private static char[] word;
	private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";

	/* The integer that is passed, is the shift Value for the Caesar cipher. 
	 * The String that is passed, is the word or phrase that is being manipulated
	 * The Boolean that is passed, determines whether to turn the ciphered text to the original
	 * phrase, or to turn the original phrase into cipher text.
	 * @return will return either the ciphered text or the original text.
	 */
	public String caesarCipher(int c, String s, boolean ciphertext) {
		char current;
		char replace = 0;
		word = s.toCharArray();
		
		for (int i = 0; i < s.length(); i++){
			current = word[i];
			
			if (current == ' ') {
				word[i] = ' ';
			}
			else {
				if (ciphertext){
					for (int j = 0; j < alphabet.length(); j++){
						if (alphabet.charAt(j) == current){
							replace = alphabet.charAt((j + c)%26);
						}
						word[i] = replace;
					}	
				}
				else if (!ciphertext){
					for (int j = 0; j < alphabet.length(); j++){
						if (alphabet.charAt(j) == current){
							replace = alphabet.charAt((j + (26-c))%26);
						}
						word[i] = replace;
					}	
				}
			}
		}
		return new String(word); 
	}
}
