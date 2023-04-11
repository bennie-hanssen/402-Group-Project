/**
 * Password checker class
 * 
 * @version Apr 8, 2023
 * 
 */

public class CheckPassword implements PasswordChecker {
	String password;
	int score, baseLenght;
	boolean resultLenght, resultSpecial, resultUpper, resultNumber, resultEmptySpace;
//	String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";

	/**
	 * Constructor for CheckPassword
	 * 
	 * @param
	 * String password
	 * 
	 */
	public CheckPassword(String password) {
		this.password = password;
		score = 0;
		baseLenght = 12; //A: Make this a constant
	}

	/**
	 * Method to check the length.
	 * 
	 * @return
	 * true if the length is at least 12
	 * 
	 */
	//A: Should have 3 thresholds instead, that award a point each
	//Just 3 ifs in a row for 12, 14 and 16 character length
	public boolean checkLenght() {
		// check if the length of the string is at least 12
		if (password.length() >= 12) {
			// add the length to the score
			score += password.length()- baseLenght ;
			// set resultLenght to true
			resultLenght = true;
		}
		else {
			resultLenght = false;
		}
		return resultLenght;
	}

	/**
	 * Method to check if there is a special character.
	 * 
	 * @return
	 * true if there is a special character
	 * 
	 */
	//A: Make char array then iterate through each index and see if the character
	//is in the password using password.contains(char)
	public boolean checkSpecialCharacter() {
		for (int i = 0; i < password.length(); i++) {
	        if (password.matches("(?=.*[!@#$%^&*()]).*")){
				resultSpecial = true;
			} else {
				resultSpecial = false;
			}
		}
		score++;
		return resultSpecial;
	}

	/**
	 * Method to check if there is at least a number.
	 * 
	 * @return
	 * true if there is a number
	 */
	//A: Same as special char note but as an int instead of char
	public boolean checkNumber() {
		for (int i = 0; i < password.length(); i++) {
            if (password.matches("(?=.*[0-9]).*")){
	            resultNumber = true;
			} else {
				resultNumber = false;
			}
		}
		score++; //In the if
		return resultNumber;
	}
	
	/**
	 * Method to check if the string has at least an empty space or is empty
	 * 
	 * @return 
	 * true if there is an empty space
	 * 
	 */
	public boolean checkEmptySpace() {
		boolean emptyString = password.isBlank();
		boolean containsEmptySpace = password.contains(" ");
		for (int i = 0; i < password.length(); i++) {
            if (emptyString == true  || containsEmptySpace == true){
	            resultEmptySpace = true;
	    		score --;

			} else {
				resultEmptySpace = false;
			}
		}
		return resultEmptySpace;
	}


	/**
	 * Method to check if there is at least an upper case character.
	 * 
	 * @return
	 * true when there is an upper case character
	 * 
	 */
	public boolean checkUpperCase() {
		for (int i = 0; i < password.length(); i++) {
            if (password.matches("(?=.*[A-Z]).*")){
	            resultUpper = true;
			} else {
				resultUpper = false;
			}
			}
		score++;
		return resultUpper;
		}
	
	/**
	 * 
	 * @return
	 * int score
	 * 
	 */
	public int getScore() {
		return score;
	}
}
