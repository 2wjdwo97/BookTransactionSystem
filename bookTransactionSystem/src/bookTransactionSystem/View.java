package bookTransactionSystem;

import java.awt.CardLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class View extends JFrame implements PropertyChangeListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CardLayout cl;
	
	private View_Login view_Login;
	private View_Main view_Main;
	private View_Registration view_Registration;
	private View_ManageBook view_ManageBook;
	private View_SearchResult view_SearchResult;
	private View_RegisterBook view_RegisterBook;
	private View_EditBook view_EditBook;
	private View_ManageUser view_ManageUser;
	
	public View() {
		cl = new CardLayout();

		setBounds(100, 100, 800, 529);
		getContentPane().setLayout(cl);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		
		getContentPane().add("login", view_Login = new View_Login(this));
		getContentPane().add("register", view_Registration = new View_Registration(this));
		getContentPane().add("main", view_Main = new View_Main(this));
		getContentPane().add("manageBook", view_ManageBook = new View_ManageBook(this));
		getContentPane().add("searchResult", view_SearchResult = new View_SearchResult(this));
		getContentPane().add("registerBook", view_RegisterBook = new View_RegisterBook(this));
		getContentPane().add("editBook", view_EditBook = new View_EditBook(this));
		getContentPane().add("manageUser", view_ManageUser = new View_ManageUser(this));
		
		setVisible(true);
	}
	
	public CardLayout getCardLayout() {
		return cl;
	}

	public View_Main getView_Main() {
		return view_Main;
	}
	public View_Registration getView_Register() {
		return view_Registration;
	}
	public View_Login getView_Login() {
		return view_Login;
	}
	public View_ManageBook getView_ManageBook() {
		return view_ManageBook;
	}
	public View_SearchResult getView_SearchResult() {
		return view_SearchResult;
	}
	public View_RegisterBook getView_RegisterBook() {
		return view_RegisterBook;
	}
	public View_EditBook getView_EditBook() {
		return view_EditBook;
	}
	public View_ManageUser getView_ManageUser() {
		return view_ManageUser;
	}

	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("error"))
			JOptionPane.showMessageDialog(this, evt.getNewValue(), "Error", JOptionPane.ERROR_MESSAGE);
		else
			JOptionPane.showMessageDialog(this, evt.getNewValue(), "Confirm", JOptionPane.INFORMATION_MESSAGE);
	}
}