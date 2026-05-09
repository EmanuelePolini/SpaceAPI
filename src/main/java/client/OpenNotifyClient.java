package client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NasaClient {
	public String callApi() {
		String urlString = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";
		String jsondata = "";
		
		try {
			
			@SuppressWarnings("deprecation")
			URL url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String output="";
			
			while((output = reader.readLine()) != null) {
				jsondata += output;
			}
			
			reader.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return jsondata;
	}
}
