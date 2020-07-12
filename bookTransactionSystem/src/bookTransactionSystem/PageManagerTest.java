package bookTransactionSystem;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import org.junit.Test;
import junit.framework.TestCase;

public class PageManagerTest extends TestCase{
	UserPageManager userPage;
	ArrayList<User> userList;
	
	protected void setUp() {
		userPage = new UserPageManager(4, new PropertyChangeSupport(this));
		userList = new ArrayList<User>();
		userList.add(new User("admin", null, null, null, null));
		for(int i = 0; i < 6; i++)
			userList.add(new User(null, null, null, null, null));
	}
	
	@Test public void testUpdateWhole() {
		userPage.updateWhole(userList);
		assertEquals(6, userPage.getList_whole().size());
	}
	
	@Test public void testUpdatePartial() {
		userPage.updateWhole(userList);
		userPage.updatePartial();
		assertEquals(4, userPage.getList_partial().size());
	}
	
	@Test public void testIncrease() {
		userPage.updateWhole(userList);
		userPage.updatePartial();
		
		assertEquals(1, userPage.getPageNum());
		userPage.increasePageNum();
		assertEquals(2, userPage.getPageNum());
		assertEquals(2, userPage.getList_partial().size());
		
		//마지막 페이지에서 increase 호출했을 때
		userPage.increasePageNum();
		assertEquals(2, userPage.getPageNum());
		assertEquals(2, userPage.getList_partial().size());
	}

	@Test public void testDecrease() {
		userPage.updateWhole(userList);
		userPage.updatePartial();
		
		userPage.increasePageNum();
		
		userPage.decreasePageNum();
		assertEquals(1, userPage.getPageNum());
		assertEquals(4, userPage.getList_partial().size());
		
		//첫 페이지에서 decrease 호출했을 때
		userPage.decreasePageNum();
		assertEquals(1, userPage.getPageNum());
		assertEquals(4, userPage.getList_partial().size());
	}
}
