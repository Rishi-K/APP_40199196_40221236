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

public class SubjectsController implements Controller{
	
	
	@Override
	public boolean insert(Object obj, Connection conn) {
		// TODO Auto-generated method stub
		Subjects sub = (Subjects) obj;
		return false;
	}
	
	
	@Override
	public boolean update(Object obj, String column ,String value, Connection conn) {
		// TODO Auto-generated method stub
		Subjects sub = (Subjects) obj;
		return false;
	}

	@Override
	public boolean delete(Object obj, Connection conn) {
		// TODO Auto-generated method stub
		Subjects sub = (Subjects) obj;
		return false;
	}

	@Override
	public boolean read(Object obj, Connection conn) {
		// TODO Auto-generated method stub
		Subjects sub = (Subjects) obj;
		return false;
	}

}
