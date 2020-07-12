package bookTransactionSystem;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String emailAddress;
	private String ID;
	private String name;
	private String phoneNumber;
	private char[] PW;
	private boolean status;
	
	private ArrayList<Book> bookList;
	
	User(String ID, char[] PW, String name, String phoneNumber, String emailAddress){
		this.ID = ID;
		this.PW = PW;
		this.name = name;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		bookList = new ArrayList<Book>();
		status = true;
	}
	public void insertBook(Book newBook) {
		bookList.add(newBook);
	}
	public String getID() {
		return ID;
	}
	public char[] getPW () {
		return PW;
	}
	public String getName() {
		return name;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public boolean getStatus() {
		return status;
	}
	
	public ArrayList<Book> getBookList() {
		return bookList;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
}
