package edu.seminolestate.hangman;
//Bijan Amirzadehasl 06/17/2021
import java.util.Scanner;

public class HangmanApplication {
	private static final int GUESS_LETTER = 1;
	private static final int GUESS_WORD = 2;
	private static final int QUIT = 3;
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {

		Hangman game = new Hangman();
		int response = 0;
		System.out.println("Mystery word: " + game.getMysteryWordWithDashes());
		do {
			
			response = getUserChoice();
			switch (response) {
			case GUESS_LETTER:  
				System.out.println("Enter a letter: ");
				char letterGuessed = scanner.nextLine().charAt(0); 
				System.out.println("\n");
	
				if (game.isCorrectLetter(letterGuessed)) { 
					if (game.isWinner()){  
						game = newGame("You win! The word was " + game.getMysteryWord(), game);
					}else {  
						processGuess("That letter is in the word", game);
					}
				} else {   
					if (game.getNumberofGuessesLeft() > 0){  
						processGuess("Sorry, that letter is not in the word.", game);
					} else { 
						game = newGame("You lose! The word was " + game.getMysteryWord(), game);
					}
				}
				break;
			case GUESS_WORD:   
				
				System.out.println("Enter the word: ");
				String wordGuessed = scanner.nextLine();  
				if (game.isCorrectWord(wordGuessed)) { 
					game = newGame("You win!!", game);
				} else { 
					processGuess("That is not the correct word!!", game);
				}
				break;
			case QUIT: 
				System.out.println("Thank you for playing Hangman!");
				scanner.close();
				break;
			}
		} while (response != QUIT);
	}
	
	public static Hangman newGame(String messageToPlayer, Hangman game){
		game = new Hangman();
		System.out.println(messageToPlayer);
		System.out.println("New mystery word: " + game.getMysteryWordWithDashes());
		return game;
	}
	
	public static void processGuess(String messageToPlayer, Hangman game){
		System.out.println(messageToPlayer);
		System.out.println("You have " + game.getNumberofGuessesLeft() + " guess(es) left");
		System.out.println("Letters used: " + game.getIncorrectLetters());
		System.out.println("Mystery word: " + game.getMysteryWordWithDashes());
	}
	
	
	public static int getUserChoice(){
		System.out.println("Choose an option.");
		System.out.println(GUESS_LETTER + ". Guess a letter");
		System.out.println(GUESS_WORD + ". Guess the word");
		System.out.println(QUIT + ". Quit");
		return Integer.parseInt(scanner.nextLine());
	}
}
