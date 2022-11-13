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
		try {
			String query = "INSERT INTO User( id, name, password ) VALUES ("+ usr.getId()+", '"+ usr.getName()+"', '"+usr.getPassword()+"');";
			Statement stmt = conn.createStatement();
			int rs = stmt.executeUpdate(query);
			
			
		}catch(Exception e) {
			System.out.println("could not insert data");
			
			System.out.println(e.getMessage());
			return false;
		}
		return true;
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
		try {
			String query = "SELECT id, name, password FROM User where id="+usr.getId()+";";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString("id")+" "+rs.getString("name")+" "+rs.getString("password"));
			}
			
		}catch(Exception e) {
			System.out.println("could not read data");
			return false;			
		}
		return true;
	}

}
