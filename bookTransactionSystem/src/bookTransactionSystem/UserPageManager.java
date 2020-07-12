package bookTransactionSystem;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class UserPageManager {
	private ArrayList<User> list_whole;
	private ArrayList<User> list_partial;
	
	private int listContentNum;
	private int pageNum;
	private PropertyChangeSupport pcs;
	
	UserPageManager(int listContentNum, PropertyChangeSupport pcs){
		pageNum = 1;
		this.pcs = pcs;
		this.listContentNum = listContentNum;
		list_partial = new ArrayList<User>();
		list_whole = new ArrayList<User>();
	}
	public void updatePartial() {
		list_partial.clear();
		for(int i = (pageNum - 1) * listContentNum;
				i <= list_whole.size() - 1 && i < pageNum * listContentNum; i++)
			list_partial.add(list_whole.get(i));
		if(list_partial.size() == 0 && list_whole.size() != 0) {
			decreasePageNum();
			updatePartial();
		}
		pcs.firePropertyChange("userList_partial", null, list_partial);
	}

	public void decreasePageNum() {
		if(pageNum != 1)
			pageNum--;
		updatePartial();
	}
	public void increasePageNum() {
		if(pageNum <= (list_whole.size() - 1) / listContentNum)
			pageNum++;
		updatePartial();
	}
	public void updateWhole(ArrayList<User> list_whole) {
		this.list_whole = new ArrayList<User>(list_whole);
		for(User user: this.list_whole)
			if(user.getID().equals("admin")) {
				this.list_whole.remove(user);
				break;
			}
	}
	public void deleteUser(User user) {
		list_whole.remove(user);
	}
	
	public ArrayList<User> getList_partial(){
		return list_partial;
	}
	
	public void setPageNum(int pageNum){
		this.pageNum = pageNum;
	}
	public int getPageNum() {
		return pageNum;
	}
	public ArrayList<User> getList_whole() {
		return list_whole;
	}
}
