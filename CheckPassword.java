
public class CheckPassword implements PasswordChecker {
	String password;
	int score;
	boolean resultLenght, resultSpecial, resultUpper, resultNumber;
	String specialCharactersString = "!@#$%&*()'+,-./:;<=>?[]^_`{|}";

	/*
	 * constructor
	 */
	public CheckPassword(String password) {
		this.password = password;
		score = 0;
	}

	/*
	 * method to check the length
	 */
	public boolean checkLenght() {
		// check if the length of the string is at least 12
		if (password.length() >= 12) {
			// add the length to the score
			score += password.length();
			// set resultLenght to true
			resultLenght = true;
		} else {
			resultLenght = false;
		}
		return resultLenght;
	}

	/*
	 * Method to check if there is a special character
	 */
	public boolean checkSpecialCharacter() {
		for (int i = 0; i < password.length(); i++) {
	        if (password.matches("(?=.*[!@#$%^&*()]).*")){
	            score++;
				resultSpecial = true;
			} else {
				resultSpecial = false;
			}
			}
		return resultSpecial;
		}

	/*
	 * method to check if there is at least a number.
	 */
	public boolean checkNumber() {
		for (int i = 0; i < password.length(); i++) {
            if (password.matches("(?=.*[1-9]).*")){
	            score++;
	            resultNumber = true;
			} else {
				resultNumber = false;
			}
			}
		return resultNumber;
		}


	/*
	 * method to check if there is at least an upper case character
	 */
	public boolean checkUpperCase() {
		for (int i = 0; i < password.length(); i++) {
            if (password.matches("(?=.*[A-Z]).*")){
	            score++;
	            resultUpper = true;
			} else {
				resultUpper = false;
			}
			}
		return resultUpper;
		}
}
