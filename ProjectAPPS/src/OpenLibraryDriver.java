import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.sqlite.SQLiteDataSource;

public class OpenLibraryDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// script to read data for authors api
		
			
		//declare and initializ all data holder variables
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
		JSONArray alternateNames=null;
			
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
					    System.out.println("key: "+ key_obj);
				    	
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
				    	
				    }
			    	
			    }catch(Exception e) {
			    	
			    }
			    
			    
			    try {
			    	alternateNames = (JSONArray)data_obj.get("alternate_names");
				    System.out.println("Alternate Names are: ");
				    for(int i=0; i< alternateNames.size(); i++) {
				    	System.out.println(alternateNames.get(i));
				    }
			    	
			    }catch(Exception e) {
			    	
			    }   

			    //Get the required object from the above created object
			    
			}
		}catch(Exception e) {
			System.out.println("Error in reading non essential data. Proceeding wihtout them");
			
		}
			
		

	}

}
