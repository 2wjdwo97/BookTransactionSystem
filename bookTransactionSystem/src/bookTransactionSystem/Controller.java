package bookTransactionSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Controller {
	private View theView;
	private ModelHandler theModel;
	
	Controller(View theView, ModelHandler theModel){
		this.theView = theView;
		this.theModel = theModel;
		
		this.theModel.addErrorObserver(this.theView);
		this.theModel.addConfirmObserver(this.theView);
		
		this.theModel.addLoginObserver(this.theView.getView_Main());
		this.theModel.addLoginObserver(this.theView.getView_ManageBook());
		this.theModel.addLoginObserver(this.theView.getView_ManageUser());
		this.theModel.addLoginObserver(this.theView.getView_SearchResult());
		
		this.theModel.addFocusBookObserver(this.theView.getView_RegisterBook());
		this.theModel.addFocusBookObserver(this.theView.getView_EditBook());
		
		this.theModel.addManageBookListObserver(this.theView.getView_ManageBook());
		this.theModel.addSearchBookListObserver(this.theView.getView_SearchResult());
		this.theModel.addSearchMetadataListObserver(this.theView.getView_RegisterBook());
		this.theModel.addUserListObserver(this.theView.getView_ManageUser());
		
		theView.getView_Login().addLoginBtnListener(new login_loginBtnListener());
		theView.getView_Login().addRegisterBtnListener(new login_registerBtnListener());
		
		theView.getView_Register().addBackBtnListener(new register_backBtnListener());
		theView.getView_Register().addCheckBtnListener(new register_checkBtnListener());
		theView.getView_Register().addRegisterBtnListener(new register_registerBtnListener());
		
		theView.getView_Main().addLogoutBtnListener(new main_logoutBtnListener());
		theView.getView_Main().addManageBookBtnListener(new main_manageBookBtnListener());
		theView.getView_Main().addManageUserBtnListener(new main_manageUserBtnListener());
		theView.getView_Main().addSearchBtnListener(new main_searchBtnListener());
		
		theView.getView_ManageBook().addBackBtnListener(new manageBook_backBtnListener());
		theView.getView_ManageBook().addRegisterBookBtnListener(new manageBook_registerBookBtnListener());
		theView.getView_ManageBook().addPreviousBtnListener(new manageBook_previousBtnListener());
		theView.getView_ManageBook().addNextBtnListener(new manageBook_nextBtnListener());
		
		theView.getView_RegisterBook().addRegisterBtnListener(new registerBook_registerBtnListener());
		theView.getView_RegisterBook().addBackBtnListener(new registerBook_backBtnListener());
		theView.getView_RegisterBook().addSearchBtnListener(new registerBook_searchBtnListener());
		theView.getView_RegisterBook().addPreviousBtnListener(new registerBook_previousBtnListener());
		theView.getView_RegisterBook().addNextBtnListener(new registerBook_nextBtnListener());
		
		theView.getView_SearchResult().addSearchBtnListener(new searchResult_searchBtnListener());
		theView.getView_SearchResult().addBackBtnListener(new searchResult_backBtnListener());
		theView.getView_SearchResult().addPreviousBtnListener(new searchResult_previousBtnListener());
		theView.getView_SearchResult().addNextBtnListener(new searchResult_nextBtnListener());
		theView.getView_SearchResult().addDeleteBtnListener(new searchResult_deleteBtnListener());
		
		theView.getView_EditBook().addBackBtnListener(new editBook_backBtnListener());
		theView.getView_EditBook().addRegisterBtnListener(new editBook_registerBtnListener());
		
		theView.getView_ManageUser().addBackBtnListener(new manageUser_backBtnListener());
		theView.getView_ManageUser().addPreviousBtnListener(new manageUser_previousBtnListener());
		theView.getView_ManageUser().addNextBtnListener(new manageUser_nextBtnListener());
	}
//====================================================//
	
	/***View_Login***/
	class login_loginBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			try {
				theModel.login(theView.getView_Login().getID(), theView.getView_Login().getPW());
				loginInputClear();
				theView.getCardLayout().show(theView.getContentPane(), "main");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(theView, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
	}
	
	class login_registerBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			theView.getCardLayout().show(theView.getContentPane(), "register");
		}
	}
	
	private void loginInputClear() {
		theView.getView_Login().setID("");
		theView.getView_Login().setPW("");
	}
	/***View_Login***/
	
	/***View_Register***/
	class register_registerBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			try {
				theModel.registerUser(theView.getView_Register().getID(), theView.getView_Register().getPW(), 
					theView.getView_Register().getName(), theView.getView_Register().getPhone(), theView.getView_Register().getEmail());
				registerInputClear();
				theView.getCardLayout().show(theView.getContentPane(), "login");
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	class register_checkBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			theModel.checkID(theView.getView_Register().getID());
		}
	}
	
	class register_backBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			registerInputClear();
			theView.getCardLayout().show(theView.getContentPane(), "login");
		}
	}
	
	private void registerInputClear() {
		theView.getView_Register().setID("");
		theView.getView_Register().setPW("");
		theView.getView_Register().setName("");
		theView.getView_Register().setPhone("");
		theView.getView_Register().setEmail("");
	}
	/***View_Register***/

	/***View_Main***/
	class main_logoutBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			theModel.logout();
			mainInputClear();
			theView.getCardLayout().show(theView.getContentPane(), "login");
		}
	}
	
	class main_manageBookBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			mainInputClear();
			theModel.manageBookEnter();
			theView.getView_ManageBook().addEditBtnListener(new manageBook_editBtnListener());
			theView.getView_ManageBook().addDeleteBtnListener(new manageBook_deleteBtnListener());
			theView.getCardLayout().show(theView.getContentPane(), "manageBook");
		}
	}
	
	class main_manageUserBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			mainInputClear();
			theModel.manageUserEnter();
			theView.getView_ManageUser().addChangeUserStatusBtnListener(new manageUser_changeUserStatusBtnListener());
			theView.getView_ManageUser().addDeleteBtnListener(new manageUser_deleteBtnListener());
			theView.getCardLayout().show(theView.getContentPane(), "manageUser");
		}
	}
	
	class main_searchBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			theModel.searchBook(theView.getView_Main().getSelectedRadio(), theView.getView_Main().getSearchBar());
			theView.getView_SearchResult().addPurchaseBtnListener(new searchResult_purchaseBtnListener());
			theView.getView_SearchResult().addDeleteBtnListener(new searchResult_deleteBtnListener());
			theView.getView_SearchResult().setSearchBar(theView.getView_Main().getSearchBar());
			mainInputClear();
			theView.getCardLayout().show(theView.getContentPane(), "searchResult");
		}
	}
	
	private void mainInputClear() {
		theView.getView_Main().setSearchBar("");
	}
	/***View_Main***/
	
	/***View_ManageBook***/
	class manageBook_backBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			theView.getCardLayout().show(theView.getContentPane(), "main");
		}
	}
	
	class manageBook_registerBookBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			theModel.registerBookEnter();
			theView.getCardLayout().show(theView.getContentPane(), "registerBook");
		}
	}
	
	class manageBook_editBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			for(int i = 0; i < 4; i++) {
				if(e.getActionCommand().equals(String.valueOf(i))) {
					theModel.setEditBook(i);
					theView.getCardLayout().show(theView.getContentPane(), "editBook");
					break;
				}
			}
		}
	}
	
	class manageBook_deleteBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			for(int i = 0; i < 4; i++) {
				if(e.getActionCommand().equals(String.valueOf(i))) {
					theModel.deleteBook(i);
					theView.repaint();
					theView.getView_ManageBook().addEditBtnListener(new manageBook_editBtnListener());
					theView.getView_ManageBook().addDeleteBtnListener(new manageBook_deleteBtnListener());
					break;
				}
			}
		}
	}
	
	class manageBook_nextBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			theModel.manageBookNextPage();
			theView.getView_ManageBook().addEditBtnListener(new manageBook_editBtnListener());
			theView.getView_ManageBook().addDeleteBtnListener(new manageBook_deleteBtnListener());
			theView.repaint();
		}
	}
	
	class manageBook_previousBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			try {
				theModel.manageBookPreviousPage();
				theView.getView_ManageBook().addEditBtnListener(new manageBook_editBtnListener());
				theView.getView_ManageBook().addDeleteBtnListener(new manageBook_deleteBtnListener());
				theView.repaint();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(theView, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
	}
	/***View_ManageBook***/
	
	/***View_EditBook***/
	class editBook_backBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			theView.getCardLayout().show(theView.getContentPane(), "manageBook");
		}
	}
	
	class editBook_registerBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			try {
				theModel.editBook(theView.getView_EditBook().getPrice(),  theView.getView_EditBook().getQuality());
				theView.getView_ManageBook().addEditBtnListener(new manageBook_editBtnListener());
				theView.getView_ManageBook().addDeleteBtnListener(new manageBook_deleteBtnListener());
				theView.getCardLayout().show(theView.getContentPane(), "manageBook");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(theView, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
	}
	/***View_EditBook***/
	
	/***View_RegisterBook***/
	class registerBook_registerBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			try {
				theModel.registerBook(theView.getView_RegisterBook().getPrice(), theView.getView_RegisterBook().getQuality());
				theView.getView_ManageBook().addEditBtnListener(new manageBook_editBtnListener());
				theView.getView_ManageBook().addDeleteBtnListener(new manageBook_deleteBtnListener());
				theView.getCardLayout().show(theView.getContentPane(), "manageBook");
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(theView, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
	}
	
	class registerBook_backBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			theView.getCardLayout().show(theView.getContentPane(), "manageBook");
		}
	}
	
	class registerBook_searchBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			theModel.searchMetadata(theView.getView_RegisterBook().getSelectedRadio(), theView.getView_RegisterBook().getSearchBar());
			theView.getView_RegisterBook().addSelectBtnListener(new registerBook_selectBtnListener());
			theView.repaint();
		}
	}
	
	class registerBook_selectBtnListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < 8; i++) {
				if(e.getActionCommand().equals(String.valueOf(i))) {
					theModel.attachMetadata(i);
					theView.repaint();
					break;
				}
			}
		}
	}
	
	class registerBook_previousBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			try {
				theModel.metadataPreviousPage();
				theView.getView_RegisterBook().addSelectBtnListener(new registerBook_selectBtnListener());
				theView.repaint();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(theView, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
	}
	class registerBook_nextBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			try {
				theModel.metadataNextPage();
				theView.getView_RegisterBook().addSelectBtnListener(new registerBook_selectBtnListener());
				theView.repaint();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(theView, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
	}
	/***View_RegisterBook***/

	
	/**View_SearchResult**/
	class searchResult_searchBtnListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			theModel.searchBook(theView.getView_SearchResult().getSelectedRadio(), theView.getView_SearchResult().getSearchBar());
			theView.getView_SearchResult().addDeleteBtnListener(new searchResult_deleteBtnListener());
			theView.getView_SearchResult().addPurchaseBtnListener(new searchResult_purchaseBtnListener());
			theView.repaint();
		}
	}
	
	class searchResult_purchaseBtnListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < 4; i++) {
				if(e.getActionCommand().equals(String.valueOf(i))) {
					theModel.purchaseBook(i);
					theView.getView_SearchResult().addPurchaseBtnListener(new searchResult_purchaseBtnListener());
					theView.getView_SearchResult().addDeleteBtnListener(new searchResult_deleteBtnListener());
					theView.repaint();
					break;
				}
			}
		}
	}
	
	class searchResult_backBtnListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			searchInputClear();
			theView.getCardLayout().show(theView.getContentPane(), "main");
		}
	}
	
	class searchResult_nextBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			try {
				theModel.searchedBookNextPage();
				theView.getView_SearchResult().addPurchaseBtnListener(new searchResult_purchaseBtnListener());
				theView.getView_SearchResult().addDeleteBtnListener(new searchResult_deleteBtnListener());
				theView.repaint();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(theView, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
	}
	
	class searchResult_previousBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			try {
				theModel.searchedBookPreviousPage();
				theView.getView_SearchResult().addPurchaseBtnListener(new searchResult_purchaseBtnListener());
				theView.getView_SearchResult().addDeleteBtnListener(new searchResult_deleteBtnListener());
				theView.repaint();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(theView, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
	}
	
	class searchResult_deleteBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			for(int i = 0; i < 4; i++) {
				if(e.getActionCommand().equals(String.valueOf(i))) {
					theModel.deleteSearchedBook(i);
					theView.getView_SearchResult().addPurchaseBtnListener(new searchResult_purchaseBtnListener());
					theView.getView_SearchResult().addDeleteBtnListener(new searchResult_deleteBtnListener());
					theView.repaint();
					break;
				}
			}
		}
	}
	
	public void searchInputClear() {
		theView.getView_SearchResult().setSearchBar("");
	}
	/**View_SearchResult**/
	
	/***View_ManageUser***/
	class manageUser_backBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			theView.getCardLayout().show(theView.getContentPane(), "main");
		}
	}
	class manageUser_previousBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			try {
				theModel.userPreviousPage();
				theView.getView_ManageUser().addDeleteBtnListener(new manageUser_deleteBtnListener());
				theView.getView_ManageUser().addChangeUserStatusBtnListener(new manageUser_changeUserStatusBtnListener());
				theView.repaint();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(theView, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
	}
	class manageUser_nextBtnListener implements ActionListener {
		public void actionPerformed(ActionEvent e)  {
			try {
				theModel.userNextPage();
				theView.getView_ManageUser().addDeleteBtnListener(new manageUser_deleteBtnListener());
				theView.getView_ManageUser().addChangeUserStatusBtnListener(new manageUser_changeUserStatusBtnListener());
				theView.repaint();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(theView, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				ex.printStackTrace();
			}
		}
	}
	
	class manageUser_deleteBtnListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < 10; i++) {
				if(e.getActionCommand().equals(String.valueOf(i))) {
					theModel.deleteUser(i);
					theView.getView_ManageUser().addChangeUserStatusBtnListener(new manageUser_changeUserStatusBtnListener());
					theView.getView_ManageUser().addDeleteBtnListener(new manageUser_deleteBtnListener());
					theView.repaint();
					break;
				}
			}
		}
	}
	
	class manageUser_changeUserStatusBtnListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			for(int i = 0; i < 10; i++) {
				if(e.getActionCommand().equals(String.valueOf(i))) {
					theModel.changeUserStatus(i);
					theView.getView_ManageUser().addChangeUserStatusBtnListener(new manageUser_changeUserStatusBtnListener());
					theView.getView_ManageUser().addDeleteBtnListener(new manageUser_deleteBtnListener());
					theView.repaint();
					break;
				}
			}
		}
	}
	/***View_ManageUser***/
}