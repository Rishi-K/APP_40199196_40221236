import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.sqlite.SQLiteDataSource;

public class BooksController implements Controller {

	
	@Override
	public boolean insert(Object obj, Connection conn) {
		// TODO Auto-generated method stub
		Books book = (Books) obj;
		try {
			String query1 = "INSERT INTO Books( key, title, author, publisher, ISBN, pageCount, language, publishDate  ) VALUES ('"+ book.getKey()+"', '"+ book.getTitle();
			String query2 = "', '"+book.getAuthor()+"', '"+book.getPublisher()+"', '"+book.getISBN()+"', "+book.getPageCount()+", '"+book.getLanguage()+"', '"+book.getPublishDate()+"');";
			String query = query1+query2;
			System.out.println(query);
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
		Books book = (Books) obj;
		try {
			String query1 = "UPDATE Books SET title='"+book.getTitle()+"' , author = '"+ book.getAuthor()+"' , publisher= '"+ book.getPublisher();
			String query2 = "' , ISBN= '"+ book.getISBN()+"' , pageCount= "+ book.getPageCount()+" , language= '"+ book.getLanguage()+"' , publishDate= '"+ book.getPublishDate();
			String query3 =	"' where key='"+book.getKey()+"' ;";
			String query = query1 + query2 + query3;
			System.out.println(query);
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
	public boolean delete(String key, Connection conn) {
		// TODO Auto-generated method stub
		
		try {
			String query = "DELETE FROM Books where key='"+key+"';";
			Statement stmt = conn.createStatement();
			int rs = stmt.executeUpdate(query);
			
			
		}catch(Exception e) {
			System.out.println("could not delete data");
			return false;			
		}
		return true;
	}

	@Override
	public Object read(String key, Connection conn) {
		// TODO Auto-generated method stub
		Books book = null;
		try {
			String query = "SELECT key, title, author, publisher, ISBN, pageCount, language, publishDate, copiesBought FROM Books where key='"+key+"';";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				book = new Books(rs.getString("key"),rs.getString("title"), rs.getString("author"), rs.getString("publisher"), rs.getString("ISBN"), rs.getInt("pageCount"), rs.getString("language"), rs.getString("publishDate") );
				book.setCopiesBought(rs.getLong("copiesBought"));
			}
			
		}catch(Exception e) {
			System.out.println("could not read data");
			return null;			
		}
		return book;
		
	}
	
	public Object readBookByName(String name, Connection conn) {
		// TODO Auto-generated method stub
		Books book = null;
		try {
			String query = "SELECT key, title, author, publisher, ISBN, pageCount, language, publishDate, copiesBought FROM Books where name='"+name+"';";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				book = new Books(rs.getString("key"),rs.getString("title"), rs.getString("author"), rs.getString("publisher"), rs.getString("ISBN"), rs.getInt("pageCount"), rs.getString("language"), rs.getString("publishDate") );
				book.setCopiesBought(rs.getLong("copiesBought"));
			}
			
		}catch(Exception e) {
			System.out.println("could not read data");
			return null;			
		}
		return book;
		
	}
	
	public ArrayList<String> getAllBooks(Connection conn) {
		// TODO Auto-generated method stub
		ArrayList<String> booklist = new ArrayList<String>(); 
		try {
			String query = "SELECT title FROM Books;";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				booklist.add(rs.getString(rs.getString("title")));
			}
			
		}catch(Exception e) {
			System.out.println("could not read data");
			return null;			
		}
		return booklist;
		
	}
	

}
