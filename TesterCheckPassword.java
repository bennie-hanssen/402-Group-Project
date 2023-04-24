/**
 * Creates output strings using PasswordChecker methods
 * 
 * 
 * @version Apr 24, 2023
 */
public class TesterCheckPassword {

	
public String TesterCheckPassword(String pssword) {
		CheckPassword psswd = new CheckPassword(pssword); // variable that contains the password typed in GUI

		boolean validity; // variable that will be used to declare if the password is valid or not

		/*
		 * Use the methods from CheckPassword and assign the return value to its
		 * respective local variable
		 */
		boolean resultLenght = psswd.checkLenght();
		boolean resultSpecial = psswd.checkSpecialCharacter();
		boolean resultUpper = psswd.checkUpperCase();
		boolean resultLower = psswd.checkLowerCase();
		boolean resultNumber = psswd.checkNumber();
		boolean resultEmpty = psswd.checkEmptySpace();

		int score = psswd.getScore(); // variable for the total score

		/*
		 * empty string that will say if the password is valid. If not valid, it will
		 * say why.
		 */
		String outputValid = "";

		// check if all the parameters are respected
		if (resultLenght == true && resultSpecial == true && resultUpper == true && resultLower == true
				&& resultNumber == true && resultEmpty == false) {
			outputValid = "Congrats! Your password is valid!";
			validity = true;
		}
		// else set the string to invalid
		else {
			outputValid = "Oh no! Invalid password:\n";
			validity = false;
			if (resultLenght == false) { // check if the length requirement is respected
				outputValid += "	- less than 12 characters\n";
			}
			if (resultSpecial == false) { // check if the special character requirement is respected
				outputValid += "	- no special character(s)\n";
			}
			if (resultUpper == false) { // check if the upper case character requirement is respected
				outputValid += "	- no upper case character(s)\n";
			}
			if (resultLower == false) { // check if the lower case character requirement is respected
				outputValid += "	- no lower case character(s)\n";
			}
			if (resultNumber == false) { // check if the number requirement is respected
				outputValid += "	- no number(s)\n";
			}
			if (resultEmpty == true) { // check if there is an empty space or the string is blank
				outputValid += "	- the password has empty spaces or is empty\n";
			}
		}
		System.out.println(outputValid);

		/*
		 * Output string for the strength of the password and score
		 */
		String outputStrenght = "\nStrenght: ";

		// If password is not valid, it will have poor strength
		if (validity == false) {
			outputStrenght += "poor";
		}

		// If password is valid, the strength will depend on its score
		else {
			if (score == 7) {
				outputStrenght += "fair";
			} else if (score > 7 && score <= 9) {
				outputStrenght += "good";
			} else {
				outputStrenght += "very good";
			}
			outputStrenght += "\nscore: " + score;
		}
		return outputStrenght; // returns text specifying strength of password
		// System.out.println(outputStrenght);
}	
}
