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
}
