import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

class TestBooksUpdate {

	@Test
	void testUpdate() {
		Connection conn = OpenLibraryDriver.getConnection();		
		APIReader areader = new APIReader();
		Books book = areader.readBookAPI("OL27351482M");
		BooksController bkc = new BooksController();
		bkc.insert(book, conn);
		Books bk = (Books) bkc.read(book.getKey(), conn);
		bk.setAuthor("ChangedAuthor");
		bkc.update(bk, null, null, conn);
		Books bk2 = (Books) bkc.read(bk.getKey(), conn);
		assertEquals("ChangedAuthor", bk2.getAuthor());
		bkc.delete(bk2.getKey(), conn);
		
	}

}
