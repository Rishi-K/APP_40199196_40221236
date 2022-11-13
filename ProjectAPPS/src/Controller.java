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

public interface Controller {
	public boolean insert( Object obj, Connection conn );
	public boolean update( Object obj, String column ,String value, Connection conn );
	public boolean delete( String key, Connection conn);
	public Object read( String key, Connection conn);

}
