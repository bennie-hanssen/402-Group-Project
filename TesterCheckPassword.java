/**
 * Creates output strings using PasswordChecker methods
 * 
 * 
 *@version Apr 8, 2023
 */
public class TesterCheckPassword {

	public static void main(String[] args) {
		

		CheckPassword psswd = new CheckPassword("kbcgedfhgtj5!");	
		boolean resultLenght = psswd.checkLenght();
		boolean resultSpecial = psswd.checkSpecialCharacter();
		boolean resultUpper = psswd.checkUpperCase();
		boolean resultNumber = psswd.checkNumber();
		boolean resultEmpty = psswd.checkEmptySpace();
		int score = psswd.getScore();

		
		String outputValid = "";
		//check if all the parameters are respected
		if (resultLenght == true && resultSpecial == true 
					&& resultUpper == true && resultNumber == true && resultEmpty == false) {
			outputValid = "Congrats! Your password is valid!";
		}
		else {
			//else set the string to invalid
			outputValid = "Oh no! Invalid password:\n";
			if (resultLenght == false) {	//check if the length requirement is respected
				outputValid += "	- less than 12 characters\n";
			}
			if (resultSpecial == false) {	//check if the special character requirement is respected
				outputValid += "	- no special character(s)\n";
			}
			if (resultUpper == false) {		//check if the upper case character requirement is respected
				outputValid += "	- no upper case character(s)\n";
			}
			if (resultNumber == false) {		//check if the number requirement is respected
				outputValid += "	- no number(s)\n";
			}
			if (resultEmpty == true) {		//check if there is an empty space or the string is blank
				outputValid += "	- the password has empty spaces or is empty\n";
			}
		}
		System.out.println(outputValid);
		
		/*
		 * Output string for the strenght of the password and score
		 */
		String outputStrenght = "\nStrenght: ";

		if (score < 4) {
			outputStrenght += "poor";
		}
		else if (score == 4) {
			outputStrenght += "fair";
		}
		else if (score > 4 && score <= 6 ) {
			outputStrenght += "good";
		}
		else {
			outputStrenght += "very good";
		}
		outputStrenght += "\nscore: " + score;
		System.out.println(outputStrenght);
	}
}