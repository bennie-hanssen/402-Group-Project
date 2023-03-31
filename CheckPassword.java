
public class CheckPassword implements PasswordChecker {
	String password;
	int score;
	boolean resultLenght, resultSpecial;
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
	 * method to check if there is a special character
	 */
	public boolean checkSpecialCharacter() {
		if (password.matches("[^a-z A-Z 0-9]")) {
			resultSpecial = true;
			score += 1; // add to the score

		} else {
			resultSpecial = false;
		}

		return resultSpecial;
	}

	@Override
	public boolean checkUpperCase() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkNumber() {
		// TODO Auto-generated method stub
		return false;
	}
}
