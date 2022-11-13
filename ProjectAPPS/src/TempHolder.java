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

public class TempHolder {
	
	public static void temp() {
		//connection to the database
		Connection c = null;
		try {
			SQLiteDataSource ds = new SQLiteDataSource();
			ds.setUrl("jdbc:sqlite:C:\\Users\\Admin\\eclipse-workspace\\ProjectAPPS\\jobs.db");
			Connection conn = ds.getConnection();
			System.out.println("Connection created");
			
			String query = "SELECT * FROM Company";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString("Location"));
			}
			
		} catch(Exception e) {
			System.out.println("error catching");
			System.out.println(e.getMessage());
		}
		
		
		//code to read Authors API
		//declare and initializ all data holder variables
		
		
		
		
	}

}
