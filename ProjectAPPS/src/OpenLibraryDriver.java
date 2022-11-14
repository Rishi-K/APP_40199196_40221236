import java.net.HttpURLConnection;
import java.net.URL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.sqlite.SQLiteDataSource;

import java.io.File; 
import java.io.FileNotFoundException;  
import java.util.Scanner;



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
	
	
	
	public static void buildDB() {
		Connection conn = OpenLibraryDriver.getConnection();
		APIReader areader = new APIReader();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// script to read data for authors api
		
		
		
		ArrayList<String> authorList = new ArrayList<String>();
		try {
		      File myObj = new File("C:\\Users\\Admin\\git\\repository\\ProjectAPPS\\AuthorKeys.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        authorList.add(data.trim());
		      }
		      myReader.close();
		} catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		System.out.println(authorList.toString());
		
		Connection conn = OpenLibraryDriver.getConnection();
		
		APIReader areader = new APIReader();
//
//		
		if(authorList != null) {
			AuthorsController ac = new AuthorsController();
			for(int i=0;i<authorList.size();i++) {
				Authors author = areader.readAuthorAPI(authorList.get(i).trim());
				ac.insert(author, conn);
			}
		}
		
		System.out.println("---------------------------");
		
		BooksController bkc = new BooksController();
		AuthorsController ac = new AuthorsController();
		ArrayList<String> authorNames = ac.getAuthorNames(conn);
		System.out.println(authorNames.toString());
		
		System.out.println("---------------------------------");
		
		ArrayList<String> booklist = new ArrayList<String>();
		for(int i=0; i< authorNames.size(); i++) {
			ArrayList<String> currentAuthorBooks = areader.getAuthorBookKeys(authorNames.get(i).split(";")[0], authorNames.get(i).split(";")[1]);
			List<String> arrlist2 = currentAuthorBooks.subList(0, 3);
			booklist.addAll(arrlist2);
			
		}
		System.out.println(booklist.toString());
		System.out.println("---------------------------------------");
		
		for(int i=0; i< booklist.size(); i++) {
			System.out.println(booklist.get(i).split(";")[0].trim());
			Books book = areader.readBookAPI(booklist.get(i).split(";")[0].trim());
			book.setAuthor(booklist.get(i).split(";")[1]);
			bkc.insert(book, conn);
		}
		
	}

}
