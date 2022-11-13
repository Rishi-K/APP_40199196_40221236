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
		
		
		try {
			String query = "INSERT INTO User( id, name, password ) VALUES ( 21474837, 'Rick Famiyawa', 'rk401@');";
			Statement stmt = conn.createStatement();
			stmt.executeQuery(query);
			
			
		}catch(Exception e) {
			System.out.println("could not read data");
			System.out.println(e.getMessage());
		}
		
		try {
			String query = "SELECT id FROM User";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString("id"));
			}
			
		}catch(Exception e) {
			System.out.println("could not read data");
		}
		
			
		

	}

}
