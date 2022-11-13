import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

class TestAuthorsUpdate {

	@Test
	void test() {
		Connection conn = OpenLibraryDriver.getConnection();		
		APIReader areader = new APIReader();
		Authors author = areader.readAuthorAPI();
		AuthorsController ac = new AuthorsController();
		ac.insert(author, conn);
		Authors aut = (Authors) ac.read(author.getKey(), conn);
		
		aut.setName("Changed Name of Author");
		ac.update(aut, null, null, conn);
		Authors aut2 = (Authors) ac.read(aut.getKey(), conn);
		assertEquals("Changed Name of Author", aut2.getName());
		ac.delete(aut2.getKey(), conn);
	}

}
