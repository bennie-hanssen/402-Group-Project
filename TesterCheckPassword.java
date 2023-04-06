
public class TesterCheckPassword {

	public static void main(String[] args) {
		
		
		CheckPassword psswd = new CheckPassword("klmnoPQR");
		boolean resultLenght = psswd.checkLenght();
		boolean resultSpecial = psswd.checkSpecialCharacter();
		boolean resultUpper = psswd.checkUpperCase();
		boolean resultNumber = psswd.checkNumber();
		
		String output = "";

		
		if (resultLenght == true && resultSpecial == true 
					&& resultUpper == true && resultNumber == true) {
			output = "Congrats! Your poassword is valid!";
		}
		else {
			output = "Oh no! Invalid password:\n";
			if (resultLenght == false) {
				output += "	- less than 12 characters\n";
			}
			if (resultSpecial == false) {
				output += "	- no special character(s)\n";
			}
			if (resultUpper == false) {
				output += "	- no upper case character(s)\n";
			}
			if (resultNumber == false) {
				output += "	- no number(s)\n";
			}
		}
		
		System.out.println(output);
	}
}