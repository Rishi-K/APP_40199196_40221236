import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

class TestUserInsertReadDelete {

	@Test
	void test() {
		Connection conn = OpenLibraryDriver.getConnection();		
		User usr = new User(21474836, "Rishab Kumar", "rk401@");
		UsersController uc = new UsersController();
		uc.insert(usr, conn);
		User ur = (User) uc.read(Integer.toString(usr.getId()), conn);
		
		System.out.println(ur.getId()+" "+ ur.getName()+" "+ ur.getPassword());
		// 21474836, Rishab Kumar, rk401@
		assertAll("User Info",
		        () -> assertEquals(21474836, ur.getId()),
		        () -> assertEquals("Rishab Kumar", ur.getName()),
		        () -> assertEquals("rk401@", ur.getPassword())
		    );
		uc.delete(Integer.toString(ur.getId()), conn);
		User ur2 = (User) uc.read(Integer.toString(ur.getId()), conn);
		assertNull(ur2);
	}

}
