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



public class OpenLibraryDriver {
	
	public static Connection getConnection() {
		Connection c = null;
		try {
			SQLiteDataSource ds = new SQLiteDataSource();
			ds.setUrl("jdbc:sqlite:C:\\Users\\Admin\\git\\repository\\ProjectAPPS\\openlib.db");
			Connection conn = ds.getConnection();
			System.out.println("Connection created");
			return conn;
			
			
		} catch(Exception e) {
			System.out.println("error catching");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// script to read data for authors api
//		APIReader areader = new APIReader();
//		areader.readBookAPI();
		
		Connection conn = OpenLibraryDriver.getConnection();
		
		
		User aUser = new User(2054567, "Mira Grant", "rk626@");
		UsersController uc = new UsersController();
		uc.insert(aUser, conn);
		uc.read(aUser, conn);
		
	}

}
