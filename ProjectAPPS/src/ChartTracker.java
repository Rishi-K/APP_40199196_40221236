import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ChartTracker {
	
	public List<Authors> getTopAuthors(Connection conn)
	{
		Authors author = null;
		ArrayList<Authors> lstAuthors=new ArrayList<Authors>();
		try {
			String query = "SELECT * FROM Authors ORDER BY saleCount DESC LIMIT 3;";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
			author = new Authors(rs.getString("key"),rs.getString("name"), rs.getString("birthDate"), rs.getString("externalLinks"), rs.getInt("saleCount") );
			lstAuthors.add(author);
		}
	
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("could not read data");
			return null;
		}
		return lstAuthors;

	}
	
	public List<Books> getTopBooks(Connection conn)
	{
		Books book = null;
		ArrayList<Books> lstAuthors=new ArrayList<Books>();
		try {
			String query = "SELECT * FROM Books ORDER BY copiesBought DESC LIMIT 3;";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
			book = new Books(rs.getString("key"),rs.getString("title"), rs.getString("author"), rs.getString("publisher"), rs.getString("ISBN"), rs.getInt("pageCount"), rs.getString("language"), rs.getString("publishDate"), rs.getLong("copiesBought") );
			lstAuthors.add(book);
		}
	
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("could not read data");
			return null;
		}
		return lstAuthors;

	}
}
