package bookTransactionSystem;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class MetadataPageManager{
	private ArrayList<Metadata> list_whole;
	private ArrayList<Metadata> list_partial;
	
	private int listContentNum;
	private int pageNum;
	private PropertyChangeSupport pcs;
	
	MetadataPageManager(int listContentNum, PropertyChangeSupport pcs) {
		pageNum = 1;
		this.pcs = pcs;
		this.listContentNum = listContentNum;
		list_partial = new ArrayList<Metadata>();
		list_whole = new ArrayList<Metadata>();
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
		pcs.firePropertyChange("metadataList_partial", null, list_partial);
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

	public void updateWhole(ArrayList<Metadata> list_whole) {
		this.list_whole = list_whole;
	}		
	
	public ArrayList<Metadata> getList_partial(){
		return list_partial;
	}
	public void setPageNum(int pageNum){
		this.pageNum = pageNum;
	}
}
