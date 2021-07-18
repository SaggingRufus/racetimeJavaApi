package sr.racetime.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpRequestHandler {
	public static String getHttpRequest(String aUrl) throws IOException {
	      StringBuilder result = new StringBuilder();
	      URL url = new URL(aUrl);
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	      
	      for (String line; (line = reader.readLine()) != null; ) {
	    	  result.append(line);
	      }
	      conn.disconnect();
	      reader.close();
	      
	      return result.toString();
	}
}
