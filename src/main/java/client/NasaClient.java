package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class OpenNotifyClient {
	public String callISSApi() {
		String urlString = "http://api.open-notify.org/iss-now.json";
		String jsondata = "";
		
		try {
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String output="";
			
			while((output = reader.readLine()) != null) {
				jsondata += output;
			}
			
			reader.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return jsondata;
	}
}
