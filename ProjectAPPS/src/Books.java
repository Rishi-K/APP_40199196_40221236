import java.util.List;


public class Books {

    private String key;
    private String title;
    private String author;
    private String publisher;
    private String ISBN;
    private int pageCount;
    private String language;
    private String publishDate;
    private long copiesBought;
    
    public Books(String key, String title, String author, String publisher, String ISBN, int pageCount, String language, String publishDate) {
    	this.key = key;
    	this.title = title;
    	this.author = author;
    	this.publisher = publisher;
    	this.ISBN = ISBN;
    	this.pageCount = pageCount;
    	this.language = language;
    	this.publishDate = publishDate;
    	
    	this.copiesBought = 0;
    	
    }
    
    public Books(String key, String title, String author, String publisher, String ISBN, int pageCount, String language, String publishDate, long copieBought) {
    	this.key = key;
    	this.title = title;
    	this.author = author;
    	this.publisher = publisher;
    	this.ISBN = ISBN;
    	this.pageCount = pageCount;
    	this.language = language;
    	this.publishDate = publishDate;
    	
    	this.copiesBought = copiesBought;
    	
    }
    
    public Books(String key, String title, String author) {
    	this.key = key;
    	this.title = title;
    	this.author = author;
    	this.publisher = "";
    	this.ISBN = "";
    	this.pageCount = 0;
    	this.language = "";
    	this.publishDate = "";
    	
    	this.copiesBought = 0;
    	
    }
    
    
    public void setCopiesBought(long copiesBought) {
    	this.copiesBought = copiesBought;
    }
    public void setPublishDate(String publishDate) {
    	this.publishDate = publishDate;
    }
    public void setLanguage(String language) {
    	this.language = language;
    }
    public void setISBN(int pageCount) {
    	this.pageCount = pageCount;
    }
    public void setISBN(String ISBN) {
    	this.ISBN = ISBN;
    }
    public void setPublisher(String publisher) {
    	this.publisher = publisher;
    }
    public void setAuthor(String author) {
    	this.author = author;
    }
    public void setTitle(String title) {
    	this.title = title;
    }
    
    public void setKey(String key) {
    	this.key = key;
    }
    
    
    public long getCopiesBought() {
    	return this.copiesBought;
    }
    public String getPublishDate() {
    	return this.publishDate;
    }
    public String getLanguage() {
    	return this.language;
    }
    public String getISBN() {
    	return this.ISBN;
    }
    public int getPageCount() {
    	return this.pageCount;
    }
    
    public String getPublisher() {
    	return this.publisher;
    }
    public String getAuthor() {
    	return this.author;
    }
    
    public String getTitle() {
    	return this.title;
    }
    public String getKey() {
    	return this.key;
    }

}
