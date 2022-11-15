import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

class TestUserUpdate {

	@Test
	void test() {
		Connection conn = OpenLibraryDriver.getConnection();		
		User usr = new User(21474836, "Rishab Kumar", "rk401@");
		UsersController uc = new UsersController();
		uc.insert(usr, conn);
		User ur = (User) uc.read(Integer.toString(usr.getId()), conn);
		ur.setPassword("ChangedPassword");
		uc.update(ur, conn);
		User ur2 = (User) uc.read(Integer.toString(ur.getId()), conn);
		assertEquals("ChangedPassword", ur2.getPassword());
		uc.delete(Integer.toString(ur.getId()), conn);
	}

}
