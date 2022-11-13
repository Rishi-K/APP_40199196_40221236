import java.util.List;

public class Authors {
	
	private String birth_date;
	private String links;
	private String key;
	private String name;
	private long saleCount;

	public Authors(String key, String name, String birth_date, String links ){
		
		this.birth_date = birth_date;
		this.links = links;
		this.key = key;
		this.name = name;
		this.saleCount = 0;
	 
	}
	
	public Authors( String key, String name ){
		
		this.birth_date = "";
		this.links = "";
		this.key = key;
		this.name = name;
		this.saleCount = 0;
	 
	}
	
	//accessor methods
	
	public String getName(){
		return this.name;
	}
	public String getKey(){
		return this.key;
	}
	public String getLinks(){
		return this.links;
	}
	public String getBirthDate(){
		return this.birth_date;
	}
	public long getSaleCount(){
		return this.saleCount;
	}
	
	//mutators method
	public void setName(String name) {
		this.name = name;
	}
	public void setKey(String key) {
		this.key = key;
	}
	
	public void setBirthDate(String birthDate) {
		this.birth_date = birthDate;
	}
	public void setLinks(String links) {
		this.links = links;
	}
	public void setSaleCount(long saleCount) {
		this.saleCount = saleCount;
	}
}
