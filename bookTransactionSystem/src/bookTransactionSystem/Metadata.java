package bookTransactionSystem;

import java.io.Serializable;

public class Metadata implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ISBN;
	private String title;
	private String publisher;
	private String author;
	private String date;
	
	Metadata(){
		
	}
	
	Metadata(String ISBN, String title, String publisher, String author, String date){
		this.ISBN = ISBN;
		this.title = title;
		this.publisher = publisher;
		this.author = author;
		this.date = date;
	}
	
	public String getISBN() {
		return ISBN;
	}
	public String getTitle() {
		return title;
	}
	public String getPublisher() {
		return publisher;
	}
	public String getAuthor() {
		return author;
	}
	public String getDate() {
		return date;
	}
}
