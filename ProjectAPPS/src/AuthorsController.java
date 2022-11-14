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

public class AuthorsController implements Controller{

	
	@Override
	public boolean insert(Object obj, Connection conn) {
		// TODO Auto-generated method stub
		Authors author = (Authors) obj;
		try {
			String query = "INSERT INTO Authors( key, name, birthDate, externalLinks  ) VALUES ('"+ author.getKey()+"', '"+ author.getName()+"', '"+author.getBirthDate()+"', '"+author.getLinks()+"');";
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
	public boolean update(Object obj, String column, String value, Connection conn) {
		// TODO Auto-generated method stub
		Authors author = (Authors) obj;
		try {
			String query = "UPDATE Authors SET name='"+author.getName()+"' , birthDate = '"+ author.getBirthDate()+"' , externalLinks= '"+ author.getLinks() +"', saleCount="+author.getSaleCount()+" where key='"+author.getKey()+"' ;";
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
			String query = "DELETE FROM Authors where key='"+key+"';";
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
		Authors author = null;
		try {
			String query = "SELECT key, name, birthDate, externalLinks, saleCount  FROM Authors where key='"+key+"';";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				author = new Authors(rs.getString("key"),rs.getString("name"), rs.getString("birthDate"), rs.getString("externalLinks") );
				author.setSaleCount(rs.getLong("saleCount"));
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("could not read data");
			return null;			
		}
		return author;
		
	}
	
	public ArrayList<String> getAuthorNames(Connection conn) {
		ArrayList<String> authorList = new ArrayList<String>();
		try {
			String query = "SELECT name, key FROM Authors;";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				authorList.add(rs.getString("name")+";"+rs.getString("key"));
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("could not read data in getAuthorNames");
			return null;			
		}
		return authorList;
	}
}
