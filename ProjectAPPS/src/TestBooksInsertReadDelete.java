import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

class TestBooksInsertReadDelete {

	@Test
	void test() {
		Connection conn = OpenLibraryDriver.getConnection();		
		APIReader areader = new APIReader();
		Books book = areader.readBookAPI("OL27351482M");
		BooksController bkc = new BooksController();
		bkc.insert(book, conn);
		Books bk = (Books) bkc.read(book.getKey(), conn);
		System.out.println(bk.getTitle()+" "+ bk.getKey()+" "+ bk.getAuthor()+" "+ bk.getPublisher());
		// The Subtle Art of Not Giving a Fuck OL27351482M OL2964000A HarperLuxe
		assertAll("Book Info",
		        () -> assertEquals("The Subtle Art of Not Giving a Fuck", bk.getTitle()),
		        () -> assertEquals("OL27351482M", bk.getKey())
		    );
		bkc.delete(bk.getKey(), conn);
		Books bk2 = (Books) bkc.read(book.getKey(), conn);
		assertNull(bk2);
	}

}
