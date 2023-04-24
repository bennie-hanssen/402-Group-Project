import java.util.stream.IntStream;

/**
 * Password checker class
 * 
 * @version Apr 22, 2023
 * 
 */

public class CheckPassword implements PasswordChecker {
	private String password, specialCharactersString, numberRange, alphabetString;
	private char[] passwordArray, specialCharArray, upperArray, lowerArray, numbersArray;
	private int score, lenght, counter;
	private final int MINLENGHT = 12;
	private boolean resultLenght, resultSpecial, resultUpper, resultLower, resultNumber, resultEmptySpace;

	/**
	 * Constructor for CheckPassword
	 * 
	 * @param String password
	 * 
	 */
	public CheckPassword(String password) {
		this.password = password;
		passwordArray = password.toCharArray();
		score = 0;
		lenght = password.length();
		specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";
		numberRange = "0123456789";
		alphabetString = "abcdefghijklmnopqrstuvwxyz";
	}

	/**
	 * Method to check the length.
	 * 
	 * @return true if the length is at least 12
	 * 
	 */

	public boolean checkLenght() {
		// check if the length of the string is 12 or 13 and add 1 to the score
		if (lenght >= MINLENGHT && lenght < 14) {
			resultLenght = true;
			score += 1;
		}
		// check if the length of the string is 14 or 15 and add 2 to the score
		else if (lenght >= 14 && lenght < 16) {
			resultLenght = true;
			score += 2;
		}
		// check if the length of the string is more than 16 and add 3 to the score
		else if (lenght >= 16) {
			resultLenght = true;
			score += 3;
		}
		// if none of those are true, set resultLenght as false
		else {
			resultLenght = false;
		}
		return resultLenght;
	}

	/**
	 * Method to check if there is a special character.
	 * 
	 * @return true if there is a special character
	 * 
	 */
	// A: Make char array then iterate through each index and see if the character
	// is in the password using password.contains(char)
	public boolean checkSpecialCharacter() {
		specialCharArray = specialCharactersString.toCharArray();

		for (int i = 0; i < lenght; i++) {
			for (int y = 0; y < specialCharactersString.length(); y++) {
				if (specialCharArray[y] == passwordArray[i]) {
					counter++;
				}
			}
		}
		if (counter > 0) {
			if (counter > 2) {
				score += 2;
				resultSpecial = true;
			} else {
				score++;
				resultSpecial = true;
			}
		} else {
			resultSpecial = false;
			score--;
		}
		counter = 0;
		return resultSpecial;
	}

	/**
	 * Method to check if there is at least a number.
	 * 
	 * @return true if there is a number
	 */
	public boolean checkNumber() {
		numbersArray = numberRange.toCharArray();

		for (int i = 0; i < (lenght); i++) {
			for (int y = 0; y < numbersArray.length; y++) {
				if (numbersArray[y] == passwordArray[i]) {
					counter++;
				}
			}
		}
		if (counter > 0) {
			if (counter > 2) {
				score += 2;
				resultNumber = true;
			} else {
				score++;
				resultNumber = true;
			}
		} else {
			resultNumber = false;
			score--;
		}
		counter = 0;
		return resultNumber;
	}

	/**
	 * Method to check if the string has an empty space or is empty
	 * 
	 * @return true if there is an empty space
	 * 
	 */
	public boolean checkEmptySpace() {
		boolean emptyString = password.isBlank();
		boolean containsEmptySpace = password.contains(" ");
		for (int i = 0; i < password.length(); i++) {
			if (emptyString == true || containsEmptySpace == true) {
				counter++;
			}
		}
		if (counter > 0) {
			score--;
			resultEmptySpace = true;
		}
		if (counter > 2) {
			score -= 2;
			resultEmptySpace = true;
		} else {
			resultEmptySpace = false;
			score++;
		}

		counter = 0;
		return resultEmptySpace;
	}

	/**
	 * Method to check if there is at least an upper case character.
	 * 
	 * @return true when there is an upper case character
	 * 
	 */
	public boolean checkUpperCase() {
		upperArray = alphabetString.toUpperCase().toCharArray();

		for (int i = 0; i < lenght; i++) {
			for (int y = 0; y < upperArray.length; y++) {
				if (upperArray[y] == passwordArray[i]) {
					counter++;
				}
			}
		}
		if (counter > 0) {
			if (counter > 2) {
				score += 2;
				resultUpper = true;
			} else {
				score++;
				resultUpper = true;
			}
		} else {
			resultUpper = false;
			score--;
		}
		counter = 0;
		return resultUpper;
	}

	/**
	 * Method to check if there is at least a lower case character.
	 * 
	 * @return true when there is a lower case character
	 * 
	 */
	public boolean checkLowerCase() {
		lowerArray = alphabetString.toCharArray();

		for (int i = 0; i < lenght; i++) {
			for (int y = 0; y < lowerArray.length; y++) {
				if (lowerArray[y] == passwordArray[i]) {
					counter++;
				}
			}
		}
		if (counter > 0) {
			if (counter > 2) {
				score += 2;
				resultLower = true;
			} else {
				score++;
				resultLower = true;
			}
		} else {
			resultUpper = false;
			score--;
		}
		counter = 0;
		return resultLower;
	}

	/**
	 * 
	 * @return int score
	 * 
	 */
	public int getScore() {
		return score;
	}
}
