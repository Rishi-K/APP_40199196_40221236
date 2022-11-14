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


public class BuyMapperController {

	public boolean insert(String book, int userId, Connection conn) {
		// TODO Auto-generated method stub
		try {
			String query = "INSERT INTO BuyMapper( user, book ) VALUES ("+ userId+", '"+ book+"');";
			Statement stmt = conn.createStatement();
			int rs = stmt.executeUpdate(query);
			System.out.println("Book buy record inserted");
			
		}catch(Exception e) {
			System.out.println("could not insert data");
			
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
	
	
	public boolean update(String book, int userId, Connection conn) {
		// TODO Auto-generated method stub		
		try {
			String query = "UPDATE BuyMapper SET user="+userId+"' where user="+userId+" and book='"+book+"';";
			System.out.println(query);
			Statement stmt = conn.createStatement();
			int rs = stmt.executeUpdate(query);
			System.out.println("Book buy record updated");
			
		}catch(Exception e) {
			System.out.println("could not update data");
			
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	
	public boolean delete(String book, int userId, Connection conn) {
		// TODO Auto-generated method stub
		try {
			String query = "DELETE FROM BuyMapper where user="+userId+" and book='"+book+"';";
			Statement stmt = conn.createStatement();
			int rs = stmt.executeUpdate(query);
			System.out.println("Book buy record deleted");
			
		}catch(Exception e) {
			System.out.println("could not delete data");
			return false;			
		}
		return true;
	}

	
	public Object read(String book, int userId, Connection conn) {
		// TODO Auto-generated method stub
		BuyMapper bmp = null;
		try {
			String query = "SELECT user, book FROM BuyMapper where user="+userId+" and book='"+book+"';";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				bmp = new BuyMapper(rs.getInt("user"),rs.getString("book"));
				
			}
			
		}catch(Exception e) {
			System.out.println("could not read data");
			return null;			
		}
		return bmp;
		
	}

}
