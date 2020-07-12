package bookTransactionSystem;

import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class DatabaseManager {
	private Database DB;
	private PropertyChangeSupport pcs;
	
	DatabaseManager(PropertyChangeSupport pcs){
		this.pcs = pcs;
		DB = new Database(pcs);
		loadData();
	}
	public ArrayList<User> getUserList(){
		return DB.getUserList();
	}
	public ArrayList<Book> getBookList(){
		return DB.getBookList();
	}
	public ArrayList<Metadata> getMetadataList(){
		return DB.getMetadataList();
	}
	public void createBook() {
		Book focusBook = new Book();
		setFocusBook(focusBook);
	}
	public void setFocusBook(Book focusBook) {
		DB.setFocusBook(focusBook);
		pcs.firePropertyChange("focusBook", null, focusBook);
	}
	
	public void setLogin_info(User user) {
		DB.insertLoginInfo(user);
	}
	public void setLogin_info() {
		DB.insertLoginInfo();
	}
	public Login_Info getLoginInfo() {
		return DB.getLoginInfo();
	}
	
	public void attachMetadata(Metadata metadata) {
		Book focusBook = DB.getFocusBook();
		focusBook.setMetadata(metadata);
		pcs.firePropertyChange("focusBook", null, focusBook);
	}
	public void checkID(String ID) {
		try {
			if(CheckValidity.checkRegistration_ID(ID, DB.getUserList()))
				pcs.firePropertyChange("confirm", null, "사용 가능한 ID");;
		} catch (Exception e) {
			pcs.firePropertyChange("error", null, e.getMessage());
			e.printStackTrace();
		}
	}
	public void deleteUser(User user) {
		DB.deleteUser(user);
		for(Book book: new ArrayList<Book>(user.getBookList()))
			DB.deleteBook(book);
		saveData();
	}
	public void deleteBook(Book book) {
		DB.deleteBook(book);
		saveData();
	}
	public void editBook(String price, String quality) throws Exception {
		Book focusBook = DB.getFocusBook();
		CheckValidity.checkBookModification_Input(price, quality);
		focusBook.setPrice(price);
		focusBook.setQuality(quality);
		focusBook = null;
		pcs.firePropertyChange("focusBook", null, focusBook);
		saveData();
	}
	public void registerUser(String ID, char[] PW, String name, String phone, String email) throws Exception {
		try {
			CheckValidity.checkRegistration_Input(DB.getUserList(), ID, PW, name, phone, email);		
			DB.insertUser( new User(ID, PW, name, phone, email));
			saveData();
		}
		catch(Exception ex) {
			pcs.firePropertyChange("error", null, ex.getMessage());			
			ex.printStackTrace();
			throw ex;
		}
	}
	public void registerBook(String price, String quality) throws Exception {
		Book focusBook = DB.getFocusBook();
		CheckValidity.checkBookRegistration_Input(focusBook.getMetadata(), price, quality);
		focusBook.setPrice(price);
		focusBook.setQuality(quality);
		focusBook.setUser(DB.getLoginInfo().getUser());
		DB.insertBook(focusBook);
		DB.getLoginInfo().getUser().insertBook(focusBook);
		focusBook = null;
		pcs.firePropertyChange("focusBook", null, focusBook);
		saveData();
	}
	
	public ArrayList<Book> searchBook_Author(String author){
		return DB.searchBook_Author(author);
	}
	public ArrayList<Book> searchBook_ISBN(String ISBN){
		return DB.searchBook_ISBN(ISBN);
	}
	
	public ArrayList<Book> searchBook_SellerID(String ID){
		return DB.searchBook_SellerID(ID);
	}
	public ArrayList<Book> searchBook_Title(String title){
		return DB.searchBook_Title(title);
	}	
	public ArrayList<Metadata> searchMetadata_ISBN(String ISBN) {
		return DB.searchMetadata_ISBN(ISBN);
	}
	public ArrayList<Metadata> searchMetadata_Title(String Title) {
		return DB.searchMetadata_Title(Title);
	}
	public User searchUser(String ID) throws Exception{
		return DB.searchUser(ID);
	}
	public User searchUser(String ID, char[] PW) throws Exception {
		return DB.searchUser(ID, PW);
	}
	
	
	public void saveData() {
		int list_Size = 0;
		String filePath;
		
		list_Size = DB.getUserList().size();
		
		try {
			filePath = "./user.data";

			FileOutputStream fos = new FileOutputStream(filePath);
			ObjectOutputStream os = new ObjectOutputStream(fos);
			
			os.writeInt(list_Size);

			for(int i = 0; i < list_Size; i++)
				os.writeObject(DB.getUserList().get(i));
				
			os.close();
			fos.close();
			
		}
		catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	public void loadData() {
		try {
			Scanner read = new Scanner (new File("./metadata.data"));
			read.useDelimiter("//");
			String title, ISBN, publisher, author, date;
			
			while(read.hasNext())
			{
				ISBN = read.next();
				title = read.next();
				publisher = read.next();
				author = read.next();
				date = read.next();
				DB.insertMetadata(new Metadata(ISBN, title, publisher, author, date));
			}
			read.close();
	    }
		catch (Exception e) {
			e.getStackTrace();
	    }
		
		int list_Size = 0;
		String filePath;
        
		try { 
            filePath="./user.data";
            File file = new File(filePath);
            if(file.isFile()) {
				FileInputStream fis = new FileInputStream(filePath);
				ObjectInputStream is = new ObjectInputStream(fis);
				DB.getUserList().clear();
				
				list_Size = is.readInt();
				for(int i = 0; i < list_Size; i++) {
					DB.insertUser(((User)is.readObject()));
					for(Book book : DB.getUserList().get(i).getBookList())
						book.setMetadata(searchMetadata_ISBN(book.getMetadata().getISBN()).get(0));
					DB.getBookList().addAll(DB.getUserList().get(i).getBookList());
				}
				is.close();
				fis.close();
			}
		} 
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
