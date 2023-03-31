
public class TesterCheckPassword {

	public static void main(String[] args) {
		CheckPassword psswd = new CheckPassword("abcdefghijklmno");
		boolean result = psswd.checkLenght();
		if (result == true) {
			System.out.println("lenght true");
		} else {
			System.out.println("lenght false");
		}

		boolean resultSpeacial = psswd.checkSpecialCharacter();
		if (resultSpeacial == true) {
			System.out.println("SpecialC true");
		} else {
			System.out.println("SpecialC false");
		}
	}

}
