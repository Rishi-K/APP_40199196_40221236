import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

class TestAuthorsInsertReadDelete {

	@Test
	void test() {
		Connection conn = OpenLibraryDriver.getConnection();		
		APIReader areader = new APIReader();
		Authors author = areader.readAuthorAPI();
		AuthorsController ac = new AuthorsController();
		ac.insert(author, conn);
		Authors aut = (Authors) ac.read(author.getKey(), conn);
		System.out.println(aut.getName()+" "+ aut.getBirthDate()+" "+ aut.getKey()+" "+ aut.getLinks());
		// J. K. Rowling 31 July 1965 OL23919A Official Site: http://www.jkrowling.com/;
		assertAll("Book Info",
		        () -> assertEquals("J. K. Rowling", aut.getName()),
		        () -> assertEquals("31 July 1965", aut.getBirthDate()),
		        () -> assertEquals("OL23919A", aut.getKey())
		    );
		ac.delete(aut.getKey(), conn);
		Books aut2 = (Books) ac.read(aut.getKey(), conn);
		assertNull(aut2);
	}

}
