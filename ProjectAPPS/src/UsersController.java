import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.sqlite.SQLiteDataSource;


public class UsersController implements Controller {

	
	@Override
	public boolean insert( Object obj, Connection conn ) {
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
	public boolean update(Object obj, String column ,String value, Connection conn) {
		// TODO Auto-generated method stub
		User usr = (User) obj;
		return false;
	}

	@Override
	public boolean delete(Object obj, Connection conn) {
		// TODO Auto-generated method stub
		User usr = (User) obj;
		return false;
	}

	@Override
	public boolean read(Object obj, Connection conn) {
		// TODO Auto-generated method stub
		User usr = (User) obj;
		return false;
	}

}
