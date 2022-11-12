public class Subjects {
    public String key;
    public String name;
    public long workCount;
    
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
