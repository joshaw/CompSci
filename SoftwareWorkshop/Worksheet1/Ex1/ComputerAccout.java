/** Defines the class ComputerAccout for holding info about a computer account
 *
 * @author Josh Wainwright
 * @version 2013-10-11
 */
public class ComputerAccout {
	private String realName, userName, password;

	/** A simple class to hold info about a computer account
	 *
	 * @param realName is the real name of the account holder
	 * @param userName is the username of the account holder
	 * @param password is the password associated with the account
	 */
	public ComputerAccout(String realName, String userName, String password){
		this.realName = realName;
		this.userName = userName;
		this.password = password;
	}

	/**
	 * @return the real name of the account holder
	 */
	public void printRealName(){
		System.out.println("Name: " + realName);
	}

	/**
	 * @return the user name of the account holder
	 */
	public void printUserName(){
		System.out.println("Name: " + userName);
	}

	/**
	 * @return the password associated with the accound
	 */
	public void printPassword(){
		System.out.println("Password: " + password);
	}

	/** toString defines how to print a computer account
	 *
	 * @return the print type of an account
	 */
	@Override
	public String toString() {
		return "realName: " + realName + "\nuserName: " + userName + "\npassword: " + password;
	}

	/** changePassword allows the stored password associated with an account to
	 * be changed.
	 *
	 * @param newPassword is the new password that will be associated with the
	 * account
	 */
	public void changePassword(String newPassword){
		password = newPassword;
		System.out.println("Password has been changed");
	}

}
