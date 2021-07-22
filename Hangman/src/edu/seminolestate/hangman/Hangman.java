package edu.seminolestate.hangman;
//Bijan Amirzadehasl 06/17/2021
public class Hangman {
	
	//variables organized
	private static final int NUMBER_WRONG_GUESSES_ALLOWED = 7;
	private final String[] dictionary = {
			"trouble", "copyright", "problem", "form", "problem", "mythical", "discover",
			"consume", "document", "flame", "flow", "chart", "magnetic", "working",
			"predict", "subordinate", "making", "copy"
	};
	private String mysteryWord;
	private StringBuilder mysteryWordWithDashes; 
	private int numberOfIncorrectGuesses;
	private int numberOfCorrectGuesses;
	private char[] incorrectLettersGuessed;
	
	//constructor
	public Hangman(){
		int dictionaryIndex = 0;
		this.incorrectLettersGuessed = new char[NUMBER_WRONG_GUESSES_ALLOWED]; 
		dictionaryIndex = (int) (Math.random() * dictionary.length); 
		mysteryWord = new String(dictionary[dictionaryIndex]);
		
		mysteryWordWithDashes = new StringBuilder();
		for (int ctr = 0; ctr < mysteryWord.length(); ctr++){
			mysteryWordWithDashes.append("-");
		}
	}
	
	public boolean isCorrectLetter(char guessedLetter){
		String strGuessedLetter = new String(String.valueOf(guessedLetter));
		int letterLocation = 0;
		strGuessedLetter = strGuessedLetter.toLowerCase(); 
		letterLocation = mysteryWord.indexOf(strGuessedLetter);
		if  (letterLocation >= 0){ 
			
			if (mysteryWordWithDashes.indexOf(strGuessedLetter) < 0){
				numberOfCorrectGuesses++;
			}
			
			mysteryWordWithDashes.replace(letterLocation, letterLocation + 1, strGuessedLetter);
			return true;
		} else {
			incorrectLettersGuessed[numberOfIncorrectGuesses] = guessedLetter;
			numberOfIncorrectGuesses++;
			return false;
		}		
	}
	

	public boolean isCorrectWord(String theWord){
		if (theWord.equalsIgnoreCase(this.mysteryWord)){
		
			numberOfCorrectGuesses = mysteryWord.length();
			mysteryWordWithDashes = new StringBuilder(mysteryWord);
			return true;
		} else {
			return false;
		}
	}
	public String getMysteryWord(){
		return this.mysteryWord;
	}
	public String getMysteryWordWithDashes() {
		return mysteryWordWithDashes.toString();
	}
	public String getIncorrectLetters(){
		return new String(incorrectLettersGuessed);
	}
	
	public int getNumberofGuessesLeft(){
		return NUMBER_WRONG_GUESSES_ALLOWED - this.numberOfIncorrectGuesses;
	}
	
	
	public boolean isWinner(){
		
		if (mysteryWord.equals(mysteryWordWithDashes.toString())){
			return true;
		} else {
			return false;
		}		
	}
}
