/**
 * Interface for the passwordChecker
 */

public interface PasswordChecker {
	// abstract methods
	public boolean checkLenght();

	public boolean checkSpecialCharacter();

	public boolean checkUpperCase();

	public boolean checkNumber();
}
