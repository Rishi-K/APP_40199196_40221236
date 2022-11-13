public class Subjects {
    public String key;
    public String name;
    public long workCount;
    
    
    
    public Subjects(String key, String name, long workCOunt) {
    	this.key = key;
    	this.name = name;
    	this.workCount = workCount;
    }
    
    public Subjects(String key, String name) {
    	this.key = key;
    	this.name = name;
    	this.workCount = 0;
    }
    
    //accessor methods
    public String getKey() {
    	return this.key;
    }    
    public String getName() {
    	return this.name;
    }
    public long workCount() {
    	return this.workCount;
    }
    
    //mutator methods
    public void setKey(String key) {
    	this.key = key;
    }
    public void setName(String name) {
    	this.name=name;
    }
    public void setWorkCount(long workCount) {
    	this.workCount= workCount;
    }
}
