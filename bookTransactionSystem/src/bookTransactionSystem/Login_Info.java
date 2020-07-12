package bookTransactionSystem;

import java.beans.PropertyChangeSupport;

public class Login_Info {
	private User user;
	private boolean isAdmin;
	private PropertyChangeSupport pcs;
	
	Login_Info(PropertyChangeSupport pcs){
		this.pcs = pcs;
		isAdmin = false;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user, boolean isAdmin) {
		this.user = user;
		this.isAdmin = isAdmin;
	}
	
	public boolean getIsAdmin() {
		return isAdmin;
	}

	public void insertLoginUser(User user) {
		if(user.getID().equals("admin"))
			isAdmin = true;
		this.user = user;
		pcs.firePropertyChange("login", null, this);
	}

	public void deleteLoginUser() {
		user = null;
		isAdmin = false;
	}
}

