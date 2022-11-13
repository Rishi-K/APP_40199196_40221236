import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserControllerTest {

	@BeforeEach
	void setUp() throws Exception {
		Connection conn = OpenLibraryDriver.getConnection();
		
		APIReader areader = new APIReader();
		Books book = areader.readBookAPI();
		Authors author = areader.readAuthorAPI();
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
