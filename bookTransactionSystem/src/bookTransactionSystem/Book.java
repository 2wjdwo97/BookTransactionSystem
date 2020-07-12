package bookTransactionSystem;

import java.io.Serializable;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int price;
	private String quality;
	private boolean status;
	private Metadata metadata;	
	private User user;
	
	Book(){	
		metadata = new Metadata();
		status = true;
	}

	public Metadata getMetadata() {
		return metadata;
	}
	public int getPrice() {
		return price;
	}
	public String getQuality() {
		return quality;
	}
	public boolean getStatus() {
		return status;
	}
	public User getUser() {
		return user;
	}
	
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	public void setPrice(String price) {
		this.price = Integer.parseInt(price);
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
