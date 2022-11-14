import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
    private int id;
    private String name;
    private String password;
    
    
    public User(int id, String name, String password) {
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
    
    public boolean buyBook(Books book, int quantity, BuyMapperController bmpc, BooksController bkc, AuthorsController ac, Connection conn ) {
    	
    	bmpc.insert(book.getKey(), this.id, conn);
    	
    	book.setCopiesBought(book.getCopiesBought()+ quantity);
    	bkc.update( book , null, null, conn);
    	
    	Authors aut = (Authors) ac.read(book.getAuthor(), conn);
    	aut.setSaleCount(aut.getSaleCount()+quantity);
    	
    	ac.update(aut, null, null, conn);
    	
    	return true;
    }
}
