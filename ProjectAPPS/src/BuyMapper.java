public class BuyMapper {
    int user;
    String book;
    
    
    public BuyMapper(int id, String bookKey) {
    	this.user = id;
    	this.book = bookKey;
    }
    
    //accessor methods
    public String getBook() {
    	return this.book;
    }    
    public int getUser() {
    	return this.user;
    }
    
    //mutator methods
    public void setBook(String book) {
    	this.book = book;
    }
    public void setUser(int user) {
    	this.user= user;
    }
    
    
}
