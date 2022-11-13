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
		User usr = new User(21474836, "Rishab Kumar", "rk401@");
		UsersController uc = new UsersController();
		
		uc.insert(usr);
			
		

	}

}
