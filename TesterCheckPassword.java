
public class TesterCheckPassword {

	public static void main(String[] args) {
		CheckPassword psswd = new CheckPassword("123!defghijklmnoPQR");
		boolean result = psswd.checkLenght();
		if (result == true) {
			System.out.println("lenght true");
		} else {
			System.out.println("lenght false");
		}

		boolean resultSpecial = psswd.checkSpecialCharacter();
		if (resultSpecial == true) {
			System.out.println("SpecialC true");
		} else {
			System.out.println("SpecialC false");
		}
		
		boolean resultUpper = psswd.checkUpperCase();
		if (resultUpper == true) {
			System.out.println("Upper true");
		} else {
			System.out.println("Upper false");
		}
		
		boolean resultNumber = psswd.checkNumber();
		if (resultNumber == true) {
			System.out.println("Number true");
		} else {
			System.out.println("Number false");
		}
	}

}
