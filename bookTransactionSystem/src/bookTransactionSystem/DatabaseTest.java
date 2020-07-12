package bookTransactionSystem;

import java.beans.PropertyChangeSupport;
import org.junit.Test;
import junit.framework.TestCase;

public class DatabaseTest extends TestCase{
	private Database database;
	protected void setUp() {
		database = new Database(new PropertyChangeSupport(this));
	}
	
	@Test public void testInsertBook() {
		assertEquals(0, database.getBookList().size());
		database.insertBook(new Book());
		assertEquals(1, database.getBookList().size());
	}
	@Test public void testSearchBook_ISBN() {
		Book book = new Book();
		Metadata metadata = new Metadata("111", null, null, null, null);
		book.setMetadata(metadata);
		book.setUser(new User(null, null, null, null, null));

		assertEquals(0, database.searchBook_ISBN("1").size());
		database.insertBook(book);
		assertEquals(1, database.searchBook_ISBN("1").size());
		
		book = new Book();
		metadata = new Metadata("211", null, null, null, null);
		book.setMetadata(metadata);
		book.setUser(new User(null, null, null, null, null));
		
		database.insertBook(book);
		assertEquals(2, database.searchBook_ISBN("1").size());
		assertEquals(1, database.searchBook_ISBN("2").size());
		
		book = new Book();
		metadata = new Metadata("331", null, null, null, null);
		book.setMetadata(metadata);
		book.setUser(new User(null, null, null, null, null));
		
		database.insertBook(book);
		assertEquals(3, database.searchBook_ISBN("1").size());
		assertEquals(1, database.searchBook_ISBN("2").size());
	}
	
	@Test public void testSearchMetadata_Title() {
		Metadata metadata = new Metadata("1", "Title", "Publihser", "Author", "2010-10-02");
		Metadata metadata2 = new Metadata("3", "Turtle", "Pub", "Auth", "2010-01-02");
		
		database.insertMetadata(metadata);
		database.insertMetadata(metadata2);
		
		assertEquals(1, database.searchMetadata_Title("Title").size());
		assertEquals(2, database.searchMetadata_Title("tle").size());
		assertEquals(1, database.searchMetadata_Title("Tit").size());
	}
}