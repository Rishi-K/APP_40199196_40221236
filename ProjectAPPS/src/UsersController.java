
public class UsersController implements Controller {

	
	@Override
	public boolean insert( Object obj ) {
		// TODO Auto-generated method stub
		User usr = (User) obj;
		System.out.println(usr.getPassword());
		System.out.println(usr.getId());
		System.out.println(usr.getName());
		usr.setName("RK");
		System.out.println(usr.getName());
		return false;
	}
	
	@Override
	public boolean update(Object obj, String column ,String value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean read(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
