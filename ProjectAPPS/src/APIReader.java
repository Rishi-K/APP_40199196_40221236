import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class APIReader {
	
	public Authors readAuthorAPI() {
		boolean cflag = true;
		JSONObject data_obj=null;
		String bio="";
		String Name_obj="";
		String key_obj="";
		String type="";
		String lastModified="";
		JSONObject remoteIds_obj=null;
		String personalName_obj = "";
		String title_obj="";
		String dob_obj="";
		JSONArray links=null;
		String links_combined = "";
		JSONArray alternateNames=null;
		String aNames_combined = "";
			
		String wikidata;
		String isni;
		String goodreads;
		String viaf;
		String librarything;			
		
		URL url =null;
		
		try {
			String base_url = "https://openlibrary.org/";
			String api = "authors/";
			String api_key = "OL23919A" +".json";
			url = new URL(base_url+api+api_key);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			//Getting the response code
			int responsecode = conn.getResponseCode();
			System.out.println(responsecode);
			
			if (responsecode != 200) {
			    
			    cflag = false;
			} 
			
		}catch(Exception e) {
			cflag = false;
		}
			
		try {
			if (cflag == true){
				  
				String inline = "";
				Scanner scanner = new Scanner(url.openStream());
				  
				//Write all the JSON data into a string using a scanner
				while (scanner.hasNext()) {
					inline += scanner.nextLine();
				}
				    
				//Close the scanner
				scanner.close();
				    
				System.out.println(inline);

				    //Using the JSON simple library parse the string into a json object
				    
					try {
				    	JSONParser parser = new JSONParser();
					    data_obj = (JSONObject) parser.parse(inline);
					    System.out.println("could reach here");
					    Name_obj = (String) data_obj.get("name");
					    System.out.println("name: "+ Name_obj);
					    
					    key_obj = (String) data_obj.get("key");
					    System.out.println("key: "+ key_obj.split("/")[2]);
				    	
				    }catch(Exception e) {
				    	cflag = false;
				    	
				    }
				}
				else {
					System.out.println("ending the creation of Author object. THere was an error reading the api.");
					
				}
			
		}catch(Exception e) {
			cflag=false;
		}
		
			
		try {	
			if(cflag==true) {
			    
			    try {
			    	bio = (String) data_obj.get("bio");
				    System.out.println("bio: "+ bio);
			    	
			    }catch(Exception e) {
			    	
			    }
			    
			    
			    try {
			    	JSONObject type_obj = (JSONObject) data_obj.get("type");
				    type = (String) type_obj.get("key");
				    System.out.println("type: "+ type);
			    	
			    }catch(Exception e) {
			    	
			    }
			    
			    
			    
			    
			    try {
			    	JSONObject lastModified_obj = (JSONObject) data_obj.get("last_modified");
				    lastModified = (String) lastModified_obj.get("value");
				    System.out.println("last_modified: "+ lastModified);
			    	
			    }catch(Exception e) {
			    	
			    }
			    
			    
			    try {
			    	remoteIds_obj = (JSONObject) data_obj.get("remote_ids");
				    System.out.println("remote ids: ");
			    	
			    }catch(Exception e) {
			    	
			    }
			    
			    
			    
			    try {
			    	wikidata = (String) remoteIds_obj.get("wikidata");
			    	System.out.println("wikidata: "+ wikidata);
			    }catch(Exception e) {
			    	
			    	System.out.println(e.getMessage());
			    	wikidata = "";			    	
			    }
			    
			    try {
			    	isni = (String) remoteIds_obj.get("isni");
			    	System.out.println("isni: "+ isni);
			    }catch(Exception e) {
			    	isni = "";			    	
			    }
			    
			    try {
			    	goodreads = (String) remoteIds_obj.get("goodreads");
			    	System.out.println("goodreads: "+ goodreads);
			    }catch(Exception e) {
			    	goodreads = "";			    	
			    }
			    
			    try {
			    	viaf = (String) remoteIds_obj.get("viaf");
			    	System.out.println("viaf: "+ viaf);
			    }catch(Exception e) {
			    	viaf = "";			    	
			    }
			    
			    try {
			    	librarything = (String) remoteIds_obj.get("librarything");
			    	System.out.println("librarything: "+ librarything);
			    }catch(Exception e) {
			    	librarything = "";			    	
			    }
			    
			    try {
			    	
			    }catch(Exception e) {
			    	personalName_obj = (String) data_obj.get("personal_name");
				    System.out.println("personal_name: "+ personalName_obj);
			    	
			    }
			    
			    
			    
			    try {
			    	title_obj = (String) data_obj.get("title");
				    System.out.println("title: "+ title_obj);
			    	
			    }catch(Exception e) {
			    	
			    }
			    
			    
			    try {
			    	dob_obj = (String) data_obj.get("birth_date");
				    System.out.println("title: "+ dob_obj);
			    }catch(Exception e) {
			    	
			    }
			    
			    
			    try {
			    	links = (JSONArray) data_obj.get("links");
				    System.out.println("External links are:");
				    for(int i=0; i< links.size(); i++) {
				    	JSONObject current_link = (JSONObject) links.get(i);
				    	System.out.println("title: "+current_link.get("title"));
				    	System.out.println("url: "+current_link.get("url"));
				    	System.out.println();
				    	links_combined+=current_link.get("title")+": "+ current_link.get("url")+"; ";
				    }
				    links_combined = links_combined.trim();
			    	
			    }catch(Exception e) {
			    	
			    }
			    
			    
			    try {
			    	alternateNames = (JSONArray)data_obj.get("alternate_names");
				    System.out.println("Alternate Names are: ");
				    for(int i=0; i< alternateNames.size(); i++) {
				    	System.out.println(alternateNames.get(i));
				    	aNames_combined+= alternateNames.get(i)+"; ";
				    }
				    aNames_combined = aNames_combined.trim();
			    	
			    }catch(Exception e) {
			    	
			    }   

			    //Get the required object from the above created object
			    
			}
		}catch(Exception e) {
			System.out.println("Error in reading non essential data. Proceeding wihtout them");
			
		}
		
		if (cflag== false) {
			return null;
		}
		else {
			Authors author = new Authors(key_obj , Name_obj , bio, dob_obj, links_combined );
			return author;
		}
		
	}
	
	// reading api to get Subject data;
	
	public Subjects readSubjectAPI() {
		boolean cflag = true;
		JSONObject data_obj=null;
		URL url =null;
		
		String name_obj="";
		String key_obj="";
		long workCount = 0;
			
		try {
			String base_url = "https://openlibrary.org/";
			String api = "subjects/";
			String api_key = "love" +".json";
			url = new URL(base_url+api+api_key);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			//Getting the response code
			int responsecode = conn.getResponseCode();
			System.out.println(responsecode);
			
			if (responsecode != 200) {
			    
			    cflag = false;
			} 
			
		}catch(Exception e) {
			cflag = false;
		}
		
		try {
			if (cflag == true){
				  
				String inline = "";
				Scanner scanner = new Scanner(url.openStream());
				  
				//Write all the JSON data into a string using a scanner
				while (scanner.hasNext()) {
					inline += scanner.nextLine();
				}
				    
				//Close the scanner
				scanner.close();
				    
				System.out.println(inline);

				    //Using the JSON simple library parse the string into a json object
				    
				    try {
				    	JSONParser parser = new JSONParser();
					    data_obj = (JSONObject) parser.parse(inline);
					    System.out.println("could reach here");
					    
					    name_obj = (String) data_obj.get("name");
					    System.out.println("name: "+ name_obj);
					    
					    key_obj = (String) data_obj.get("key");
					    System.out.println("key: "+ key_obj);
					    
					    
				    	
				    }catch(Exception e) {
				    	cflag = false;
				    	
				    }
				}
				else {
					System.out.println("ending the creation of Author object. There was an error reading the api.");
					
				}
			
		}catch(Exception e) {
			cflag=false;
		}
		
		try {	
			if(cflag==true) {
			    
			    try {
			    	workCount = (long) data_obj.get("work_count");
				    System.out.println("workCount: "+ workCount);
			    	
			    }catch(Exception e) {
			    	workCount = 0;
			    }		    
			    
			}
		}catch(Exception e) {
			System.out.println("Error in reading non essential data. Proceeding wihtout them");
			
		}
		
		if (cflag== false) {
			return null;
		}
		else {
			Subjects subject = new Subjects(key_obj , name_obj , workCount );
			return subject;
		}		
		
	}
	
	
	public Books readBookAPI() {
		boolean cflag = true;
		JSONObject data_obj=null;
		
		String name_obj="";
		String key_obj="";
		
		String publish_date="";
		
		JSONArray publisher_list=null;
		String publisher="";
		
		JSONArray isbn_list=null;
		String isbn="";
		
		JSONArray author_list=null;
		String author="";
		
		JSONArray language_list=null;
		String language="";
		
		long pageCount = 0;
		
		URL url =null;
		
		try {
			String base_url = "https://openlibrary.org/";
			String api = "books/";
			String api_key = "OL27351482M" +".json";
			url = new URL(base_url+api+api_key);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			//Getting the response code
			int responsecode = conn.getResponseCode();
			System.out.println(responsecode);
			
			if (responsecode != 200) {
			    
			    cflag = false;
			} 
			
		}catch(Exception e) {
			cflag = false;
		}
			
		try {
			if (cflag == true){
				  
				String inline = "";
				Scanner scanner = new Scanner(url.openStream());
				  
				//Write all the JSON data into a string using a scanner
				while (scanner.hasNext()) {
					inline += scanner.nextLine();
				}
				    
				//Close the scanner
				scanner.close();
				    
				System.out.println(inline);

				    //Using the JSON simple library parse the string into a json object
				    
					try {
				    	JSONParser parser = new JSONParser();
					    data_obj = (JSONObject) parser.parse(inline);
					    System.out.println("could reach here");
					    
					    name_obj = (String) data_obj.get("title");
					    System.out.println("name: "+ name_obj);
					    
					    key_obj = (String) data_obj.get("key");
					    System.out.println("key: "+ key_obj);
				    	
				    }catch(Exception e) {
				    	cflag = false;
				    	
				    }
				}
				else {
					System.out.println("ending the creation of Author object. There was an error reading the api.");
					
				}
			
		}catch(Exception e) {
			cflag=false;
		}
		
		try {	
			if(cflag==true) {
			    
			    try {
			    	publish_date = (String) data_obj.get("publish_date");
				    System.out.println("publish date: "+ publish_date);
			    	
			    }catch(Exception e) {
			    	publish_date = "";
			    }	
			    
			    try {
			    	pageCount = (long) data_obj.get("number_of_pages");
				    System.out.println("pageCount: "+ pageCount);
			    	
			    }catch(Exception e) {
			    	System.out.println(e.getMessage());
			    	pageCount = 0;
			    }
			    
			    try {
			    	isbn_list = (JSONArray)data_obj.get("isbn_13");				    
				    isbn = (String) isbn_list.get(0);
				    System.out.println("isbn: "+ isbn);
			    	
			    }catch(Exception e) {
			    	publish_date = "";
			    }
			    
			    try {
			    	publisher_list = (JSONArray)data_obj.get("publishers");				    
				    publisher = (String) publisher_list.get(0);
				    System.out.println("publisher: "+ publisher);
			    	
			    }catch(Exception e) {
			    	publish_date = "";
			    }
			    
			    
			    try {
			    	author_list = (JSONArray) data_obj.get("authors");
				    JSONObject authorOb = (JSONObject) author_list.get(0);
				    author = authorOb.get("key").toString();
				    System.out.println("author: "+ author.split("/")[2]);
				    
				    
			    	
			    }catch(Exception e) {
			    	
			    }
			    
			    try {
			    	language_list = (JSONArray) data_obj.get("languages");
				    JSONObject languageOb = (JSONObject) language_list.get(0);
				    language = languageOb.get("key").toString();
				    System.out.println("language: "+ language.split("/")[2]);
				    
				    
			    	
			    }catch(Exception e) {
			    	
			    }
			    
			    
			}
		}catch(Exception e) {
			System.out.println("Error in reading non essential data. Proceeding wihtout them");
			
		}
		
		if (cflag== false) {
			return null;
		}
		else {
			//Subjects subject = new Subjects(key_obj , name_obj , workCount );
			return null;
		}
		
		
	}
	
	
	
	
	

}
