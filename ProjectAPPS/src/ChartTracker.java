import java.util.List;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ChartTracker {
	
	private Books bookOne;
	private Books bookTwo;
	private Books bookThree;
	
	private Authors authorOne;
	private Authors authorTwo;
	private Authors authorThree;
	private boolean errorFlag= false;
	
	public boolean getErrorFlag() {
		return this.errorFlag;
	}
	
	
	public Authors getAuthorOne() {
		return this.authorOne;
	}
	public Authors getAuthorTwo() {
		return this.authorTwo;
	}
	public Authors getAuthorThree() {
		return this.authorThree;
	}
	
	public Books getBookOne() {
		return this.bookOne;
	}
	public Books getBookTwo() {
		return this.bookTwo;
	}
	
	public Books getBookThree() {
		return this.bookThree;
	}
	
	public ChartTracker(Connection conn) {
		boolean af = this.getTopAuthors(conn);
		if(af!=true) {
			this.authorOne=null;
			this.authorTwo=null;
			this.authorThree=null;
			this.errorFlag = true;
		}
		
		boolean bf = this.getTopBooks(conn);
		if(bf!=true) {
			this.bookOne=null;
			this.bookTwo=null;
			this.bookThree=null;
			this.errorFlag = true;
		}
	}
	
	public boolean getTopAuthors(Connection conn)
	{
		Authors author = null;
		ArrayList<Authors> lstAuthors=new ArrayList<Authors>();
		try {
			String query = "SELECT * FROM Authors ORDER BY saleCount DESC LIMIT 3;";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int i =1;
			while(rs.next()) {
				author = new Authors(rs.getString("key"),rs.getString("name"), rs.getString("birthDate"), rs.getString("externalLinks"), rs.getInt("saleCount") );
				if(i==1) {
					this.authorOne = author;
					i++;
				}
				else if(i==2) {
					this.authorTwo = author;
					i++;
				}
				else if(i==3){
					this.authorThree = author;
					i++;
				}
				else {
					continue;
				}
			}
	
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("could not read data");
			return false;
		}
		
		return true;

	}
	
	public boolean getTopBooks(Connection conn)
	{
		Books book = null;
		ArrayList<Books> lstAuthors=new ArrayList<Books>();
		try {
			String query = "SELECT * FROM Books ORDER BY copiesBought DESC LIMIT 3;";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			int i =1;
			while(rs.next()) {
				book = new Books(rs.getString("key"),rs.getString("title"), rs.getString("author"), rs.getString("publisher"), rs.getString("ISBN"), rs.getInt("pageCount"), rs.getString("language"), rs.getString("publishDate"), rs.getLong("copiesBought") );
				if(i==1) {
					this.bookOne = book;
					i++;
				}
				else if(i==2) {
					this.bookTwo = book;
					i++;
				}
				else if(i==3){
					this.bookThree = book;
					i++;
				}
				else {
					continue;
				}
		}
	
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("could not read data");
			return false;
		}
		return true;

	}
	
	
	public boolean update(Connection conn) {
		boolean af = this.getTopAuthors(conn);
		boolean bf = this.getTopBooks(conn);
		if(af==true && bf == true) {
			this.errorFlag=false;
		}
		else {
			this.errorFlag = true;
		}
		return this.errorFlag;
	}
}
