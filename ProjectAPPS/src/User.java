import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    private int id;
    private String name;
    private String password;
    private ChartTracker ct=null;
    
    
    public User(int id, String name, String password ) {
    	this.id = id;
    	this.name = name;
    	this.password = password;
    	
    }
    
    
    //accessor methods
    public int getId() {
    	return this.id;
    }
    public String getName() {
    	return this.name;
    }
    public String getPassword() {
    	return this.password;
    }
    public ChartTracker getChartTracker() {
    	return this.ct;
    }
    
    //mutator methods
    public void setName(String name) {
    	this.name = name;
    }
    public void setPassword(String pwd) {
    	this.password = pwd;
    }
    public void setPassword(int id) {
    	this.id = id;
    }
    
    public void setChartTracker(ChartTracker ct) {
    	this.ct = ct;
    }
    
    public boolean buyBook(Books book, int quantity, BuyMapperController bmpc, BooksController bkc, AuthorsController ac, Connection conn ) {
    	
    	bmpc.insert(book.getKey(), this.id, conn);
    	
    	book.setCopiesBought(book.getCopiesBought()+ quantity);
    	bkc.update( book , conn);
    	
    	Authors aut = (Authors) ac.read(book.getAuthor(), conn);
    	aut.setSaleCount(aut.getSaleCount()+quantity);
    	
    	ac.update(aut, conn);
    	
    	ct.update(conn);
    	
    	return true;
    }
}
