import java.util.Scanner;

public class UI {
	
	private Engine GE = null; 
	
	// int value 'i' is written as shiftValue
	private static Boolean endProgram = false;
	private static String phrase;
	private static int shiftValue;
	private static String cyberText;
	private static Scanner sc;
	
	
	public UI(Engine game) {
		GE = game;
		sc = new Scanner(System.in);
	}
	
	// This method runs the program in a while loop.
	public void start() {
		
		while (!endProgram){
			sc = new Scanner(System.in);
			setPhrase();
			setI();
			cyberText = GE.caesarCipher(shiftValue, phrase, true);
			System.out.println(cyberText);
			System.out.println(GE.caesarCipher(shiftValue, cyberText, false));
			
		}
		sc.close();
	}
	
	
	/* Assumes no numbers are entered. If nothing is entered, the while loop in the start method
	will break and the endMessage will print. */ 
	public static void setPhrase() {
		
		System.out.printf( "To exit program press enter without entering a phrase\n" + 
				"Input a lowercase word or sentence: ");
		
		phrase = sc.nextLine();

		if(phrase.isEmpty()) {
			endProgram = true;
			endMessage();
		}
		
	}

	/* Assumes a number is entered. The number must be 0 or greater.
	 *If a number greater than 25 is entered (the number of letters in the 
	 *alphabet), then '%' is used to determine the value of 'i'
	 */ 
	public static void setI() {
		System.out.print("Enter a positive value for Caesar Cipher: ");
		shiftValue = sc.nextInt();
		while (shiftValue < 0){
			System.out.print("Must enter a positive number: ");
			shiftValue = sc.nextInt();
		}
		
		if (shiftValue > 25){
			shiftValue = shiftValue%26; 
		}

	}

	// prints right before quitting the program
	public static void endMessage() {
		System.out.println("Program has ended");
		System.exit(0);
	}
}
