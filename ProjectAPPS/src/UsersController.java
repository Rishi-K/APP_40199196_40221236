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
			System.out.println("User inserted");
			
		}catch(Exception e) {
			System.out.println("could not insert data");
			
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	@Override
	public boolean update(Object obj, Connection conn) {
		// TODO Auto-generated method stub
		User usr = (User) obj;
		try {
			String query = "UPDATE User SET name='"+usr.getName()+"' , password = '"+ usr.getPassword()+"' where id="+usr.getId()+" ;";
			System.out.println(query);
			Statement stmt = conn.createStatement();
			int rs = stmt.executeUpdate(query);
			System.out.println("User updated");
			
		}catch(Exception e) {
			System.out.println("could not update data");
			
			System.out.println(e.getMessage());
			return false;
		}
		return true;
		
	}

	@Override
	public boolean delete(String key, Connection conn) {
		// TODO Auto-generated method stub
		int ikey = Integer.parseInt(key);
		try {
			String query = "DELETE FROM User where id="+ikey+";";
			Statement stmt = conn.createStatement();
			int rs = stmt.executeUpdate(query);
			System.out.println("User deleted");
			
		}catch(Exception e) {
			System.out.println("could not delete data");
			return false;			
		}
		return true;
	}

	@Override
	public Object read(String key, Connection conn) {
		// TODO Auto-generated method stub
		int ikey = Integer.parseInt(key);
		User usr = null;
		try {
			String query = "SELECT id, name, password FROM User where id="+ikey+";";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				usr = new User(rs.getInt("id"),rs.getString("name"), rs.getString("password"));
				
			}
			
		}catch(Exception e) {
			System.out.println("could not read data");
			return null;			
		}
		return usr;
		
	}

}
