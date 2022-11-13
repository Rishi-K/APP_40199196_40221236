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
		Connection conn = OpenLibraryDriver.getConnection();
		
		APIReader areader = new APIReader();
		Books book = areader.readBookAPI();
		Authors author = areader.readAuthorAPI();
		System.out.println("------------------------------------------");
		
//		System.out.println(book.getKey()+" "+ book.getTitle()+" "+ book.getAuthor());
//		System.out.println(book.getPublishDate()+" "+ book.getPageCount()+" "+ book.getPublisher());
//		System.out.println(book.getLanguage());
//		
//		System.out.println(author.getKey()+" "+ author.getName()+" "+ author.getBio()+" "+ author.getBirthDate()+ " "+ author.getSaleCount()+" "+ author.getLinks());
		
//		BooksController bkc = new BooksController();
//		bkc.insert(book, conn);
		AuthorsController ac = new AuthorsController();
		ac.insert(author, conn);
//		author.setName("Jada Rollins");
//		ac.update(author, null, null, conn);
		
		Authors aut = (Authors)ac.read("OL23919A", conn);
		System.out.println(aut.getName()+" "+ aut.getBirthDate()+" "+ aut.getKey()+" "+ aut.getLinks());
		
//		ac.delete("OL23919A", conn);
//		Books bk = (Books) bkc.read("OL27351482M", conn);
//		System.out.println(bk.getTitle()+" "+ bk.getKey()+" "+ bk.getAuthor()+" "+ bk.getPublisher());
//		
//		bk.setISBN("ISBN00001");
//		bkc.update(bk, null, null, conn);
		
//		bkc.delete("OL27351482M", conn);
		
		
		
	}

}
