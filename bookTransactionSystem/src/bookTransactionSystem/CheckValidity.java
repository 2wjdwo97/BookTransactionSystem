package bookTransactionSystem;

import java.util.ArrayList;


public abstract class CheckValidity {
	/***Login***/
	public static void checkLogin_Input(String ID, char[] PW) throws Exception {
		if(ID.length() == 0)
			throw new Exception("Enter your ID.");
		if(PW.length == 0)
			throw new Exception("Enter your PW.");
	}

	public static void checkValidUser(boolean status) throws Exception {
		if(!status)
			throw new Exception("Deactivated User");
	}
	/***Login***/
	
	/***User Registration***/
	public static void checkRegistration_Input(ArrayList<User> userList, String ID, char[] PW, String name, String phoneNumber,String emailAddress) throws Exception {
		checkRegistration_ID(ID, userList);
		checkRegistration_PW(PW);
		checkRegistration_Name(name);
		checkRegistration_PhoneNumber(phoneNumber);
		checkRegistration_Email(emailAddress);
	}
	
	public static boolean checkRegistration_ID(String ID, ArrayList<User> userList) throws Exception {
		for(User user:userList) {
			if(ID.equals(user.getID()))
				throw new Exception("Current ID has already been registered.");
		}
		if(ID.length() < 1 || ID.length() > 10)
			throw new Exception("Length of ID: 1 to 10");
		return true;
	}

	private static void checkRegistration_PW(char[] PW) throws Exception {
		if(PW.length < 5 || PW.length > 12)
			throw new Exception("Length of PW: 5 to 12");
	}
	private static void checkRegistration_Name(String name) throws Exception {
		if(name.length() < 1)
			throw new Exception("Incorrect Form: Name");
	}
	private static void checkRegistration_PhoneNumber(String phoneNumber) throws Exception {
		if(phoneNumber.length() != 11 || !phoneNumber.substring(0, 3).equals("010"))
			throw new Exception("Incorrect Form: Phone Number");
		Integer.parseInt(phoneNumber);
	}
	private static void checkRegistration_Email(String emailAddress) throws Exception {
		;
	}
	/***User Registration***/

	/***Book Registration***/
	public static void checkBookRegistration_Input(Metadata metadata, String price, String quality) throws Exception {
		checkBookRegistration_Metadata(metadata);
		checkBookRegistration_Price(price);
	}
	
	private static void checkBookRegistration_Metadata(Metadata metadata) throws Exception{
		if(metadata.getTitle() == null)
			throw new Exception("Select your book.");		
	}
	private static void checkBookRegistration_Price(String price) throws Exception{
		if(Integer.parseInt(price) < 0)
			throw new Exception("Incorrect Form: price.");		
	}	
	/***Book Registration***/

	/***Book Modification***/
	public static void checkBookModification_Input(String price, String quality) throws Exception {
		checkBookRegistration_Price(price);
	}
	/***Book Modification***/
	
}

