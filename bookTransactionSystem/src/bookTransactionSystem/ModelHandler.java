package bookTransactionSystem;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelHandler {
	private PropertyChangeSupport pcs;

	private	DatabaseManager DBManager;
	private UserPageManager userPage;
	private ManageBookPageManager manageBookPage;
	private SearchedBookPageManager searchedBookPage;
	private MetadataPageManager metadataPage;
	
	ModelHandler(){
		pcs = new  PropertyChangeSupport(this);
		DBManager = new DatabaseManager(pcs);

		userPage = new UserPageManager(10, pcs);
		manageBookPage = new ManageBookPageManager(4, pcs);
		searchedBookPage = new SearchedBookPageManager(4, pcs);
		metadataPage = new MetadataPageManager(8, pcs);
		
		metadataPage.updateWhole(DBManager.getMetadataList());
		userPage.updateWhole(DBManager.getUserList());	
	}
	
	public void addErrorObserver(PropertyChangeListener l) {
		pcs.addPropertyChangeListener("error", l);
	}
	public void addConfirmObserver(PropertyChangeListener l) {
		pcs.addPropertyChangeListener("confirm", l);
	}
	public void addFocusBookObserver(PropertyChangeListener l) {
		pcs.addPropertyChangeListener("focusBook", l);
	}
	public void addLoginObserver(PropertyChangeListener l) {
		pcs.addPropertyChangeListener("login", l);
	}
	public void addManageBookListObserver(PropertyChangeListener l) {
		pcs.addPropertyChangeListener("manageBookList_partial", l);
	}
	public void addSearchBookListObserver(PropertyChangeListener l) {
		pcs.addPropertyChangeListener("searchedBookList_partial", l);
	}
	public void addSearchMetadataListObserver(PropertyChangeListener l) {
		pcs.addPropertyChangeListener("metadataList_partial", l);
	}
	public void addUserListObserver(PropertyChangeListener l) {
		pcs.addPropertyChangeListener("userList_partial", l);
	}

	public void attachMetadata(int index) {
		Metadata metadata = metadataPage.getList_partial().get(index);
		DBManager.attachMetadata(metadata);
	}
	public void changeUserStatus(int index) {
		User user = userPage.getList_partial().get(index);
		user.setStatus(!user.getStatus());
		userPage.updatePartial();
		DBManager.saveData();
	}
	public void checkID(String ID) {
		DBManager.checkID(ID);
	}
	public void deleteBook(int index) {
		Book book = manageBookPage.getList_partial().get(index);
		DBManager.deleteBook(book);
		manageBookPage.updatePartial();
	}
	public void deleteSearchedBook(int index) {
		Book book = searchedBookPage.getList_partial().get(index);
		DBManager.deleteBook(book);
		searchedBookPage.delete(index);
		searchedBookPage.updatePartial();
	}
	public void deleteUser(int index) {
		User user = userPage.getList_partial().get(index);
		DBManager.deleteUser(user);
		userPage.deleteUser(user);
		userPage.updatePartial();
	}
	public void editBook(String price, String quality) throws Exception {
		DBManager.editBook(price, quality);
		manageBookPage.updatePartial();
	}
	public void login(String ID, char[] PW) throws Exception{
		User user;
		CheckValidity.checkLogin_Input(ID, PW);
		user = DBManager.searchUser(ID, PW);
		CheckValidity.checkValidUser(user.getStatus());
		manageBookPage.updateWhole(user.getBookList());
		DBManager.setLogin_info(user);
	}
	public void logout() {
		DBManager.setLogin_info();
	}
	public void manageBookEnter() {
		resetManageBookPageNum();
		manageBookPage.updatePartial();
	}
	public void manageBookNextPage() {
		manageBookPage.increasePageNum();
	}
	public void manageBookPreviousPage() {
		manageBookPage.decreasePageNum();
	}
	public void manageUserEnter() {
		resetUserPageNum();
		userPage.updatePartial();
	}
	public void metadataNextPage() {
		metadataPage.increasePageNum();
	}
	public void metadataPreviousPage() {
		metadataPage.decreasePageNum();
	}
	public void purchaseBook(int index) {
		Book book = searchedBookPage.getList_partial().get(index);
		book.setStatus(false);
		searchedBookPage.delete(index);
		searchedBookPage.updatePartial();
		pcs.firePropertyChange("confirm", null, "구매자: " + DBManager.getLoginInfo().getUser().getEmailAddress() + "\n판매자: " + book.getUser().getEmailAddress());
		DBManager.saveData();
	}
	public void registerBook(String price, String quality) throws Exception {
		DBManager.registerBook(price, quality);
		manageBookPage.updatePartial();
	}
	public void registerBookEnter() {
		DBManager.createBook();
		resetMetadataPageNum();
		metadataPage.updatePartial();
	}
	public void registerUser(String ID, char[] PW, String name, String phone, String email) throws Exception{
		try {
			DBManager.registerUser(ID, PW, name, phone, email);
			userPage.updateWhole(DBManager.getUserList());
		}
		catch(Exception ex) {
			throw ex;
		}
	}
	public void searchedBookNextPage() {
		searchedBookPage.increasePageNum();
	}
	public void searchedBookPreviousPage() {
		searchedBookPage.decreasePageNum();
	}
	public void searchMetadata(String searchOption, String content) {
		switch(searchOption) {
		case "Title":
			metadataPage.updateWhole(DBManager.searchMetadata_Title(content));
			break;
		case "ISBN":
			metadataPage.updateWhole(DBManager.searchMetadata_ISBN(content));
			break;
		default:
		}
		resetMetadataPageNum();
		metadataPage.updatePartial();
	}
	public void searchBook(String searchOption, String content) {
		switch(searchOption) {
		case "Title":
			searchedBookPage.updateWhole(DBManager.searchBook_Title(content));
			break;
		case "Author":
			searchedBookPage.updateWhole(DBManager.searchBook_Author(content));
			break;
		case "ISBN":
			searchedBookPage.updateWhole(DBManager.searchBook_ISBN(content));
			break;
		case "ID":
			searchedBookPage.updateWhole(DBManager.searchBook_SellerID(content));
			break;
		default:
		}
		resetSearchedBookPageNum();
		searchedBookPage.updatePartial();
	}
	public void setEditBook(int index) {
		Book book = manageBookPage.getList_partial().get(index);
		DBManager.setFocusBook(book);
	}
	public void userNextPage() {
		userPage.increasePageNum();
	}
	public void userPreviousPage(){
		userPage.decreasePageNum();
	}

	private void resetMetadataPageNum() {
		metadataPage.setPageNum(1);
	}
	private void resetUserPageNum() {
		userPage.setPageNum(1);
	}
	private void resetSearchedBookPageNum() {
		searchedBookPage.setPageNum(1);
	}
	private void resetManageBookPageNum() {
		manageBookPage.setPageNum(1);
	}
}
