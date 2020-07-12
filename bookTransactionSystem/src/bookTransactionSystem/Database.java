package bookTransactionSystem;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.Arrays;

public class Database {
	private Login_Info login_info;
	private Book focusBook;
	private ArrayList<User> userList;
	private ArrayList<Book> bookList;
	private ArrayList<Metadata> metadataList;
	
	Database(PropertyChangeSupport pcs){
		userList = new ArrayList<User>();
		bookList = new ArrayList<Book>();
		metadataList = new ArrayList<Metadata>();
		login_info = new Login_Info(pcs);
	}
	
	public ArrayList<User> getUserList() {
		return userList;
	}
	public ArrayList<Book> getBookList() {
		return bookList;
	}
	public ArrayList<Metadata> getMetadataList(){
		return metadataList;
	}
	public Book getFocusBook() {
		return focusBook;
	}
	public Login_Info getLoginInfo() {
		return login_info;
	}
	
	public void setFocusBook(Book focusBook) {
		this.focusBook = focusBook;
	}
	
	public void insertLoginInfo(User user) {
		login_info.insertLoginUser(user);
	}
	public void insertLoginInfo() {
		login_info.deleteLoginUser();
	}
	
	public void insertUser(User user) {
		userList.add(user);
	}
	public void insertBook(Book book) {
		bookList.add(book);
	}
	public void insertMetadata(Metadata metadata) {
		metadataList.add(metadata);
	}
	
	public void deleteBook(Book book) {
		bookList.remove(book);
		book.getUser().getBookList().remove(book);
	}
	public void deleteUser(User user) {
		userList.remove(user);
	}
	
	
	public ArrayList<Book> searchBook_Author(String author){
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		for(Book book : this.bookList)
			if(book.getMetadata().getAuthor().contains(author) && book.getStatus()
					&& (book.getUser().getStatus() || login_info.getIsAdmin()))
				bookList.add(book);
		
		return bookList;
	}
	public ArrayList<Book> searchBook_ISBN(String ISBN){
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		for(Book book : this.bookList)
			if(book.getMetadata().getISBN().contains(ISBN) && book.getStatus() 
					&& (book.getUser().getStatus() || login_info.getIsAdmin()))
				bookList.add(book);
		
		return bookList;
	}
	
	public ArrayList<Book> searchBook_SellerID(String ID){
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		for(Book book : this.bookList)
			if(book.getUser().getID().contains(ID) && book.getStatus() 
					&& (book.getUser().getStatus() || login_info.getIsAdmin()))
				bookList.add(book);
		
		return bookList;
	}
	public ArrayList<Book> searchBook_Title(String title){
		ArrayList<Book> bookList = new ArrayList<Book>();
		
		for(Book book : this.bookList) {
			if(book.getMetadata().getTitle().contains(title) && book.getStatus() 
					&& (book.getUser().getStatus() || login_info.getIsAdmin()))
				bookList.add(book);
		}
		return bookList;
	}	
	public ArrayList<Metadata> searchMetadata_ISBN(String ISBN) {
		ArrayList<Metadata> metadataList = new ArrayList<Metadata>();
		for(Metadata metadata : this.metadataList) {
			if(metadata.getISBN().contains(ISBN)) {
				metadataList.add(metadata);
			}
		}
		return metadataList;
	}
	public ArrayList<Metadata> searchMetadata_Title(String Title) {
		ArrayList<Metadata> metadataList = new ArrayList<Metadata>();
		for(Metadata metadata : this.metadataList) {
			if(metadata.getTitle().contains(Title)) {
				metadataList.add(metadata);
			}
		}
		return metadataList;
	}
	public User searchUser(String ID) throws Exception{
		for(User user : userList)
			if(ID.equals(user.getID()))
				return user;
		throw new Exception("No user data found.");
	}
	public User searchUser(String ID, char[] PW) throws Exception {
		for(User user : userList)
			if(ID.equals(user.getID()) && Arrays.equals(PW,user.getPW()))				
				return user;
		throw new Exception("No user data found.");
	}
}
