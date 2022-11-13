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


public class BuyMapperController implements Controller {

	
	@Override
	public boolean insert(Object obj, Connection conn) {
		// TODO Auto-generated method stub
		BuyMapper bmap = (BuyMapper) obj;
		return false;
	}
	
	@Override
	public boolean update(Object obj, String column ,String value, Connection conn) {
		// TODO Auto-generated method stub
		BuyMapper bmap = (BuyMapper) obj;
		return false;
	}

	@Override
	public boolean delete(String key, Connection conn) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public Object read(String key, Connection conn) {
		// TODO Auto-generated method stub
		
		return false;
	}

}
