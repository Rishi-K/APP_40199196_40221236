import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
class TestUserBuyBook {

	@Test
	void test() {
		int quantity = 30;
		Connection conn = OpenLibraryDriver.getConnection();
		User usr = new User(324535, "Ross Geller", "RG@12");
		ChartTracker ct = new ChartTracker(conn);
		usr.setChartTracker(ct);
		BooksController bkc = new BooksController();
		AuthorsController ac = new AuthorsController();
		BuyMapperController bmpc = new BuyMapperController();
		
		Books book = (Books) bkc.readBookByName("Before They Are Hanged", conn);
		
		usr.buyBook(book, quantity, bmpc, bkc, ac, conn);
		assertAll("Top Chart Info",
		        () -> assertEquals("Before They Are Hanged", ct.getBookOne().getTitle()),
		        () -> assertEquals("Joe Abercrombie", ct.getAuthorOne().getName())
		    );
		
	}

}
